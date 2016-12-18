package bl.webstaffserviceimpl;

import bl.webstaffservice.WebStaffService;
import constant.ResultMessage;
import data.dao.webstaffdao.WebManagerDao;
import data.dao.webstaffdao.WebSalesmanDao;
import po.WebSalesmanPO;
import rmi.RemoteHelper;
import vo.WebSalesmanVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.naming.ldap.ManageReferralControl;
/**
 * 网站工作人员总控
 * @author aa
 *
 */
public class WebStaffController implements WebStaffService{
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
		String year = String.valueOf(Calendar.YEAR);
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
		try {
			return webSalesmanDao.addWebSalesman(webSalesmanVO.changeIntoPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.remote_fail;
		}
	}

	@Override
	public ArrayList<WebSalesmanVO> getWebSalesmanInfo() {
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
		if(ID=="0000000000"){
			WebManager manager = WebManager.getInstance();
			return manager.changePassword(oldPassword,newPassword);
		}
		else{
			WebSalesman webSalesman = WebSalesman.getInstance(ID);
			return webSalesman.changePassword(oldPassword,newPassword);
		}
	}
	@Override
	public ResultMessage forceChangePassword(String ID, String newPassword) {
		// TODO Auto-generated method stub
		if(ID=="0000000000"){
			return ResultMessage.noChangeMade;
		}
		else{
			WebSalesman webSalesman = WebSalesman.getInstance(ID);
			return webSalesman.forceChangePassword(newPassword);
		}
	}

	@Override
	public ResultMessage addWebManager(String ID, String password) {
		// TODO Auto-generated method stub
		return ResultMessage.noChangeMade;
	}

	
	public static ResultMessage checkPassword(String ID, String password) {
		if(ID=="0000000000"){
			WebManager webManager = WebManager.getInstance();
			return webManager.checkPassword(password);
		}
		else{
			WebSalesman webSalesman = WebSalesman.getInstance(ID);
			return webSalesman.checkPassword(password);
		}
	}

	

}
