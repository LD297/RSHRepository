package presentation.usercontroller;

/**
 * Created by john on 2016/12/7.
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class NoCommentUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView addCommentImage;

    @FXML
    private Button addCommentButton;

    @FXML
    void changeToAddComment(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert addCommentImage != null : "fx:id=\"addCommentImage\" was not injected: check your FXML file '暂无评价.fxml'.";
        assert addCommentButton != null : "fx:id=\"addCommentButton\" was not injected: check your FXML file '暂无评价.fxml'.";

    }
}
