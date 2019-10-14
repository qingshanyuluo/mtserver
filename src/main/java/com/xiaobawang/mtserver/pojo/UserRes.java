package com.xiaobawang.mtserver.pojo;

public class UserRes {
	private int errorcode;
	private String status;
	private User user;


	public int getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User u) {
		this.user = u;
	}
	@Override
	public String toString() {
		return "UserRes [errorcode=" + errorcode + ", status=" + status + ", user=" + user + "]";
	}
	
	
}
