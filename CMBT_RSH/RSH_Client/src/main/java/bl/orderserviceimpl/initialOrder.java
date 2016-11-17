package bl.orderserviceimpl;

import java.util.ArrayList;
import java.util.Date;

import bl.orderservice.HotelInfoService;
import bl.promotionServiceimpl.PromotionController;
import bl.userserviceimpl.CreditRecordList;
import bl.PromotionService;
import bl.hotelserviceimpl.HotelController;
import po.OrderPO;
import vo.CreditRecordVO;
import vo.RoomNormVO;
import constant.ResultMessage;
import constant.RoomType;

public class initialOrder {
	
	String hotelid;
	HotelController hotelinfo;
	
	PromotionService pro;
	
	public void setPromotionController(PromotionController promotioncontroller){
		pro = promotioncontroller;
	}
	CreditRecordList record;
	public void setCreditRecordList(CreditRecordList credit){
		record = credit;
	}
	
	
	public void setPro(PromotionService pro) {
		this.pro = pro;
	}


	//根据酒店得到 房间规模
	public ArrayList<RoomNormVO> getHotelRoom(String hotelid){
		hotelinfo.getCheckInDDL(hotelid);
		hotelinfo = new HotelController(hotelid);
		ArrayList<RoomNormVO> rooms = hotelinfo.getRoomNorms();
		
		return rooms;
	}
	//根据时间得到可用客房数量
	public int[] getRoomInfo(String hotelid,Date checkIn,Date checkOut){
		
		ArrayList<RoomNormVO> rooms = this.getHotelRoom(hotelid);

		int nums[] = new int[rooms.size()];//���ÿͷ�����
		double prices[] = new double[rooms.size()];
		for(int i=0;i<rooms.size();i++){
		    nums[i] = hotelinfo.numOfRoomAvail(rooms.get(i).roomType, checkIn, checkOut);//->���ݸ�ui
		}
		return nums;
	}
	//根据界面得到orderpo
	public OrderPO getOrder(String hotelid,String userid,Date checkIn,Date checkOut,int roomNum[]){
		ArrayList<RoomNormVO> rooms = this.getHotelRoom(hotelid);
		double prices[] = new double[rooms.size()];
		
		for(int i=0;i<rooms.size();i++){
		    prices[i] = hotelinfo.getRoomNorms().get(i).price;//->返回给ui
		}
		double truevalue = 0;
		for(int i=0;i<rooms.size();i++){
			truevalue = truevalue+roomNum[i]*prices[i];
		}
		
		return new OrderPO("orderid",userid,hotelid,rooms,roomNum,truevalue,0,"pro","",0,checkIn,checkOut);
			
	}
	
	
	//根据界面信息 生成orderid完善orderpo
	public void add(OrderPO order){
		if(initialOrder.check(order).equals(ResultMessage.pass)){
	        
			CreditRecordVO creditRecord = new CreditRecordVO(hotelid, null, hotelid, null, hotelid, 0); 
			record.addCreditRecord(creditRecord);
			
			ArrayList<RoomNormVO> rooms = order.norm;
			int nums[] = new int[rooms.size()];
			nums = order.numbers;
			Date checkIn = order.checkIn;
			Date checkOut = order.checkOut;
			
			if(record.canOrder()==true){
			    System.out.println("成功");
		        for(int i=0;i<rooms.size();i++)
		            hotelinfo.changeRoomAvail(rooms.get(i).roomType, nums[i],checkIn,checkOut);
		    }
			else
				System.out.println("失败");
		}
		return;
	}
	//根据orderpo得到优惠后价格
	public double getDiscounted(OrderPO order){
		String hotelid = order.hotelid;
		Date checkIn = order.checkIn;
		Date checkOut = order.checkOut;
		
		ArrayList<RoomNormVO> rooms = order.norm;
		int size = rooms.size();
		int nums[] = new int[size];
		double prices[] = new double[size];
		nums = order.numbers;
		for(int i=0;i<size;i++){
			prices[i] = rooms.get(i).price;
		}
		
		ArrayList<String> promotion = new ArrayList<String>();
		String roomdis;
		for(int i=0;i<size;i++){
		    roomdis = pro.countPromotionOfRoom(hotelid, rooms.get(i).roomType, nums[i], checkIn, checkOut);
		    if(roomdis!=null){
		    	String[] tem = roomdis.split("#");
		    	promotion.add(tem[0]);
		    	prices[i] = Integer.valueOf(tem[1]);
		    }
		}
		double sum = 0;
		for(int i=0;i<size;i++)
		    sum += prices[i]*nums[i];
		
		order.setTrueValue(sum);
		String orderdis = pro.countPromotionOfOrder(order);
		if(orderdis!=null){
			String tem[] = orderdis.split("#");
			promotion.add(tem[0]);
			order.setTrueValue(Integer.valueOf(tem[1]));
		}
			
		//PromotionService->(hotelid,userid,RoomNormVO[] norm;int[] numbers;)
		return order.truevalue;
	}
	
	public static ResultMessage check(OrderPO orderpo){
		return null;
	}
}
