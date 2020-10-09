package edu.unca.csci201.nonexceptions;

import java.util.Scanner;

public class Login {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		UserManager um = new UserManager();
		String username;
		String password;
		
		do {
			System.out.print("Username: ");
			username = scan.nextLine();
			
			System.out.print("Password: ");
			password = scan.nextLine();
			
		} while (! um.isValid(username, password));
		
		
			
		User u = um.getUser(username);
		
		System.out.println("Login successful");
		
		// Forward to the user account page, etc.
		
	
	}

}
