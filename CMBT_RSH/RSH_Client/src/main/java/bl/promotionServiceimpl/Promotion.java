package bl.promotionServiceimpl;

import constant.ConditionType;
import constant.DeductionType;
import constant.ResultMessage;

import java.util.Date;

/**
 * 策略类
 * @author aa
 *
 */
public class Promotion {

	String reason;
	String Setter;
	Date beginDate;
	Date endDate;

	ScopeType scopeType;
	ConditionType conditionType;
	DeductionType deductionType;

	public Promotion (String Reason, String ID){
		reason=Reason;
		Setter = ID;
	}

	/**
	 * 读取数据层中数据，若无返回null
	 * @param Reason
	 * @param ID
	 * @return
	 */
	public static Promotion getInstance(String Reason, String ID){

		return null;
	}

	public ResultMessage setScope(constant.ScopeType stype, String id, String rtype) {
		// TODO Auto-generated method stub
		scopeType =new ScopeType();
		return null;
	}
	public ResultMessage setConditionType(ConditionType type, int requirement) {
		// TODO Auto-generated method stub
		return null;
	}
	public ResultMessage setDeductionType(DeductionType type, int num) {
		// TODO Auto-generated method stub
		return null;
	}
	public ResultMessage setDate(Date tempBeginDate, Date tempEndDate) {
		// TODO Auto-generated method stub
		beginDate=tempBeginDate;
		endDate=tempEndDate;
		return null;
	}

	/**
	 * 在数据层中插入；
	 * @return
	 */
	public ResultMessage insertPromotion(){

		return null;
	}


	/**
	 * 从数据库中删除
	 * @param tempReason
	 * @param iD
	 * @return
	 */
	public static ResultMessage delPromotion(String tempReason, String iD) {
		// TODO Auto-generated method stub

		return null;
	}

	/**
	 * 在数据层中更新
	 * @return
	 */
	public ResultMessage update() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
