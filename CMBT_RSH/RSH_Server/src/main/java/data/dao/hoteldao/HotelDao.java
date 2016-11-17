package data.dao.hoteldao;

import constant.*;
import po.*;
import vo.*;
import java.util.*;
/**
 * Created by a297 on 16/11/13.
 */
public interface HotelDao {
    /**
     * 在数据库该酒店信息中加入一条评论
     * @param id
     * @param userID
     * @param comment
     * @return
     */
    public ResultMessage addComment(String id, String userID, String comment);
    public ResultMessage checkPassword(String id, String password);
    public HotelPO getHotel(String id);

    /**
     * 更新数据库中该酒店的评分
     * @param grade
     * @return
     */
    public ResultMessage updateGrade(double grade);
    public ResultMessage updateHotel (HotelVO vo);

    public ResultMessage addSpecialRoom(RoomVO vo);
    public ResultMessage deleteSpecialRoom(RoomVO vo);
    public ArrayList<RoomVO> getRoomList();
    public ResultMessage updateRoomList(ArrayList<RoomVO> roomList);

    public ResultMessage changeRoomAvail(RoomType roomType, int num, Date checkIn, Date checkOut);
    public int numOfRoomAvail(RoomType roomType, Date checkIn, Date checkOut);
    public ArrayList<RoomAvailVO> getRoomAvailList(Date date);
    public ResultMessage updateRoomAvailList(ArrayList<RoomAvailVO> availableRoomList);

    public ArrayList<HotelVO> getHotelList(String address,String businessArea);
    public HotelVO getHotelInfo(String id);
    public ArrayList<HotelVO> sort(SortBy sortBy,SortMethod sortM);
    public ArrayList<HotelVO> select(SelectConditionVO vo);
    public int getHotelNum(String address);
    public ResultMessage addHotel(String id,String password);
    public ResultMessage deleteHotel(String id);
    public ResultMessage updateHotelStaff(HotelStaffPO po);
}
