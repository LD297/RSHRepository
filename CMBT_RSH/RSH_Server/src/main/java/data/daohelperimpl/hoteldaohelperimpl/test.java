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

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sky-PC on 2016/12/12.
 */
public class test {
    static HotelDaoHelperMySql hotelDao = null; // new HotelDaoHelperMySql();
   /*

    // success
    @Test
    public void testgetAll()throws RemoteException{
    	ArrayList<HotelPO> list = hotelDao.getAll();
    	assertEquals(list.get(1).getAddressDetail(),"平泉街012号");
    }
    // success
    @Test
    public void testdeleteSpecialRoom() throws RemoteException{
        RoomPO roomPO = new RoomPO("2153000001","标准间","url",0,0,false);
        ResultMessage result = hotelDao.deleteSpecialRoom(roomPO);
        assertEquals(result,ResultMessage.idNotExist);
    } 
    // success
    @Test
    public void testaddSpecialRoom() throws RemoteException{
        RoomPO roomPO = new RoomPO("2153000001","豪华大床间","url",20,400,false);
        ResultMessage result = hotelDao.addSpecialRoom(roomPO);
        assertEquals(result,ResultMessage.idAlreadyExist);
    }*/
    // success
    @Test
    public void testaddHotel() throws RemoteException{
        String id = hotelDao.getNewHotelID("215300");
    	HotelPO hotelPO = new HotelPO(id,"15987663987","LaRud","215300","平泉街211号","123456");
        ResultMessage result = hotelDao.addHotel(hotelPO);
        
        String id2 = hotelDao.getNewHotelID("215300");
        HotelPO hotelPO2 = new HotelPO(id2,"17394857369","qucio","215300","平泉街012号","765432");
        ResultMessage result2 = hotelDao.addHotel(hotelPO2);
        assertEquals(result,ResultMessage.succeed);
        assertEquals(result2,ResultMessage.succeed);
    }/*
    // success
    @Test
    public void testupdateHotel () throws RemoteException{
        HotelPO hotelPO = new HotelPO("2153000001", "15998976532", "金陵大酒店", "url","215300", "夫子庙110号",200.0,
                "建于1997，历史悠久，古韵悠长", "含wifi", 3, 4.0, "23:10:00");

        ResultMessage result = hotelDao.updateHotel(hotelPO);
        assertEquals(result,ResultMessage.succeed);
    }
    // success
    @Test
    public void testupdateGrade() throws RemoteException{
        String hotelid = "2153000001";
        int grade = 4;
        ResultMessage result = hotelDao.updateGrade(hotelid,grade);
        assertEquals(result,ResultMessage.succeed);
    }
    
    // success
    @Test
    public void  testgetRoomList() throws RemoteException{
        String hotelid = "2153000001";
        ArrayList<RoomPO> list = hotelDao.getRoomList(hotelid);
        assertEquals(list.get(1).getType(),"豪华大床间");
    }
     // success
    @Test
    public void testgetHotel()throws RemoteException{
    	String hotelid = "2153000001";
    	HotelPO po =hotelDao.getHotel(hotelid) ;
    	assertEquals(po.getAddressDetail(),"夫子庙110号");
    }
    // success
    @Test
    public void  testgetHotelList() throws RemoteException{
        String district = "215300";
        ArrayList<HotelPO> list = hotelDao.getHotelList(district);
        assertEquals(list.get(0).getName(),"金陵大酒店");
    }
    // success
    @Test
    public void testupdateRoom() throws RemoteException{
        RoomPO roomPO = new RoomPO("2153000002","标准间","url",40,220,true);
        ResultMessage result = hotelDao.updateRoom(roomPO);
        assertEquals(result,ResultMessage.succeed);
    }
    
    // success
    @Test
    public void testnumOfRoomAvail() throws RemoteException,ParseException{
        String hotelid = "2153000002";
        String roomType = "标准间";
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
        Date checkIn = sim.parse("2016-12-28");
        Date checkOut = sim.parse("2016-12-29");
        int result = hotelDao.numOfRoomAvail(hotelid,roomType,checkIn,checkOut);
        assertEquals(result,40);
    }
    // success
    @Test
    public void testchangeRoomAvail() throws RemoteException, ParseException{
    	String id="2153000002";
    	String roomType="标准间";
    	boolean isPlus = false;
    	int num = 0;
    	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
    	Date checkIn = sim.parse("2016-12-22");
    	Date checkOut = sim.parse("2016-12-23");
        ResultMessage result = hotelDao.changeRoomAvail(id, roomType, isPlus, num, checkIn, checkOut);
        assertEquals(result,ResultMessage.succeed);
    }
   
    // success
    @Test
    public void  testgetRoomAvailList() throws RemoteException,ParseException{

        String hotelid = "2153000002";
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
        Date indate = sim.parse("2016-12-27");
        ArrayList<RoomAvailPO> list = hotelDao.getRoomAvailList(hotelid,indate);
        assertEquals(list.get(0).getAmountAvail(),40);
    }
    
     */
}
