package presentation.usercontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import presentation.tools.ImageFactory;
import presentation.tools.UIJumpTool;

public class LoadingUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane loadingAnchorPane;
    
    
    @FXML
	void mouseEntered(MouseEvent event) {
		ImageFactory.getImageFactory().setHotelImages();
		UIJumpTool.getUiJumpTool().changeSearchHotelToBrowseHotel();
	}
   
    public AnchorPane getloading() {
		return loadingAnchorPane;
	}
    
    @FXML
    void initialize() {
        assert loadingAnchorPane != null : "fx:id=\"loadingAnchorPane\" was not injected: check your FXML file '正在加载.fxml'.";
    }
}
