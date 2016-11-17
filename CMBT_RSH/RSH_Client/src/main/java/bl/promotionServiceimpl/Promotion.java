package bl.promotionServiceimpl;

import java.util.Date;
import constant.ConditionType;
import constant.ResultMessage;
import constant.RoomType;
import constant.ScopeType;

/**
 * 策略类
 * @author aa
 *
 */
public class Promotion {

	String reason;
	String Setter;
	Scope scope;
	ConditionType cType;
	PromotionType pType;
	Date beginDate;
	Date endDate;
	public Promotion (String Reason, String ID){
		reason=Reason;
		Setter = ID;
	}
	public ResultMessage setScope(ScopeType stype, String id, RoomType rtype) {
		// TODO Auto-generated method stub
		
		return null;
	}
	public ResultMessage setConditionType(ConditionType type, int requirement) {
		// TODO Auto-generated method stub
		return null;
	}
	public ResultMessage setPromotionType(PromotionType type, int num) {
		// TODO Auto-generated method stub
		return null;
	}
	public ResultMessage setDate(Date beginDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * ���ݿ����
	 */
	public static ResultMessage delPromotion(String reason2, String iD) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * ���ݿ����
	 */
	public ResultMessage update() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
