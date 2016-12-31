package bl.promotionServiceimpl.deduction;

import constant.DeductionType;

/**
 * 减额优惠
 * @author aa
 *
 */
public class ReduceDeduction extends Deduction {

	double reduceNum;
	public ReduceDeduction(double reduceNum){
		this.reduceNum = reduceNum;
	}

	@Override
	public DeductionType getType() {
		return DeductionType.REDUCE;
	}

	@Override
	public double getNum() {
		return reduceNum;
	}

	public double getDeduction(double total){
		if(total<reduceNum)
			return 0;
		else{
			return total-reduceNum;
		}
	}
	
}
