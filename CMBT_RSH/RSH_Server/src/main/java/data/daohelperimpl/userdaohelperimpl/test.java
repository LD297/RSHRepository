package data.daohelperimpl.userdaohelperimpl;

import static org.junit.Assert.*;
import constant.CreditAction;
import constant.MemberType;
import constant.ResultMessage;
import constant.Sexuality;
import po.CreditRecordPO;
import po.UserPO;

import java.io.IOException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;

/**
 * Created by sky-PC on 2016/12/12.
 */
public class test {
    static CreditRecordListDaoHelperMySql creditDao = new CreditRecordListDaoHelperMySql();
    static UserDaoHelperMySql userDao =null;// new UserDaoHelperMySql();
    
    @Test
    public void testaddCreditRecord() throws RemoteException{
        CreditRecordPO po = new CreditRecordPO("14775378908",new Date(),null,
                CreditAction.execute,"+300",300);
        ResultMessage result = creditDao.addCreditRecord(po);
        assertEquals(result,ResultMessage.succeed);
    }
/*

    @Test
    public void testgetInfo() throws RemoteException{
        String id = "14775378908";
        UserPO po = userDao.getInfo(id);
        assertEquals(po.geteMail(),"229@sian.com");
    }
    @Test
    public void testupdate() throws RemoteException{
        UserPO po = new UserPO("14775378908", "123456", "tina", "url://",
                LocalDate.now(),0, MemberType.commom, 0,
                "李未", Sexuality.female, "229@sian.com",null);
        ResultMessage result = userDao.update(po);
        assertEquals(result,ResultMessage.succeed);
    }
    @Test
    public void  testgetCreditRecordList() throws RemoteException{
        String userid = "14775378908";
        Iterator<CreditRecordPO> iterator = creditDao.getCreditRecordList(userid);
        assertEquals(iterator.next().getCredit(),300);
    }
   */
    @Test
    public void testinsert() throws RemoteException{
        UserPO po = new UserPO("14775378908", "123456", "tina", "url://",
                LocalDate.now(),0, MemberType.commom, 0,
                "李未", Sexuality.female, "2299357362@qq.com",null);
        ResultMessage result = userDao.insert(po);
        assertEquals(result,ResultMessage.idAlreadyExist);
    }
    
}
