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

    // 以下七个方法请开发人员从接口类中移除。bl同层调用，不要写在这种专门向上提供的接口类中。可以在bl实现包中另写接口，也可以直接调实现类。
    public ResultMessage delPromotion(String setterID,String promotionID);

    public ArrayList<PromotionVO> getPromotionOfPeriod(Date beginDate, Date EndDate);

    public ArrayList <PromotionVO> getPromotionOfRoom (String hotelID, String roomType);

    public ArrayList<PromotionVO> getPromotionOfHotel(String hotelID);

    public ArrayList <PromotionVO> getPromotionOfDistrict (String district);

    public String countPromotionOfRoom(String hotelID, String type, int num, int price,Date beginDate, Date endDate);

    public ResultMessage setCoupon();
}
