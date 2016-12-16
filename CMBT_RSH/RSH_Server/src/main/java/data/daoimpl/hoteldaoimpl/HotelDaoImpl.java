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
    public ResultMessage addComment(String hotelid, String userid, int grade, String comment)throws RemoteException {
        return hotelDaoHelper.addComment(hotelid,userid,grade,comment);
    }

    public ResultMessage checkPassword(String hotelid, String password)throws RemoteException {
        return hotelDaoHelper.checkPassword(hotelid,password);
    }

    public HotelPO getHotel(String id)throws RemoteException {
        return hotelDaoHelper.getHotel(id);
    }

    public ResultMessage updateGrade(String hotelid,int grade)throws RemoteException {
        return hotelDaoHelper.updateGrade(hotelid,grade);
    }

    public ResultMessage updateHotel(HotelVO vo)throws RemoteException {
        return hotelDaoHelper.updateHotel(vo);
    }

    public ResultMessage addSpecialRoom(RoomVO vo)throws RemoteException {
        return hotelDaoHelper.addSpecialRoom(vo);
    }

    public ResultMessage deleteSpecialRoom(RoomVO vo)throws RemoteException {
        return hotelDaoHelper.deleteSpecialRoom(vo);
    }

    public ArrayList<RoomVO> getRoomList(String hotelid)throws RemoteException {
        return hotelDaoHelper.getRoomList(hotelid);
    }

    public ResultMessage updateRoom(RoomVO vo)throws RemoteException {
        return hotelDaoHelper.updateRoom(vo);
    }

    public ResultMessage changeRoomAvail(String hotelid,String roomType,Boolean isPlus, int num, Date checkIn, Date checkOut)throws RemoteException {
        return hotelDaoHelper.changeRoomAvail(hotelid,roomType,isPlus,num,checkIn,checkOut);
    }

    public int numOfRoomAvail(String hotelid,String roomType, Date checkIn, Date checkOut)throws RemoteException {
        return hotelDaoHelper.numOfRoomAvail(hotelid,roomType,checkOut,checkOut);
    }

    public ArrayList<RoomAvailVO> getRoomAvailList(String hotelID, Date checkIn, Date checkOut)throws RemoteException {
        return hotelDaoHelper.getRoomAvailList(hotelID,checkIn,checkOut);
    }

    public ResultMessage updateRoomAvail(RoomAvailVO vo)throws RemoteException {
        return null;
    }

    public ArrayList<HotelVO> getHotelList(String address, String businessArea)throws RemoteException {
        return hotelDaoHelper.getHotelList(address,businessArea);
    }

    public HotelVO getHotelInfo(String hotelid)throws RemoteException {
        return hotelDaoHelper.getHotelInfo(hotelid);
    }

/*    public ArrayList<HotelVO> sort(SortBy sortBy, SortMethod sortM)throws RemoteException {
        return null;
    }*/
    public ArrayList<HotelVO> selectByName(String hotelName)throws RemoteException{
        return hotelDaoHelper.selectByName(hotelName);
    }

    public ArrayList<HotelVO> selectByCondition(SelectConditionVO vo)throws RemoteException {
        return hotelDaoHelper.selectByCondition(vo);
    }

    public int getHotelNum(String address)throws RemoteException {
        return hotelDaoHelper.getHotelNum(address);
    }

    public ResultMessage addHotel(String hotelid, String password)throws RemoteException {
        return hotelDaoHelper.addHotel(hotelid,password);
    }

    public ResultMessage deleteHotel(String hotelid)throws RemoteException {
        return hotelDaoHelper.deleteHotel(hotelid);
    }

    public ResultMessage updateHotelStaff(HotelStaffPO po)throws RemoteException {
        return hotelDaoHelper.updateHotelStaff(po);
    }
}
