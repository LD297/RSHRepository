package presentation.hotelcontrollertools;

import constant.HotelInputFeedback;

/**
 * Created by a297 on 16/12/7.
 */
public class HotelInputCheck {

    /**
     *检查维护酒店基本信息界面的输入
     */
    public static String checkHotelName(String hotelName) {
        if(hotelName.equals(""))
            return HotelInputFeedback.EMPTY_INPUT;
        if (hotelName.length() <1 || hotelName.length() >15)
            return HotelInputFeedback.NAME_ILLEGAL;
        else
            return HotelInputFeedback.LEGAL;
    }

    public static String checkLevel(String level) {
        if(level.equals(""))
            return HotelInputFeedback.EMPTY_INPUT;
        if(Integer.valueOf(level)<1||Integer.valueOf(level)>6)
            return HotelInputFeedback.LEVEL_ILLEGAL;
        else
            return HotelInputFeedback.LEGAL;
    }

    public static String checkTime(String theTime) {
        if(theTime.equals(""))
            return HotelInputFeedback.EMPTY_INPUT;
        String[] time = theTime.split(":");
        int h = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);
        int second = Integer.parseInt(time[2]);
        if(h<12||h>=24||min<0||min>=60||second<0||second>=60)
            return HotelInputFeedback.TIME_ILLEGAL;
        else
            return HotelInputFeedback.LEGAL;
    }
    public static String checkPrice(String thePrice){
        if(thePrice.equals(""))
            return HotelInputFeedback.EMPTY_INPUT;
        double price = Double.valueOf(thePrice);
        if(price<0)
            return HotelInputFeedback.PRICE_ILLEGAL;
        else
            return HotelInputFeedback.LEGAL;
    }
    public static String checkURL(String theURL){
        if(theURL.equals(""))
            return HotelInputFeedback.EMPTY_INPUT;
        return HotelInputFeedback.LEGAL;
    }
    public static String checkBriefIntro(String briefIntro) {
        if(briefIntro.equals(""))
            return HotelInputFeedback.EMPTY_INPUT;
        if(briefIntro.length()<1||briefIntro.length()>128)
            return HotelInputFeedback.BRIEFINTRO_ILLEGAL;
        else
            return HotelInputFeedback.LEGAL;
    }
    /**
     * 检查添加客房界面的输入
     */
    public static String checkRoomType(String roomType){
        if(roomType.equals(""))
            return HotelInputFeedback.EMPTY_INPUT;
        else
            return HotelInputFeedback.LEGAL;
    }
    public static String checkRoomNum(String roomNum){
        if(roomNum.equals(""))
            return HotelInputFeedback.EMPTY_INPUT;
        double theNum = Double.valueOf(roomNum);
        if(theNum<1)
            return HotelInputFeedback.ROOMNUM_ILLEGAL;
        else
            return HotelInputFeedback.LEGAL;
    }
}
