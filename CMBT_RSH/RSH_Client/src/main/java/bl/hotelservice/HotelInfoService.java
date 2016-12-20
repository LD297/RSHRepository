package bl.hotelservice;

import constant.ResultMessage;
import vo.RoomNormVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * 在查看酒店信息时调用该接口中的方法
 * Created by sky-PC on 2016/12/12.
 */
public interface HotelInfoService {
	
    /**
     * 添加订单时调用
     * 得到房间规格（房间类型,原始价格）,其中，房间类型为String，如"单人间"、"标准间"等
     * @return
     */
    public ArrayList<RoomNormVO> getRoomNorm(String hotelID);
    
    /**
     * 得到该酒店的最晚入住时间
     * @return  格式为HH:mm:ss 的时间
     */
    public String getCheckInDDL(String hotelID);
    
    /**
     * 得到某酒店某房间类型特定时间段的可用客房数量
     * @param roomType
     * @param checkIn
     * @param checkOut
     * @return
     */
    public int getRoomAvailNum(String hotelID,String roomType, Date checkIn, Date checkOut);
   
    /**
     * 更新数据库中酒店的评分
     * 由逻辑层传入用户评分，数据层对已有的评分和新增评分取平均值
     * 并更新酒店的评分数据
     * @param grade 用户打分（范围0~5，闭区间）
     * @return
     */
    public ResultMessage updateGrade(String hotelID, int grade);
}
