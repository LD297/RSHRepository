package bl.webstaffserviceimpl;

import java.util.ArrayList;

import bl.webstaffservice.WebStaffService;
import constant.ResultMessage;
import vo.WebSalesmanVO;

public class WebStaffService_Stub implements WebStaffService{

	@Override
	public String getIDForWebsalesman() {
		// TODO Auto-generated method stub
		return "1534111111";
	}

	@Override
	public ResultMessage addWebSalesman(WebSalesmanVO webSalesmanVO) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	@Override
	public ArrayList<WebSalesmanVO> getAllWebSalesmen() {
		WebSalesmanVO vo1 = new WebSalesmanVO("754656473838", "江苏省", "南京市", "栖霞区","", "王小二");
		WebSalesmanVO vo2 = new WebSalesmanVO("713207738356", "江苏省", "南京市", "栖霞区", "","王小二");
		WebSalesmanVO vo3 = new WebSalesmanVO("754333333336", "江苏省", "南京市", "栖霞区","", "王小二");
		WebSalesmanVO vo4 = new WebSalesmanVO("222222222222", "江苏省", "南京市", "栖霞区", "","王小二");
		WebSalesmanVO vo5 = new WebSalesmanVO("711111111111", "江苏省", "南京市", "栖霞区",  "","王小二");
		WebSalesmanVO vo6 = new WebSalesmanVO("999999999999", "江苏省", "南京市", "栖霞区", "", "王小二");
		WebSalesmanVO vo7 = new WebSalesmanVO("666666666666", "江苏省", "南京市", "栖霞区",  "","王小二");
		WebSalesmanVO vo8 = new WebSalesmanVO("888888888888", "江苏省", "南京市", "栖霞区", "", "王小二");
		WebSalesmanVO vo9 = new WebSalesmanVO("777777777777", "江苏省", "南京市", "栖霞区", "", "王小二");
		WebSalesmanVO vo11 = new WebSalesmanVO("55555555555", "江苏省", "南京市", "栖霞区", "", "王小二");
		WebSalesmanVO vo12 = new WebSalesmanVO("44444444444", "江苏省", "南京市", "栖霞区", "", "王小二");
		WebSalesmanVO vo13 = new WebSalesmanVO("33333333333", "江苏省", "南京市", "栖霞区", "", "王小二");
		WebSalesmanVO vo14 = new WebSalesmanVO("22222222222", "江苏省", "南京市", "栖霞区", "", "王小二");
		WebSalesmanVO vo15 = new WebSalesmanVO("11111111111", "江苏省", "南京市", "栖霞区", "", "王小二");
		WebSalesmanVO vo16 = new WebSalesmanVO("70000000000", "江苏省", "南京市", "栖霞区", "", "王小二");
		WebSalesmanVO vo17 = new WebSalesmanVO("4354867965797", "江苏省", "南京市", "栖霞区", "", "王小二");
		WebSalesmanVO vo18 = new WebSalesmanVO("7546564738356", "江苏省", "南京市", "栖霞区", "","王小二");
		WebSalesmanVO vo19 = new WebSalesmanVO("190383007695", "江苏省", "南京市", "栖霞区",  "","王小二");
		ArrayList<WebSalesmanVO> webSalesmanVOs = new ArrayList<>();
		webSalesmanVOs.add(vo19);
		webSalesmanVOs.add(vo1);
		webSalesmanVOs.add(vo18);
		webSalesmanVOs.add(vo17);
		webSalesmanVOs.add(vo16);
		webSalesmanVOs.add(vo15);
		webSalesmanVOs.add(vo13);
		webSalesmanVOs.add(vo14);
		webSalesmanVOs.add(vo12);
		webSalesmanVOs.add(vo9);
		webSalesmanVOs.add(vo11);
		webSalesmanVOs.add(vo8);
		webSalesmanVOs.add(vo7);
		webSalesmanVOs.add(vo6);
		webSalesmanVOs.add(vo5);
		webSalesmanVOs.add(vo3);
		webSalesmanVOs.add(vo4);
		webSalesmanVOs.add(vo2);
		return webSalesmanVOs;
	}

	@Override
	public ResultMessage changePassword(String ID, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public ResultMessage updateWebSalesman(WebSalesmanVO webSalesmanVO) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	@Override
	public WebSalesmanVO getWebSalesman(String webSalesmanID) {
		// TODO Auto-generated method stub
		return null;
	}

}
