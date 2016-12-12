package bl.orderserviceimpl;

/**
 * Created by sky-PC on 2016/12/4.
 */

import bl.hotelservice.HotelInfoService;
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

    private HotelInfoService hotelInfoService;
    private Count count;
    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
    public void setHotelInfoService(HotelInfoService hotelInfoService){
        this.hotelInfoService = hotelInfoService;
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
        hotelInfoService = new HotelController(orderVO.getHotelID());
        RoomNormVO room = orderVO.getRoom();
        int roomNum = orderVO.getRoomNumber();
        Date checkIn = orderVO.getCheckIn();
        Date checkOut = orderVO.getCheckOut();
        if(hotelInfoService.getRoomAvailNum(room.getRoomType(),checkIn,checkOut)<roomNum)
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

