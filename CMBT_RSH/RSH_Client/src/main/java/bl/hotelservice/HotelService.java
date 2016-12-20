package bl.hotelservice;

import constant.ResultMessage;
import vo.HotelVO;
import vo.RoomAvailVO;
import vo.RoomVO;

import java.util.ArrayList;
import java.util.Date;

import org.junit.validator.PublicClassValidator;

/**
 * 功能最小化，紧扣大作业需求。
 * 如：对客房信息的维护，需求中只有"录入可用客房（类型、数量、原始价格）"这句。
 * 因此，先只考虑add和delete。不考虑update。
 * 且"单人间"、"标准间"、"特色房间"都适用
 */
public interface HotelService {

	// 用户、酒店查看该酒店详情
    public HotelVO getHotelInfo(String id);

	/**
	 * 酒店工作人员维护酒店基本信息
	 */
    public ResultMessage updateHotel (HotelVO vo);

    // 返回该酒店的客房信息列表
    public ArrayList<RoomVO> getRoomList(String id);

	// 增加客房
	public ResultMessage addSpecialRoom(RoomVO vo);

	// 删除客房
	public ResultMessage deleteSpecialRoom(RoomVO vo);

	// 返回该日期段的可用客房信息列表（获得可用房间类型、数量、价格，供线下入住时查看）
	public ArrayList<RoomAvailVO> getRoomAvailList(String hotelId, Date checkIn);

	// 线下提前离开，酒店工作人员手动增加可用客房数
    public ResultMessage plusRoomAvail(String hotelId, String roomType,int num, Date checkIn, Date checkOut);

	// 线下办理入住，酒店工作人员手动减少可用客房数
    public ResultMessage minusRoomAvail(String hotelId, String roomType,int num, Date checkIn, Date checkOut);

    public int numOfRoomAvail(String hotelId, String roomType, Date checkIn, Date checkOut);
    
    public ArrayList< String > getImageAddresses(String hotelID);
    
    public String getImageAddress(String hotelID, String roomType);
    
    
}
