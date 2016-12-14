package presentation.tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * 处理日期
 * @author john
 *
 */
public class MyDateFormat {
	private static final String pattern = "yyyy-MM-dd";
	private static MyDateFormat myDateFormat = null;
	private static DateTimeFormatter dateFormatter = 
            DateTimeFormatter.ofPattern(pattern);
	private MyDateFormat() {}
	
	public static MyDateFormat getInstance() {
		if(myDateFormat == null){
			myDateFormat = new MyDateFormat();
		}
		return myDateFormat;
	}
	
	/**
	 * 将localdate转成
	 * @param localDate"yyyy-MM-dd"字符串形式
	 * @return
	 */
	public String toString(LocalDate localDate) {
		if(localDate==null){
			return "";
		}else {
			return dateFormatter.format(localDate);
		}
	}
	/**
	 * 将"yyyy-MM-dd"字符串形式转成localdate
	 * @param date
	 * @return
	 */
	public LocalDate toLocalDate(String date) {
		if(date==null||date.isEmpty()){
			return null;
		}
		return LocalDate.parse(date,dateFormatter);
	}
	
	/**
	 * 将localdate转成date
	 */
	public Date changeLocalDateToDate(LocalDate localDate){
		Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
		Date date = Date.from(instant);
		return date;
	}
	
	/**
	 * 将local date转成星期几
	 */
	public String getWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String week = "星期";
		switch (calendar.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			week+="日";
			break;
		case 2:
			week+="一";
			break;
		case 3:
			week+="二";
			break;
		case 4:
			week+="三";
			break;
		case 5:
			week+="四";
			break;
		case 6:
			week+="五";
			break;
		case 7:
			week+="六";
			break;
		default:
			break;
		}
		return week;
	}
	
	/**
	 * 将date转成
	 * @param Date"MM-dd"字符串形式
	 * @return
	 */
	public String toString(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd");
		
		if(date==null){
			return "";
		}else {
			return dateFormat.format(date);
		}
	}
	
}
