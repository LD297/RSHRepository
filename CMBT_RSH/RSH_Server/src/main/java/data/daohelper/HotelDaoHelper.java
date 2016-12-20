package data.daohelper;

import constant.ResultMessage;
import constant.SortBy;
import constant.SortMethod;
import po.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by aa on 2016/12/3.
 */
public interface HotelDaoHelper {
    // 根据酒店ID 得到酒店对象
    public HotelPO getHotel(String hotelID) throws RemoteException;
    // 根据酒店传入地区 初始化酒店账号
    public String getNewHotelID(String district) throws RemoteException;
    // 添加酒店（注销酒店 暂不考虑）
    public ResultMessage addHotel(HotelPO hotelPO) throws RemoteException;
    // 更新酒店评分
    public ResultMessage updateGrade(String hotelID,int grade) throws RemoteException;
    // 更新酒店基本信息
    public ResultMessage updateHotel (HotelPO hotelPO) throws RemoteException;
    // 根据roompo里的酒店账号 添加酒店的客房信息 并将该房间类型可用客房数量置为总数
    public ResultMessage addSpecialRoom(RoomPO roomPO) throws RemoteException;
    // 根据roompo里的酒店账号 删除酒店的客房信息
    public ResultMessage deleteSpecialRoom(RoomPO roomPO) throws RemoteException;
    // 根据酒店ID 得到酒店的所有房间的信息
    public ArrayList<RoomPO> getRoomList(String hotelID) throws RemoteException;
    // 根据roompo里的酒店账号 更新该房间类型的信息
    public ResultMessage updateRoom(RoomPO roomPO) throws RemoteException;
    // 根据酒店ID、日期 得到酒店在该日期下的所有客房的可用信息
    public ArrayList<RoomAvailPO> getRoomAvailList(String hotelID, Date checkIn) throws RemoteException;
    // 更改酒店 房间类型 房间可用数量的信息
    // 当酒店手动修改（checkin==checkout）
    public ResultMessage changeRoomAvail(String hotelID, String roomType,boolean isPlus, int num, Date checkIn, Date checkOut) throws RemoteException;
    // 得到酒店 房间类型 一段日期 可用数量
    public int numOfRoomAvail(String hotelID, String roomType, Date checkIn, Date checkOut) throws RemoteException;
    // 根据地址和商圈的到酒店列表
    public ArrayList<HotelPO> getHotelList(String district) throws RemoteException;
    // 网站管理人员 得到酒店信息
    public ArrayList<HotelPO> getAll() throws RemoteException;
 // 得到酒店所需图片地址
    public ArrayList<String> getImageAddresses(String hotelID) throws RemoteException;
}
