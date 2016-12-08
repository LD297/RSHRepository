package presentation.tools;

/**
 * Created by john on 2016/12/8.
 */
public class UserInfoUtil {
    private static UserInfoUtil userInfoUtil = null;
    private UserInfoUtil(){}
    public UserInfoUtil getInstance(){
        if(userInfoUtil==null){
            userInfoUtil = new UserInfoUtil();
        }
        return userInfoUtil;
    }
    private String userID;
    private String hotelName;
    private String hotelAddress;
    private String hotelArea;
    private String orderID;


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelArea() {
        return hotelArea;
    }

    public void setHotelArea(String hotelArea) {
        this.hotelArea = hotelArea;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }



}
