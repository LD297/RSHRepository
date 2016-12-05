package data.daohelperimpl.promotiondaohelperimpl;

import constant.ResultMessage;
import data.daohelperimpl.jdbc.DBHelper;
import po.PromotionPO;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by sky-PC on 2016/12/3.
 */
public class PromotionDaoHelperMySql {

    private DBHelper db = new DBHelper();

    public void init(){
        //path表示你所创建文件的路径
        String path = "D:\\360downloads";
        File f = new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
        // fileName表示你创建的文件名；
        String fileName = "Promotion.db";
        File file = new File(f,fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();}
        }

        db.executeSql("USE Promotion");
        // 身份 账号 密码
        db.executeSql("CREATE TABLE PromotionInfo(role tinyint,id char(26),password varchar(30))" );
    }

    public void finish(){
        File f = new File("D:\\360downloads\\Promotion.db");  // 输入要删除的文件位置
        if(f.exists())
            f.delete();
    }
    public ResultMessage insert(PromotionPO po)throws RemoteException {
        return null;
    }

    public ResultMessage del(String id, String reason)throws RemoteException {
        return null;
    }

    public ResultMessage update(PromotionPO po)throws RemoteException {
        return null;
    }

    public PromotionPO find(String id, String reason)throws RemoteException {
        return null;
    }

    public ArrayList<PromotionPO> finds(String str)throws RemoteException {
        return null;
    }
}
