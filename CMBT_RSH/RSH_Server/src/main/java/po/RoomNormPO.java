package po;

import java.io.Serializable;

/**
 * Created by sky-PC on 2016/12/16.
 */
public class RoomNormPO implements Serializable {
    private String hotelID;
    private String roomType;
    private double price;

    public RoomNormPO(String hotelID,String roomType, Double price) {
        this.hotelID = hotelID;
        this.roomType = roomType;
        this.price = price;
    }
    public String getHotelID(){
        return hotelID;
    }
    public String getRoomType(){
        return roomType;
    }
    public double getPrice(){
        return price;
    }
}
