package data.daohelperimpl.userdaohelperimpl;

import constant.CreditAction;
import constant.MemberType;
import constant.ResultMessage;
import constant.Sexuality;
import po.CreditRecordPO;
import po.UserPO;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by sky-PC on 2016/12/12.
 */
public class test {
    CreditRecordListDaoHelperMySql creditDao = new CreditRecordListDaoHelperMySql();
    UserDaoHelperMySql userDao = new UserDaoHelperMySql();
    public void  testgetCreditRecordList() throws RemoteException{
        String userid = "";
        Iterator<CreditRecordPO> iterator = creditDao.getCreditRecordList(userid);
    }

    public void testaddCreditRecord() throws RemoteException{
        CreditRecordPO po = new CreditRecordPO("",new Date(),"1234567890",
                CreditAction.execute,"+300",300);
        ResultMessage result = creditDao.addCreditRecord(po);
    }



    public void testgetInfo() throws RemoteException{
        String id = "";
        UserPO po = userDao.getInfo(id);
    }

    public void testupdate() throws RemoteException{
        UserPO po = new UserPO("14775378908", "123456", "tina", "url://",
                LocalDate.now(),0, MemberType.commom, 0,
                "李未", Sexuality.female, "2299357362@qq.com",null);
        ResultMessage result = userDao.update(po);
    }

    public void testinsert() throws RemoteException{
        UserPO po = new UserPO("14775378908", "123456", "tina", "url://",
                LocalDate.now(),0, MemberType.commom, 0,
                "李未", Sexuality.female, "2299357362@qq.com",null);
        ResultMessage result = userDao.insert(po);
    }

    public  void testsetMemberLevel() throws RemoteException{
        int[] gradeWithCredit = {};
        ResultMessage result = userDao.setMemberLevel(gradeWithCredit);
    }
}
