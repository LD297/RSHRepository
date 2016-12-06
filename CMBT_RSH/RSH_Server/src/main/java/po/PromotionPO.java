package po;

import java.util.Date;

public class PromotionPO {

	String setter;
	String id;
	String reason;
	Date beginDate;
	Date endDate;

	String scope;//销售策略适用的范围，包括某地区、某酒店、某房间类型，若无用等长0代替
	String scopeNum;

	String  conditionType;//销售策略适用的条件，包括房间数量、价值、会员等级（企业会员）、用户生日
	int condionNum;

	String deductionType;//折扣的方式，包括打折，降价，（coupon优惠券方式暂缓）
	int deductionNum;
}
