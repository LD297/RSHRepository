package bl.orderserviceimpl;

import constant.StateOfOrder;
import data.dao.orderdao.OrderDao;
import po.OrderPO;
import vo.OrderVO;
import vo.RoomNormVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

public class CheckOrder {

	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}


    /**
     * 显示订单详情
     * @param orderID
     * @return
     */
	public OrderVO detail(String orderID){
		try{
			return this.transformPOToVO(orderDao.searchByID(orderID));
		}catch(RemoteException e){
			e.printStackTrace();
			return null;
		}
	}

    /**
     * 用户浏览酒店时
     * 浏览在该酒店下的所有订单
     * @param userID
     * @param hotelID
     * @return
     */
	public ArrayList<OrderVO> specificOrder(String userID,String hotelID){
        ArrayList<OrderPO> orders;
        try{
            orders = orderDao.searchByHotelWithUser(userID,hotelID);
        }catch(RemoteException e){
            e.printStackTrace();
            return null;
        }
        ArrayList<OrderVO> selectedList = new ArrayList<OrderVO>();
        for(int i=0;i<orders.size();i++){
            OrderVO orderVO = this.transformPOToVO(orders.get(i));
            selectedList.add(orderVO);
        }
		return selectedList;
	}

    /**
     * 提供给用户视角：
     *     分类查看订单
     *
     * PS:查看全部订单时：
     *     state设为null
     * @param userID
     * @param state
     * @return
     */
	public ArrayList<OrderVO> userClassify(String userID, StateOfOrder state){
        return this.classify(this.getOrderOfUser(userID),state);
	}

    /**
     * 提供给酒店视角：
     *     分类查看订单
     *
     * PS:查看全部订单时：
     *     state设为null
     * @param hotelID
     * @param state
     * @return
     */
    public ArrayList<OrderVO> hotelClassify(String hotelID, StateOfOrder state){
        return this.classify(this.getOrderOfHotel(hotelID),state);
    }

    /**
     * 提供给酒店的
     * 返回该用户在酒店的最近订单的状态
     * when return null->no order be reserved
     * @param userID
     * @param hotelID
     * @return
     */
	public StateOfOrder getOrderStateOfUser(String userID, String hotelID){
        try{
		    ArrayList<OrderPO> orders = orderDao.searchByHotelWithUser(userID,hotelID);
            int size = orders.size();
            return orders.get(size-1).getState();
        }catch (RemoteException e){
            e.printStackTrace();
            return null;
        }
	}


	// 完成从PO到VO的操作
	private OrderVO transformPOToVO(OrderPO orderPO){
        String orderID = orderPO.getOrderID();
        String userID = orderPO.getUserID();
        String userName = orderPO.getUserName();
        String hotelID = orderPO.getHotelID();
        String hotelName = orderPO.getHotelName();
        StateOfOrder state = orderPO.getState();
        RoomNormVO room = orderPO.getRoom();
        int roomNumber = orderPO.getRoomNumber();
        double roomPrice = orderPO.getRoomPrice();
        int peopleNumber = orderPO.getPeopleNumber();
        boolean withChild = orderPO.getWithChild();

        double originValue = orderPO.getOriginValue();
        double trueValue = orderPO.getTrueValue();
        String promotion =  orderPO.getPromotion();
        String comment = orderPO.getComment();
        int grade = orderPO.getGrade();

        Date checkIn = orderPO.getCheckIn();
        Date checkOut = orderPO.getCheckOut();
        Date hotelDDL = orderPO.getHotelDDL();
        Date generationDate = orderPO.getGenerationDate();
        Date actualCheckIn = orderPO.getActualCheckIn();
        Date actualCheckOut = orderPO.getActualCheckOut();
        Date cancelTime = orderPO.getCancelTime();
        Date cancelAbnormalTime = orderPO.getCancelAbnormalTime();

        OrderVO orderVO = new OrderVO(orderID, userID, userName, hotelID, hotelName, state,
                room, roomPrice, roomNumber, peopleNumber, withChild,
                originValue, trueValue, promotion,
                comment, grade, checkIn, checkOut, hotelDDL, generationDate,
                actualCheckIn, actualCheckOut, cancelTime, cancelAbnormalTime);
        return orderVO;
    }
    // 根据订单状态选择符合条件订单
    private ArrayList<OrderVO> classify(ArrayList<OrderPO> orders, StateOfOrder state){
        ArrayList<OrderVO> selectedList = new ArrayList<OrderVO>();

        if(state==null){
            for(int i=0;i<orders.size();i++){
                OrderVO orderVO = this.transformPOToVO(orders.get(i));
                selectedList.add(orderVO);
            }
            return selectedList;
        }
        else{
            for(int i=0;i<orders.size();i++)
                if(orders.get(i).getState()==state)
                    selectedList.add(this.transformPOToVO(orders.get(i)));
            return selectedList;
        }
    }
    // 得到该用户的所有订单
    private ArrayList<OrderPO> getOrderOfUser(String userID){
        try{
            return orderDao.searchByUser(userID);
        }catch(RemoteException e){
            e.printStackTrace();
            return null;
        }
    }
    // 得到该酒店的所有订单
    private ArrayList<OrderPO> getOrderOfHotel(String hotelID){
        try{
            return orderDao.searchByHotel(hotelID);
        }catch(RemoteException e){
            e.printStackTrace();
            return null;
        }
    }
}
