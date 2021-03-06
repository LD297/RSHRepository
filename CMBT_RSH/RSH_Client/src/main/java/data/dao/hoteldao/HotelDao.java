package data.dao.hoteldao;

import constant.ResultMessage;
import constant.SortBy;
import constant.SortMethod;
import po.HotelPO;
import po.RoomAvailPO;
import po.RoomNormPO;
//import po.HotelStaffPO;
import po.RoomAvailPO;
import po.RoomNormPO;
import po.RoomPO;
import vo.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * 服务器HotelDao的stub
 * Created by a297 on 16/11/13.
 */
public interface HotelDao extends Remote{

    public HotelPO getHotel(String id) throws RemoteException;
    
    public String getNewHotelID(String district) throws RemoteException;
    
    public ResultMessage addHotel(HotelPO hotelPO) throws RemoteException;
    
   
    
    public ResultMessage updateHotel (HotelPO hotelPO) throws RemoteException;
    
    public ResultMessage addSpecialRoom(RoomPO roomPO) throws RemoteException;
    
    public ResultMessage deleteSpecialRoom(RoomPO po) throws RemoteException;
    
    public ArrayList<RoomPO> getRoomList(String id) throws RemoteException;
    
    public ResultMessage updateRoomList(RoomPO roomPO) throws RemoteException;
    
    public ArrayList<RoomAvailPO> getRoomAvailList(String id, Date checkIn) throws RemoteException;
    
    public ResultMessage changeRoomAvail(String id, String roomType,boolean isPlus, int num, Date checkIn, Date checkOut) throws RemoteException;
    
    public int numOfRoomAvail(String id, String roomType, Date checkIn, Date checkOut) throws RemoteException;
    
    public ArrayList<HotelPO> getHotelList(String district) throws RemoteException;
   
    public ResultMessage updateGrade(String hotelID,int grade) throws RemoteException;
    
    public ArrayList<HotelPO> getAll() throws RemoteException;
    
    public ArrayList<String> getImageAddresses(String hotelID) throws RemoteException;
    
      // 根据roompo里的酒店账号 更新该房间类型的信息
    public ResultMessage updateRoom(RoomPO roomPO) throws RemoteException;
   
}

