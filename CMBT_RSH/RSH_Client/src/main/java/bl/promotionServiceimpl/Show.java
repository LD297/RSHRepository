package bl.promotionServiceimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import data.dao.promotiondao.PromotionDao;
import po.PromotionPO;
import rmi.RemoteHelper;
import vo.PromotionVO;

/**
 * 向presentation层返回策略列表
 * @author aa
 *
 */
public class Show {

	private static PromotionDao promotionDao;
	private static Show show = null;
	private Show(){
		RemoteHelper remoteHelper = RemoteHelper.getInstance();
		promotionDao = remoteHelper.getPromotionDao();
	}
	public static Show getInstance(){
		if(show==null){
			show = new Show();
		}
		return show;
	}
<<<<<<< HEAD
	/**
	 * 一段时间内的策略
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
//	public static ArrayList<PromotionVO> getPromotionOfPeriod(Date beginDate, Date endDate) {
//		// TODO Auto-generated method stub
//		ArrayList<PromotionVO> result= new ArrayList<PromotionVO>();
//		Iterator<PromotionPO> tempRes = null;
//		try {
////			tempRes = promotionDao.finds(beginDate,endDate).iterator();
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//		while(tempRes.hasNext()){
//			result.add(PromotionPO.changeIntoPromotionVo(tempRes.next()));
//		}
//		return result;
//	}

	/**
	 * 符合某酒店特定房间的优惠策略
	 * @param hotelID
	 * @param roomType
	 * @return
	 */
	public static ArrayList<PromotionVO> getPrmotionOfRoom(String hotelID, String roomType) {
		// TODO Auto-generated method stub
		ArrayList<PromotionVO> result= new ArrayList<PromotionVO>();
		Iterator<PromotionPO> tempRes = null;
		try {
			tempRes = promotionDao.finds(hotelID+roomType).iterator();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		while(tempRes.hasNext()){
			result.add(PromotionPO.changeIntoPromotionVo(tempRes.next()));
		}
		return result;
	}

	/**
	 * 符合特定酒店的优惠策略
	 * @param hotelID
	 * @return
	 */
	public static ArrayList<PromotionVO> getPromotionOfHotel(String hotelID) {
		// TODO Auto-generated method stub
		return getPrmotionOfRoom(hotelID,null);
	}

	/**
	 * 符合特定地区的优惠策略
	 * @param district
	 * @return
	 */
	public static ArrayList<PromotionVO> getPromotionOfDistrict(String district) {
		// TODO Auto-generated method stub
		return getPrmotionOfRoom(district,null);
	}
=======
	
	
	
>>>>>>> origin/master

}
