package bl.hotelserviceimpl;

import constant.ResultMessage;
import data.dao.hoteldao.HotelDao;
import data.dao_Stub.hoteldao_Stub.HotelDao_Stub;
import po.HotelPO;
import po.RoomNormPO;
import po.RoomPO;
import rmi.RemoteHelper;
import vo.HotelVO;
import vo.RoomAvailVO;
import vo.RoomNormVO;
import vo.RoomVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

public class Hotel{

	String hotelID;
	HotelPO hotelPO;   //持有持久化对象引用以保存具体数据
	private HotelManager hotelManager;
	RoomAvail roomAvail;
	private ArrayList<String> imageAddresses = null;
	
	private static HotelDao hotelDao= null;
	
	private void initRemote(){
		RemoteHelper remoteHelper = RemoteHelper.getInstance();
		hotelDao  = remoteHelper.getHotelDao();
	}
	
	private Hotel(String hotelID){
		initRemote();
		this.hotelID = hotelID;
		hotelManager = HotelManager.getInstance(hotelID);
		roomAvail = RoomAvail.getInstance(hotelID);
		try {
			hotelPO = hotelDao.getHotel(hotelID);
			imageAddresses = hotelDao.getImageAddresses(hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static Hotel getInstance(String hotelID){
		return new Hotel(hotelID);
	}


	public static ResultMessage addHotel(HotelVO hotelVO) {
		HotelPO newHotelPO = hotelVO.changeIntoPO();
		ResultMessage resultMessage = null;
		try {
			resultMessage = hotelDao.addHotel(newHotelPO);
		}catch (RemoteException e){
			return ResultMessage.remote_fail;
		}
		return resultMessage;
	}

	// 调用自身数据库
	public ResultMessage checkPassword(String password) {
		if(hotelPO==null){
			return ResultMessage.idNotExist;
		}
		if(hotelPO.getPassword().equals(password)){
			return ResultMessage.succeed;
		}
		else{
			return ResultMessage.password_wrong;
		}
	}
	
	// 酒店自身dao建立后，随即初始化该酒店po，用来生成vo，供展示层用
	public HotelVO getHotelInfo() {
		if(hotelPO == null)
			return null;
		return hotelPO.changeIntoVO();
	}

	public ResultMessage updateHotel(HotelVO vo) {
		return getHotelManager().updateHotel(vo);
	}
	
	public ResultMessage addSpecialRoom(RoomVO vo) {
		RoomManager roomManager = getHotelManager().getRoomManager();
		return roomManager.addSpecialRoom(vo);
	}
	
	public ResultMessage deleteSpecialRoom(RoomVO vo) {
		RoomManager roomManager = getHotelManager().getRoomManager();
		return roomManager.deleteSpecialRoom(vo);
	}
	
	public ArrayList<RoomVO> getRoomList() {
		RoomManager roomManager = getHotelManager().getRoomManager();
		return roomManager.getRoomList();
	}
	
	public ResultMessage updateRoomList(ArrayList<RoomVO> roomList) {
		RoomManager roomManager = getHotelManager().getRoomManager();
		return roomManager.updateRoomList(roomList);
	}
	
	public ArrayList<RoomAvailVO> getRoomAvailList(Date checkIn,Date checkOut) {
		return roomAvail.getRoomAvailList(checkIn);
	}
	
	
	/**
	 * 供给order模块
	 * 返回该酒店的所有房间规格（类型、价格）
	 * 调用自身数据库实现
	 * @return
	 */
	public ArrayList<RoomNormVO> getRoomNorms() {
		ArrayList<RoomPO> roomPOs = null;
		try {
			roomPOs = hotelDao.getRoomList(hotelID);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		ArrayList<RoomNormVO> roomNormVOs  = new ArrayList<>();
		for(RoomPO roomPO:roomPOs){
			roomNormVOs.add(new RoomNormVO(hotelID, roomPO.getType(), roomPO.getPrice()));
		}
		return roomNormVOs;
	}

	// 供给order模块
	// 返回该酒店指定日期下该房间类型的可用数量
	public int numOfRoomAvail(String roomType, Date checkIn, Date checkOut) {
		return roomAvail.getRoomAvailNum( roomType, checkIn, checkOut);
	}

	// 供给order模块
	// 更新系统的可用客房信息
	public ResultMessage changeRoomAvail(String roomType,Boolean isPlus, int num, Date checkIn, Date checkOut) {
		return roomAvail.changeRoomAvail( roomType, isPlus,num, checkIn, checkOut);
	}

	/**
	 * 供给order模块
	 * 返回该酒店的最晚入住时间
	 * 调用自身数据库实现
	 * @param id
	 * @return
	 */
	public String getCheckInDDL() {
		if(hotelPO==null){
			return "00:00:00";
		}
		return hotelPO.getLatestCheckinTime();
	}
	/**
	 * 更新数据库中酒店的评分
	 * update grade  where  to do it???
	 * @param grade 用户打分（范围0~5，闭区间，加权计算后界面输出星级）
	 * @return
	 */
	public ResultMessage updateGrade(int grade) {
		initRemote();
		try {
			return hotelDao.updateGrade(hotelID, grade);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.remote_fail;
		}
	}

	public HotelManager getHotelManager() {
		return hotelManager;
	}

	public boolean hasEnoughRoom(String roomType, int roomNum, Date begin, Date end) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<String> getImageAddresses(){
		ArrayList<String > images = new ArrayList<>();
		for(String imageAddress:imageAddresses){
			images.add(imageAddress.split(" ")[1]);
		}
		return images;
	}

	public String getImageAddresForRoom(String roomType) {
		// TODO Auto-generated method stub
		for(String imageAddress:imageAddresses){
			if(imageAddress.split(" ")[0].equals(roomType)){
				return imageAddress.split(" ")[1];
			}
		}
		return null;
	}
	
}
