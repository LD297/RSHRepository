package bl.hotelservice;

import constant.ResultMessage;
import vo.RoomNormVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sky-PC on 2016/12/12.
 */
public interface HotelInfoService {
    /**
     * 添加订单时调用
     * 得到房间规格（房间类型,原始价格）,其中，房间类型为String，如"单人间"、"标准间"等
     * @return
     */
    public ArrayList<RoomNormVO> getRoomNorm();
    /**
     * 得到该酒店的最晚入住时间，时间类型为String, 格式统一为"00:00:00"
     */
    public String getCheckInDDL(String hotelID);
    /**
     * 选择roomType、checkIn与checkOut后
     * 根据酒店id、时间得到该房间类型可用客房数量
     * @param roomType
     * @param checkIn
     * @param checkOut
     * @return
     */
    public int getRoomAvailNum(String roomType, Date checkIn, Date checkOut);
    /**
     * 更新数据库中酒店的评分
     * @param grade 用户打分（范围0~5，闭区间，加权计算后界面输出星级）
     * @return
     */
    public ResultMessage updateGrade(int grade);
}
