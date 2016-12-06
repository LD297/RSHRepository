package data.daohelperimpl.userdaohelperimpl;

import constant.ResultMessage;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;

/**
 * Created by sky-PC on 2016/12/6.
 */
public class MemberLevelTXT {

    public void init(){

        // fileName表示你创建的文件名；
        String fileName = "MemberLevelSetting.txt";
        File file = new File(fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();}
        }
    }
    // 网站营销人员 制定会员等级制度
    public ResultMessage setMemberLevel(int[] gradeWithCredit) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }
}
