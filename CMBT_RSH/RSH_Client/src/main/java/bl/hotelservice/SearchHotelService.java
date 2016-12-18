package bl.hotelservice;

import constant.SortBy;
import constant.SortMethod;
import vo.HotelVO;
import vo.SelectConditionVO;

import java.util.ArrayList;

public interface SearchHotelService {

	/**
	 * 返回符合该地址和商圈的经过综合排序的酒店列表
	 * 综合排序：评分从高到低（实现类再调用其他方法实现）
	 * @param address
	 * @param businessArea
	 * @return
	 */
	public ArrayList<HotelVO> getHotelList(String address, String businessArea);
	
	/**
	 * 网站管理人员界面调用，返回所有的酒店
	 */
	public ArrayList<HotelVO> getHotelList();

	/**
	 * 返回排序后的酒店列表
	 * 可以叠加
	 * @param hotelList
	 * @param sortBy
	 * @param sortM
	 * @return
	 */
	public ArrayList<HotelVO> sort(ArrayList<HotelVO> hotelList, SortBy sortBy,SortMethod sortM);

	/**
	 * 返回筛选后的酒店列表
	 * @param hotelList
	 * @param vo
	 * @return
	 */
	public ArrayList<HotelVO> select(ArrayList<HotelVO> hotelList, SelectConditionVO vo);

	/**
	 * 返回根据酒店名称得到的酒店列表
	 * @param hotelList
	 * @param hotelName
	 * @return
	 */
	public ArrayList<HotelVO> select(ArrayList<HotelVO> hotelList, String hotelName);

}
