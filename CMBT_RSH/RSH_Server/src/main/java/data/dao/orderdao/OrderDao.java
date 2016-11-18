package data.dao.orderdao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.OrderPO;
import constant.ResultMessage;
import constant.StateOfOrder;

public interface OrderDao extends Remote{
	//根据订单编号查找订单
	public OrderPO find(String orderid) throws RemoteException;
	//根据用户编号查找订单	
	public ArrayList<OrderPO> userFind(String uderid) throws RemoteException;
	//根据酒店编号查找订单
	public ArrayList<OrderPO> hotelFind(String hotelid) throws RemoteException;
	//根据状态编号查找订单
	public ArrayList<OrderPO> stateFind(StateOfOrder state) throws RemoteException;
	//新建订单
	public ResultMessage insert(OrderPO orderpo) throws RemoteException;
	//删除订单
	public ResultMessage delete(String orderid) throws RemoteException;
	//订单状态更新
	public ResultMessage stateUpdate(String orderid,StateOfOrder newstate) throws RemoteException;
	//评价订单
	public ResultMessage commentUpdate(String orderid, double grade, String comment) throws RemoteException;
	//订单实际离开时间更新
	public ResultMessage leaveUpdate(String orderid,Date leavetime) throws RemoteException;
	
    public void	init() throws RemoteException;
	
    public void finish() throws RemoteException;


}