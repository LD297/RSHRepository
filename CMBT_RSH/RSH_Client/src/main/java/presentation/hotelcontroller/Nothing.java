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

}
