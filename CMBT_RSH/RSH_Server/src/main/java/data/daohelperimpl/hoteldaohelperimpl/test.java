package data.daohelperimpl.hoteldaohelperimpl;

import constant.ResultMessage;
import po.HotelPO;
import po.HotelStaffPO;
import po.RoomAvailPO;
import po.RoomPO;

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
    public void testupdateHotel (HotelPO vo) throws RemoteException{
        HotelPO hotelPO = new HotelPO("", "15998976532", "金陵酒店", "地址", "夫子庙",
                "建于1997，历史悠久，古韵悠长", "含wifi", 3, 4.0, "23:10:00");

        ResultMessage result = hotelDao.updateHotel(hotelPO);
    }

    public void testaddSpecialRoom() throws RemoteException{
        RoomPO roomPO = new RoomPO("","singleRoom",40,200,true);
        ResultMessage result = hotelDao.addSpecialRoom(roomPO);
    }
    public void testdeleteSpecialRoom() throws RemoteException{
        RoomPO roomPO = new RoomPO("","singleRoom",40,200,true);
        ResultMessage result = hotelDao.deleteSpecialRoom(roomPO);
    }
    public void  testgetRoomList() throws RemoteException{
        String hotelid = "";
        ArrayList<RoomPO> list = hotelDao.getRoomList(hotelid);
    }
    public void testupdateRoom() throws RemoteException{
        RoomPO roomPO = new RoomPO("","singleRoom",30,200,true);
        ResultMessage result = hotelDao.updateRoom(roomPO);
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
        ArrayList<RoomAvailPO> list = hotelDao.getRoomAvailList(hotelid,indate);
    }
    public void  testupdateRoomAvail() throws RemoteException{
        RoomAvailPO roomAvailPO = new RoomAvailPO("","singleRoom",12,120.0,false);
        ResultMessage result = hotelDao.updateRoomAvail(roomAvailPO);
    }

    public void  testgetHotelList() throws RemoteException{
        String address = "";
        String businessArea = "";
        ArrayList<HotelPO> list = hotelDao.getHotelList(address,businessArea);
    }
    public void testgetHotelInfo() throws RemoteException{
        String id = "";
        HotelPO hotelPO = hotelDao.getHotelInfo(id);
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
        HotelPO hotelPO = new HotelPO("13648606135","LaRud","龙泉街","123456");
        ResultMessage result = hotelDao.addHotel(hotelPO);
    }
    public void  testupdateHotelStaff() throws RemoteException{
        HotelStaffPO po = new HotelStaffPO("","15708478080");
        ResultMessage result = hotelDao.updateHotelStaff(po);
    }
}
