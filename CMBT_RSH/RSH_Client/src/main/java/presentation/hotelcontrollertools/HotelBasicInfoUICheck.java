package presentation.hotelcontrollertools;

import constant.HotelBasicInfoUIFeedback;
import vo.HotelVO;

/**
 * Created by a297 on 16/12/7.
 */
public class HotelBasicInfoUICheck {

    public static String[] checkHotelVO(HotelVO newHotelVO) {
        /**
         * Fb = feedback (反馈)
         */
        String nameFb = checkHotelName(newHotelVO.getHotelName());
        String telFb = checkTel(newHotelVO.getTel());
        String latestCheckinTimeFb = checkTime(newHotelVO.getLatestCheckInTime());
        String levelFb = checkLevel(newHotelVO.getLevel());
        String addrFb = checkAddr(newHotelVO.getDetailAddress());
        String districtFb = checkBArea(newHotelVO.getDistrict());
        String briefIntroFb = checkBriefIntro(newHotelVO.getBriefIntro());
        String facilityFb = checkFacility(newHotelVO.getFacility());
        String[] feedback = new String[]{nameFb, telFb,
                latestCheckinTimeFb, levelFb,
                addrFb, districtFb, briefIntroFb, facilityFb};
        return feedback;
    }

    private static String checkFacility(String facility) {
        if(facility.length()>20)
            return HotelBasicInfoUIFeedback.FACILITY_ILLEGAL;
        else
            return HotelBasicInfoUIFeedback.LEGAL;
    }

    private static String checkBriefIntro(String briefIntro) {
        if(briefIntro.length()>20)
            return HotelBasicInfoUIFeedback.BRIEFINTRO_ILLEGAL;
        else
            return HotelBasicInfoUIFeedback.LEGAL;
    }

    private static String checkBArea(String businessArea) {
        if(businessArea.length()>10)
            return HotelBasicInfoUIFeedback.BUSSINESS_ILLEGAL;
        else
            return HotelBasicInfoUIFeedback.LEGAL;
    }

    private static String checkAddr(String addr) {
        if(addr.length()>30)
            return HotelBasicInfoUIFeedback.ADDR_ILLEGAL;
         else
             return HotelBasicInfoUIFeedback.LEGAL;
    }

    private static String checkLevel(int level) {
        if(level<0||level>5)
            return HotelBasicInfoUIFeedback.LEVEL_ILLEGAL;
        else
            return HotelBasicInfoUIFeedback.LEGAL;
    }

    private static String checkTime(String latestCheckinTime) {
        String[] time = latestCheckinTime.split(":");
        int h = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);
        int second = Integer.parseInt(time[2]);
        if(h<12||h>=24||min<0||min>=60||second<0||second>=60)
            return HotelBasicInfoUIFeedback.TIME_ILLEGAL;
        else
            return HotelBasicInfoUIFeedback.LEGAL;
    }

    private static String checkTel(String tel) {
        if(tel.length()!=11)
            return HotelBasicInfoUIFeedback.TEL_ILLEGAL;
        else
            return HotelBasicInfoUIFeedback.LEGAL;
    }


    private static String checkHotelName(String name) {
        if(name.length()>15)
            return HotelBasicInfoUIFeedback.NAME_ILLEGAL;
        else
            return HotelBasicInfoUIFeedback.LEGAL;
    }
}
