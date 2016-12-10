package presentation.usercontroller;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class CommentUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane gridPaneFilledWithComment;

    @FXML
    private TextField pageField;

    @FXML
    private Label lastPageLabel;

    @FXML
    private Label nextPageLabel;

    @FXML
    void changeToLastPage(MouseEvent event) {

    }

    @FXML
    void changeToNextPage(MouseEvent event) {

    }

    @FXML
    void changeToReferedPage(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert gridPaneFilledWithComment != null : "fx:id=\"gridPaneFilledWithComment\" was not injected: check your FXML file '查看评价.fxml'.";
        assert pageField != null : "fx:id=\"pageField\" was not injected: check your FXML file '查看评价.fxml'.";
        assert lastPageLabel != null : "fx:id=\"lastPageLabel\" was not injected: check your FXML file '查看评价.fxml'.";
        assert nextPageLabel != null : "fx:id=\"nextPageLabel\" was not injected: check your FXML file '查看评价.fxml'.";

    }
}
