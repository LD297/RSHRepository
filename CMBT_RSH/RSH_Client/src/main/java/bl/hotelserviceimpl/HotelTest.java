package bl.hotelserviceimpl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import constant.ResultMessage;
import constant.RoomType;
import vo.RoomAvailVO;

public class HotelTest {
	
	Hotel hotel;
	
	public HotelTest(){

		MockRoomManager roomManager = new MockRoomManager();
		MockHotelManager hotelManager = new MockHotelManager(roomManager);
		MockRoomAvail roomAvail = new MockRoomAvail();
		/**
		 * 酒店业务逻辑领域对象
		 */
		this.hotel = new Hotel("12345678912");
		hotel.setHotelManager(hotelManager);
		hotel.setRoomAvail(roomAvail);
	}
	
	@Test
	public void updateHotelTest() {
		assertEquals(ResultMessage.succeed, hotel.updateHotel(null));
	}
	@Test
	public void addSpecialRoomTest() {
		assertEquals(ResultMessage.succeed, hotel.addSpecialRoom(null));
	}
	@Test
	public void deleteSpecialRoomTest() {
		assertEquals(ResultMessage.succeed, hotel.deleteSpecialRoom(null));
	}
	@Test
	public void getRoomListTest() {
		assertEquals("天鸿凯莱", hotel.getRoomList().get(0).id);
		assertEquals(RoomType.doubleRoom, hotel.getRoomList().get(0).type);
	}
	@Test
	public void updateRoomListTest() {
		assertEquals(ResultMessage.succeed, hotel.updateRoomList(null));	
	}
	@Test
	// 供给order模块
	// 返回该酒店指定日期下该房间类型的可用数量
	public void numOfRoomAvailTest() {
		Date checkIn = new Date(2016,11,5);
		Date checkOut = new Date(2016,11,9);
		assertEquals(10, hotel.numOfRoomAvail(RoomType.singleRoom, checkIn, checkOut));	
	}
	@Test
	// 供给order模块
	// 更新系统的可用客房信息
	public void changeRoomAvailTest() {
		Date checkIn = new Date(2016,11,5);
		Date checkOut = new Date(2016,11,9);
		assertEquals(ResultMessage.succeed, hotel.changeRoomAvail(RoomType.doubleRoom, 2, checkIn, checkOut));	
	}
	@Test
	public void getRoomAvailListTest() {
		Date date = new Date(2016, 12, 10);
		assertEquals("天鹅大酒店", hotel.getRoomAvailList(date).get(0).id);
		assertEquals(RoomType.doubleRoom, hotel.getRoomList().get(0).type);
	}
	@Test
	public void updateRoomAvailListTest() {
		ArrayList<RoomAvailVO> list = new ArrayList<RoomAvailVO>();
		list.add(new RoomAvailVO("如家", RoomType.doubleRoom));
		assertEquals(ResultMessage.succeed, hotel.updateRoomAvailList(list));	
	}
	
}
