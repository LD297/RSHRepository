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

    private static PromotionDaoImpl promotionDaoImpl;
    private  DaoHelperFactory daoHelperFactory ;
    private PromotionDaoHelper promotionDaoHelper;

    private PromotionDaoImpl()throws RemoteException{
        daoHelperFactory = new DaoHelperFactoryImpl();
        promotionDaoHelper = daoHelperFactory.getPromotionDaoHelper();
    }



    public static PromotionDaoImpl getInstance(){
        if(promotionDaoImpl==null){
            try {
                promotionDaoImpl = new PromotionDaoImpl();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return promotionDaoImpl;
    }

    public ResultMessage insert(PromotionPO po)throws RemoteException {
        return promotionDaoHelper.insert(po);
    }

    public ResultMessage delete(String setter, String id)throws RemoteException {
        return promotionDaoHelper.delete(setter,id);
    }

    public ResultMessage update(PromotionPO po)throws RemoteException {
        return promotionDaoHelper.update(po);
    }

    public PromotionPO findBySetterWithSort(String setter, String id)throws RemoteException {
        return promotionDaoHelper.findBySetterWithSort(setter, id);
    }

    public ArrayList<PromotionPO> findByDistrictWithHotel(String district,String hotel)throws RemoteException {
        return promotionDaoHelper.findByDistrictWithHotel(district, hotel);
    }

}
