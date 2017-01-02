package presentation.usercontroller;

import constant.CreditAction;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import presentation.tools.ImageFactory;
import presentation.tools.Locator;
import presentation.tools.MyDateFormat;
import vo.CreditRecordVO;
/**
 * 信用记录上一栏信用记录信息
 * @author john
 *
 */
public class SingleCreditRecordAnchorPane extends AnchorPane{
	private Label weekLabel = null;
	private Label dateLabel = null;
	private Label orderIDLabel = null;
	/**
	 * 信用变化 ，诸如+700
	 */
	private Label creditActionLabel = null;
	/**
	 * 累计结果的值
	 */
	private Label totalCreditLabel = null;
	/**
	 * 累计结果标签
	 */
	private Label totalCredit = null;
	private ImageView orderStateImage = null;
	
	public SingleCreditRecordAnchorPane(CreditRecordVO creditRecordVO){
		orderStateImage = new ImageView();
		weekLabel = new Label(MyDateFormat.getInstance().getWeek(creditRecordVO.getDate()));
		dateLabel = new Label(MyDateFormat.getInstance().toString(creditRecordVO.getDate()));
		if(creditRecordVO.getOrderid().equals("null")){
			orderIDLabel = new Label();
		}else {
			orderIDLabel = new Label(creditRecordVO.getOrderid());
		}
		creditActionLabel = new Label(creditRecordVO.getChange());
		totalCreditLabel = new Label(String.valueOf(creditRecordVO.getCredit()));
		totalCredit = new Label("累计结果");
		CreditAction creditAction = creditRecordVO.getCreditAction();
		ImageFactory imageFactory = ImageFactory.getImageFactory();
		//如果是延迟入住或恢复异常订单
		if(creditAction==CreditAction.cancel_abnomal){
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
		
		//设置组件属性
		orderStateImage.setFitHeight(20.0);
		orderStateImage.setFitWidth(20.0);
		weekLabel.setStyle("-fx-text-fill: rgba(0,0,0,0.55)");
		weekLabel.setFont(Font.font("Times New Roman", 14));
		dateLabel.setStyle("-fx-text-fill: rgba(0,0,0,0.55)");
		dateLabel.setFont(Font.font("Times New Roman", 14));
		orderIDLabel.setStyle("-fx-text-fill: rgba(0,0,0,0.55)");
		orderIDLabel.setFont(Font.font("Times New Roman", 14));
		creditActionLabel.setFont(Font.font("Times New Roman", 16));
		totalCreditLabel.setFont(Font.font("Times New Roman", 16));
		totalCredit.setFont(Font.font("Times New Roman", 16));
		
		//添加组件
		this.getChildren().add(weekLabel);
		this.getChildren().add(dateLabel);
		this.getChildren().add(creditActionLabel);
		this.getChildren().add(orderIDLabel);
		this.getChildren().add(orderStateImage);
		this.getChildren().add(totalCreditLabel);
		this.getChildren().add(totalCredit);
		
		//设置组件位置
		Locator locator = Locator.getLocator();
		locator.setLocation(weekLabel, 20.0,50.0,14.0,419.0);
		locator.setLocation(dateLabel, 46.0,20.0,14.0,432.0);
		locator.setLocation(creditActionLabel, 18.0,48.0,102.0,331.0);
		locator.setLocation(orderStateImage, 18.0,48.0,176.0,285.0);
		locator.setLocation(orderIDLabel, 41.0,15.0,102.0,191.0);
		locator.setLocation(totalCreditLabel, 18.0,48.0,418.0,0.0);
		locator.setLocation(totalCredit, 13.0,43.0,330.0,85.0);
	}

}
