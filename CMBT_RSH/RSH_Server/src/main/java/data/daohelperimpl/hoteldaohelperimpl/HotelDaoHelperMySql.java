package data.daohelperimpl.hoteldaohelperimpl;

import data.daohelper.DaoHelperMySql;

import java.io.File;
import java.io.IOException;

/**
 * Created by a297 on 16/11/27.
 */
public class HotelDaoHelperMySql extends DaoHelperMySql{
    public void init(){
        //path表示你所创建文件的路径
        String path = "D:\\360downloads";
        File f = new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
        // fileName表示你创建的文件名；
        String fileName = "HotelList.db";
        File file = new File(f,fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();}
        }
    }
    public void finish(){
        File f = new File("D:\\360downloads\\HotelList.db");  // 输入要删除的文件位置
        if(f.exists())
            f.delete();
    }
}