package data.daoimpl.promotiondaoimpl;

import constant.ResultMessage;
import data.dao.promotiondao.PromotionDao;
import data.daohelper.DaoHelperFactory;
import data.daohelper.PromotionDaoHelper;
import data.daohelperimpl.DaoHelperFactoryImpl;
import po.PromotionPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by aa on 2016/11/27.
 */
public class PromotionDaoImpl extends UnicastRemoteObject implements PromotionDao {

    private  DaoHelperFactory daoHelperFactory ;
    private PromotionDaoHelper promotionDaoHelper;

    private PromotionDaoImpl()throws RemoteException{
    	if(daoHelperFactory==null)
            daoHelperFactory = new DaoHelperFactoryImpl();
        if(promotionDaoHelper==null)
    	    promotionDaoHelper = daoHelperFactory.getPromotionDaoHelper();
    }

    public static PromotionDaoImpl getInstance(){
    	try {
			return new PromotionDaoImpl();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
    }

    
    // 得到新的促销策略的编号
    @Override
 	public String getNewID(String setterID)throws RemoteException{
 		return promotionDaoHelper.getNewID(setterID);
 	}
     
    // 添加策略
    @Override
    public ResultMessage insert(PromotionPO po) throws RemoteException{
        return promotionDaoHelper.insert(po);
    }
    // 制定者-> 策略序号 -> 删除
    @Override
    public ResultMessage delete(String setterID, String sortID)throws RemoteException{
        return promotionDaoHelper.delete(setterID, sortID);
    }
    // 更新策略
    @Override
    public ResultMessage  update (PromotionPO po)throws RemoteException{
        return promotionDaoHelper.update(po);
    }

    // 制定者、策略编号 -> 查找
    @Override
 	public PromotionPO find(String setter, String promotionID) throws RemoteException{
 		return promotionDaoHelper.find(setter, promotionID);
 	}
 	
 	// 6位->district 10->hotel
    @Override
 	public ArrayList<PromotionPO> finds(String scope) throws RemoteException{
 		return promotionDaoHelper.finds(scope);
 	}



}
