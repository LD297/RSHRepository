package data.dao_Stub.userdao_Stub;

import bl.userserviceimpl.User;
import constant.MemberType;
import constant.ResultMessage;
import constant.Sexuality;
import data.dao.userdao.UserDao;
import po.UserPO;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by aa on 2016/12/13.
 */
public class UserDao_Stub implements UserDao {
    private static UserDao_Stub userDao_stub=null;

    ArrayList<UserPO> userPOS = new ArrayList<>();
    UserPO userPO=null;
    int[] memberLevelBoundaries = new int[10];


    public static UserDao_Stub getInstance(){
        if(userDao_stub==null){
            userDao_stub = new UserDao_Stub();
        }
        return userDao_stub;
    }

    private UserDao_Stub(){
        UserPO userPO;
        Date date = new Date();
        LocalDate localDate = LocalDate.of(2011,1,2);
        userPO = new UserPO("123456789098","123456","fanfan","??",
                localDate ,1, MemberType.commerce,1,"WuYifam", Sexuality.male,
                "111@nju,cn","dajiudian");
        userPOS.add(userPO);
    }
    @Override
    public UserPO getInfo(String id) throws RemoteException {
        userPO.setID(id);
        return userPO;
    }

    @Override
    public ResultMessage update(UserPO po) throws RemoteException {
        return ResultMessage.succeed;
    }

    @Override
    public ResultMessage add(UserPO po) throws RemoteException {
        userPOS.add(po);
        return ResultMessage.succeed;
    }

    @Override
    public ResultMessage setMemberLevel(int[] gradeWithCredit) throws RemoteException {
        memberLevelBoundaries = gradeWithCredit;
        return ResultMessage.succeed;
    }

    @Override
    public int[] getMemberLevel() throws RemoteException {
        return memberLevelBoundaries;
    }

	@Override
	public ArrayList<UserPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
