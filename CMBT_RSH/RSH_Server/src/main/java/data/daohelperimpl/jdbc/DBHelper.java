package data.daohelperimpl.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by sky-PC on 2016/11/27.
 */
public class DBHelper {
	private DBHelper dbHelper = null;
    private Statement statement = null;
    private Connection connection = null;

    public DBHelper() {
        try {
            Class.forName(Values.DRIVER_MYSQL);     //加载JDBC驱动
            System.out.println("Driver Load Success.");

            connection = DriverManager.getConnection(Values.URL);    //创建数据库连接对象
            statement = connection.createStatement();       //创建Statement对象
        } catch (Exception e)
        {// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public DBHelper getDBHelper(){
    	if(dbHelper==null)
    		dbHelper = new DBHelper();
    	return dbHelper;
    }
    
    public Connection getConn(){
        return this.connection;
    }
    public void close() {
        try {
            this.connection.close();
            this.statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*
     * 执行数据操作
     * 输    入:SQL语句
     * 返回值:空
     */
    public void executeSql(String sql) {
        try {
            statement.execute(sql);
        } catch (SQLException e)
        {// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /*
     * 根据sql查询数据库，返回一个结果集
     * 输    入:SQL语句
     * 返回值:ResultSet 查询结果
     */
    public ResultSet query(String sql) {
        ResultSet result = null;

        try {
            result = statement.executeQuery(sql);
        } catch (SQLException e)
        {// TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}