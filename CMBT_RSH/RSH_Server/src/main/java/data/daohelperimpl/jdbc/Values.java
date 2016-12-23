package data.daohelperimpl.jdbc;

import java.util.Scanner;

/**
 * Created by sky-PC on 2016/11/27.
 */
public class Values {
    public static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";    //MySQL JDBC驱动字符串
    
    public static String URL = null;
    //数据库Url,用来标识要连接的数据库，其中数据库名、用户名、密码是根据你自己的数据库情况设定

    public static void setURL(){
    	System.out.println("输入密码");
    	Scanner scan = new Scanner(System.in);
    	String password = scan.nextLine();
    	scan.close();
    	URL =  "jdbc:mysql://localhost:3306/OurData?"+"user=root&password="+password+
    			"&useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false&useSSL=true";
    }
}