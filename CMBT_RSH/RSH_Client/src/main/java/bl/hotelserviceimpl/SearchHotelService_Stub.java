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
		HotelVO vo1 = new HotelVO("000001", "1234567890", "1号酒店", "江苏省 南京市 仙林中心","010009",
				"no more info", "懒得写", 3, 99.9, "1day");
		vo1.setPassword("weiywigirui");
		HotelVO vo2 = new HotelVO("000002", "1234567890", "2号酒店", "江苏省 南京市 仙林中心","010009",
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo3 = new HotelVO("000003", "1234567890", "3号酒店", "江苏省 南京市 仙林中心","010009",
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo4 = new HotelVO("000004", "1234567890", "4号酒店", "江苏省 南京市 仙林中心","010009",
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo5 = new HotelVO("000005", "1234567890", "5号酒店", "江苏省 南京市 仙林中心","010009",
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo6 = new HotelVO("000006", "1234567890", "6号酒店", "江苏省 南京市 仙林中心","010009",
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo7 = new HotelVO("000007", "1234567890", "7号酒店", "江苏省 南京市 仙林中心","010009",
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo8 = new HotelVO("000008", "1234567890", "8号酒店", "江苏省 南京市 仙林中心","010009",
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo9 = new HotelVO("000009", "1234567890", "9号酒店", "江苏省 南京市 仙林中心","010009",
				"no more info", "懒得写", 3, 99.9, "1day");
		vo2.setPassword("weiywigirui");
		vo3.setPassword("weiywigirui");
		vo4.setPassword("weiywigirui");
		vo5.setPassword("weiywigirui");
		vo6.setPassword("weiywigirui");
		vo7.setPassword("weiywigirui");
		vo8.setPassword("weiywigirui");
		vo9.setPassword("weiywigirui");
		
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
		HotelVO vo1 = new HotelVO("000001", "1234567890", "1号酒店", address, businessArea, "no more info", "懒得写", 3, 99.9,
				"1day");
		HotelVO vo2 = new HotelVO("000002", "1234567890", "2号酒店", address, businessArea, "no more info", "懒得写", 3, 99.9,
				"1day");
		HotelVO vo3 = new HotelVO("000003", "1234567890", "3号酒店", address, businessArea, "no more info", "懒得写", 3, 99.9,
				"1day");
		HotelVO vo4 = new HotelVO("000004", "1234567890", "4号酒店", address, businessArea, "no more info", "懒得写", 3, 99.9,
				"1day");
		HotelVO vo5 = new HotelVO("000005", "1234567890", "5号酒店", address, businessArea, "no more info", "懒得写", 3, 99.9,
				"1day");
		HotelVO vo6 = new HotelVO("000006", "1234567890", "6号酒店", address, businessArea, "no more info", "懒得写", 3, 99.9,
				"1day");
		HotelVO vo7 = new HotelVO("000007", "1234567890", "7号酒店", address, businessArea, "no more info", "懒得写", 3, 99.9,
				"1day");
		HotelVO vo8 = new HotelVO("000008", "1234567890", "8号酒店", address, businessArea, "no more info", "懒得写", 3, 99.9,
				"1day");
		HotelVO vo9 = new HotelVO("000009", "1234567890", "9号酒店", address, businessArea, "no more info", "懒得写", 3, 99.9,
				"1day");
		vo1.setPassword("weiywigirui");
		vo2.setPassword("weiywigirui");
		vo3.setPassword("weiywigirui");
		vo4.setPassword("weiywigirui");
		vo5.setPassword("weiywigirui");
		vo6.setPassword("weiywigirui");
		vo7.setPassword("weiywigirui");
		vo8.setPassword("weiywigirui");
		vo9.setPassword("weiywigirui");
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
		HotelVO vo1 = new HotelVO("000001", "1234567890", "1号酒店", address, businessArea, "no more info", "懒得写", 3, 99.9,
				"1day");
		HotelVO vo2 = new HotelVO("000002", "1234567890", "2号酒店", address, businessArea, "no more info", "懒得写", 3, 99.9,
				"1day");
		HotelVO vo3 = new HotelVO("000003", "1234567890", "3号酒店", address, businessArea, "no more info", "懒得写", 3, 99.9,
				"1day");
		HotelVO vo4 = new HotelVO("000004", "1234567890", "4号酒店", address, businessArea, "no more info", "懒得写", 3, 99.9,
				"1day");
		HotelVO vo5 = new HotelVO("000005", "1234567890", "5号酒店", address, businessArea, "no more info", "懒得写", 3, 99.9,
				"1day");
		HotelVO vo6 = new HotelVO("000006", "1234567890", "6号酒店", address, businessArea, "no more info", "懒得写", 3, 99.9,
				"1day");
		HotelVO vo7 = new HotelVO("000007", "1234567890", "7号酒店", address, businessArea, "no more info", "懒得写", 3, 99.9,
				"1day");
		HotelVO vo8 = new HotelVO("000008", "1234567890", "8号酒店", address, businessArea, "no more info", "懒得写", 3, 99.9,
				"1day");
		HotelVO vo9 = new HotelVO("000009", "1234567890", "9号酒店", address, businessArea, "no more info", "懒得写", 3, 99.9,
				"1day");
		vo1.setPassword("weiywigirui");
		vo2.setPassword("weiywigirui");
		vo3.setPassword("weiywigirui");
		vo4.setPassword("weiywigirui");
		vo5.setPassword("weiywigirui");
		vo6.setPassword("weiywigirui");
		vo7.setPassword("weiywigirui");
		vo8.setPassword("weiywigirui");
		vo9.setPassword("weiywigirui");

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
		HotelVO vo1 = new HotelVO("000001", "1234567890", "1号酒店", address, businessArea, "no more info", "懒得写", 3, 99.9,
				"1day");
		HotelVO vo2 = new HotelVO("000002", "1234567890", "2号酒店", address, businessArea, "no more info", "懒得写", 3, 99.9,
				"1day");
		HotelVO vo3 = new HotelVO("000003", "1234567890", "3号酒店", address, businessArea, "no more info", "懒得写", 3, 99.9,
				"1day");
		HotelVO vo4 = new HotelVO("000004", "1234567890", "4号酒店", address, businessArea, "no more info", "懒得写", 3, 99.9,
				"1day");
		HotelVO vo5 = new HotelVO("000005", "1234567890", "5号酒店", address, businessArea, "no more info", "懒得写", 3, 99.9,
				"1day");
		HotelVO vo6 = new HotelVO("000006", "1234567890", "6号酒店", address, businessArea, "no more info", "懒得写", 3, 99.9,
				"1day");
		HotelVO vo7 = new HotelVO("000007", "1234567890", "7号酒店", address, businessArea, "no more info", "懒得写", 3, 99.9,
				"1day");
		HotelVO vo8 = new HotelVO("000008", "1234567890", "8号酒店", address, businessArea, "no more info", "懒得写", 3, 99.9,
				"1day");
		HotelVO vo9 = new HotelVO("000009", "1234567890", "9号酒店", address, businessArea, "no more info", "懒得写", 3, 99.9,
				"1day");
		vo1.setPassword("weiywigirui");
		vo2.setPassword("weiywigirui");
		vo3.setPassword("weiywigirui");
		vo4.setPassword("weiywigirui");
		vo5.setPassword("weiywigirui");
		vo6.setPassword("weiywigirui");
		vo7.setPassword("weiywigirui");
		vo8.setPassword("weiywigirui");
		vo9.setPassword("weiywigirui");

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
		HotelVO vo1 = new HotelVO("000001", "1234567890", "1号酒店","江苏省 南京市 仙林中心","010009",
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo2 = new HotelVO("000002", "1234567890", "2号酒店","江苏省 南京市 仙林中心","010009",
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo3 = new HotelVO("000003", "1234567890", "3号酒店", "江苏省 南京市 仙林中心","010009",
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo4 = new HotelVO("000004", "1234567890", "4号酒店", "江苏省 南京市 仙林中心","010009",
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo5 = new HotelVO("000005", "1234567890", "5号酒店","江苏省 南京市 仙林中心","010009",
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo6 = new HotelVO("000006", "1234567890", "6号酒店", "江苏省 南京市 仙林中心","010009",
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo7 = new HotelVO("000007", "1234567890", "7号酒店","江苏省 南京市 仙林中心","010009",
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo8 = new HotelVO("000008", "1234567890", "8号酒店","江苏省 南京市 仙林中心","010009",
				"no more info", "懒得写", 3, 99.9, "1day");
		HotelVO vo9 = new HotelVO("000009", "1234567890", "9号酒店", "江苏省 南京市 仙林中心","010009",
				"no more info", "懒得写", 3, 99.9, "1day");
		vo1.setPassword("weiywigirui");
		vo2.setPassword("weiywigirui");
		vo3.setPassword("weiywigirui");
		vo4.setPassword("weiywigirui");
		vo5.setPassword("weiywigirui");
		vo6.setPassword("weiywigirui");
		vo7.setPassword("weiywigirui");
		vo8.setPassword("weiywigirui");
		vo9.setPassword("weiywigirui");
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
