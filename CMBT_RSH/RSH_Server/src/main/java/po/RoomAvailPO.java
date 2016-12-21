package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sky-PC on 2016/12/16.
 */
public class RoomAvailPO extends RoomPO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 对该类型房间信息查询的时间段
     * (只包含起止日期，起于fromTo[0]的12:00，止于fromTo[1]的11：59)
     */
    public Date beginDate;
    public Date endDate;
    /**
     * 该时间段内的可用房间数量（算法处理后的结果）
     */
    private int amountAvail;
    
    public RoomAvailPO(String id, String roomType,String address, int amountTotal, double price,
                       boolean basicOrSpecial) {
        super(id, roomType, address,amountTotal, price, basicOrSpecial);
    }


    public int getAmountAvail() {
        return amountAvail;
    }
    public void setAmountAvail(int amountAvail) {
        this.amountAvail = amountAvail;
    }

}
