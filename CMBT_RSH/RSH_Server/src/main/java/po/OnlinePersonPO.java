package po;

import java.io.Serializable;

import constant.Role;

public class OnlinePersonPO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	Role role;
	String ID;
	public OnlinePersonPO(Role role,String ID) {
		this.ID = ID;
		this.role = role;
	}
	public Role getRole() {
		return role;
	}
		public String getId() {
		return ID;
	}
	
}
