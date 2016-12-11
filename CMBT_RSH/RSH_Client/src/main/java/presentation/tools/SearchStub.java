package presentation.tools;

import java.util.ArrayList;

import bl.hotelservice.SearchHotelService;
import constant.SortBy;
import constant.SortMethod;
import vo.HotelVO;
import vo.SelectConditionVO;

public class SearchStub implements SearchHotelService{

	public ArrayList<HotelVO> getHotelList(String address, String businessArea) {
		// TODO Auto-generated method stub
		HotelVO vo1 = new HotelVO("123456", "12345678901", "NJU Great Hotel1", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
		HotelVO vo2 = new HotelVO("123457", "12345678901", "NJU Great Hotel2", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
		HotelVO vo3 = new HotelVO("123458", "12345678901", "NJU Great Hotel3", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
		HotelVO vo4 = new HotelVO("123459", "12345678901", "NJU Great Hotel4", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
		HotelVO vo5 = new HotelVO("723456", "12345678901", "NJU Great Hotel5", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
		HotelVO vo6 = new HotelVO("823456", "12345678901", "NJU Great Hotel6", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
		HotelVO vo7 = new HotelVO("923456", "12345678901", "NJU Great Hotel7", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
		HotelVO vo8 = new HotelVO("323456", "12345678901", "NJU Great Hotel8", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
		HotelVO vo9 = new HotelVO("523456", "12345678901", "NJU Great Hotel9", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
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
	public ArrayList<HotelVO> select(SelectConditionVO vo) {
		HotelVO vo1 = new HotelVO("123456", "12345678901", "NJU Great Hotel1", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
		HotelVO vo2 = new HotelVO("123457", "12345678901", "NJU Great Hotel2", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
		HotelVO vo3 = new HotelVO("123458", "12345678901", "NJU Great Hotel3", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
		HotelVO vo4 = new HotelVO("123459", "12345678901", "NJU Great Hotel4", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
		HotelVO vo5 = new HotelVO("723456", "12345678901", "NJU Great Hotel5", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
		HotelVO vo6 = new HotelVO("823456", "12345678901", "NJU Great Hotel6", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
		HotelVO vo7 = new HotelVO("923456", "12345678901", "NJU Great Hotel7", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
		HotelVO vo8 = new HotelVO("323456", "12345678901", "NJU Great Hotel8", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
		HotelVO vo9 = new HotelVO("523456", "12345678901", "NJU Great Hotel9", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
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
	public HotelVO getHotelInfo(String id) {
		HotelVO vo = new HotelVO(id, "12345678901", "NJU Great Hotel1", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
		return vo;
	}

	@Override
	public ArrayList<HotelVO> sort(SortBy sortBy, SortMethod sortM) {
		HotelVO vo1 = new HotelVO("123456", "12345678901", "NJU Great Hotel1", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
		HotelVO vo2 = new HotelVO("123457", "12345678901", "NJU Great Hotel2", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
		HotelVO vo3 = new HotelVO("123458", "12345678901", "NJU Great Hotel3", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
		HotelVO vo4 = new HotelVO("123459", "12345678901", "NJU Great Hotel4", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
		HotelVO vo5 = new HotelVO("723456", "12345678901", "NJU Great Hotel5", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
		HotelVO vo6 = new HotelVO("823456", "12345678901", "NJU Great Hotel6", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
		HotelVO vo7 = new HotelVO("923456", "12345678901", "NJU Great Hotel7", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
		HotelVO vo8 = new HotelVO("323456", "12345678901", "NJU Great Hotel8", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
		HotelVO vo9 = new HotelVO("523456", "12345678901", "NJU Great Hotel9", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
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
