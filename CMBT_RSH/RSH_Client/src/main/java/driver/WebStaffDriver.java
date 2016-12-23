package driver;

import javax.xml.transform.Templates;

import bl.webstaffserviceimpl.WebStaffController;
import data.dao.webstaffdao.WebSalesmanDao;
import rmi.RemoteHelper;
import vo.WebSalesmanVO;

public class WebStaffDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebStaffDriver webStaffDriver = new WebStaffDriver();
		webStaffDriver.test1();
	}
	
	String ID = "0000000000";
	String ID2 = "0000000001";
	String password = "123";
	String district = "000000";
	WebSalesmanVO webSalesmanVO = new WebSalesmanVO(ID2, district, password, "123");
	void test1(){
		WebStaffController webStaffController = new WebStaffController();
		System.out.println("begin");
		System.out.println(webStaffController.getAllWebSalesmen().size());
		System.out.println(webStaffController.updateWebSalesman(webSalesmanVO));
		System.out.println(webStaffController.addWebSalesman(webSalesmanVO).toString());
		System.out.println(webStaffController.getIDForWebsalesman());
		System.out.println("end");
	}

	void testManager(){
		WebStaffController webStaffController = new WebStaffController();
//		webStaffController.
	}
}
