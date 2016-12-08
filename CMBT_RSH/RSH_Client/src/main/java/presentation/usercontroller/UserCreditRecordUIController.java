package presentation.usercontroller;

/**
 * Created by john on 2016/12/7.
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class UserCreditRecordUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label yearLabel;

    @FXML
    private Label dayOfTodayLabel;

    @FXML
    private Label monthdayOfTodayLabel;

    @FXML
    private Label weekOfTodayLabel;

    @FXML
    private Label weekOfLine1;

    @FXML
    private Label weekOfLine5;

    @FXML
    private Label weekOfLine4;

    @FXML
    private Label weekOfLine3;

    @FXML
    private Label weekOfLine2;

    @FXML
    private Label monthdayOfLine1;

    @FXML
    private Label monthdayOfLine2;

    @FXML
    private Label monthdayOfLine3;

    @FXML
    private Label monthdayOfLine4;

    @FXML
    private Label monthdayOfLine5;

    @FXML
    private Label creditActionLabelOfLine1;

    @FXML
    private Label resultLabelOfLine1;

    @FXML
    private Label creditSumOfline1;

    @FXML
    private Label creditActionLabelOfLine5;

    @FXML
    private Label creditActionLabelOfLine4;

    @FXML
    private Label creditActionLabelOfLine3;

    @FXML
    private Label creditActionLabelOfLine2;

    @FXML
    private Label creditSumOfline5;

    @FXML
    private Label creditSumOfline4;

    @FXML
    private Label creditSumOfline3;

    @FXML
    private Label creditSumOfline2;

    @FXML
    private Label resultLabelOfLine5;

    @FXML
    private Label resultLabelOfLine4;

    @FXML
    private Label resultLabelOfLine3;

    @FXML
    private Label resultLabelOfLine2;

    @FXML
    private ImageView ordertypeImageOfLine3;

    @FXML
    private ImageView ordertypeImageOfLine4;

    @FXML
    private ImageView ordertypeImageOfLine5;

    @FXML
    private ImageView ordertypeImageOfLine1;

    @FXML
    private Label lastPageLabel;

    @FXML
    private TextField pageField;

    @FXML
    private Label nextPageLabel;

    @FXML
    private ImageView ordertypeImageOfLine2;

    @FXML
    void changeToLastPage(MouseEvent event) {

    }

    @FXML
    void changeToNextPage(MouseEvent event) {

    }

    @FXML
    void changeToSpecficPage(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert yearLabel != null : "fx:id=\"yearLabel\" was not injected: check your FXML file '信用记录.fxml'.";
        assert dayOfTodayLabel != null : "fx:id=\"dayOfTodayLabel\" was not injected: check your FXML file '信用记录.fxml'.";
        assert monthdayOfTodayLabel != null : "fx:id=\"monthdayOfTodayLabel\" was not injected: check your FXML file '信用记录.fxml'.";
        assert weekOfTodayLabel != null : "fx:id=\"weekOfTodayLabel\" was not injected: check your FXML file '信用记录.fxml'.";
        assert weekOfLine1 != null : "fx:id=\"weekOfLine1\" was not injected: check your FXML file '信用记录.fxml'.";
        assert weekOfLine5 != null : "fx:id=\"weekOfLine5\" was not injected: check your FXML file '信用记录.fxml'.";
        assert weekOfLine4 != null : "fx:id=\"weekOfLine4\" was not injected: check your FXML file '信用记录.fxml'.";
        assert weekOfLine3 != null : "fx:id=\"weekOfLine3\" was not injected: check your FXML file '信用记录.fxml'.";
        assert weekOfLine2 != null : "fx:id=\"weekOfLine2\" was not injected: check your FXML file '信用记录.fxml'.";
        assert monthdayOfLine1 != null : "fx:id=\"monthdayOfLine1\" was not injected: check your FXML file '信用记录.fxml'.";
        assert monthdayOfLine2 != null : "fx:id=\"monthdayOfLine2\" was not injected: check your FXML file '信用记录.fxml'.";
        assert monthdayOfLine3 != null : "fx:id=\"monthdayOfLine3\" was not injected: check your FXML file '信用记录.fxml'.";
        assert monthdayOfLine4 != null : "fx:id=\"monthdayOfLine4\" was not injected: check your FXML file '信用记录.fxml'.";
        assert monthdayOfLine5 != null : "fx:id=\"monthdayOfLine5\" was not injected: check your FXML file '信用记录.fxml'.";
        assert creditActionLabelOfLine1 != null : "fx:id=\"creditActionLabelOfLine1\" was not injected: check your FXML file '信用记录.fxml'.";
        assert resultLabelOfLine1 != null : "fx:id=\"resultLabelOfLine1\" was not injected: check your FXML file '信用记录.fxml'.";
        assert creditSumOfline1 != null : "fx:id=\"creditSumOfline1\" was not injected: check your FXML file '信用记录.fxml'.";
        assert creditActionLabelOfLine5 != null : "fx:id=\"creditActionLabelOfLine5\" was not injected: check your FXML file '信用记录.fxml'.";
        assert creditActionLabelOfLine4 != null : "fx:id=\"creditActionLabelOfLine4\" was not injected: check your FXML file '信用记录.fxml'.";
        assert creditActionLabelOfLine3 != null : "fx:id=\"creditActionLabelOfLine3\" was not injected: check your FXML file '信用记录.fxml'.";
        assert creditActionLabelOfLine2 != null : "fx:id=\"creditActionLabelOfLine2\" was not injected: check your FXML file '信用记录.fxml'.";
        assert creditSumOfline5 != null : "fx:id=\"creditSumOfline5\" was not injected: check your FXML file '信用记录.fxml'.";
        assert creditSumOfline4 != null : "fx:id=\"creditSumOfline4\" was not injected: check your FXML file '信用记录.fxml'.";
        assert creditSumOfline3 != null : "fx:id=\"creditSumOfline3\" was not injected: check your FXML file '信用记录.fxml'.";
        assert creditSumOfline2 != null : "fx:id=\"creditSumOfline2\" was not injected: check your FXML file '信用记录.fxml'.";
        assert resultLabelOfLine5 != null : "fx:id=\"resultLabelOfLine5\" was not injected: check your FXML file '信用记录.fxml'.";
        assert resultLabelOfLine4 != null : "fx:id=\"resultLabelOfLine4\" was not injected: check your FXML file '信用记录.fxml'.";
        assert resultLabelOfLine3 != null : "fx:id=\"resultLabelOfLine3\" was not injected: check your FXML file '信用记录.fxml'.";
        assert resultLabelOfLine2 != null : "fx:id=\"resultLabelOfLine2\" was not injected: check your FXML file '信用记录.fxml'.";
        assert ordertypeImageOfLine3 != null : "fx:id=\"ordertypeImageOfLine3\" was not injected: check your FXML file '信用记录.fxml'.";
        assert ordertypeImageOfLine4 != null : "fx:id=\"ordertypeImageOfLine4\" was not injected: check your FXML file '信用记录.fxml'.";
        assert ordertypeImageOfLine5 != null : "fx:id=\"ordertypeImageOfLine5\" was not injected: check your FXML file '信用记录.fxml'.";
        assert ordertypeImageOfLine1 != null : "fx:id=\"ordertypeImageOfLine1\" was not injected: check your FXML file '信用记录.fxml'.";
        assert lastPageLabel != null : "fx:id=\"lastPageLabel\" was not injected: check your FXML file '信用记录.fxml'.";
        assert pageField != null : "fx:id=\"pageField\" was not injected: check your FXML file '信用记录.fxml'.";
        assert nextPageLabel != null : "fx:id=\"nextPageLabel\" was not injected: check your FXML file '信用记录.fxml'.";
        assert ordertypeImageOfLine2 != null : "fx:id=\"ordertypeImageOfLine2\" was not injected: check your FXML file '信用记录.fxml'.";

    }
}
