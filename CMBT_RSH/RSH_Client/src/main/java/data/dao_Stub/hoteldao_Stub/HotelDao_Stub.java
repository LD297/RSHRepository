package data.dao_Stub.hoteldao_Stub;

import constant.ResultMessage;
import constant.SortBy;
import constant.SortMethod;
import data.dao.hoteldao.HotelDao;
import po.HotelPO;
import po.RoomAvailPO;
import po.RoomNormPO;
//import po.HotelStaffPO;
import po.RoomPO;
import vo.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by a297 on 16/11/20.
 */
public class HotelDao_Stub implements  HotelDao{
    public ResultMessage checkPassword(String id, String password) {
        if(id.equals("13951897687")&&password.equals("jksggkskjg"))
            return ResultMessage.succeed;
        else
            return ResultMessage.fail;
    }

    @Override
    public HotelPO getHotel(String id) {
    	HotelPO hotelPO = new HotelPO("0123456789","11122233344", "12345667781",  "天鸿凯莱大酒店", "南京市栖霞区", "123456",  
                "新开张", "一应俱全", 4, 4.8, 123);
    			
        return hotelPO;
    }

    public ResultMessage updateGrade(double grade) {
        // TODO: 16/11/20
        return null;
    }

    @Override
    public ResultMessage updateHotel(HotelPO hotelPO) {
        if(hotelPO.getName().equals("~~~"))
            return ResultMessage.succeed;
        else
            return ResultMessage.fail;
    }

    @Override
    public ResultMessage addSpecialRoom(RoomPO roomPO) {
        if(roomPO.getAmountTotal()==20)
            return ResultMessage.succeed;
        else
            return ResultMessage.fail;
    }

    @Override
    public ResultMessage deleteSpecialRoom(RoomPO po) {
        if(po.getAmountTotal()==20)
            return ResultMessage.succeed;
        else
            return ResultMessage.fail;
    }

    @Override
    public ArrayList<RoomPO> getRoomList(String id) {
        if(id.equals("~~~")){
            RoomVO roomVO = new RoomVO("12345678912", "doubleRoom", 20, 300, "basic");
            ArrayList<RoomPO> rooms = new ArrayList<RoomPO>();
            rooms.add(roomVO.changeIntoPO());
            return rooms;
        }
        else
            return null;
    }

    public ResultMessage updateRoomList(ArrayList<RoomPO> roomPOList) {
        if(roomPOList.get(0).getType().equals("singleRoom"))
            return ResultMessage.succeed;
        else
            return null;
    }

    @Override
    public ResultMessage changeRoomAvail(String id, String roomType, boolean isPlus,int num, Date checkIn, Date checkOut) {
        if(id.equals("12345678912"))
            return ResultMessage.succeed;
        else
            return ResultMessage.fail;
    }

    @Override
    public int numOfRoomAvail(String id, String roomType, Date checkIn, Date checkOut) {
        if(id.equals("12345678912")&&roomType.equals("singleRoom"))
            return 10;
        else
            return 0;
    }

    public ArrayList<RoomAvailVO> getRoomAvailList(String id, Date checkIn, Date checkOut) throws RemoteException {
        return null;
    }
    public ResultMessage updateRoomAvailList(String id, ArrayList<RoomAvailVO> roomAvailList) {
        if(id.equals("0000000000"))
            return ResultMessage.succeed;
        else
            return ResultMessage.fail;
    }


    public String getCheckInDDL(String id) {
        // TODO: 16/11/20
        return null;
    }

    @Override
    public ArrayList<HotelPO> getHotelList(String district) {
        // TODO: 16/11/20
        return null;
    }

    public HotelPO getHotelInfo(String id) {
        // TODO: 16/11/20
        return null;
    }



    public String getHotelID(String district) throws RemoteException {
        return null;
    }


    @Override
    public ResultMessage addHotel(HotelPO hotelPO) {
        if(hotelPO.getId().equals("6666666666")&&hotelPO.getPassword().equals("2333"))
            return ResultMessage.succeed;
        else
            return ResultMessage.fail;
    }

    @Override
    public ResultMessage deleteHotel(String id) {
        if(id.equals("2333333333"))
            return ResultMessage.succeed;
        else
            return ResultMessage.fail;
    }
/**
    @Override
    public ResultMessage updateHotelStaff(HotelStaffPO hotelStaffPO) {
        if(hotelStaffPO.getHotelID().equals("6666666666"))
            return ResultMessage.succeed;
        else
            return ResultMessage.fail;
    }
*/
	@Override
	public String getNewHotelID(String district) throws RemoteException {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
     public ResultMessage updateRoomList(RoomPO roomPO) throws RemoteException {
	// TODO Auto-generated method stub
	return null;

	}

	@Override
	public ArrayList<RoomAvailPO> getRoomAvailList(String id, Date checkIn) throws RemoteException {
			// TODO Auto-generated method stub
	return null;
	}

	@Override
	public ResultMessage updateGrade(String hotelID, int grade) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HotelPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getImageAddresses(String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
