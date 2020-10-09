package edu.unca.csci201.useexceptions;

import java.util.Scanner;

import edu.unca.csci201.useexceptions.exceptions.AccountLockedException;
import edu.unca.csci201.useexceptions.exceptions.LoginSystemBaseException;
import edu.unca.csci201.useexceptions.exceptions.PasswordInvalidException;
import edu.unca.csci201.useexceptions.exceptions.UsernameNotFoundException;

public class Login {

	public static void main(String[] args) throws LoginSystemBaseException {

		Scanner scan = new Scanner(System.in);
		
		UserManager um = new UserManager();
		String username;
		String password;
		User u;
		
		do {
			try {
				System.out.print("Username: ");
				username = scan.nextLine();
				
				System.out.print("Password: ");
				password = scan.nextLine();
					
				u = um.getUser(username, password);
				
				break;
			} catch (UsernameNotFoundException e) {
				System.out.println("Username not found, please try again");
			} catch (PasswordInvalidException e) {
				System.out.println("Password invalid, please try again");
			} catch (AccountLockedException e) {
				System.out.println("Your account has been locked");
				return;
			}
			
		} while (true);
		
		System.out.println("Login successful");
		
		// Forward to the user account page, etc.
		
	
	}

}
