package bl.promotionServiceimpl;

import constant.ScopeType;
import constant.ConditionType;
import constant.DeductionType;
import constant.ResultMessage;
import data.dao.promotiondao.PromotionDao;
import jdk.nashorn.internal.objects.annotations.Setter;
import po.PromotionPO;
import rmi.RemoteHelper;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * 策略类
 * @author aa
 *负责策略的增删改查
 */
public class Promotion {

	private static final int  hotelIDLength=10 ;
	private static PromotionDao promotionDao;
	public static ArrayList<PromotionPO> existPromotionPO = new ArrayList<PromotionPO>();

	private String setterID;
	private String promotionID;
	private String reason;

	private Date beginDate;
	private Date endDate;

	Scope scope;
	Condition condition;
	Deduction deduction;

	public Promotion (String tempSetter, String tempPromID,String tempReason){
		setterID = tempSetter;
		promotionID = tempPromID;
		reason=tempReason;
	}
	public void setDate(Date tempBeginDate, Date tempEndDate) {
		// TODO Auto-generated method stub
		beginDate=tempBeginDate;
		endDate=tempEndDate;
	}

	public void setScope(ScopeType scopeType, String scopeNum,String roomType) {
		// TODO Auto-generated method stub
		if(scopeType == ScopeType.DISTRICT){
			scope = new DistrictScope(scopeNum);
		}
		else if(scopeType == ScopeType.HOTEL){
			scope = new HotelScope(scopeNum);
		}
		else if(scopeType == ScopeType.ROOM){
			scope = new RoomScope(scopeNum,roomType);
		}
	}
	public void setCondition(ConditionType cType,int cNum) {
		// TODO Auto-generated method stub
		if(cType == ConditionType.BIRTHDAY){
			condition = new BirthdayCondition();
		}
		else if(cType == ConditionType.COMMERCE){
			condition = new MemberCondition(cNum);
		}
		else if(cType == ConditionType.ROOMNUM){
			condition = new NumCondition(cNum);
		}
		else if(cType == ConditionType.TOTAL){
			condition = new TotalCondition(cNum);
		}
	}
	public void setDeduction(DeductionType dType, int dNum) {
		// TODO Auto-generated method stub
		if(dType == DeductionType.DISCOUNT){
			deduction = new DiscountDeduction(dNum);
		}
		else if(dType == DeductionType.REDUCE){
			deduction = new ReduceDeduction(dNum);
		}
	}

	public String getReason(){
		return this.reason;
	}


	public static void initRemote(){
		if(promotionDao!=null) {
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			promotionDao = remoteHelper.getPromotionDao();
		}
	}
	/**
	 * 读取数据层中数据，若无返回null
	 * @param tempSetter
	 * @param tempPromID
	 * @return
	 */
	public static Promotion getInstance(String tempSetter, String tempPromID){
		/**
		 * what if the promotion is already exit somewhere in the bl?
		 * will jvm delete it after use
		 */
		initRemote();
		PromotionPO promotionPO = null;
		try {
			promotionPO = promotionDao.find(tempSetter,tempPromID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(promotionPO==null)
			return null;
		else
			return PromotionPO.changeIntoPromotion(promotionPO);
	}

	/**
	 * 在数据层中插入；
	 * @return
	 */
	public ResultMessage insertPromotion(){
		if(Promotion.getInstance(setterID,promotionID)==null)
			return ResultMessage.already_exist;
		PromotionPO promotionPO = this.changeIntoPO();
		try {
			promotionDao.insert(promotionPO);
		} catch (RemoteException e) {
			return ResultMessage.remote_fail;
		}
		return ResultMessage.succeed;
	}

	/**
	 * 从数据库中删除
	 * @param tempSetter
	 * @param tempPromID
	 * @return
	 */
	public static ResultMessage delPromotion(String tempSetter, String tempPromID) {
		// TODO Auto-generated method stub
		if(getInstance(tempSetter,tempPromID)==null){
			return ResultMessage.not_exist;
		}
		try {
			promotionDao.del(tempSetter,tempPromID);
		} catch (RemoteException e) {
			return ResultMessage.remote_fail;
		}
		return ResultMessage.succeed;
	}

	/**
	 * 在数据层中更新
	 * @return
	 */
	public ResultMessage update() {
		// TODO Auto-generated method stub
		if(getInstance(this.setterID,this.promotionID)==null){
			return ResultMessage.not_exist;
		}
		PromotionPO promotionPO = this.changeIntoPO();
		try {
			promotionDao.update(promotionPO);
		} catch (RemoteException e) {
			return ResultMessage.remote_fail;
		}
		return ResultMessage.succeed;
	}
	
	public PromotionPO changeIntoPO(){
		PromotionPO promotionPO = new PromotionPO(setterID,promotionID,reason,
				beginDate,endDate,
				scope.getType(),scope.getNum(),scope.getRoomType(),
				condition.getType(),condition.getNum(),
				deduction.getType(),deduction.getNum());
		return promotionPO;
	}
}
