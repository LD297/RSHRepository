package data.dao.promotiondao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import constant.ResultMessage;
import po.PromotionPO;

/**
 * 
 * @author aa
 *
 */
public interface PromotionDao extends Remote{
    // 添加策略
	public ResultMessage insert(PromotionPO po) throws RemoteException;
    // 制定者-> 策略序号 -> 删除
	public ResultMessage delete(String setterID, String sortID)throws RemoteException;
    // 更新策略
	public ResultMessage  update (PromotionPO po)throws RemoteException;
    // 某地区、某酒店、某房间类型 -> 查找
	public PromotionPO findBySetterWithSort(String setter, String id) throws RemoteException;
    // 开始日期、结束日期  -> 查找
	public ArrayList<PromotionPO> findByDistrictWithHotel(String district,String hotel) throws RemoteException;

}
