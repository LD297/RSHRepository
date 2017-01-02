package presentation.hotelcontrollertools;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by a297 on 16/12/14.
 */
public class DateTransform {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static String getDateTransFormed(Date date){
        String dateTransformed = simpleDateFormat.format(date);
        return dateTransformed;
    }
}
