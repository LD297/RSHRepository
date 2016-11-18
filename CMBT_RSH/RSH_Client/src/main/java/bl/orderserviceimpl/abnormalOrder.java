package bl.orderserviceimpl;

import java.util.Date;
import java.util.ArrayList;

import bl.orderservice.HotelInfoService;
import bl.userserviceimpl.CreditRecordList;
import constant.*;
import po.OrderPO;
import vo.RoomNormVO;
import vo.CreditRecordVO;

public class abnormalOrder {
	
	HotelInfoService hotelinfo;
	
	OrderPO orderpo ;
	public void setOrder(OrderPO ord){
		this.orderpo = ord;
	}//方便测试
	
	CreditRecordList record;
	public void setCreditRecordList(CreditRecordList re){
		this.record = re;
	}
	
	//酒店撤销异常订单 手动补登记

	public ResultMessage hotelCancelAbnormal(String orderid){//cause:延迟入住ס
		//orderdataservice update
		return null;
	}
	
	public OrderPO[] browseAbnormal(){
		return null;
	}
	
	public void handleAbnormalRoom(){
	    
		
		OrderPO[] abList = this.browseAbnormal();
		for(int i=0;i<abList.length;i++){
			
            ArrayList<RoomNormVO> rooms = abList[i].norm;
           	int size = rooms.size();
           	int nums[] = new int[size];
           	nums = abList[i].numbers;
           	Date checkIn = abList[i].checkIn;
           	Date checkOut = abList[i].checkOut;
            	
           	for(int j=0;j<size;j++)//rooms.size
           	    hotelinfo.changeRoomAvail(rooms.get(j).roomType,nums[j] , checkIn, checkOut);
        }
		
	}
	
	public ResultMessage webCancelAbnormal(String orderid){//cause:申诉->change credit
        
		 //orderdataservice->find�õ�orderpo
/*		ArrayList<RoomNormVO> rooms =  orderpo.norm;
		int num[] = new int[rooms.size()];
		num = orderpo.numbers;
		Date checkIn = orderpo.checkIn;
		Date checkOut = orderpo.checkOut;
		
		for(int i=0;i<rooms.size();i++)
		    hotelinfo.changeRoomAvail(rooms.get(i).type, num[i],checkIn,checkOut);
	*/	
		CreditRecordVO creditRecord = new CreditRecordVO(orderid, null, orderid, null, orderid, 0); 
		
		record.addCreditRecord(creditRecord);
		
		return ResultMessage.success; 
	}

}
