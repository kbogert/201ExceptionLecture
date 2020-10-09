package edu.unca.csci201.nonexceptions;

public class UserManager {

	DatabaseConnector db;
	
	public UserManager () {
		db = new DatabaseConnector();
		
		if (! db.ConnectDatabase()) {
			System.out.println("Error, could not connect to database");
		}
		
	}
	
	public boolean isValid(String username, String password) {
	
		User search = db.GetUser(username);
		
		if (search == null) {
			System.out.println("ERROR, username not found");
			return false;
		}
		
		if (! search.getPassword().equals(password)) {
			System.out.println("Password is invalid");
			return false;
		}
		
		if (search.isAccountLocked()) {
			System.out.println("ERROR, account is locked");
			return false;
		}
		
		return true;
	}
	
	public User getUser(String username) {
		
		return db.GetUser(username);
		
	}
}
