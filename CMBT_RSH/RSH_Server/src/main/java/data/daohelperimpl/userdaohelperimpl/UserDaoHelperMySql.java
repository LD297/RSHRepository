package data.daohelperimpl.userdaohelperimpl;

import constant.MemberType;
import constant.ResultMessage;
import constant.Sexuality;
import data.dao.userdao.UserDao;
import data.daohelperimpl.jdbc.DBHelper;
import po.UserPO;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sky-PC on 2016/12/3.
 */
public class UserDaoHelperMySql {

    private DBHelper db = new DBHelper();

    public void init(){
        //path表示你所创建文件的路径
        String path = "D:\\360downloads";
        File f = new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
        // fileName表示你创建的文件名；
        String fileName = "User.db";
        File file = new File(f,fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();}
        }

        db.executeSql("USE User");
        // 账号 密码 昵称 头像url
        // 会员等级 会员类型 信用值
        // 真实姓名 性别 邮箱
        db.executeSql("CREATE TABLE UserInfo(userID char(26),password varchar(30),nickName varchar(10),image varchar(30)," +
                "grade tinyint,memberType tinyint,credit int," +
                "trueName varchar(10),sex tinyint,eMail varchar(30))" );
    }

    public void finish(){
        File f = new File("D:\\360downloads\\User.db");  // 输入要删除的文件位置
        if(f.exists())
            f.delete();
    }
    // 根据id得到用户信息
    public UserPO getInfo(String id) throws RemoteException {
        String getInfoSql = "SELECT *FROM UserInfo WHERE userID='"+id+"' LIMIT 1";
        ResultSet result = db.query(getInfoSql);

        try{
            while(result.next()){
                String password = result.getString(2);
                String nickName = result.getString(3);
                String image = result.getString(4);
                int level = result.getInt(5);
                MemberType type = this.intToMemberType(result.getInt(6));
                int credit = result.getInt(7);
                String name = result.getString(8);
                Sexuality sex = this.intToSexuality(result.getInt(9));
                String eMail = result.getString(10);

                UserPO po = new UserPO(id,password,nickName,image,level,type,credit,name,sex,eMail){};
                return po;
            }

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        // TODO Auto-generated method stub
        return null;
    }

    public ResultMessage update(UserPO po) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    public ResultMessage add(UserPO po) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    public ResultMessage checkPassword(String id, String password) throws RemoteException {
        // TODO Auto-generated method stub
        return ResultMessage.succeed;
    }

    public ResultMessage register(String id) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    public ResultMessage register(String id, String commerceName) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    public ResultMessage setMemberLevel(int[][] gradeWithCredit) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    public MemberType intToMemberType(int type){
        if(type==0)
            return MemberType.commom;
        else
            return MemberType.commerce;
    }
    public Sexuality intToSexuality(int sex){
        if(sex==0)
            return Sexuality.female;
        else
            return Sexuality.male;
    }
}
