package data.daohelperimpl.userdaohelperimpl;

import constant.ResultMessage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;

/**
 * Created by sky-PC on 2016/12/6.
 */
public class MemberLevelTXT {
    private static final String fileName = "TXTData/MemberLevelSetting.txt";
    public void init(){
        // fileName表示你创建的文件名；
        File file = new File(fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();}
        }
    }
    // 网站营销人员 制定会员等级制度
    public ResultMessage setMemberLevel(int gradeWithCredit) throws RemoteException,IOException {
    	FileOutputStream fs = new FileOutputStream(new File(fileName));
    	
    	FileWriter fw = new FileWriter(fileName);
    	String credits = String.valueOf(gradeWithCredit);
    	fw.write(credits);
    	fw.flush();
    	fw.close();
    	return ResultMessage.succeed;
    }
    public int getMemberLevel()throws RemoteException,IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
    	String data = br.readLine();
    	br.close();
    	
    	return Integer.parseInt(data);
    	
    }
 
}
