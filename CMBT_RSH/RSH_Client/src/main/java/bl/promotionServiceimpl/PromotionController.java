package bl.promotionServiceimpl;

import bl.userserviceimpl.User;
import constant.MemberType;
import constant.ResultMessage;
import data.dao.promotiondao.PromotionDao;
import po.PromotionPO;
import rmi.RemoteHelper;
import vo.OrderInfo;
import vo.OrderVO;
import vo.PromotionVO;
import vo.RoomVO;
import vo.UserVO;
import bl.promotionservice.PromotionService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * 策略包总控
 * @author aa
 *
 */
public class PromotionController implements PromotionService {

	private static PromotionDao promotionDao = null;
	Promotion promotion;
	PromotionVO promotionVO=null;

	private static void initRemote(){
		if(promotionDao==null){
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			promotionDao = remoteHelper.getPromotionDao();
		}
	}
	
	@Override
	public String getIDForNewPromotion(String setterID) {
		initRemote();
		String newID;
		try {
			newID = promotionDao.getNewID(setterID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return "remote_fail";
		}
		return newID;
	}

	@Override
	public ResultMessage addPromotion(PromotionVO promotionVO) {
		initRemote();
		try {
			return promotionDao.insert(promotionVO.changeIntoPO());
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.remote_fail;
		}
	}		;


	@Override
	public ResultMessage delPromotion(String setterID, String promotionID) {
		try {
			return promotionDao.delete(setterID, promotionID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.remote_fail;
		}
	}

	@Override
	public ArrayList<PromotionVO> getPromotionOfHotel(String hotelID) {
		ArrayList<PromotionPO> promotionPOs = new ArrayList<>();
		ArrayList<PromotionVO> promotionVOs = new ArrayList<>();
		initRemote();
		try {
			promotionPOs = promotionDao.finds(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return promotionVOs;
		}
		for(PromotionPO promotionPO:promotionPOs){
			promotionVOs.add(promotionPO.changeIntoVO());
		}
		return promotionVOs;
	}

	/**
	 * promotionDao 中可直接使用 hotelID 或 district 作为参数
	 */
	@Override
	public ArrayList<PromotionVO> getPromotionOfDistrict(String district) {
		return getPromotionOfHotel(district);
	}


	/**
	 * 订单生成时计算最优策略
	 * @param orderInfo
	 * @return
	 */
	public String countPromotionOfRoom(OrderInfo orderInfo) {
		return Count.countPromotionOfRoom(orderInfo);
	}






}
