package Test;

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

import data.daohelperimpl.userdaohelperimpl.CreditRecordListDaoHelperMySql;
import data.daohelperimpl.userdaohelperimpl.MemberLevelTXT;
import data.daohelperimpl.userdaohelperimpl.UserDaoHelperMySql;

/**
 * Created by sky-PC on 2016/12/12.
 */
public class UserTest {
    static CreditRecordListDaoHelperMySql creditDao = new CreditRecordListDaoHelperMySql();
    static UserDaoHelperMySql userDao = new UserDaoHelperMySql();
   
    @Test
    public void testaddCreditRecord() throws RemoteException{
        CreditRecordPO po = new CreditRecordPO("14775378908",new Date(),null,
                CreditAction.execute,"+300",300);
        ResultMessage result = creditDao.addCreditRecord(po);
        assertEquals(result,ResultMessage.succeed);
    }


    @Test
    public void testgetInfo() throws RemoteException{
        String id = "14775378908";
        UserPO po = userDao.getInfo(id);
        System.out.print(po.getPassword());
    }
    
    @Test
    public void  testgetCreditRecordList() throws RemoteException{
        String userid = "11111111111";
        Iterator<CreditRecordPO> iterator = creditDao.getCreditRecordList(userid).iterator();
        assertEquals(iterator.next().getCredit(),300);
    }
   
    @Test// 账号不存在
    public void testinsert1() throws RemoteException{
        UserPO po = new UserPO("11111111111", "123456", "tina", "http://ww4.sinaimg.cn/mw690/a2a81745jw1fba7y9sx2rj20en0ebad8.jpg",
                LocalDate.now(),0, MemberType.not_member, 0,
                "李未", Sexuality.female, "2299357362@qq.com",null);
        ResultMessage result = userDao.insert(po);
        assertEquals(result,ResultMessage.succeed);
    }
    @Test// 账号不存在
    public void testinsert2() throws RemoteException{
        UserPO po = new UserPO("2222222222", "123456", "tina", "http://ww4.sinaimg.cn/mw690/a2a81745jw1fba7y9sx2rj20en0ebad8.jpg",
                LocalDate.now(),0, MemberType.not_member, 0,
                "李未", Sexuality.female, "2299357362@qq.com",null);
        ResultMessage result = userDao.insert(po);
        assertEquals(result,ResultMessage.idAlreadyExist);
    }
    
    @Test// 更新信息
    public void testupdate() throws RemoteException{
        UserPO po = new UserPO("1111111111", "123456", "tina", "http://ww4.sinaimg.cn/mw690/a2a81745jw1fba7y9sx2rj20en0ebad8.jpg",
                LocalDate.now(),0, MemberType.commom, 0,
                "李未", Sexuality.female, "229@sian.com",null);
        ResultMessage result = userDao.update(po);
        assertEquals(result,ResultMessage.succeed);
    }
    @Test// 制定会员等级
     public void testLevelSet()throws IOException{
    	MemberLevelTXT member = new MemberLevelTXT();
    	assertEquals(member.setMemberLevel(200),ResultMessage.succeed);
    }
}
