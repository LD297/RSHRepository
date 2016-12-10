package presentation.usercontroller;

import constant.CreditAction;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import presentation.tools.ImageFactory;
import presentation.tools.MyDateFormat;
import vo.CreditRecordVO;

public class SingleCreditRecordAnchorPane extends AnchorPane{
	private Label weekLabel = null;
	private Label dateLabel = null;
	private Label orderIDLabel = null;
	/**
	 * 信用变化 ，诸如+700
	 */
	private Label creditActionLabel = null;
	private Label totalCreditLabel = null;
	private ImageView orderStateImage = null;
	private CreditRecordVO creditRecordVO = null;
	
	public SingleCreditRecordAnchorPane(CreditRecordVO creditRecordVO){
		this.creditRecordVO = creditRecordVO;
		weekLabel = new Label(MyDateFormat.getInstance().getWeek(creditRecordVO.getDate()));
		dateLabel = new Label(MyDateFormat.toString(creditRecordVO.getDate()));
		orderIDLabel = new Label(creditRecordVO.getOrderid());
		creditActionLabel = new Label(creditRecordVO.getChange());
		totalCreditLabel = new Label(String.valueOf(creditRecordVO.getCredit()));
		CreditAction creditAction = creditRecordVO.getCreditAction();
		ImageFactory imageFactory = ImageFactory.getImageFactory();
		//如果是延迟入住或恢复异常订单
		if(creditAction==CreditAction.delay_checkin||creditAction==CreditAction.cancel_abnomal){
			orderStateImage.setImage(imageFactory.getDelayCheckinImage());
		//如果是异常订单
		}else if (creditAction==CreditAction.abnormal) {
			orderStateImage.setImage(imageFactory.getAbmormalOrderImage());
		//信用充值
		}else if (creditAction==CreditAction.bymoney) {
			orderStateImage.setImage(imageFactory.getChargeForCreditImage());
		//撤销订单
		}else if (creditAction==CreditAction.cancel) {
			orderStateImage.setImage(imageFactory.getCancelAbnormalImage());
		//执行订单
		}else{
			orderStateImage.setImage(imageFactory.getOrderExecutedImage());
		}
	}

}
