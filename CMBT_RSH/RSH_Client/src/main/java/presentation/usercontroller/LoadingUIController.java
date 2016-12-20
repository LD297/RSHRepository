package presentation.usercontroller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.tools.UIJumpTool;
import presentation.tools.UserUIFXMLFactory;

public class LoadingUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane loadingAnchorPane;
    
    private boolean isSelectionUI = false;
    
    @FXML
    void mouseEntered(MouseEvent event) {
    	
    	final Timer timer = new Timer();
    	TimerTask timerTask = new TimerTask() {
			
			@Override
			public void run() {
				loadingAnchorPane.setVisible(false);
				if(!isSelectionUI){
		    		UIJumpTool.getUiJumpTool().changeSearchHotelToBrowseHotel();
		    	}
			}
		};
    	timer.schedule(timerTask, 3000);
    	
    }
    public void init(boolean isSelectionUI) {
		this.isSelectionUI = isSelectionUI;
	}

    @FXML
    void initialize() {
        assert loadingAnchorPane != null : "fx:id=\"loadingAnchorPane\" was not injected: check your FXML file '正在加载.fxml'.";
    }
}
