package po;

import java.io.Serializable;

import constant.Role;

public class OnlinePersonPO implements Serializable{
	private static final long serialVersionUID = 1L;
	Role role;
	String id;
	String password;
	public OnlinePersonPO(Role role,String id,String password) {
		this.id = id;
		this.password = password;
		this.role = role;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
