package bl.webstaffserviceimpl;

import bl.webstaffservice.WebStaffService;
import constant.ResultMessage;
import data.dao.webstaffdao.WebSalesmanDao;
import po.WebSalesmanPO;
import rmi.RemoteHelper;
import vo.WebSalesmanVO;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;


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
		initRemote();
		try {
			return webSalesmanDao.getNewID();
		} catch (RemoteException e) {
			e.printStackTrace();
			return "remote_fail";
		}
	}

	@Override
	public ResultMessage addWebSalesman(WebSalesmanVO webSalesmanVO) {
		initRemote();
		String webSalesmanID = webSalesmanVO.getId();
		try {
			if(webSalesmanDao.findByID(webSalesmanID)!=null){
				return ResultMessage.idAlreadyExist;
			}
			return webSalesmanDao.insert(webSalesmanVO.changeIntoPO());
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.remote_fail;
		}
	}
	
	@Override
	public WebSalesmanVO getWebSalesman(String webSalesmanID) {
		initRemote();
		WebSalesmanPO webSalesmanPO ;
		try {
			webSalesmanPO = webSalesmanDao.findByID(webSalesmanID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		return webSalesmanPO.changeIntoVO();
	}
	
	@Override
	public ArrayList<WebSalesmanVO> getAllWebSalesmen() {
		initRemote();
		ArrayList<WebSalesmanPO> webSalesmanPOs = new ArrayList<>();
		ArrayList<WebSalesmanVO> webSalesmanVOs = new ArrayList<>();
		try {
			webSalesmanPOs = webSalesmanDao.getAll();
		} catch (RemoteException e) {
			e.printStackTrace();
			return webSalesmanVOs;
		}
		for(WebSalesmanPO webSalesmanPO:webSalesmanPOs){
			webSalesmanVOs.add(webSalesmanPO.changeIntoVO());
		}
		return webSalesmanVOs;
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
	
	@Override
	public ResultMessage changePassword(String ID, String oldPassword,String newPassword) {
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
		String webSalesmanID = webSalesmanVO.getId();
		
		initRemote();
		try {
			if(webSalesmanDao.findByID(webSalesmanID)==null){
				return ResultMessage.idNotExist;
			}
			return webSalesmanDao.update(webSalesmanVO.changeIntoPO());
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.remote_fail;
		}
	}

	


	

	
}
