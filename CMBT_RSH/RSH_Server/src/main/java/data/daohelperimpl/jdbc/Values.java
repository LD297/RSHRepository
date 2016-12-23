package data.daohelperimpl.jdbc;

/**
 * Created by sky-PC on 2016/11/27.
 */
public class Values {
    public static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";    //MySQL JDBC驱动字符串
    public static final String URL = "jdbc:mysql://localhost:3306/OurData?"
            + "user=root&password=123&useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false&useSSL=true";//数据库Url,用来标识要连接的数据库，其中数据库名、用户名、密码是根据你自己的数据库情况设定

}