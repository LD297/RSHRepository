package bl.promotionServiceimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import data.dao.promotiondao.PromotionDao;
import po.PromotionPO;
import rmi.RemoteHelper;
import vo.PromotionVO;

/**
 * 向presentation层返回策略列表
 * @author aa
 *
 */
public class Show {

	private static PromotionDao promotionDao;
	private static Show show = null;
	private Show(){
		RemoteHelper remoteHelper = RemoteHelper.getInstance();
		promotionDao = remoteHelper.getPromotionDao();
	}
	public static Show getInstance(){
		if(show==null){
			show = new Show();
		}
		return show;
	}
	
	
	

}
