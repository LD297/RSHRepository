package bl.hotelserviceimpl;

import constant.ResultMessage;
import constant.RoomType;
import data.dao.hoteldao.HotelDao;
import po.HotelPO;
import vo.HotelVO;
import vo.RoomAvailVO;
import vo.RoomNormVO;
import vo.RoomVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

public class Hotel{

	String id;
	/**
	 * 该酒店信息，由构造方法初始化
	 */
	HotelPO hotelPO;
	HotelManager hotelManager;
	RoomAvail roomAvail;
	HotelDao hotelDao;
	
	Hotel(String id){
		this.id = id;
		try{
			this.hotelPO = hotelDao.getHotel(this.id);
		}catch (RemoteException e){
			e.printStackTrace();
		}
	}

	public void setHotelManager(HotelManager hotelManager) {
		this.hotelManager = hotelManager;
	}

	public void setRoomAvail(RoomAvail roomavail) {
		this.roomAvail = roomavail;
	}

	public void setHotelDao(HotelDao hotelDao){this.hotelDao = hotelDao;}

	// 调用自身数据库
	public ResultMessage checkPassword(String id, String password) {
		ResultMessage resultMessage = null;
		try {
			resultMessage = hotelDao.checkPassword(id, password);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return resultMessage;
	}
	
	// 调用自身数据库
	public HotelVO getHotel() {
		return HotelVO.createHotelVO(hotelPO);
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
		return hotelManager.getRoomList(this.id);
	}
	
	public ResultMessage updateRoomList(ArrayList<RoomVO> roomList) {
		return hotelManager.updateRoomList(roomList);
	}
	
	public ArrayList<RoomAvailVO> getRoomAvailList(Date date) {
		return roomAvail.getRoomAvailList(id, date);
	}
	
	public ResultMessage updateRoomAvailList(ArrayList<RoomAvailVO> roomAvailList) {
		return roomAvail.updateRoomAvailList(id, roomAvailList);
	}
	
	/**
	 * 供给order模块
	 * 返回该酒店的所有房间规格（类型、价格）
	 * 调用自身数据库实现
	 * @return
	 */
	public ArrayList<RoomNormVO> getRoomNorms() {
		ArrayList<RoomNormVO> arrayList = null;
		try {
			arrayList = hotelDao.getRoomNorms(this.id);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return arrayList;
	}

	// 供给order模块
	// 返回该酒店指定日期下该房间类型的可用数量
	public int numOfRoomAvail(RoomType roomType, Date checkIn, Date checkOut) {
		return roomAvail.numOfRoomAvail(this.id, roomType, checkIn, checkOut);
	}

	// 供给order模块
	// 更新系统的可用客房信息
	public ResultMessage changeRoomAvail(RoomType roomType, int num, Date checkIn, Date checkOut) {
		return roomAvail.changeRoomAvail(this.id, roomType, num, checkIn, checkOut);
	}

	/**
	 * 供给order模块
	 * 返回该酒店的最晚入住时间
	 * 调用自身数据库实现
	 * @param id
	 * @return
	 */
	public String getCheckInDDL(String id) {
		String result = null;
		try {
			result = hotelDao.getCheckInDDL(id);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return result;
	}
	
}
