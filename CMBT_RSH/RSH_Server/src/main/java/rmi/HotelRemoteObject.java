package rmi;

import constant.*;
import data.dao.hoteldao.HotelDao;
import data.daoimpl.hoteldaoimpl.HotelDaoImpl;
import po.*;
import vo.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

/**
 * 创建远程类：
 * 1）继承java.rmi.server.UnicastRemoteObject类并实现远程接口
 * 2）构造器必须抛出RemoteException异常
 *
 * Created by a297 on 16/11/26.
 */
public class HotelRemoteObject extends UnicastRemoteObject implements HotelDao {
    /**
     *
     * @throws RemoteException
     */
    private static final long serialVersioUID = 4029039744279087114L;
    private HotelDao hotelDao;
    protected HotelRemoteObject() throws RemoteException {
        hotelDao = HotelDaoImpl.getInstance();
    }


    public ResultMessage addComment(String id, String userID, String comment) throws RemoteException {
        return hotelDao.addComment(id, userID,comment);
    }

    public ResultMessage checkPassword(String id, String password) throws RemoteException {
        return hotelDao.checkPassword(id, password);
    }

    public HotelPO getHotel(String id) throws RemoteException{
        return hotelDao.getHotel(id);
    }

    public ResultMessage updateGrade(double grade) throws RemoteException {
        return hotelDao.updateGrade(grade);
    }

    public ResultMessage updateHotel(HotelVO vo) throws RemoteException {
        return hotelDao.updateHotel(vo);
    }

    public ResultMessage addSpecialRoom(RoomVO vo) throws RemoteException {
        return hotelDao.addSpecialRoom(vo);
    }

    public ResultMessage deleteSpecialRoom(RoomVO vo) throws RemoteException {
        return hotelDao.deleteSpecialRoom(vo);
    }

    public ArrayList<RoomVO> getRoomList() throws RemoteException {
        return hotelDao.getRoomList();
    }

    public ResultMessage updateRoomList(ArrayList<RoomVO> roomList) throws RemoteException {
        return hotelDao.updateRoomList(roomList);
    }

    public ResultMessage changeRoomAvail(String roomType, int num, Date checkIn, Date checkOut) throws RemoteException {
        return hotelDao.changeRoomAvail(roomType, num, checkIn, checkOut);
    }

    public int numOfRoomAvail(String roomType, Date checkIn, Date checkOut) throws RemoteException{
        return hotelDao.numOfRoomAvail(roomType, checkIn, checkOut);
    }

    public ArrayList<RoomAvailVO> getRoomAvailList(Date date) throws RemoteException {
        return hotelDao.getRoomAvailList(date);
    }

    public ResultMessage updateRoomAvailList(ArrayList<RoomAvailVO> roomAvailList)  throws RemoteException{
        return hotelDao.updateRoomAvailList(roomAvailList);
    }

    public ArrayList<HotelVO> getHotelList(String address, String businessArea) throws RemoteException {
        return hotelDao.getHotelList(address, businessArea);
    }

    public HotelVO getHotelInfo(String id) throws RemoteException {
        return hotelDao.getHotelInfo(id);
    }

    public ArrayList<HotelVO> sort(SortBy sortBy, SortMethod sortM) throws RemoteException {
        return hotelDao.sort(sortBy, sortM);
    }

    public ArrayList<HotelVO> select(SelectConditionVO vo) throws RemoteException {
        return hotelDao.select(vo);
    }

    public int getHotelNum(String address) throws RemoteException {
        return hotelDao.getHotelNum(address);
    }

    public ResultMessage addHotel(String id, String password) throws RemoteException {
        return hotelDao.addHotel(id, password);
    }

    public ResultMessage deleteHotel(String id) throws RemoteException {
        return hotelDao.deleteHotel(id);
    }

    public ResultMessage updateHotelStaff(HotelStaffPO po) throws RemoteException {
        return hotelDao.updateHotelStaff(po);
    }
}
