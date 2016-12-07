package data.daoimpl.hoteldaoimpl;

import constant.ResultMessage;
import constant.SortBy;
import constant.SortMethod;
import data.dao.hoteldao.HotelDao;
import data.daohelper.DaoHelperFactory;
import data.daohelper.HotelDaoHelper;
import data.daohelperimpl.DaoHelperFactoryImpl;
import po.HotelPO;
import po.HotelStaffPO;
import vo.HotelVO;
import vo.RoomAvailVO;
import vo.RoomVO;
import vo.SelectConditionVO;

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

    private HotelDaoImpl()throws RemoteException{
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
    public ResultMessage addComment(String id, String userID, String comment)throws RemoteException {
        return null;
    }

    public ResultMessage checkPassword(String id, String password)throws RemoteException {
        return null;
    }

    public HotelPO getHotel(String id)throws RemoteException {
        return null;
    }

    public ResultMessage updateGrade(double grade)throws RemoteException {
        return null;
    }

    public ResultMessage updateHotel(HotelVO vo)throws RemoteException {
        return null;
    }

    public ResultMessage addSpecialRoom(RoomVO vo)throws RemoteException {
        return null;
    }

    public ResultMessage deleteSpecialRoom(RoomVO vo)throws RemoteException {
        return null;
    }

    public ArrayList<RoomVO> getRoomList()throws RemoteException {
        return null;
    }

    public ResultMessage updateRoomList(ArrayList<RoomVO> roomList)throws RemoteException {
        return null;
    }

    public ResultMessage changeRoomAvail(String roomType, int num, Date checkIn, Date checkOut)throws RemoteException {
        return null;
    }

    public int numOfRoomAvail(String roomType, Date checkIn, Date checkOut)throws RemoteException {
        return 0;
    }

    public ArrayList<RoomAvailVO> getRoomAvailList(Date date)throws RemoteException {
        return null;
    }

    public ResultMessage updateRoomAvailList(ArrayList<RoomAvailVO> availableRoomList)throws RemoteException {
        return null;
    }

    public ArrayList<HotelVO> getHotelList(String address, String businessArea)throws RemoteException {
        return null;
    }

    public HotelVO getHotelInfo(String id)throws RemoteException {
        return null;
    }

    public ArrayList<HotelVO> sort(SortBy sortBy, SortMethod sortM)throws RemoteException {
        return null;
    }

    public ArrayList<HotelVO> select(SelectConditionVO vo)throws RemoteException {
        return null;
    }

    public int getHotelNum(String address)throws RemoteException {
        return 0;
    }

    public ResultMessage addHotel(String id, String password)throws RemoteException {
        return null;
    }

    public ResultMessage deleteHotel(String id)throws RemoteException {
        return null;
    }

    public ResultMessage updateHotelStaff(HotelStaffPO po)throws RemoteException {
        return null;
    }
}
