package bl.hotelserviceimpl.controller;

import java.util.ArrayList;
import java.util.Date;

import bl.hotelservice.HotelInfoService;
import bl.hotelserviceimpl.Hotel;
import constant.ResultMessage;
import vo.RoomNormVO;
/**
 * 
 * @author aa
 *
 */
public class HotelInfoController implements HotelInfoService{
	
	@Override
	public ArrayList<RoomNormVO> getRoomNorm(String hotelID) {
		// TODO Auto-generated method stub
		Hotel hotel = Hotel.getInstance(hotelID);
		if(hotel == null){
			return new ArrayList<>();
		}
		return hotel.getRoomNorms();
	}

	@Override
	public String getCheckInDDL(String hotelID) {
		// TODO Auto-generated method stub
		Hotel hotel = Hotel.getInstance(hotelID);
		if(hotel==null){
			return null;
		}
		return hotel.getCheckInDDL();
	}

	@Override
	public int getRoomAvailNum(String hotelID, String roomType, Date checkIn, Date checkOut) {
		// TODO Auto-generated method stub
		Hotel hotel = Hotel.getInstance(hotelID);
		if(hotel == null){
			return -1;
		}
		return hotel.numOfRoomAvail(roomType, checkIn, checkOut);
	}

	@Override
	public ResultMessage updateGrade(String hotelID,int grade) {
		// TODO Auto-generated method stub
		Hotel hotel = Hotel.getInstance(hotelID);
		if(hotel == null){
			return ResultMessage.idNotExist;
		}
		return hotel.updateGrade(grade);
	}

}
