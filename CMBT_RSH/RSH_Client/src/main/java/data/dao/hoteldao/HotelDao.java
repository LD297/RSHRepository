package data.dao.hoteldao;

import vo.HotelVO;
import constant.*;
import po.*;
import vo.*;
import java.util.*;
/**
 * Created by a297 on 16/11/13.
 */
public interface HotelDao {

    public ResultMessage addComment(CommentPO commentPO);
    public ResultMessage checkPassword(String id, String password);
    public HotelPO getHotel(String id);
    /**
     * 更新数据库中该酒店的评分
     * @param grade
     * @return
     */
    public ResultMessage updateGrade(double grade);
    public ResultMessage updateHotel (HotelPO hotelPO);
    public ResultMessage addSpecialRoom(RoomPO roomVO);
    public ResultMessage deleteSpecialRoom(RoomPO po);
    public ArrayList<RoomVO> getRoomList(String id);
    public ResultMessage updateRoomList(ArrayList<RoomPO> roomPOList);
    public ResultMessage changeRoomAvail(RoomType roomType, int num, Date checkIn, Date checkOut);
    public int numOfRoomAvail(RoomType roomType, Date checkIn, Date checkOut);
    public ArrayList<RoomAvailVO> getRoomAvailList(Date date);
    public ResultMessage updateRoomAvailList(ArrayList<RoomAvailVO> roomAvailList);
    public ArrayList<RoomNormVO> getRoomNorms(String id);
    public String getCheckInDDL(String id);
    public ArrayList<HotelVO> getHotelList(String address,String businessArea);
    public HotelPO getHotelInfo(String id);
    public ArrayList<HotelVO> sort(SortBy sortBy,SortMethod sortM);
    public ArrayList<HotelVO> select(SelectConditionVO vo);
    public int getHotelNum(String address);
    public ResultMessage addHotel(HotelPO hotelPO);
    public ResultMessage deleteHotel(String id);
    public ResultMessage updateHotelStaff(HotelStaffPO hotelStaffPO);

}
