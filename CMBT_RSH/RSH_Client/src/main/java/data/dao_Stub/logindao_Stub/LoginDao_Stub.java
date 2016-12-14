package data.dao_Stub.logindao_Stub;

import constant.ResultMessage;
import constant.Role;
import data.dao.logindao.LoginDao;
import po.OnlinePersonPO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by aa on 2016/12/13.
 */
public class LoginDao_Stub implements LoginDao {
    private static LoginDao_Stub loginDao_stub= null;
    Map<String,OnlinePersonPO> personPOMap;

    private LoginDao_Stub(){
        personPOMap.clear();
    }

    public static LoginDao_Stub getInstance(){
        if(loginDao_stub==null){
            loginDao_stub = new LoginDao_Stub();
        }
        return loginDao_stub;
    }

    @Override
    public ResultMessage addOnline(OnlinePersonPO po) throws RemoteException {
        if(personPOMap.containsKey(po.getId())){
            return ResultMessage.already_exist;
        }
        else{
            personPOMap.put(po.getId(),po);
        }
        return ResultMessage.succeed;
    }

    @Override
    public ResultMessage deleteOnline(Role role, String id) throws RemoteException {
        if(personPOMap.containsKey(id)){
            personPOMap.remove(id);
            return ResultMessage.succeed;
        }
        else{
            return ResultMessage.not_exist;
        }
    }
}
