package presentation.hotelcontrollertools;

import constant.HotelBasicInfoUIFeedback;
import vo.HotelVO;

/**
 * Created by a297 on 16/12/7.
 */
public class HotelBasicInfoUICheck {

    public static String checkHotelName(String hotelName) {
        if (hotelName.length() < 1 || hotelName.length() > 15)
            return HotelBasicInfoUIFeedback.NAME_ILLEGAL;
        else
            return HotelBasicInfoUIFeedback.LEGAL;
    }

    public static String checkLevel(String level) {
        if(Integer.valueOf(level)<1||Integer.valueOf(level)>6)
            return HotelBasicInfoUIFeedback.LEVEL_ILLEGAL;
        else
            return HotelBasicInfoUIFeedback.LEGAL;
    }

    public static String checkTime(String theTime) {
        String[] time = theTime.split(":");
        int h = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);
        int second = Integer.parseInt(time[2]);
        if(h<12||h>=24||min<0||min>=60||second<0||second>=60)
            return HotelBasicInfoUIFeedback.TIME_ILLEGAL;
        else
            return HotelBasicInfoUIFeedback.LEGAL;
    }
    public static String checkPrice(String thePrice){
        double price = Double.valueOf(thePrice);
        if(price<0)
            return HotelBasicInfoUIFeedback.PRICE_ILLEGAL;
        else
            return HotelBasicInfoUIFeedback.LEGAL;
    }
    public static String checkURL(String theURL){
        //TODO
        return HotelBasicInfoUIFeedback.LEGAL;
    }
    public static String checkBriefIntro(String briefIntro) {
        if(briefIntro.length()<1||briefIntro.length()>128)
            return HotelBasicInfoUIFeedback.BRIEFINTRO_ILLEGAL;
        else
            return HotelBasicInfoUIFeedback.LEGAL;
    }
}
