package data.daohelperimpl.userdaohelperimpl;

import constant.ResultMessage;
import data.daohelperimpl.jdbc.DBHelper;
import po.CreditRecordPO;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Iterator;

/**
 * Created by sky-PC on 2016/12/3.
 */
public class CreditRecordListDaoHelperMySql {

    private DBHelper db = new DBHelper();

    public void init(){
        //path表示你所创建文件的路径
        String path = "D:\\360downloads";
        File f = new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
        // fileName表示你创建的文件名；
        String fileName = "CreditRecord.db";
        File file = new File(f,fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();}
        }

        db.executeSql("USE CreditRecord");
        // 身份 账号 密码
        db.executeSql("CREATE TABLE CreditRecordInfo(role tinyint,id char(26),password varchar(30))" );
    }

    public void finish(){
        File f = new File("D:\\360downloads\\CreditRecord.db");  // 输入要删除的文件位置
        if(f.exists())
            f.delete();
    }
    public Iterator<CreditRecordPO> getCreditRecordList(String userid) throws RemoteException {
        return null;
    }

    public ResultMessage addCreditRecord(CreditRecordPO po) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }
}
