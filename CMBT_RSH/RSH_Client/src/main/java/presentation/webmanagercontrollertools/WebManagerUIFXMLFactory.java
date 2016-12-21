package presentation.webmanagercontrollertools;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import presentation.webmanagercontroller.CheckUserInfoUIController;
import presentation.webmanagercontroller.ManafeWebsalesmanUIController;
import presentation.webmanagercontroller.ManageHotelUIController;
import presentation.webmanagercontroller.ManageUserUIController;
import presentation.webmanagercontroller.ManagerHomepageUIController;
import presentation.webmanagercontroller.ModifyHotelUIController;
import presentation.webmanagercontroller.ModifyUserInfoUIController;
import presentation.webmanagercontroller.ModifyWebSalesmanUIController;
import presentation.webmanagercontroller.SuccessAddHotelUIController;
import presentation.webmanagercontroller.SuccessAddWebSalesmanUIController;

public class WebManagerUIFXMLFactory {
	private static WebManagerUIFXMLFactory webManagerUIFXMLFactory = null;
	private WebManagerUIFXMLFactory(){}
	public static WebManagerUIFXMLFactory getInstance() {
		if(webManagerUIFXMLFactory==null){
			webManagerUIFXMLFactory = new WebManagerUIFXMLFactory();
		}
		return webManagerUIFXMLFactory;
	}
	
	private ManagerHomepageUIController managerHomepageUIController = null;
	private ManageHotelUIController manageHotelUIController = null;
	private ManageUserUIController manageUserUIController = null;
	private ManafeWebsalesmanUIController manafeWebsalesmanUIController = null;
	private CheckUserInfoUIController checkUserInfoUIController = null;
	private SuccessAddHotelUIController successAddHotelUIController = null;
	private SuccessAddWebSalesmanUIController successAddWebSalesmanUIController = null;
	private ModifyHotelUIController modifyHotelUIController = null;
	private ModifyWebSalesmanUIController modifyWebSalesmanUIController = null;
	private ModifyUserInfoUIController modifyUserInfoUIController = null;
	
	private AnchorPane manageUserAnchorPane = null;
	private AnchorPane manageHotelAnchorPane = null;
	private AnchorPane manageWebsalesmanAnchorPane = null;
	private AnchorPane aboutUsAnchorPane = null;

	public AnchorPane getManageHomepage() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/网管首页 .fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		managerHomepageUIController = loader.getController();
		return anchorPane;
	}
	
	public ManagerHomepageUIController getManagerHomepageUIController() {
		return managerHomepageUIController;
	}
	public AnchorPane getAboutUs() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/网管_关于我们.fxml"));
		if(aboutUsAnchorPane==null){
			try {
				aboutUsAnchorPane = loader.load();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return aboutUsAnchorPane;
	}
	
	
	public AnchorPane getManageUser() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/网管_管理用户.fxml"));
		if(manageUserAnchorPane==null){
			try {
				manageUserAnchorPane = loader.load();
			} catch (Exception e) {
				e.printStackTrace();
			}
			manageUserUIController = loader.getController();
		}
		return manageUserAnchorPane;
	}
	
	public AnchorPane getManageHotel() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/网管_管理酒店.fxml"));
		if(manageHotelAnchorPane==null){
			try {
				manageHotelAnchorPane = loader.load();
			} catch (Exception e) {
				e.printStackTrace();
			}
			manageHotelUIController = loader.getController();
		}
		return manageHotelAnchorPane;
	}
	
	public AnchorPane getManageWebSalesman() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/网管_管理营销人员.fxml"));
		if(manageWebsalesmanAnchorPane==null){
			try {
				manageWebsalesmanAnchorPane = loader.load();
			} catch (Exception e) {
				e.printStackTrace();
			}
			manafeWebsalesmanUIController = loader.getController();
		}
		return manageWebsalesmanAnchorPane;
	}
	public AnchorPane getModifyOwnPassword() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/网管_修改自己的密码.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return anchorPane;
	}
	
	
	public AnchorPane getSuccessAddHotel() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/网管_添加酒店成功.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		successAddHotelUIController = loader.getController();
		return anchorPane;
	}
	
	public AnchorPane getSuccessAddWebSalesman() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/网管_添加营销人员成功.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		successAddWebSalesmanUIController = loader.getController();
		return anchorPane;
	}
	
	public AnchorPane getAddHotel() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/网管_添加酒店.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return anchorPane;
	}
	
	public AnchorPane getAddWebSalesman() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/网管_添加营销人员.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return anchorPane;
	}
	
	public AnchorPane getModifyHotel() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/网管_修改酒店信息.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		modifyHotelUIController = loader.getController();
		return anchorPane;
	}
	
	public AnchorPane getModifyWebSalesman() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/网管_修改营销人员信息.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		modifyWebSalesmanUIController = loader.getController();
		return anchorPane;
	}
	
	public AnchorPane getCheckUserInfo(){
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/网管_查看用户信息.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		checkUserInfoUIController = loader.getController();
		return anchorPane;
	}
	
	public AnchorPane getModifyUserInfo() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/网管_修改用户信息.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		modifyUserInfoUIController = loader.getController();
		return anchorPane;
	}
	

	public CheckUserInfoUIController getCheckUserInfoUIController() {
		return checkUserInfoUIController;
	}
	
	public SuccessAddHotelUIController getSuccessAddHotelUIController() {
		return successAddHotelUIController;
	}
	public SuccessAddWebSalesmanUIController getSuccessAddWebSalesmanUIController() {
		return successAddWebSalesmanUIController;
	}
	public ManageHotelUIController getManageHotelUIController() {
		return manageHotelUIController;
	}
	public ModifyHotelUIController getModifyHotelUIController() {
		return modifyHotelUIController;
	}
	public ManageUserUIController getManageUserUIController() {
		return manageUserUIController;
	}
	public ManafeWebsalesmanUIController getManafeWebsalesmanUIController() {
		return manafeWebsalesmanUIController;
	}
	public ModifyWebSalesmanUIController getModifyWebSalesmanUIController() {
		return modifyWebSalesmanUIController;
	}
	public ModifyUserInfoUIController getModifyUserInfoUIController() {
		return modifyUserInfoUIController;
	}
}
