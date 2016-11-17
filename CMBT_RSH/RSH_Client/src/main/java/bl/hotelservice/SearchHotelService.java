package bl.hotelservice;

import java.util.ArrayList;

import constant.*;
import vo.*;

public interface SearchHotelService {
	
	// 返回符合该地址和商圈的经过综合排序的酒店列表
	public ArrayList<HotelVO> getHotelList(String address,String businessArea);
	
	// 返回排序后的酒店列表
	public ArrayList<HotelVO> sort(SortBy sortBy,SortMethod sortM);
	
	// 返回筛选后的酒店列表
	public ArrayList<HotelVO> select(SelectConditionVO vo);
	
	// 返回该酒店详情
	public HotelVO getHotelInfo(String id);
}
