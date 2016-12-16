package data.daohelperimpl.hoteldaohelperimpl;

import constant.ResultMessage;
import po.HotelStaffPO;
import vo.HotelVO;
import vo.RoomAvailVO;
import vo.RoomVO;
import vo.SelectConditionVO;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sky-PC on 2016/12/12.
 */
public class test {
    HotelDaoHelperMySql hotelDao = new HotelDaoHelperMySql();
    public void testupdateGrade() throws RemoteException{
        String hotelid = "";
        int grade = 4;
        ResultMessage result = hotelDao.updateGrade(hotelid,grade);
    }
    public void testupdateHotel (HotelVO vo) throws RemoteException{
        HotelVO hotelVO = new HotelVO("", "15998976532", "金陵酒店", "地址", "夫子庙",
                "建于1997，历史悠久，古韵悠长", "含wifi", 3, 4.0, "23:10:00");

        ResultMessage result = hotelDao.updateHotel(hotelVO);
    }

    public void testaddSpecialRoom() throws RemoteException{
        RoomVO roomVO = new RoomVO("","singleRoom",40,200,true);
        ResultMessage result = hotelDao.addSpecialRoom(roomVO);
    }
    public void testdeleteSpecialRoom(RoomVO vo) throws RemoteException{
        RoomVO roomVO = new RoomVO("","singleRoom",40,200,true);
        ResultMessage result = hotelDao.deleteSpecialRoom(roomVO);
    }
    public void  testgetRoomList() throws RemoteException{
        String hotelid = "";
        ArrayList<RoomVO> list = hotelDao.getRoomList(hotelid);
    }
    public void testupdateRoom(RoomVO vo) throws RemoteException{
        RoomVO roomVO = new RoomVO("","singleRoom",30,200,true);
        ResultMessage result = hotelDao.updateRoom(roomVO);
    }

    public void testnumOfRoomAvail() throws RemoteException,ParseException{
        String hotelid = "";
        String roomType = "singleRoom";
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
        Date checkIn = sim.parse("2016-11-11");
        Date checkOut = sim.parse("2016-11-13");
        int result = hotelDao.numOfRoomAvail(hotelid,roomType,checkIn,checkOut);
    }
    public void  testgetRoomAvailList() throws RemoteException,ParseException{

        String hotelid = "";
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
        Date indate = sim.parse("2016-01-28");
        Date outdate = sim.parse("2016-01-30");
        ArrayList<RoomAvailVO> list = hotelDao.getRoomAvailList(hotelid,indate,outdate);
    }
    public void  testupdateRoomAvail() throws RemoteException{
        RoomAvailVO vo = new RoomAvailVO("","singleRoom");
        ResultMessage result = hotelDao.updateRoomAvail(vo);
    }

    public void  testgetHotelList() throws RemoteException{
        String address = "";
        String businessArea = "";
        ArrayList<HotelVO> list = hotelDao.getHotelList(address,businessArea);
    }
    public void testgetHotelInfo() throws RemoteException{
        String id = "";
        HotelVO hotelVO = hotelDao.getHotelInfo(id);
    }
    //  public ArrayList<HotelVO> sort(SortBy sortBy,SortMethod sortM) throws RemoteException;
    // public ArrayList<HotelVO> selectByName(String hotelName)throws RemoteException;
    // public void testselectByCondition(SelectConditionVO vo) throws RemoteException;
    public void  testgetHotelNum() throws RemoteException{
        String address = "";
        int result = hotelDao.getHotelNum(address);
    }
    public void testaddHotel() throws RemoteException{
        String id="";
        String password="";
        ResultMessage result = hotelDao.addHotel(id,password);
    }
    public void testdeleteHotel() throws RemoteException{
        String id = "";
        ResultMessage result = hotelDao.deleteHotel(id);
    }
    public void  testupdateHotelStaff() throws RemoteException{
        HotelStaffPO po = new HotelStaffPO("","15708478080");
        ResultMessage result = hotelDao.updateHotelStaff(po);
    }
}
