package bl.promotionservice;

import constant.ResultMessage;
import vo.PromotionVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by aa on 2016/12/10.
 */
public interface PromotionService {

    public String getIDForNewPromotion(String setter);

    public ResultMessage addPromotion(PromotionVO promotionVO);

    public ResultMessage delPromotion(String setterID,String promotionID);

    public ArrayList<PromotionVO> getPromotionOfPeriod(Date beginDate, Date EndDate);

    public ArrayList <PromotionVO> getPromotionOfRoom (String hotelID, String roomType);

    public ArrayList<PromotionVO> getPromotionOfHotel(String hotelID);

    public ArrayList <PromotionVO> getPromotionOfDistrict (String district);

    public String countPromotionOfRoom(String hotelID, String type, int num, int price,Date beginDate, Date endDate);

    public ResultMessage setCoupon();
}
