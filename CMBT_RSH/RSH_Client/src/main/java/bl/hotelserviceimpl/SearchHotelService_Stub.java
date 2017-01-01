package bl.hotelserviceimpl;

import java.util.ArrayList;

import bl.hotelservice.SearchHotelService;
import constant.SortBy;
import constant.SortMethod;
import vo.HotelVO;
import vo.SelectConditionVO;

public class SearchHotelService_Stub implements SearchHotelService{

	@Override
	public ArrayList<HotelVO> getHotelList(String province,String city, String businessArea) {
		HotelVO vo1 = new HotelVO("1234560001", "1号酒店", "仙林大道", "1234567890","123456", 4, 99.9,0, "00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo2= new HotelVO("000002", "2号酒店", "仙林大道", "234567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo3 = new HotelVO("000003", "3号酒店", "仙林大道", "1234567890","123456", 4, 99.9,0, "00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo4 = new HotelVO("000004", "4号酒店", "仙林大道", "4567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo5 = new HotelVO("000001", "5号酒店", "仙林大道", "1234567890","123456", 4, 99.9,0, "00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo6 = new HotelVO("000001", "6号酒店", "仙林大道", "14567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo7 = new HotelVO("000001", "7号酒店", "仙林大道", "1234567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo8 = new HotelVO("000001", "8号酒店", "仙林大道", "12345690","123456", 4, 99.9,0, "00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo9 = new HotelVO("000001", "9号酒店", "仙林大道", "1234567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
			
		
		
		ArrayList<HotelVO> list = new ArrayList<>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);
		list.add(vo5);
		list.add(vo6);
		list.add(vo7);
		list.add(vo8);
		list.add(vo9);
		return list;
	}

	@Override
	public ArrayList<HotelVO> sort(ArrayList<HotelVO> hotelList, SortBy sortBy, SortMethod sortM) {
		String address = "江苏省 南京市 仙林中心";
		String businessArea = "010009";
		HotelVO vo1 = new HotelVO("0100190001", "1号酒店", "仙林大道", "0100097890","123456", 4, 99.9,0, "00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo2 = new HotelVO("0100090002", "2号酒店", "仙林大道", "1234567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo3 = new HotelVO("0100090003", "3号酒店", "仙林大道", "1234567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo4 = new HotelVO("0100090004", "4号酒店", "仙林大道", "1234567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo5 = new HotelVO("0100090005", "5号酒店", "仙林大道", "1234567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo6 = new HotelVO("0100090006", "6号酒店", "仙林大道", "1234567890","123456", 4, 99.9,0, "00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo7 = new HotelVO("0100090007", "7号酒店", "仙林大道", "1234567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo8 = new HotelVO("0100090008", "8号酒店", "仙林大道", "1234567890","123456", 4, 99.9,0, "00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo9 = new HotelVO("0100090009", "9号酒店", "仙林大道", "1234567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		
		ArrayList<HotelVO> list = new ArrayList<>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);
		list.add(vo5);
		list.add(vo6);
		list.add(vo7);
		list.add(vo8);
		list.add(vo9);
		return list;
	}

	@Override
	public ArrayList<HotelVO> select(ArrayList<HotelVO> hotelList, SelectConditionVO vo) {
		String address = "江苏省 南京市 仙林中心";
		String businessArea = "010009";
		HotelVO vo1 = new HotelVO("0100190001", "1号酒店", "仙林大道", "0100097890","123456", 4, 99.9,0, "00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo2 = new HotelVO("0100090002", "2号酒店", "仙林大道", "1234567890","123456", 4, 99.9,0, "00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo3 = new HotelVO("0100090003", "3号酒店", "仙林大道", "1234567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo4 = new HotelVO("0100090004", "4号酒店", "仙林大道", "1234567890","123456", 4, 99.9,0, "00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo5 = new HotelVO("0100090005", "5号酒店", "仙林大道", "1234567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo6 = new HotelVO("0100090006", "6号酒店", "仙林大道", "1234567890","123456", 4, 99.9,0, "00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo7 = new HotelVO("0100090007", "7号酒店", "仙林大道", "1234567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo8 = new HotelVO("0100090008", "8号酒店", "仙林大道", "1234567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo9 = new HotelVO("0100090009", "9号酒店", "仙林大道", "1234567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		
		ArrayList<HotelVO> list = new ArrayList<>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);
		list.add(vo5);
		list.add(vo6);
		list.add(vo7);
		list.add(vo8);
		list.add(vo9);
		return list;
	}

	@Override
	public ArrayList<HotelVO> select(ArrayList<HotelVO> hotelList, String hotelName) {
		String address = "江苏省 南京市 仙林中心";
		String businessArea = "010009";
		HotelVO vo1 = new HotelVO("0100190001", "1号酒店", "仙林大道", "0100097890","123456", 4, 99.9,0, "00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo2 = new HotelVO("0100090002", "2号酒店", "仙林大道", "1234567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo3 = new HotelVO("0100090003", "3号酒店", "仙林大道", "1234567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo4 = new HotelVO("0100090004", "4号酒店", "仙林大道", "1234567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo5 = new HotelVO("0100090005", "5号酒店", "仙林大道", "1234567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo6 = new HotelVO("0100090006", "6号酒店", "仙林大道", "1234567890","123456", 4, 99.9,0, "00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo7 = new HotelVO("0100090007", "7号酒店", "仙林大道", "1234567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo8 = new HotelVO("0100090008", "8号酒店", "仙林大道", "1234567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo9 = new HotelVO("0100090009", "9号酒店", "仙林大道", "1234567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		
		ArrayList<HotelVO> list = new ArrayList<>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);
		list.add(vo5);
		list.add(vo6);
		list.add(vo7);
		list.add(vo8);
		list.add(vo9);
		return list;
	}

	@Override
	public ArrayList<HotelVO> getHotelList() {
		HotelVO vo1 = new HotelVO("0100190001", "1号酒店", "仙林大道163号", "0100097890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo2 = new HotelVO("0100090002", "2号酒店", "仙林大道163号", "1234567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo3 = new HotelVO("0100090003", "3号酒店", "仙林大道163号", "1234567890","123456", 4, 99.9,0, "00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo4 = new HotelVO("0100090004", "4号酒店", "仙林大道163号", "1234567890","123456", 4, 99.9,0, "00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo5 = new HotelVO("0100090005", "5号酒店", "仙林大道163号", "1234567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo6 = new HotelVO("0100090006", "6号酒店", "仙林大道163号", "1234567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo7 = new HotelVO("0100090007", "7号酒店", "仙林大道163号", "1234567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo8 = new HotelVO("0100090008", "8号酒店", "仙林大道163号", "1234567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		HotelVO vo9 = new HotelVO("0100090009", "9号酒店", "仙林大道163号", "1234567890","123456", 4, 99.9, 0,"00:00:00", "nothing", "nothing", "somewhere");
		
		ArrayList<HotelVO> list = new ArrayList<>();
		
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);
		list.add(vo5);
		list.add(vo6);
		list.add(vo7);
		list.add(vo8);
		list.add(vo9);
		return list;
	}

}
