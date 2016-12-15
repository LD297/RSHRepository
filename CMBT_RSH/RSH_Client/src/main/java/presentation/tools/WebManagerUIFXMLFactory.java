package presentation.tools;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class WebManagerUIFXMLFactory {
	private static WebManagerUIFXMLFactory webManagerUIFXMLFactory = null;
	private WebManagerUIFXMLFactory(){}
	public static WebManagerUIFXMLFactory getInstance() {
		if(webManagerUIFXMLFactory==null){
			webManagerUIFXMLFactory = new WebManagerUIFXMLFactory();
		}
		return webManagerUIFXMLFactory;
	}

	public AnchorPane getManageUser() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/网站管理人员 。用户.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = loader.load();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return anchorPane;
	}
	
	public AnchorPane getManageHotel() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/网站管理人员 。酒店.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = loader.load();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return anchorPane;
	}
	
	public AnchorPane getManageWebSalesman() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/网站管理人员 。营销人员.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = loader.load();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return anchorPane;
	}
	

	
}
