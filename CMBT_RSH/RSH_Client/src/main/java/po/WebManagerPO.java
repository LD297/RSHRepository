package po;

import java.io.Serializable;

public class WebManagerPO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
