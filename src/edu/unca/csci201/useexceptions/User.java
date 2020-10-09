package edu.unca.csci201.useexceptions;

public class User {

	String username;
	String password;
	boolean accountLocked;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAccountLocked() {
		return accountLocked;
	}
	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}
	
	public User(String username, String password, boolean accountLocked) {
		super();
		this.username = username;
		this.password = password;
		this.accountLocked = accountLocked;
	}
	
	
	
}
