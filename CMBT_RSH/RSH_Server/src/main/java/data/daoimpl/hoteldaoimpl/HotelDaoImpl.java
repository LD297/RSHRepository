package data.daoimpl.hoteldaoimpl;

import constant.ResultMessage;
import constant.RoomType;
import constant.SortBy;
import constant.SortMethod;
import data.dao.hoteldao.HotelDao;
import po.HotelPO;
import po.HotelStaffPO;
import vo.HotelVO;
import vo.RoomAvailVO;
import vo.RoomVO;
import vo.SelectConditionVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by a297 on 16/11/26.
 */
public class HotelDaoImpl implements HotelDao {
    public ResultMessage addComment(String id, String userID, String comment) {
        return null;
    }

    public ResultMessage checkPassword(String id, String password) {
        return null;
    }

    public HotelPO getHotel(String id) {
        return null;
    }

    public ResultMessage updateGrade(double grade) {
        return null;
    }

    public ResultMessage updateHotel(HotelVO vo) {
        return null;
    }

    public ResultMessage addSpecialRoom(RoomVO vo) {
        return null;
    }

    public ResultMessage deleteSpecialRoom(RoomVO vo) {
        return null;
    }

    public ArrayList<RoomVO> getRoomList() {
        return null;
    }

    public ResultMessage updateRoomList(ArrayList<RoomVO> roomList) {
        return null;
    }

    public ResultMessage changeRoomAvail(RoomType roomType, int num, Date checkIn, Date checkOut) {
        return null;
    }

    public int numOfRoomAvail(RoomType roomType, Date checkIn, Date checkOut) {
        return 0;
    }

    public ArrayList<RoomAvailVO> getRoomAvailList(Date date) {
        return null;
    }

    public ResultMessage updateRoomAvailList(ArrayList<RoomAvailVO> availableRoomList) {
        return null;
    }

    public ArrayList<HotelVO> getHotelList(String address, String businessArea) {
        return null;
    }

    public HotelVO getHotelInfo(String id) {
        return null;
    }

    public ArrayList<HotelVO> sort(SortBy sortBy, SortMethod sortM) {
        return null;
    }

    public ArrayList<HotelVO> select(SelectConditionVO vo) {
        return null;
    }

    public int getHotelNum(String address) {
        return 0;
    }

    public ResultMessage addHotel(String id, String password) {
        return null;
    }

    public ResultMessage deleteHotel(String id) {
        return null;
    }

    public ResultMessage updateHotelStaff(HotelStaffPO po) {
        return null;
    }
}
