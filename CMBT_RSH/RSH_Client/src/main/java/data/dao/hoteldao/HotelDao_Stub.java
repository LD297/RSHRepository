package data.dao.hoteldao;

import constant.ResultMessage;
import constant.SortBy;
import constant.SortMethod;
import po.CommentPO;
import po.HotelPO;
import po.HotelStaffPO;
import po.RoomPO;
import vo.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by a297 on 16/11/20.
 */
public class HotelDao_Stub implements  HotelDao{
    @Override
    public ResultMessage addComment(CommentPO commentPO) {
        // TODO: 16/11/20
        return ResultMessage.succeed;
    }

    @Override
    public ResultMessage checkPassword(String id, String password) {
        if(id.equals("13951897687")&&password.equals("jksggkskjg"))
            return ResultMessage.succeed;
        else
            return ResultMessage.fail;
    }

    @Override
    public HotelPO getHotel(String id) {
        return HotelPO.createHotelPO(new HotelVO("0123456789","11122233344",
                "天鸿凯莱大酒店", "南京市栖霞区", "仙林大学城", "新开张", "一应俱全",
                4, 4.8, "23:44:59"));
    }

    @Override
    public ResultMessage updateGrade(double grade) {
        // TODO: 16/11/20
        return null;
    }

    @Override
    public ResultMessage updateHotel(HotelPO hotelPO) {
        if(hotelPO.getName().equals("~~~"))
            return ResultMessage.succeed;
        else
            return ResultMessage.fail;
    }

    @Override
    public ResultMessage addSpecialRoom(RoomPO roomPO) {
        if(roomPO.getAmountTotal()==20)
            return ResultMessage.succeed;
        else
            return ResultMessage.fail;
    }

    @Override
    public ResultMessage deleteSpecialRoom(RoomPO po) {
        if(po.getAmountTotal()==20)
            return ResultMessage.succeed;
        else
            return ResultMessage.fail;
    }

    @Override
    public ArrayList<RoomVO> getRoomList(String id) {
        if(id.equals("~~~")){
            RoomVO roomVO = new RoomVO("12345678912", "doubleRoom", 20, 300, "basic");
            ArrayList<RoomVO> rooms = new ArrayList<RoomVO>();
            rooms.add(roomVO);
            return rooms;
        }
        else
            return null;
    }

    @Override
    public ResultMessage updateRoomList(ArrayList<RoomPO> roomPOList) {
        if(roomPOList.get(0).getType().equals("singleRoom"))
            return ResultMessage.succeed;
        else
            return null;
    }

    @Override
    public ResultMessage changeRoomAvail(String id, String roomType, int num, Date checkIn, Date checkOut) {
        if(id.equals("12345678912"))
            return ResultMessage.succeed;
        else
            return ResultMessage.fail;
    }

    @Override
    public int numOfRoomAvail(String id, String roomType, Date checkIn, Date checkOut) {
        if(id.equals("12345678912")&&roomType.equals("singleRoom"))
            return 10;
        else
            return 0;
    }

    @Override
    public ArrayList<RoomAvailVO> getRoomAvailList(String id, Date date) {
        if(id.equals("6666666666")){
            RoomAvailVO roomAvail = new RoomAvailVO(id, "doubleRoom", 10, 200, "basic");
            ArrayList<RoomAvailVO> list = new ArrayList<RoomAvailVO>();
            list.add(roomAvail);
            return list;
        }
        else
            return null;
    }

    @Override
    public ResultMessage updateRoomAvailList(String id, ArrayList<RoomAvailVO> roomAvailList) {
        if(id.equals("0000000000"))
            return ResultMessage.succeed;
        else
            return ResultMessage.fail;
    }

    @Override
    public ArrayList<RoomNormVO> getRoomNorms(String id) {
        // TODO: 16/11/20
        return null;
    }

    @Override
    public String getCheckInDDL(String id) {
        // TODO: 16/11/20
        return null;
    }

    @Override
    public ArrayList<HotelVO> getHotelList(String address, String businessArea) {
        // TODO: 16/11/20
        return null;
    }

    @Override
    public HotelPO getHotelInfo(String id) {
        // TODO: 16/11/20
        return null;
    }

    @Override
    public ArrayList<HotelVO> sort(SortBy sortBy, SortMethod sortM) {
        ArrayList<HotelVO> list = new ArrayList<HotelVO>();
        list.add(new HotelVO("2333333333"));
        return list;
    }

    @Override
    public ArrayList<HotelVO> select(SelectConditionVO vo) {
        ArrayList<HotelVO> list = new ArrayList<HotelVO>();
        list.add(new HotelVO("2333333333"));
        return list;
    }

    @Override
    public int getHotelNum(String address) {
        if(address.equals("南京市白下区"))
            return 1;
        else
            return 0;
    }

    @Override
    public ResultMessage addHotel(HotelPO hotelPO) {
        if(hotelPO.getId().equals("6666666666")&&hotelPO.getPassword().equals("2333"))
            return ResultMessage.succeed;
        else
            return ResultMessage.fail;
    }

    @Override
    public ResultMessage deleteHotel(String id) {
        if(id.equals("2333333333"))
            return ResultMessage.succeed;
        else
            return ResultMessage.fail;
    }

    @Override
    public ResultMessage updateHotelStaff(HotelStaffPO hotelStaffPO) {
        if(hotelStaffPO.getHotelID().equals("6666666666"))
            return ResultMessage.succeed;
        else
            return ResultMessage.fail;
    }
}
