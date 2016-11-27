package bl.hotelserviceimpl;

import constant.ResultMessage;
import constant.RoomType;
import data.dao.hoteldao.HotelDao_Stub;
import org.junit.Test;
import vo.HotelVO;
import vo.RoomAvailVO;
import vo.RoomVO;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class HotelTest {
	
	Hotel hotel;
    HotelVO hotelVO;
    RoomVO roomVO;
	
	public HotelTest(){

		/**
		 * 酒店业务逻辑领域对象
		 */
		this.hotel = new Hotel("12345678912");
        /**
         * 酒店数据接口的stub
         */
        HotelDao_Stub hotelDao_stub = new HotelDao_Stub();

		RoomManager roomManager = new RoomManager(hotelDao_stub);
		HotelManager hotelManager = new HotelManager(roomManager, hotelDao_stub);
		RoomAvail roomAvail = new RoomAvail(hotelDao_stub);

		hotel.setHotelManager(hotelManager);
		hotel.setRoomAvail(roomAvail);
        hotel.setHotelDao(hotelDao_stub);

        /**
         * 只有id,用于简单测试
         */
        hotelVO = new HotelVO(this.hotel.id);

        /**
         *
         */
        roomVO = new RoomVO(this.hotel.id, RoomType.doubleRoom, 20, 300, "basic");
    }

    @Test
	public void updateHotelTest() {
		assertEquals(ResultMessage.succeed, hotel.updateHotel(this.hotelVO));
	}
	@Test
	public void addSpecialRoomTest() {
		assertEquals(ResultMessage.succeed, hotel.addSpecialRoom(this.roomVO));
	}
	@Test
	public void deleteSpecialRoomTest() {
		assertEquals(ResultMessage.succeed, hotel.deleteSpecialRoom(this.roomVO));
	}
	@Test
	public void getRoomListTest() {
		assertEquals(this.hotel.id, hotel.getRoomList().get(0).id);
		assertEquals(RoomType.doubleRoom, hotel.getRoomList().get(0).type);
	}
	@Test
	public void updateRoomListTest() {
        RoomVO roomVO = new RoomVO("12345678912", RoomType.singleRoom, 10, 200, "basic");
        ArrayList<RoomVO> rooms = new ArrayList<RoomVO>();
        rooms.add(roomVO);
		assertEquals(ResultMessage.succeed, hotel.updateRoomList(rooms));
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
		assertEquals("6666666666", hotel.getRoomAvailList(date).get(0).id);
		assertEquals(RoomType.doubleRoom, hotel.getRoomAvailList(date).get(0).type);
	}
	@Test
	public void updateRoomAvailListTest() {
		ArrayList<RoomAvailVO> list = new ArrayList<RoomAvailVO>();
		list.add(new RoomAvailVO("0000000000", RoomType.doubleRoom, 10, 200, "basic"));
		assertEquals(ResultMessage.succeed, hotel.updateRoomAvailList(list));
	}
	
}
