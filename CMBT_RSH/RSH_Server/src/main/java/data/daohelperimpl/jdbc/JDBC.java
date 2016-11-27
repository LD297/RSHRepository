package data.daohelperimpl.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by sky-PC on 2016/11/27.
 */
public class JDBC {
    private Statement statement;

    public JDBC() {
        try
        {
            Class.forName(Values.DRIVER_MYSQL);     //加载JDBC驱动
            System.out.println("Driver Load Success.");

            Connection connection = DriverManager.getConnection(Values.URL);    //创建数据库连接对象
            statement = connection.createStatement();       //创建Statement对象
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
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

        try
        {
            result = statement.executeQuery(sql);
        } catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }

    /*
     * 打印UserInfo表的数据
     * 输    入:结果集(数据表)
     * 返回值:空
     */
    public void printUserInfo(ResultSet result) {
        try
        {
            while(result.next()) {
                System.out.println("userName:" + result.getString(1)
                        + ", password:" + result.getString(2));
            }
        } catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*
     * 执行数据操作
     * 输    入:SQL语句
     * 返回值:空
     */
    public void executeSql(String sql) {
        try
        {
            statement.execute(sql);
        } catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
