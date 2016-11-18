package bl.hotelserviceimpl;

import java.util.ArrayList;

import vo.HotelVO;
import vo.SelectConditionVO;


/**
 * 测试searchhotel对selecthotel的调用
 * @author a297
 *
 */
public class MockSelectHotel extends SelectHotel {
	public ArrayList<HotelVO> select(SelectConditionVO vo) {
		ArrayList<HotelVO> list = new ArrayList<HotelVO>();
		list.add(new HotelVO("TinyTimes"));
		return list;
	}
}
