package bl.hotelserviceimpl;

import java.util.ArrayList;

import bl.hotelservice.SearchHotelService;
import constant.SortBy;
import constant.SortMethod;
import vo.HotelVO;
import vo.SelectConditionVO;

public class SearchHotelService_Stub implements SearchHotelService{

	@Override
	public ArrayList<HotelVO> getHotelList(String address, String businessArea) {
		HotelVO vo1 = new HotelVO("000001", "1234567890", "1号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo2 = new HotelVO("000002", "1234567890", "2号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo3 = new HotelVO("000003", "1234567890", "3号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo4 = new HotelVO("000004", "1234567890", "4号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo5 = new HotelVO("000005", "1234567890", "5号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo6 = new HotelVO("000006", "1234567890", "6号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo7 = new HotelVO("000007", "1234567890", "7号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo8 = new HotelVO("000008", "1234567890", "8号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo9 = new HotelVO("000009", "1234567890", "9号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		
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
		String businessArea = "hdgfjkgg";
		String address = "jgjsgfjfjdh";
		HotelVO vo1 = new HotelVO("000001", "1234567890", "1号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo2 = new HotelVO("000002", "1234567890", "2号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo3 = new HotelVO("000003", "1234567890", "3号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo4 = new HotelVO("000004", "1234567890", "4号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo5 = new HotelVO("000005", "1234567890", "5号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo6 = new HotelVO("000006", "1234567890", "6号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo7 = new HotelVO("000007", "1234567890", "7号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo8 = new HotelVO("000008", "1234567890", "8号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo9 = new HotelVO("000009", "1234567890", "9号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		
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
		String businessArea = "hdgfjkgg";
		String address = "jgjsgfjfjdh";
		HotelVO vo1 = new HotelVO("000001", "1234567890", "1号酒店", address, businessArea  ,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo2 = new HotelVO("000002", "1234567890", "2号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo3 = new HotelVO("000003", "1234567890", "3号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo4 = new HotelVO("000004", "1234567890", "4号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo5 = new HotelVO("000005", "1234567890", "5号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo6 = new HotelVO("000006", "1234567890", "6号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo7 = new HotelVO("000007", "1234567890", "7号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo8 = new HotelVO("000008", "1234567890", "8号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo9 = new HotelVO("000009", "1234567890", "9号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		
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
		String businessArea = "hdgfjkgg";
		String address = "jgjsgfjfjdh";
		HotelVO vo1 = new HotelVO("000001", "1234567890", "1号酒店", address, businessArea  ,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo2 = new HotelVO("000002", "1234567890", "2号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo3 = new HotelVO("000003", "1234567890", "3号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo4 = new HotelVO("000004", "1234567890", "4号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo5 = new HotelVO("000005", "1234567890", "5号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo6 = new HotelVO("000006", "1234567890", "6号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo7 = new HotelVO("000007", "1234567890", "7号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo8 = new HotelVO("000008", "1234567890", "8号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo9 = new HotelVO("000009", "1234567890", "9号酒店", address, businessArea,
				"no more info", "懒得写", 3, 99.9, "1day");
		
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
