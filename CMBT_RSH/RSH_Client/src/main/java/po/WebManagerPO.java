package po;

import vo.WebManagerVO;

public class WebManagerPO {

	
	String webManagerID;
	String password;

	public WebManagerPO(String webManagerID, String password){
		this.webManagerID = webManagerID;
		this.password = password;
	}
	public String getPassword(){
		return password;
	}

}
