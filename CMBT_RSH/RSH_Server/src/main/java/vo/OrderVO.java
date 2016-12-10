package vo;

import constant.StateOfOrder;

import java.util.Date;

/**
 * Created by sky-PC on 2016/12/10.
 */
public class OrderVO {

    // 注：一笔订单允许一种房间类型
    private String orderID = null;
    private String userID = null;
    private String userName = null;
    private String hotelID = null;
    private StateOfOrder state = null;
    // 酒店，类型，原始价格
    private RoomNormVO room = null;
    private int roomNumber = 0;
    // 计算后的单间房间实际价格
    private double roomPrice = 0;
    private int peopleNumber = 0;
    private boolean withChild = false;

    private double originValue = 0;
    private double trueValue = 0;
    private String promotion =  null;
    private String comment = null;
    // 评分：0，1，2，3，4，5
    private int grade = 0;
    /**
     * 预计入住日期（含时间）（用户操作）
     * 预计离开日期（含时间）（用户操作）
     */
    private Date checkIn = null;
    private Date checkOut = null;
    /**
     * 订单生成日期（界面暂时不显示时间，但可以保存以备需求变更）
     */
    private Date generationDate = null;
    /**
     * 实际入住日期（含时间）（酒店操作）
     * 实际离开日期（含时间）（酒店操作）
     */
    private Date actualCheckIn = null;
    private Date actualCheckOut = null;
    /**
     *  记录撤销订单时间
     *  和撤销异常时间
     */
    private Date cancelTime = null;
    private Date cancelAbnormalTime = null;


    /**
     * 订单详情：返回所有信息
     * @param orderID
     * @param userID
     * @param userName
     * @param hotelID
     * @param state
     * @param room
     * @param roomPrice
     * @param roomNumber
     * @param peopleNumber
     * @param withChild
     * @param originValue
     * @param trueValue
     * @param promotion
     * @param comment
     * @param grade
     * @param checkIn
     * @param checkOut
     * @param generationDate
     * @param actualCheckIn
     * @param actualCheckOut
     * @param cancelTime
     * @param cancelAbnormalTime
     */
    public OrderVO(String orderID, String userID, String userName, String hotelID, StateOfOrder state,
                   RoomNormVO room, double roomPrice, int roomNumber, int peopleNumber, boolean withChild,
                   double originValue, double trueValue, String promotion,
                   String comment, int grade, Date checkIn, Date checkOut, Date generationDate,
                   Date actualCheckIn, Date actualCheckOut, Date cancelTime, Date cancelAbnormalTime){

        this.orderID = orderID;
        this.userID = userID;
        this.userName = userName;
        this.hotelID = hotelID;
        this.state = state;
        this.room = room;
        this.roomPrice = roomPrice;
        this.roomNumber = roomNumber;
        this.peopleNumber = peopleNumber;
        this.withChild = withChild;
        this.originValue = originValue;
        this.trueValue = trueValue;
        this.promotion = promotion;
        this.comment = comment;
        this.grade = grade;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.generationDate = generationDate;
        this.actualCheckIn = actualCheckIn;
        this.actualCheckOut = actualCheckOut;
        this.cancelTime = cancelTime;
        this.cancelAbnormalTime = cancelAbnormalTime;
    }
}
