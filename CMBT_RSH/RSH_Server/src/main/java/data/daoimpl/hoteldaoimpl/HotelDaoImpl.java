package data.daoimpl.hoteldaoimpl;

import constant.ResultMessage;
import data.dao.hoteldao.HotelDao;
import data.daohelper.DaoHelperFactory;
import data.daohelper.HotelDaoHelper;
import data.daohelperimpl.DaoHelperFactoryImpl;
import po.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by a297 on 16/11/26.
 */
public class HotelDaoImpl extends UnicastRemoteObject implements HotelDao {
    private HotelDaoHelper hotelDaoHelper = null;
    private DaoHelperFactory daoHelperFactory = null;

    private HotelDaoImpl()throws RemoteException{
    	if(daoHelperFactory==null)
    		daoHelperFactory = new DaoHelperFactoryImpl();
    	if(hotelDaoHelper==null)
            hotelDaoHelper = daoHelperFactory.getHotelDaoHelper();
    }
    
    public static HotelDaoImpl getInstance(){
    	try {
			return new HotelDaoImpl();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
    }

    // 根据酒店ID 得到酒店对象
    @Override
    public HotelPO getHotel(String hotelID) throws RemoteException{
        return hotelDaoHelper.getHotel(hotelID);
    }
    // 根据酒店传入地区 初始化酒店账号
    @Override
    public String getNewHotelID(String district) throws RemoteException{
        return hotelDaoHelper.getNewHotelID(district);
    }
    // 添加酒店（注销酒店 暂不考虑）
    @Override
    public ResultMessage addHotel(HotelPO hotelPO) throws RemoteException{
        return hotelDaoHelper.addHotel(hotelPO);
    }
    // 更新酒店评分
    @Override
    public ResultMessage updateGrade(String hotelID,int grade) throws RemoteException{
        return hotelDaoHelper.updateGrade(hotelID, grade);
    }
    // 更新酒店基本信息
    @Override
    public ResultMessage updateHotel (HotelPO hotelPO) throws RemoteException{
        return hotelDaoHelper.updateHotel(hotelPO);
    }
    // 根据roompo里的酒店账号 添加酒店的客房信息 并将该房间类型可用客房数量置为总数
    @Override
    public ResultMessage addSpecialRoom(RoomPO roomPO) throws RemoteException{
        return hotelDaoHelper.addSpecialRoom(roomPO);
    }
    // 根据roompo里的酒店账号 删除酒店的客房信息
    @Override
    public ResultMessage deleteSpecialRoom(RoomPO roomPO) throws RemoteException{
        return hotelDaoHelper.deleteSpecialRoom(roomPO);
    }
    // 根据酒店ID 得到酒店的所有房间的信息
    @Override
    public ArrayList<RoomPO> getRoomList(String hotelID) throws RemoteException{
        return hotelDaoHelper.getRoomList(hotelID);
    }
    // 根据roompo里的酒店账号 更新该房间类型的信息
    @Override
    public ResultMessage updateRoom(RoomPO roomPO) throws RemoteException{
        return hotelDaoHelper.updateRoom(roomPO);
    }
    // 根据酒店ID、日期 得到酒店在该日期下的所有客房的可用信息
    @Override
    public ArrayList<RoomAvailPO> getRoomAvailList(String hotelID, Date checkIn) throws RemoteException{
        return hotelDaoHelper.getRoomAvailList(hotelID, checkIn);
    }
    // 更改酒店 房间类型 房间可用数量的信息
    // 当酒店手动修改（checkin==checkout）
    @Override
    public ResultMessage changeRoomAvail(String id, String roomType,boolean isPlus, int num, Date checkIn, Date checkOut) throws RemoteException{
        return hotelDaoHelper.changeRoomAvail(id, roomType, isPlus, num, checkIn, checkOut);
    }
    // 得到酒店 房间类型 一段日期 可用数量
    @Override
    public int numOfRoomAvail(String id, String roomType, Date checkIn, Date checkOut) throws RemoteException{
        return hotelDaoHelper.numOfRoomAvail(id, roomType, checkIn, checkOut);
    }
    // 根据地址和商圈的到酒店列表
    @Override
    public ArrayList<HotelPO> getHotelList(String district) throws RemoteException{
        return hotelDaoHelper.getHotelList(district);
    }
    // 网站管理人员 得到酒店信息
    @Override
    public ArrayList<HotelPO> getAll() throws RemoteException{
    	return hotelDaoHelper.getAll();
    }
    // 得到酒店所需图片地址
    @Override
    public ArrayList<String> getImageAddresses(String hotelID) throws RemoteException{
    	return hotelDaoHelper.getImageAddresses(hotelID);
    }
  

}
