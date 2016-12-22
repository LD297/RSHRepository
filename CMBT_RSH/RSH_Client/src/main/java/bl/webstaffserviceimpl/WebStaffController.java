package bl.webstaffserviceimpl;

import bl.webstaffservice.WebStaffService;
import constant.ResultMessage;
import data.dao.webstaffdao.WebManagerDao;
import data.dao.webstaffdao.WebSalesmanDao;
import po.WebSalesmanPO;
import rmi.RemoteHelper;
import vo.WebSalesmanVO;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import javax.naming.ldap.ManageReferralControl;
/**
 * 网站工作人员总控
 * @author aa
 *
 */
public class WebStaffController implements WebStaffService{
	
	private static final String MANAGER_ID = "0000000000";
	
	private static WebSalesmanDao webSalesmanDao = null;
	
	private static void initRemote(){
		if(webSalesmanDao == null){
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			webSalesmanDao = remoteHelper.getWebSalesmanDao();
		}		
	}
	
	
	@Override
	public String getIDForWebsalesman() {
		// TODO Auto-generated method stub
		String year = String.valueOf(LocalDate.now().getYear());
		initRemote();
		try {
			return webSalesmanDao.getIDForNewWebSalesman(year);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "remote_fail";
		}
	}

	@Override
	public ResultMessage addWebSalesman(WebSalesmanVO webSalesmanVO) {
		// TODO Auto-generated method stub
		initRemote();
		String webSalesmanID = webSalesmanVO.getId();
		try {
			if(webSalesmanDao.findByID(webSalesmanID)!=null){
				return ResultMessage.already_exist;
			}
			return webSalesmanDao.insert(webSalesmanVO.changeIntoPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.remote_fail;
		}
	}

	@Override
	public ArrayList<WebSalesmanVO> getAllWebSalesmen() {
		// TODO Auto-generated method stub
		initRemote();
		ArrayList<WebSalesmanPO> webSalesmanPOs = new ArrayList<>();
		ArrayList<WebSalesmanVO> webSalesmanVOs = new ArrayList<>();
		try {
			webSalesmanPOs = webSalesmanDao.getAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return webSalesmanVOs;
		}
		for(WebSalesmanPO webSalesmanPO:webSalesmanPOs){
			webSalesmanVOs.add(webSalesmanPO.changeIntoVO());
		}
		return webSalesmanVOs;
	}
	
	@Override
	public ResultMessage changePassword(String ID, String oldPassword,String newPassword) {
		// TODO Auto-generated method stub
		if(ID.equals(MANAGER_ID)){
			WebManager manager = WebManager.getInstance();
			return manager.changePassword(oldPassword,newPassword);
		}
		else{
			WebSalesman webSalesman = WebSalesman.getInstance(ID);
			return webSalesman.changePassword(oldPassword,newPassword);
		}
	}

	@Override
	public ResultMessage updateWebSalesman(WebSalesmanVO webSalesmanVO) {
		// TODO Auto-generated method stub
		String webSalesmanID = webSalesmanVO.getId();
		initRemote();
		
		try {
			if(webSalesmanDao.findByID(webSalesmanID)==null){
				return ResultMessage.idNotExist;
			}
			return webSalesmanDao.update(webSalesmanVO.changeIntoPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.remote_fail;
		}
	}

	/**
	 * 登陆模块调用
	 * @param ID
	 * @param password
	 * @return
	 */
	public static ResultMessage checkPassword(String ID, String password) {
		if(ID.equals(MANAGER_ID)){
			WebManager webManager = WebManager.getInstance();
			return webManager.checkPassword(password);
		}
		else{
			WebSalesman webSalesman = WebSalesman.getInstance(ID);
			return webSalesman.checkPassword(password);
		}
	}

	
}
