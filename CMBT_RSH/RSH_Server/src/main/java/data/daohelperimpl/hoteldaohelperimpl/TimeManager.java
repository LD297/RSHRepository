package data.daohelperimpl.hoteldaohelperimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import data.daohelperimpl.jdbc.DBHelper;

public class TimeManager {
	
	public static void main(String[] args){
		new TimeManager();
	}
	
	//时间间隔(一天)  
    private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;  
    public TimeManager() {  
        Calendar calendar = Calendar.getInstance();  
	    calendar.set(Calendar.HOUR_OF_DAY,0 ); //凌晨0点  
	    calendar.set(Calendar.MINUTE, 0);  
	    calendar.set(Calendar.SECOND, 0);  
	    Date date=calendar.getTime(); //第一次执行定时任务的时间  
	        //如果第一次执行定时任务的时间 小于当前的时间  
	        //此时要在 第一次执行定时任务的时间加一天，以便此任务在下个时间点执行。如果不加一天，任务会立即执行。  
	    if (date.before(new Date())) {  
	        date = this.addDay(date, 1);  
	    }  
	    Timer timer = new Timer();  
	    Task task = new Task();  
	        //安排指定的任务在指定的时间开始进行重复的固定延迟执行。  
	    timer.schedule(task,date,PERIOD_DAY);    
	}  
    // 增加或减少天数  
    public Date addDay(Date date, int num) {  
        Calendar startDT = Calendar.getInstance();  
        startDT.setTime(date);  
        startDT.add(Calendar.DAY_OF_MONTH, num);  
        return startDT.getTime();  
    }  
}
//updateRoomAListWithDayChanged
class Task extends TimerTask{
    DBHelper db = new DBHelper();

	@Override
	public void run() {
		db.executeSql("USE OurData");
        PreparedStatement pst = null;
	   
    	Connection con = null;
	    ArrayList<String> aListList = new ArrayList<String>();
        ArrayList<Integer> totalNumList = new ArrayList<Integer>();
        ArrayList<String> hotelIDList = new ArrayList<String>();
        ArrayList<String> roomTypeList = new ArrayList<String>();

        String getAListSql = "SELECT hotelID,roomType,amountTotal,aList FROM RoomInfo";
        ResultSet result = db.query(getAListSql);
        try{
            while(result.next()){
                hotelIDList.add(result.getString(1));
                roomTypeList.add(result.getString(2));
                totalNumList.add(result.getInt(3));
                aListList.add(result.getString(4));
            }
        }catch(SQLException e){
          e.printStackTrace();
        }
	    String updateAListWithDayChangedSql = "UPDATE RoomInfo SET aList=? WHERE hotelID=? and roomType=? LIMIT 1";
        int index = -1;
        String aList = "";

        try{
            pst = con.prepareStatement(updateAListWithDayChangedSql);
            for(int i=0;i<aListList.size();i++) {
                index = aListList.get(i).indexOf(",");
                aList = aListList.get(i).substring(index+1)+","+String.valueOf(totalNumList.get(i));
	            pst.setString(1,aList);
	            pst.setString(2,hotelIDList.get(i));
	            pst.setString(3,roomTypeList.get(i));
                pst.execute();
            }
        }catch(SQLException e){
        	e.printStackTrace();
        }
	}
}


