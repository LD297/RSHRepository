package data.daohelperimpl.logindaohelperimpl;

import constant.ResultMessage;
import constant.Role;
import data.daohelper.LoginDaoHelper;
import data.daohelperimpl.jdbc.DBHelper;
import po.OnlinePersonPO;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by sky-PC on 2016/12/3.
 */
public class LoginDaoHelperMySql implements LoginDaoHelper{
	
    private ArrayList<OnlinePersonPO> onlineInfo = null;
   
    public void init() {
    	onlineInfo = new ArrayList<OnlinePersonPO>();
    }

    public void finish(){
        onlineInfo.clear();;
    }
    public ArrayList<OnlinePersonPO> get(){
    	return onlineInfo;
    }
    // 添加在线人员
    public ResultMessage addOnline(OnlinePersonPO po) throws RemoteException {
        for(int i=0;i<onlineInfo.size();i++)
        	if(onlineInfo.get(i).getId().equals(po.getId()))
        		return ResultMessage.idAlreadyExist;
        
        onlineInfo.add(po);
        return ResultMessage.succeed;
    }
    // 去除在线人员
    public ResultMessage deleteOnline(Role role, String id) throws RemoteException {
    	for(int i=0;i<onlineInfo.size();i++){
    		OnlinePersonPO po = onlineInfo.get(i);
        	if(po.getId().equals(id)&&po.getRole()==role){
        		onlineInfo.remove(i);
        		return ResultMessage.succeed;
        	}
    	}
        return ResultMessage.idNotExist;
    }
}
