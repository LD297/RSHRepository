package bl.orderserviceimpl;

import java.util.ArrayList;
import java.util.Date;

import bl.hotelserviceimpl.CommentImpl;
import bl.orderservice.CommentService;
import bl.orderservice.HotelInfoService;
import bl.userserviceimpl.CreditRecordList;
import constant.*;
import po.OrderPO;
import vo.CreditRecordVO;
import vo.RoomNormVO;

public class normalOrder {
	HotelInfoService hotelinfo;
	
    OrderPO orderpo ;
	
	public void setOrder(OrderPO ord){
		orderpo = ord;
	}//方便测试
	
	CommentService com = new CommentImpl();
	
	public void setCommentImpl(CommentImpl commentimpl){
		com = commentimpl;
	}
	
	CreditRecordList credit;
	public void setCreditRecordList(CreditRecordList record){
		credit = record;
	}
	//用户撤销未执行订单
	public void cancelMyOrder(String orderid){
		//orderdataservice->find�õ�orderpo
		
		ArrayList<RoomNormVO> rooms =  orderpo.norm;
		int num[] = new int[rooms.size()];
		num = orderpo.numbers;
		Date checkIn = orderpo.checkIn;
		Date checkOut = orderpo.checkOut;
		String time = hotelinfo.getCheckInDDL(orderpo.hotelid);
		
		for(int i=0;i<rooms.size();i++)
		    hotelinfo.changeRoomAvail(rooms.get(i).roomType, num[i],checkIn,checkOut);
		
		int hour = Integer.valueOf(time.substring(0, 2));
		int minute = Integer.valueOf(time.substring(3));
		
		Date d = new Date();
		int truehour = d.getHours();
		int trueminute = d.getMinutes();
		
		if(hour-truehour<6||(hour-truehour==6&&minute<trueminute)){
			CreditRecordList record = new CreditRecordList(orderpo.userid);
	        
			CreditRecordVO creditRecord = new CreditRecordVO(time, d, time, null, time, trueminute); 
			record.addCreditRecord(creditRecord);
		}
		System.out.println("success");
		
		return ;
	}
	
	//酒店执行订单
	public ResultMessage execute(String orderid){
		//orderdataservice update
		//orderdataservice find ->orderpo
        
		CreditRecordVO creditRecord = new CreditRecordVO(orderid, null, orderid, null, orderid, 0); 
		credit.addCreditRecord(creditRecord);
		
		return ResultMessage.success;
	}
	
	
	public ResultMessage comment(String hotelid, String orderid, double grade, String comment){
		//CommentService->CommentImpl
		ResultMessage a = CommentService.addComment(hotelid, orderid, comment);
		ResultMessage b = com.updateGrade(grade);
		
		if(a.equals(b)&&a.equals(ResultMessage.succeed))
		    return ResultMessage.succeed;
		else
			return ResultMessage.failure;
	}
	
	public void setAbnormal(String orderid){
		String time = hotelinfo.getCheckInDDL(orderid.substring(10, 20));
		int hour = Integer.valueOf(time.substring(0, 2));
		int minute = Integer.valueOf(time.substring(3));
		
		Date d = new Date();
		int truehour = d.getHours();
		int trueminute = d.getMinutes();
		if(truehour>hour||(truehour==hour&&trueminute>minute)){
			System.out.println("��Ϊ�쳣");//orderdataservice->update
			CreditRecordList record = new CreditRecordList(orderpo.userid);
	        
			CreditRecordVO creditRecord = new CreditRecordVO(time, d, time, null, time, trueminute); 
			record.addCreditRecord(creditRecord);
		}
		System.out.println("success");
		return ;
	}
	
	public ResultMessage leaveUpdate(String orderid){
		return null;
	}
	
	public OrderPO[] browseUnperformed(){
		return null;
	}

}
