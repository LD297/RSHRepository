package bl.hotelserviceimpl;

import constant.ResultMessage;
import data.dao.hoteldao.HotelDao;
import data.dao.hoteldao.HotelDao_Stub;
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
	
	public Hotel(String id){
		this.id = id;
	}

	public void setHotelManager(HotelManager hotelManager) {
		this.hotelManager = hotelManager;
	}

	public void setRoomAvail(RoomAvail roomavail) {
		this.roomAvail = roomavail;
	}

	public void setHotelDao(HotelDao hotelDao){
		this.hotelDao = hotelDao;
		initHotelPO();
	}

	private void initHotelPO() {
		try {
			hotelPO = hotelDao.getHotel(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

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
	
	// 酒店自身dao建立后，随即初始化该酒店po，用来生成vo，供展示层用
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
	
	public ArrayList<RoomAvailVO> getRoomAvailList(Date checkIn,Date checkOut) {
		return roomAvail.getRoomAvailList(id, checkIn, checkOut);
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
			arrayList = hotelDao.getRoomNorm(this.id);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return arrayList;
	}

	// 供给order模块
	// 返回该酒店指定日期下该房间类型的可用数量
	public int numOfRoomAvail(String roomType, Date checkIn, Date checkOut) {
		return roomAvail.getRoomAvailNum(this.id, roomType, checkIn, checkOut);
	}

	// 供给order模块
	// 更新系统的可用客房信息
	public ResultMessage changeRoomAvail(String roomType,Boolean isPlus, int num, Date checkIn, Date checkOut) {
		return roomAvail.changeRoomAvail(this.id, roomType, isPlus,num, checkIn, checkOut);
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
	/**
	 * 更新数据库中酒店的评分
	 * @param grade 用户打分（范围0~5，闭区间，加权计算后界面输出星级）
	 * @return
	 */
	public ResultMessage updateGrade(int grade) {
		ResultMessage resultMessage = null;
		try {
			resultMessage = hotelDao.updateGrade(grade);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return resultMessage;
	}
	
}
