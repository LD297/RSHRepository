package bl.hotelserviceimpl;

import java.util.ArrayList;
import java.util.Date;

import org.junit.experimental.theories.Theories;
import org.omg.CORBA.ULongLongSeqHelper;

import bl.orderserviceimpl.Order;
import bl.orderserviceimpl.initialOrder;
import constant.*;
import po.HotelPO;
import vo.*;

public class Hotel{
	
	String id;
	HotelPO hotelInfo;
	HotelManager hotelManager;
	RoomAvail roomAvail;
	
	
	Hotel(String id){
		this.id = id;
		this.init();
	}
	
	/**
	 * 初始化一些成员变量的值 
	 */
	private void init(){
		// TODO
	}
	
	public void setHotelManager(HotelManager hotelManager) {
		this.hotelManager = hotelManager;
	}

	public void setRoomAvail(RoomAvail roomavail) {
		this.roomAvail = roomavail;
	}

	// 静态直接调用
	public static ResultMessage checkPassword(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// 调用自身数据库
	public HotelVO getHotel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// 调用自身数据库
	public ResultMessage updateGrade(double grade) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ResultMessage updateHotel(HotelVO vo) {
		return hotelManager.updateHotel(vo);
	}
	
	public ResultMessage addSpecialRoom(RoomVO vo) {
		return hotelManager.addSpecialRoom(vo);
	}
	
	public ResultMessage deleteSpecialRoom(RoomVO vo) {
		return hotelManager.deleteSpecialRoom(vo);
	}
	
	public ArrayList<RoomVO> getRoomList() {
		return hotelManager.getRoomList();
	}
	
	public ResultMessage updateRoomList(ArrayList<RoomVO> roomList) {
		return hotelManager.updateRoomList(roomList);
	}
	
	public ArrayList<RoomAvailVO> getRoomAvailList(Date date) {
		return roomAvail.getRoomAvailList(date);
	}
	
	public ResultMessage updateRoomAvailList(ArrayList<RoomAvailVO> availableRoomList) {
		return roomAvail.updateRoomAvailList(availableRoomList);
	}
	
	/**
	 * 供给order模块
	 * 返回该酒店的所有房间规格（类型、价格）
	 * 调用自身数据库实现
	 * @return
	 */
	public ArrayList<RoomNormVO> getRoomNorms() {
		// TODO Auto-generated method stub
		return null;
	}

	// 供给order模块
	// 返回该酒店指定日期下该房间类型的可用数量
	public int numOfRoomAvail(RoomType roomType, Date checkIn, Date checkOut) {
		return roomAvail.numOfRoomAvail(roomType, checkIn, checkOut);
	}

	// 供给order模块
	// 更新系统的可用客房信息
	public ResultMessage changeRoomAvail(RoomType roomType, int num, Date checkIn, Date checkOut) {
		return roomAvail.changeRoomAvail(roomType, num, checkIn, checkOut);
	}

	// 供给order模块
	// 返回该酒店的最晚入住时间
	// 
	public static String getCheckInDDL(String id) {
		return null;
	}
	
}
