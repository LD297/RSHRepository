package presentation.hotelcontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import vo.HotelVO;

public class Nothing{
    String hotelName;
    String province;
    String city;
    String businessArea;
    String streetAndNumber;
    String fullAddress;
    String tel;

    String hotelId;
    // 星级1~6
    private int level = -1;
    // 评分0~5
    private double grade = 0;

    private String facility = "0000";

    private String latestCheckInTime = "";

    public String getFullAddress(){
        return this.fullAddress;
    }

    package presentation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

    public class HotelBasicInfoUIController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private TextField hotelNameTextField;

        @FXML
        private Label checkInLabel;

        @FXML
        private TextField imageUrlTextField;

        @FXML
        private ImageView parkImage;

        @FXML
        private CheckBox canteeCheckBox;

        @FXML
        private Label briefIntroPrompt;

        @FXML
        private Label addressLabel;

        @FXML
        private ImageView wifiImage;

        @FXML
        private Button confirmButton;

        @FXML
        private CheckBox parkCheckBox;

        @FXML
        private Label hotelNameLabel;

        @FXML
        private AnchorPane anchorPane;

        @FXML
        private Label startLevelLabel;

        @FXML
        private Label IDLabel;

        @FXML
        private Button backButton;

        @FXML
        private Label urlPrompt;

        @FXML
        private TextField priceTextField;

        @FXML
        private CheckBox swimmingPoolCheckBox;

        @FXML
        private Label telLabel;

        @FXML
        private Label timePrompt;

        @FXML
        private Label gradeLabel;

        @FXML
        private Text parkText;

        @FXML
        private Label hotelNamePrompt;

        @FXML
        private ImageView hotelImage;

        @FXML
        private Text swimmingPoolText;

        @FXML
        private TextField levelTextField;

        @FXML
        private Label briefLabel;

        @FXML
        private ImageView diningroomImage;

        @FXML
        private Text canteenText;

        @FXML
        private Label pricePrompt;

        @FXML
        private TextField checkInTextField;

        @FXML
        private CheckBox wifiCheckBox;

        @FXML
        private Text wifiText;

        @FXML
        private ImageView swimpoolImage;

        @FXML
        private ImageView editImage;

        @FXML
        private Label levelPrompt;

        @FXML
        private TextArea briefIntroTextArea;

        @FXML
        void 867a7a(ActionEvent event) {

        }

        @FXML
        void editHotelName(ActionEvent event) {

        }

        @FXML
        void editLevel(ActionEvent event) {

        }

        @FXML
        void editLevel(ActionEvent event) {

        }

        @FXML
        void editCheckIn(ActionEvent event) {

        }

        @FXML
        void editBriefIntro(ActionEvent event) {

        }

        @FXML
        void editWifi(ActionEvent event) {

        }

        @FXML
        void editSwimmingPool(ActionEvent event) {

        }

        @FXML
        void editPark(ActionEvent event) {

        }

        @FXML
        void editCanteen(ActionEvent event) {

        }

        @FXML
        void editImageClicked(ActionEvent event) {

        }

        @FXML
        void confirmButtonClicked(ActionEvent event) {

        }

        @FXML
        void editImageUrl(ActionEvent event) {

        }

        @FXML
        void editPrice(ActionEvent event) {

        }

        @FXML
        void backButtonClicked(ActionEvent event) {

        }

        @FXML
        void initialize() {

        }
    }


}
