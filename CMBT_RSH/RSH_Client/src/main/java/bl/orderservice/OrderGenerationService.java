package bl.orderservice;

import constant.ResultMessage;
import po.OrderPO;
import vo.OrderVO;
import vo.RoomNormVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sky-PC on 2016/11/20.
 */
public interface OrderGenerationService {

    /**
     * 订单生成时：
     * 根据酒店得到房间规模（酒店编号、房间类型、原始价格）
     * 房间类型选择中的条目
     * @param hotelID
     * @return
     */
    public ArrayList<RoomNormVO> getRoomNorm(String hotelID);

    /**
     * 选择roomType、checkIn与checkOut后
     * 根据酒店、时间得到该房间类型可用客房数量
     * @param hotelID
     * @param checkIn
     * @param checkOut
     * @return
     */
    public int getRoomAvailNum(String hotelID,String roomType, Date checkIn, Date checkOut);

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
    public String getTrueValue(String userID, String hotelID, Date checkIn, Date checkOut, RoomNormVO room, int roomNum);

    /**
     * 确认订单时：
     * 界面封装orderVO（userID,userName,hotelID,hotelName,RoomNormVO,roomPrice,
     *                  roomNum,originValue,trueValue,promotion,withChildren,peopleNumber,checkIn,checkOut）
     * 根据（用户信用值信息）判断是否可以提交
     * 不可提交 返回信息提示
     * 再次检查可用数量 会员信息 优惠政策是否存在
     * 出现出入 返回出入信息提示
     * 生成orderid
     * 没有出入 更新数据库 返回成功
     * @param orderVO
     * @return
     */
    public ResultMessage confirmReservation(OrderVO orderVO);
}
