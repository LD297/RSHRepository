package bl.orderserviceimpl;

import bl.hotelserviceimpl.HotelController;
import bl.promotionServiceimpl.Count;
import bl.userserviceimpl.CreditRecordList;
import bl.userserviceimpl.User;
import constant.ResultMessage;
import po.OrderPO;
import vo.OrderVO;
import vo.RoomNormVO;
import vo.UserVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sky-PC on 2016/11/20.
 */
public class OrderGenerationController  {

    OrderGeneration orderGeneration;

    public void setOrderGeneration(OrderGeneration orderGeneration) {
        this.orderGeneration = orderGeneration;
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
        return orderGeneration.getTrueValue(userID, hotelID, checkIn, checkOut, room, roomNum);
    }

    /**
     * 确认订单时：
     * 根据（用户信用值信息）判断是否可以提交
     * 再次检查可用数量 会员信息 优惠政策是否存在）出现出入 返回信息提示
     * @param orderVO
     * @return
     */
    public ResultMessage confirmExecution(OrderVO orderVO){
        return orderGeneration.confirmExecution(orderVO);
    }

}
