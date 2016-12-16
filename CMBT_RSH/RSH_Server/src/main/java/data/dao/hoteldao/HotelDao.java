package data.dao.hoteldao;

import constant.*;
import po.*;
import vo.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;
/**
 * 创建远程接口：
 * 1）直接或间接继承java.rmi.Remote接口
 * 2）接口中所有方法声明抛出java.rmi.RemoteException异常或父异常
 *
 * Created by a297 on 16/11/13.
 */
public interface HotelDao extends Remote {
    /**
     * 在数据库该酒店信息中加入一条评论
     * @param id
     * @param userID
     * @param comment
     * @return
     */
    public ResultMessage addComment(String id, String userID, int grade, String comment) throws RemoteException;
    public ResultMessage checkPassword(String id, String password) throws RemoteException;
    public HotelPO getHotel(String id) throws RemoteException;

    /**
     * 更新数据库中该酒店的评分
     * @param grade
     * @return
     */
    public ResultMessage updateGrade(String hotelid,int grade) throws RemoteException;
    public ResultMessage updateHotel (HotelVO vo) throws RemoteException;

    public ResultMessage addSpecialRoom(RoomVO vo) throws RemoteException;
    public ResultMessage deleteSpecialRoom(RoomVO vo) throws RemoteException;
    public ArrayList<RoomVO> getRoomList(String hotelid) throws RemoteException;
    public ResultMessage updateRoom(RoomVO vo) throws RemoteException;

    public ResultMessage changeRoomAvail(String hotelid,String roomType, Boolean isPlus,int num, Date checkIn, Date checkOut) throws RemoteException;
    public int numOfRoomAvail(String hotelid,String roomType, Date checkIn, Date checkOut) throws RemoteException;
    public ArrayList<RoomAvailVO> getRoomAvailList(String hotelid, Date checkIn, Date checkOut) throws RemoteException;
    public ResultMessage updateRoomAvail(RoomAvailVO vo) throws RemoteException;

    public ArrayList<HotelVO> getHotelList(String address,String businessArea) throws RemoteException;
    public HotelVO getHotelInfo(String id) throws RemoteException;
//  public ArrayList<HotelVO> sort(SortBy sortBy,SortMethod sortM) throws RemoteException;
    public ArrayList<HotelVO> selectByName(String hotelName)throws RemoteException;
    public ArrayList<HotelVO> selectByCondition(SelectConditionVO vo) throws RemoteException;
    public int getHotelNum(String address) throws RemoteException;
    public ResultMessage addHotel(String id,String password) throws RemoteException;
    public ResultMessage deleteHotel(String id) throws RemoteException;
    public ResultMessage updateHotelStaff(HotelStaffPO po) throws RemoteException;
}
