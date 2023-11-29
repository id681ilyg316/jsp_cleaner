package com.four.Mybatis.Bean;

public class Admin {
	private Integer AdminID;
	private String UserName;
	private String password;
	private String state;
	private String realName;
	
	
	public Admin(String userName, String password) {
		super();
		UserName = userName;
		this.password = password;
	}
	
	public Admin() {
		super();
	}

	public Integer getAdminID() {
		return AdminID;
	}
	public void setAdminID(Integer adminID) {
		AdminID = adminID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Override
	public String toString() {
		return "Admin [AdminID=" + AdminID + ", UserName=" + UserName + ", password=" + password + "]";
	}
	
	
}
