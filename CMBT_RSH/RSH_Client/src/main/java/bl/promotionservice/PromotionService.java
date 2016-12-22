package bl.promotionservice;

import constant.ResultMessage;
import vo.PromotionVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by aa on 2016/12/10.
 */
public interface PromotionService {
   
	/**
	 * 得到促销策略ID
	 * 制定促销策略界面调用
	 * @param setterID
	 * @return
	 */
	String getIDForNewPromotion(String setterID);

	/**
     * 酒店工作人员或网站营销人员制定促销策略时调用
     * @param promotionVO 成员变量setterID用于确认身份
     * @return
     */
    public ResultMessage addPromotion(PromotionVO promotionVO);

    /**
     * 酒店或网站删除促销策略时调用
     * @param setterID
     * @param promotionID
     * @return
     */
    public ResultMessage delPromotion(String setterID,String promotionID);

    /**
     * 得到酒店所有促销策略，
     * 酒店工作人员查看所有促销策略
     * @param hotelID
     * @return
     */
    public ArrayList<PromotionVO> getPromotionOfHotel(String hotelID);
    
    /**
     * 限于网站营销人员制定的地区促销策略
     * 网站营销人员查看制定过的策略
     * @param district
     * @return
     */
    public ArrayList <PromotionVO> getPromotionOfDistrict (String district);

	
   
}
