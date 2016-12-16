package po;

//import bl.webstaffserviceimpl;

import java.io.Serializable;

public class WebManagerPO implements Serializable {

	String id;
	String password;
	public WebManagerPO(String id, String password){
		this.id = id;
		this.password = password;
	}
	public String getID(){
		return this.id;
	}
	public String getPassword(){
		return this.password;
	}
}
