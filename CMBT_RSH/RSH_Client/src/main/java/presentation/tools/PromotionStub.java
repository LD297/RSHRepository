package presentation.tools;

import java.util.ArrayList;
import java.util.Date;

import bl.promotionservice.PromotionService;
import constant.ResultMessage;
import po.OrderPO;
import vo.PromotionVO;

public class PromotionStub implements PromotionService{

	@Override
	public ResultMessage addPromotion(PromotionVO promotionVO) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	@Override
	public ResultMessage delPromotion(String reason, String ID) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	


	@Override
	public ArrayList<PromotionVO> getPromotionOfHotel(String hotelID) {
/*		PromotionVO vo1 = new PromotionVO();
		vo1.reason = "0001";
		PromotionVO vo2 = new PromotionVO();
		vo2.reason = "0002";
		PromotionVO vo3 = new PromotionVO();
		vo3.reason = "0003";
		PromotionVO vo4 = new PromotionVO();
		vo4.reason = "0004";
		ArrayList<PromotionVO> list = new ArrayList<>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);*/
		return null;
	}

	@Override
	public ArrayList<PromotionVO> getPromotionOfDistrict(String district) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
