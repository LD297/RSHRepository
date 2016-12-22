package bl.hotelservice;

import constant.ResultMessage;
import vo.HotelVO;
import vo.RoomAvailVO;
import vo.RoomVO;

import java.util.ArrayList;
import java.util.Date;

import org.junit.validator.PublicClassValidator;


public interface HotelService {

	/**
	 * 得到酒店所有信息，浏览酒店信息时调用
	 * @param id
	 * @return
	 */
    public HotelVO getHotelInfo(String id);

	/**
	 * 酒店工作人员维护酒店基本信息时调用
	 */
    public ResultMessage updateHotel (HotelVO vo);

    /**
     * 返回该酒店所有房间
     * @param id
     * @return
     */
    public ArrayList<RoomVO> getRoomList(String hotelID);

	/**
	 * 增加客房种类
	 * 客房信息维护界面
	 * @param vo
	 * @return
	 */
	public ResultMessage addSpecialRoom(RoomVO vo);

	/**
	 * 删除客房种类
	 * 客房信息维护界面
	 * @param vo
	 * @return
	 */
	public ResultMessage deleteSpecialRoom(RoomVO vo);

	/**
	 *  返回该日期段的可用客房信息列表
	 *  （获得可用房间类型、数量、价格，供线下入住时查看）
	 * @param hotelId
	 * @param checkIn
	 * @return
	 */
	public ArrayList<RoomAvailVO> getRoomAvailList(String hotelId, Date checkIn);

	/**
	 *  线下提前离开，酒店工作人员手动增加可用客房数
	 * @param hotelId
	 * @param roomType
	 * @param num
	 * @param checkIn
	 * @param checkOut
	 * @return
	 */
    public ResultMessage plusRoomAvail(String hotelId, String roomType,int num, Date checkIn, Date checkOut);

	/**
	 *  线下办理入住，酒店工作人员手动减少可用客房数
	 * @param hotelId
	 * @param roomType
	 * @param num
	 * @param checkIn
	 * @param checkOut
	 * @return
	 */
    public ResultMessage minusRoomAvail(String hotelId, String roomType,int num, Date checkIn, Date checkOut);

    /**
     * 查看可用客房界面
     * 返回特定情况下可用客房数量
     * @param hotelId
     * @param roomType
     * @param checkIn
     * @param checkOut
     * @return
     */
    public int numOfRoomAvail(String hotelId, String roomType, Date checkIn, Date checkOut);
    
    /**
     * 用户浏览酒店界面
     * 返回酒店所有图片
     * @param hotelID
     * @return
     */
    public ArrayList< String > getImageAddresses(String hotelID);
    
    /**
     * 返回酒店某房间图片
     * @param hotelID
     * @param roomType
     * @return
     */
    public String getImageAddress(String hotelID, String roomType);
}
