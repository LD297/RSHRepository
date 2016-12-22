package po;

//import bl.webstaffserviceimpl;

import java.io.Serializable;

public class WebManagerPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String webManagerID;
	String password;
	public WebManagerPO(String id, String password){
		this.webManagerID = id;
		this.password = password;
	}
	public String getID(){
		return this.webManagerID;
	}
	public String getPassword(){
		return this.password;
	}
}
