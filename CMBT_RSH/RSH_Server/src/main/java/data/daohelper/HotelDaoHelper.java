package data.daohelper;

import constant.ResultMessage;
import constant.SortBy;
import constant.SortMethod;
import po.HotelPO;
import po.HotelStaffPO;
import vo.HotelVO;
import vo.RoomAvailVO;
import vo.RoomVO;
import vo.SelectConditionVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by aa on 2016/12/3.
 */
public interface HotelDaoHelper {
    public ResultMessage addComment(String hotelID, String userID,  int grade,String comment)throws RemoteException ;

    public ResultMessage checkPassword(String hotelID, String password)throws RemoteException ;

    public HotelPO getHotel(String hotelID)throws RemoteException ;

    public ResultMessage updateGrade(String hotelID,int grade)throws RemoteException ;

    public ResultMessage updateHotel(HotelVO vo)throws RemoteException ;

    public ResultMessage addSpecialRoom(RoomVO vo)throws RemoteException ;

    public ResultMessage deleteSpecialRoom(RoomVO vo)throws RemoteException ;

    public ArrayList<RoomVO> getRoomList(String hotelID)throws RemoteException ;

    public ResultMessage updateRoom(RoomVO vo)throws RemoteException ;

    public ResultMessage changeRoomAvail(String hotelid,String roomType,Boolean isPlus, int num, Date checkIn, Date checkOut)throws RemoteException ;

    public int numOfRoomAvail(String hotelid,String roomType, Date checkIn, Date checkOut)throws RemoteException ;

    public ArrayList<RoomAvailVO> getRoomAvailList(String hotelid,Date date)throws RemoteException ;

    public ResultMessage updateRoomAvail(RoomAvailVO vo)throws RemoteException ;

    public ArrayList<HotelVO> getHotelList(String address, String businessArea)throws RemoteException ;

    public HotelVO getHotelInfo(String id)throws RemoteException ;

//  public ArrayList<HotelVO> sort(SortBy sortBy, SortMethod sortM)throws RemoteException ;

    public ArrayList<HotelVO> selectByName(String hotelName)throws RemoteException;

    public ArrayList<HotelVO> selectByCondition(SelectConditionVO vo)throws RemoteException ;

    public int getHotelNum(String address)throws RemoteException ;

    public ResultMessage addHotel(String id, String password)throws RemoteException ;

    public ResultMessage deleteHotel(String id)throws RemoteException ;

    public ResultMessage updateHotelStaff(HotelStaffPO po)throws RemoteException ;
}
