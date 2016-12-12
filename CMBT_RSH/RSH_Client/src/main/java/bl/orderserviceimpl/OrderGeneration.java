package bl.orderserviceimpl;

/**
 * Created by sky-PC on 2016/12/4.
 */

import bl.hotelservice.HotelService;
import bl.hotelserviceimpl.HotelController;
import bl.promotionServiceimpl.Count;
import bl.userserviceimpl.CreditRecordList;
import bl.userserviceimpl.User;
import constant.ResultMessage;
import data.dao.orderdao.OrderDao;
import vo.OrderVO;
import vo.RoomNormVO;
import vo.UserVO;

import java.util.ArrayList;
import java.util.Date;

public class OrderGeneration {

    private HotelService hotelService;
    private Count count;
    private OrderDao orderDao;

    public void setHotelInfoService(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    /**
     * 订单生成时：
     * 根据酒店得到房间规模（酒店编号、房间类型、原始价格）
     * 房间类型选择中的条目
     * @param hotelID
     * @return
     */
    public ArrayList<RoomNormVO> getRoomNorm(String hotelID){
        hotelService = new HotelController(hotelID);
        ArrayList<RoomNormVO> rooms = hotelService.getRoomNorms();
        return rooms;
    }

    /**
     * 选择checkIn与checkOut后
     * 根据酒店、时间得到所有房间类型可用客房数量
     * 与getHotelRoom 一一对应
     * @param hotelID
     * @param checkIn
     * @param checkOut
     * @return
     */
    public int[] getRoomAvailNum(String hotelID, Date checkIn, Date checkOut){
        ArrayList<RoomNormVO> rooms = this.getRoomNorm(hotelID);
        int availNum[] = new int[rooms.size()];

        hotelService = new HotelController(hotelID);
        for(int i=0;i<rooms.size();i++){
            availNum[i] = hotelService.numOfRoomAvail(rooms.get(i).getRoomType(), checkIn, checkOut);
        }
        return availNum;
    }

    /**
     * 选择房间类型、房间数量完成后
     * 根据用户、酒店、checkIn、checkOut、房间类型、房间数量
     * 上述参数实时更新后 需要实时去计算
     * 得到优惠后的价格以及优惠策略
     * @param userID
     * @param hotelID
     * @param checkIn
     * @param checkOut
     * @param room
     * @param roomNum
     * @return 优惠策略形式：String#double->promotion#truePrice
     */
    public String getTrueValue(String userID, String hotelID, Date checkIn, Date checkOut,
                            RoomNormVO room, int roomNum){
        User user = new User(userID);
        UserVO userVO = user.getInfo();
        double originValue = room.getPrice()*roomNum;
        return Count.countPromotionOfRoom(hotelID,room.getRoomType(),roomNum,(int)originValue,////////
                checkIn,checkOut,userVO.birthday,userVO.getMemberType(),userVO.getLevel());
    }

    /**
     * 确认订单时：
     * 根据（用户信用值信息）判断是否可以提交
     * 再次检查可用数量 会员信息 优惠政策是否存在）出现出入 返回信息提示
     * @param orderVO
     * @return
     */
    public ResultMessage confirmExecution(OrderVO orderVO){
        // 检查信用值

        CreditRecordList credit = new CreditRecordList(orderVO.getUserID());
        User user = new User(orderVO.getUserID());
        if(!user.canGenerateOrder())
            return ResultMessage.creditLack;

        // 检查房间信息
        hotelService = new HotelController(orderVO.getHotelID());
        RoomNormVO room = orderVO.getRoom();
        int roomNum = orderVO.getRoomNumber();
        Date checkIn = orderVO.getCheckIn();
        Date checkOut = orderVO.getCheckOut();
        if(hotelService.numOfRoomAvail(room.getRoomType(),checkIn,checkOut)<roomNum)
            return ResultMessage.roomNumLack;

        // 检查价格
        OrderGeneration initial = new OrderGeneration();
        double price = Double.parseDouble(initial.getTrueValue(orderVO.getUserID(),orderVO.getHotelID(),
                orderVO.getCheckIn(),orderVO.getCheckOut(),orderVO.getRoom(),orderVO.getRoomNumber()).split("#")[1]);
        if(orderVO.getTrueValue()<price)
            return ResultMessage.promotionLoss;

        this.add(orderVO);
        return ResultMessage.succeed;
    }

    //根据界面信息 生成orderid完善orderpo
    private void add(OrderVO orderVO){
        OrderGeneration initial = new OrderGeneration();

        if(initial.confirmExecution(orderVO).equals(ResultMessage.succeed)){
            //orderDao.insert();
        }
        return;
    }
}

