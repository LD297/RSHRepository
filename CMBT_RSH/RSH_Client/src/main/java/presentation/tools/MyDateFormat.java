package presentation.tools;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
		String result = null;
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
}
