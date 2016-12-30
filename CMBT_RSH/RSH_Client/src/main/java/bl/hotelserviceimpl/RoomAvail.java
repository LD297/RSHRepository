package bl.hotelserviceimpl;

import constant.ResultMessage;
import data.dao.hoteldao.HotelDao;
import po.RoomAvailPO;
import rmi.RemoteHelper;
import vo.RoomAvailVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

public class RoomAvail {

	HotelDao hotelDao = null;
	String hotelID;
	
	public static RoomAvail getInstance(String hotelID){
		return new RoomAvail(hotelID);
	}
	
	private RoomAvail(String hotelID){
		this.hotelID = hotelID;
	}
	
	private void initRemote(){
		if(hotelDao==null){
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			hotelDao = remoteHelper.getHotelDao();
		}
	}

	// 供给order模块
	// 返回该酒店指定日期下该房间类型的可用数量
	public int getRoomAvailNum(String roomType, Date checkIn, Date checkOut) {
		int numOfRoomAvail = 0;
		initRemote();
		try{
			numOfRoomAvail = hotelDao.numOfRoomAvail(hotelID, roomType, checkIn, checkOut);
		}catch (RemoteException e){
			e.printStackTrace();
			return 0;
		}
		return numOfRoomAvail;
	}
	
	// 供给order模块
	// 更新系统的可用客房信息
	public ResultMessage changeRoomAvail( String roomType,boolean isPlus,int num, Date checkIn, Date checkOut) {
		initRemote();
		try {
			return hotelDao.changeRoomAvail(hotelID, roomType,isPlus, num, checkIn, checkOut);
		}catch (RemoteException e){
			e.printStackTrace();
			return ResultMessage.remote_fail;
		}
	}
	
	public ArrayList<RoomAvailVO> getRoomAvailList( Date checkIn) {
		ArrayList<RoomAvailPO> availPOs = new ArrayList<>();
		ArrayList<RoomAvailVO> availVOs = new ArrayList<>();
		initRemote();
		try{
			availPOs = hotelDao.getRoomAvailList(hotelID, checkIn);
		}catch (RemoteException e){
			e.printStackTrace();
			return availVOs;
		}
		for(RoomAvailPO roomAvailPO:availPOs){
			availVOs.add(roomAvailPO.changeIntoVO());
		}
		return availVOs;
	}
	

}
