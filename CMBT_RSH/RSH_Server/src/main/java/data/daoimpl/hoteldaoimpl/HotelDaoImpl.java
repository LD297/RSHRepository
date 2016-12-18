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
    private static HotelDaoImpl hotelDaoImpl;
    private HotelDaoHelper hotelDaoHelper;
    private DaoHelperFactory daoHelperFactory;

    public HotelDaoImpl()throws RemoteException{
        daoHelperFactory = new DaoHelperFactoryImpl();
        hotelDaoHelper = daoHelperFactory.getHotelDaoHelper();
    }

    public static HotelDaoImpl getInstance(){
        if(hotelDaoImpl ==null){
            try {
                hotelDaoImpl = new HotelDaoImpl();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return hotelDaoImpl;
    }
    // 根据酒店ID 得到酒店对象
    public HotelPO getHotel(String hotelID) throws RemoteException{
        return hotelDaoHelper.getHotel(hotelID);
    }
    // 根据酒店传入地区 初始化酒店账号
    public String getNewHotelID(String district) throws RemoteException{
        return hotelDaoHelper.getNewHotelID(district);
    }
    // 添加酒店（注销酒店 暂不考虑）
    public ResultMessage addHotel(HotelPO hotelPO) throws RemoteException{
        return hotelDaoHelper.addHotel(hotelPO);
    }
    // 更新酒店评分
    public ResultMessage updateGrade(String hotelID,int grade) throws RemoteException{
        return hotelDaoHelper.updateGrade(hotelID, grade);
    }
    // 更新酒店基本信息
    public ResultMessage updateHotel (HotelPO hotelPO) throws RemoteException{
        return hotelDaoHelper.updateHotel(hotelPO);
    }
    // 根据roompo里的酒店账号 添加酒店的客房信息 并将该房间类型可用客房数量置为总数
    public ResultMessage addSpecialRoom(RoomPO roomPO) throws RemoteException{
        return hotelDaoHelper.addSpecialRoom(roomPO);
    }
    // 根据roompo里的酒店账号 删除酒店的客房信息
    public ResultMessage deleteSpecialRoom(RoomPO roomPO) throws RemoteException{
        return hotelDaoHelper.deleteSpecialRoom(roomPO);
    }
    // 根据酒店ID 得到酒店的所有房间的信息
    public ArrayList<RoomPO> getRoomList(String hotelID) throws RemoteException{
        return hotelDaoHelper.getRoomList(hotelID);
    }
    // 根据roompo里的酒店账号 更新该房间类型的信息
    public ResultMessage updateRoom(RoomPO roomPO) throws RemoteException{
        return hotelDaoHelper.updateRoom(roomPO);
    }
    // 根据酒店ID、日期 得到酒店在该日期下的所有客房的可用信息
    public ArrayList<RoomAvailPO> getRoomAvailList(String hotelID, Date checkIn) throws RemoteException{
        return hotelDaoHelper.getRoomAvailList(hotelID, checkIn);
    }
    // 更改酒店 房间类型 房间可用数量的信息
    // 当酒店手动修改（checkin==checkout）
    public ResultMessage changeRoomAvail(String id, String roomType,boolean isPlus, int num, Date checkIn, Date checkOut) throws RemoteException{
        return hotelDaoHelper.changeRoomAvail(id, roomType, isPlus, num, checkIn, checkOut);
    }
    // 得到酒店 房间类型 一段日期 可用数量
    public int numOfRoomAvail(String id, String roomType, Date checkIn, Date checkOut) throws RemoteException{
        return hotelDaoHelper.numOfRoomAvail(id, roomType, checkIn, checkOut);
    }
    // 根据地址和商圈的到酒店列表
    public ArrayList<HotelPO> getHotelList(String address,String businessArea) throws RemoteException{
        return hotelDaoHelper.getHotelList(address, businessArea);
    }

}
