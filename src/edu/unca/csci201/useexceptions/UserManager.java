package edu.unca.csci201.useexceptions;

import edu.unca.csci201.useexceptions.exceptions.AccountLockedException;
import edu.unca.csci201.useexceptions.exceptions.DatabaseDownException;
import edu.unca.csci201.useexceptions.exceptions.LoginSystemBaseException;
import edu.unca.csci201.useexceptions.exceptions.PasswordInvalidException;

public class UserManager {

	DatabaseConnector db;
	
	public UserManager () throws DatabaseDownException{
		
		db = new DatabaseConnector();
		
		db.ConnectDatabase();
		
	}
	
	public void isValid(User u, String password) throws LoginSystemBaseException {
	
		if (! u.getPassword().equals(password)) {
			throw new PasswordInvalidException();
		}
		
		if (u.isAccountLocked()) {
			throw new AccountLockedException();
		}
		
	}
	
	public User getUser(String username, String password) throws LoginSystemBaseException {
		
		User u = db.GetUser(username);
		isValid(u, password);
		return u;

	}
}
