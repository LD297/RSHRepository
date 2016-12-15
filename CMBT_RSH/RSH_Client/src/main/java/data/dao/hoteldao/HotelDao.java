package data.dao.hoteldao;

import constant.ResultMessage;
import constant.SortBy;
import constant.SortMethod;
import po.HotelPO;
//import po.HotelStaffPO;
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
    
    public ResultMessage deleteHotel(String id) throws RemoteException;
    
    public ResultMessage updateHotel (HotelPO hotelPO) throws RemoteException;
    
    public ResultMessage addSpecialRoom(RoomPO roomPO) throws RemoteException;
    
    public ResultMessage deleteSpecialRoom(RoomPO po) throws RemoteException;
    
    public ArrayList<RoomVO> getRoomList(String id) throws RemoteException;
    
    public ResultMessage updateRoomList(ArrayList<RoomPO> roomPOList) throws RemoteException;
    
    public ArrayList<RoomAvailVO> getRoomAvailList(String id, Date checkIn, Date checkOut) throws RemoteException;
    
   
    
    public ResultMessage changeRoomAvail(String id, String roomType,boolean isPlus, int num, Date checkIn, Date checkOut) throws RemoteException;
    
    public int numOfRoomAvail(String id, String roomType, Date checkIn, Date checkOut) throws RemoteException;
    
    
    public ResultMessage updateRoomAvailList(String id, ArrayList<RoomAvailVO> roomAvailList) throws RemoteException;
    
    public ArrayList<RoomNormVO> getRoomNorm(String id) throws RemoteException;
    
    public ArrayList<HotelVO> getHotelList(String address,String businessArea) throws RemoteException;
     
    public ArrayList<HotelVO> select(SelectConditionVO vo) throws RemoteException;
    
   
   
    
  
}

