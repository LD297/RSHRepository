package presentation.usercontroller;

/**
 * Created by john on 2016/12/4.
 */

import java.net.URL;
import java.util.ResourceBundle;

import constant.ResultMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import presentation.tools.UIJumpTool;
import presentation.tools.UserUIFXMLFactory;

public class SearchHotelUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button searchButton;

    @FXML
    private TextField addressField;

    @FXML
    private TextField areaField;

    private AnchorPane guide;

    @FXML
    void changeToHotelBrowse(ActionEvent event) {
        myChangeToHotelBrowse();
    }

    @FXML
    void changeToHotelBrowseByButton(MouseEvent event) {
        myChangeToHotelBrowse();

    }

    private void myChangeToHotelBrowse(){
        ResultMessage resultMessage = checkInput();
        if(resultMessage==ResultMessage.succeed){
            //TODO 根据地址和商圈
            UIJumpTool.getUiJumpTool().changeSearchHotelToBrowseHotel();
        }else{
            //TODO 提示框
        }

    }

    //TODO check input
    private ResultMessage checkInput(){
        return ResultMessage.succeed;
    }


    public void setGuide(AnchorPane guide){this.guide = guide;}


    @FXML
    void initialize() {
        assert searchButton != null : "fx:id=\"searchButton\" was not injected: check your FXML file '搜索酒店.fxml'.";
        assert addressField != null : "fx:id=\"addressField\" was not injected: check your FXML file '搜索酒店.fxml'.";
        assert areaField != null : "fx:id=\"areaField\" was not injected: check your FXML file '搜索酒店.fxml'.";

    }
}

