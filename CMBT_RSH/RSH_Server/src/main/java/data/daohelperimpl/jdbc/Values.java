package data.daohelperimpl.jdbc;

import java.util.Scanner;

/**
 * Created by sky-PC on 2016/11/27.
 */
public class Values {
	private Values(){};
	private static Values values = null;
	public static Values getInstance() {
		if(values==null){
			values = new Values();
		}
		return values;
	}
    public static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";    //MySQL JDBC驱动字符串
    private String password = null;
    public static String URL = null;
    //数据库Url,用来标识要连接的数据库，其中数据库名、用户名、密码是根据你自己的数据库情况设定

    public void setURL(){
    	URL =  "jdbc:mysql://localhost:3306/OurData?"+"user=root&password="+password+
    			"&useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false&useSSL=true";
    }
    public void setPassword(String password) {
		this.password = password;
	}
}