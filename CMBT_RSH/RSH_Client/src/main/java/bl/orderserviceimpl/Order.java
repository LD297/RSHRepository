package bl.orderserviceimpl;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import bl.BLHelper;
import bl.hotelservice.HotelService;
import bl.hotelserviceimpl.HotelController;
import bl.hotelserviceimpl.HotelInfoController;
import bl.userserviceimpl.CreditRecordList;
import bl.userserviceimpl.UserController;
import bl.userserviceimpl.UserForOrderController;
import constant.CreditAction;
import constant.ResultMessage;
import constant.StateOfOrder;
import data.dao.hoteldao.HotelDao;
import data.dao.orderdao.OrderDao;
import po.OrderPO;
import rmi.RemoteHelper;
import vo.CreditRecordVO;
import vo.OrderVO;
import vo.RoomNormVO;

public class Order {

	private static OrderDao orderDao = null;
	OrderPO orderPO;

	private Order(String orderID) {
		initRemote();
		try {
			orderPO = orderDao.searchByID(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private static void initRemote() {
		if (orderDao == null) {
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			orderDao = remoteHelper.getOrderDao();
		}
	}

	public static Order getInstance(String orderID) {
		Order order = new Order(orderID);
		if (order.orderPO == null)
			return null;
		else {
			return order;
		}
	}

	public static ResultMessage generateOrder(OrderVO orderVO) {
		UserForOrder userForOrder = new UserForOrderController();
		if (!userForOrder.canGenerate(orderVO.getUserID())) {
			return ResultMessage.creditLack;
		}
		initRemote();
		ResultMessage resultMessage = null;
		try {
			resultMessage = orderDao.insert(orderVO.changeIntoPO());
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.remote_fail;
		}
		if (resultMessage == ResultMessage.succeed) {
			HotelController hotelController = new HotelController();
			resultMessage = hotelController.minusRoomAvail(orderVO.getHotelID(), orderVO.getRoomType(),
					orderVO.getRoomNumber(), orderVO.getCheckIn(), orderVO.getCheckOut());
		}
		return resultMessage;
	}

	/**
	 * hotel can execute the order, add the credit and set the state as execute;
	 * updata checkin time
	 * 
	 * @return
	 */
	public ResultMessage execute() {

		// can be executed??
		StateOfOrder stateOfOrder = orderPO.getState();
		if (stateOfOrder != StateOfOrder.unexecuted && stateOfOrder != StateOfOrder.canceled) {
			return ResultMessage.noChangeMade;
		}

		// the time is okay
		Date now = new Date();
		Date checkOutTime;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(orderPO.getCheckOut());
		try {
			checkOutTime = df.parse(str + " 12:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
			return ResultMessage.fail;
		}
		if (now.getTime() - checkOutTime.getTime() > 0) {
			return ResultMessage.timeOut;
		}

		// change the state and actual checkIntime
		orderPO.setState(StateOfOrder.executed);
		orderPO.setActualCheckIn(new Date());

		// change the recordListe:
		UserForOrder userForOrder = new UserForOrderController();
		userForOrder.addCreditRecordForExecute(orderPO.getUserID(), orderPO.getOrderID(), (int) orderPO.getTrueValue(),
				now);
		return update();
	}

	/**
	 * hotel call this method when the guest is leaving and set the checkout
	 * Date;
	 * 
	 * @return
	 */
	public ResultMessage leaveUpdate() {
		if (orderPO.getState() != StateOfOrder.executed) {
			return ResultMessage.noChangeMade;
		}
		orderPO.setActualCheckOut(new Date());
		return update();
	}

	public ResultMessage cancelUnexecuted() {
		if (orderPO.getState() != StateOfOrder.unexecuted)
			return ResultMessage.fail;

		// 得到订单信息
		String userID = orderPO.getUserID();
		String hotelID = orderPO.getHotelID();
		RoomNormVO room = orderPO.getRoom();
		int roomNum = orderPO.getRoomNumber();
		Date checkIn = orderPO.getCheckIn();
		Date checkOut = orderPO.getCheckOut();

		// 酒店可用客房数量增加
		// 增加量=订单中预定的客房数量
		HotelController hotelController = new HotelController();
		hotelController.plusRoomAvail(hotelID, room.getRoomType(), roomNum, checkIn, checkOut);

		// 订单状态置为已撤销
		ResultMessage resultMessage = null;
		orderPO.setState(StateOfOrder.canceled);
		initRemote();
		try {
			resultMessage = orderDao.update(orderPO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.remote_fail;
		}

		// 判断是否超时：成立->扣除信用值（订单价值一半）
		int creditChange = getCreditReduced(orderPO.changeIntoVO());
		if (resultMessage == ResultMessage.succeed && creditChange > 0) {
			UserForOrder userForOrder = new UserForOrderController();
			resultMessage = userForOrder.minusCreditRecordForCancel(userID, orderPO.getOrderID(), creditChange,
					new Date());
		}
		return resultMessage;
	}

	private ResultMessage update() {
		initRemote();
		try {
			return orderDao.update(orderPO);

		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.remote_fail;
		}
	}

	/**
	 * 计算时间差 单位：秒 类内部调用
	 * 
	 * @param checkOut
	 * @param deadline
	 * @param cancelTime
	 * @return
	 */

	public ResultMessage addComment(int grade, String comment) {
		// 检查订单状态是否为已执行
		if (orderPO.getState() != StateOfOrder.executed)
			return ResultMessage.fail;

		// 订单评分评论更新
		orderPO.setComment(comment);
		orderPO.setGrade(grade);
		ResultMessage resultMessage = null;
		resultMessage = update();
		if (ResultMessage.succeed != resultMessage) {
			return resultMessage;
		}

		// 酒店评分更新
		if (resultMessage == ResultMessage.succeed) {
			HotelInfoController hotelInfoController = new HotelInfoController();
			resultMessage = hotelInfoController.updateGrade(orderPO.getHotelID(), grade);
		}
		return resultMessage;
	}

	public static int getCreditReduced(OrderVO orderVO) {
		Date now = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
		Date DDL;
		try {
			DDL = simpleDateFormat.parse(orderVO.getHotelDDL());
		} catch (ParseException e) {
			e.printStackTrace();
			return -1;
		}
		DDL = new Date(DDL.getTime() + orderVO.getCheckIn().getTime());
		int difference = BLHelper.getDifferenceSeconds(now, DDL);
		if (difference >= 3600 * 6) {
			return 0;
		} else {
			return (int) orderVO.getTrueValue() / 2;
		}

	}

	public ResultMessage webCancelAbnormal(boolean isHalf) {
		// is abnormal or not
		if (orderPO.getState() != StateOfOrder.abnormal) {
			return ResultMessage.noChangeMade;
		}
		
		// change the creditRecordList
		double halfOrFull = 1 / 2;
		if (!isHalf)
			halfOrFull = 1;
		int creditChange = (int) (halfOrFull * orderPO.getTrueValue());
		UserForOrder userForOrder = new UserForOrderController();
		userForOrder.addCreditRecordForCancelAbnormal(orderPO.getUserID(), orderPO.getOrderID(), creditChange,
				new Date());

		//update order info
		orderPO.setState(StateOfOrder.canceled);
		return update();
	}

	public ResultMessage hotelCancelAbnormal() {
		// can cancel abnormal?? before checkout time
		Date cancelTime = new Date();
		Date checkOutTime = orderPO.getCheckOut();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(checkOutTime);
		try {
			checkOutTime = df.parse(str + " 12:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
			return ResultMessage.fail;
		}
		if (checkOutTime.getTime() - cancelTime.getTime() < 0)
			return ResultMessage.timeOut;
		return webCancelAbnormal(false);
	}
}
