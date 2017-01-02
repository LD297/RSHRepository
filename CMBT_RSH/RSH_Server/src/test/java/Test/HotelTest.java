package Test;

import constant.ResultMessage;
import po.HotelPO;
import po.RoomAvailPO;
import po.RoomPO;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import data.daohelperimpl.hoteldaohelperimpl.HotelDaoHelperMySql;
import static org.junit.Assert.*;

/**
 * Created by sky-PC on 2016/12/12.
 */
public class HotelTest {
    static HotelDaoHelperMySql hotelDao = null; // new HotelDaoHelperMySql();

    // success
    @Test// 得到酒店详情
    public void testgetHotel()throws RemoteException{
    	String hotelid = "2153000001";
    	HotelPO po =hotelDao.getHotel(hotelid) ;
    	assertEquals(po.getAddressDetail(),"夫子庙110号");
    }
    // success
    @Test// 得到商圈内酒店列表
    public void  testgetHotelList() throws RemoteException{
        String district = "215300";
        ArrayList<HotelPO> list = hotelDao.getHotelList(district);
        assertEquals(list.size(),3);
    }
    // success
    @Test// 得到所有酒店
    public void testgetAll()throws RemoteException{
    	ArrayList<HotelPO> list = hotelDao.getAll();
    	assertEquals(list.size(),5);
    }
    // success
    @Test// 更新酒店信息
    public void testupdateHotel () throws RemoteException{
        HotelPO hotelPO = new HotelPO("2153000001", "15998976532", "金陵大酒店", "url","215300", "夫子庙110号",200.0,
                "建于1997，历史悠久，古韵悠长", "含wifi", 3, 4.0, "23:10:00");

        ResultMessage result = hotelDao.updateHotel(hotelPO);
        assertEquals(result,ResultMessage.succeed);
    }
    
    // success
    @Test// 删除客房
    public void testdeleteSpecialRoom() throws RemoteException{
        RoomPO roomPO = new RoomPO("2153000001","标准间",null,0,0);
        ResultMessage result = hotelDao.deleteSpecialRoom(roomPO);
        assertEquals(result,ResultMessage.succeed);
    } 
    // success
    @Test //添加客房
    public void testaddSpecialRoom1() throws RemoteException{
        RoomPO roomPO = new RoomPO("2153000001","单人间","/images/默认房间图片.jpg",10,200);
        ResultMessage result = hotelDao.addSpecialRoom(roomPO);
        assertEquals(result,ResultMessage.idAlreadyExist);
    }
    // success
    @Test //添加客房
    public void testaddSpecialRoom2() throws RemoteException{
        RoomPO roomPO = new RoomPO("2153000001","双人间","/images/默认房间图片.jpg",20,300);
        ResultMessage result = hotelDao.addSpecialRoom(roomPO);
        assertEquals(result,ResultMessage.succeed);
    }
    
    // success
    @Test // 修改可用客房
    public void testchangeRoomAvail() throws RemoteException, ParseException{
    	String id="2153000002";
    	String roomType="标准间";
    	boolean isPlus = false;
    	int num = 1;
    	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
    	Date checkIn = sim.parse("2016-12-22");
    	Date checkOut = sim.parse("2016-12-23");
        ResultMessage result = hotelDao.changeRoomAvail(id, roomType, isPlus, num, checkIn, checkOut);
        assertEquals(result,ResultMessage.succeed);
    }
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
    public void  testgetRoomAvailList() throws RemoteException,ParseException{

        String hotelid = "2153000002";
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
        Date indate = sim.parse("2016-12-27");
        ArrayList<RoomAvailPO> list = hotelDao.getRoomAvailList(hotelid,indate);
        assertEquals(list.get(0).getAmountAvail(),40);
    }
}
