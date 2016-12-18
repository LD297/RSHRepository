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
     * 酒店工作人员或网站营销人员制定促销策略时调用
     * @param promotionVO 成员变量setterID用于确认身份
     * @return
     */
    public ResultMessage addPromotion(PromotionVO promotionVO);

    public ResultMessage delPromotion(String setterID,String promotionID);

    public ArrayList<PromotionVO> getPromotionOfHotel(String hotelID);
    
    /**
     * 限于网站营销人员制定的地区促销策略
     * @param district
     * @return
     */
    public ArrayList <PromotionVO> getPromotionOfDistrict (String district);

   
}
