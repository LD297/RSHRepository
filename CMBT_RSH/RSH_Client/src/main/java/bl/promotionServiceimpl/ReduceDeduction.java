package bl.promotionServiceimpl;

import constant.DeductionType;

/**
 * 减额优惠
 * @author aa
 *
 */
public class ReduceDeduction extends Deduction {

	int reduceNum;
	public ReduceDeduction(int dNum){
		reduceNum = dNum;
	}

	@Override
	public DeductionType getType() {
		return DeductionType.REDUCE;
	}

	@Override
	public int getNum() {
		return reduceNum;
	}

	public int getDeduction(int total){
		
		return total-reduceNum;
	}
	
}
