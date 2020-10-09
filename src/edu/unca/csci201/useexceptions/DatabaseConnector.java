package edu.unca.csci201.useexceptions;

import java.util.Random;

import edu.unca.csci201.useexceptions.exceptions.DatabaseDownException;
import edu.unca.csci201.useexceptions.exceptions.LoginSystemBaseException;
import edu.unca.csci201.useexceptions.exceptions.UsernameNotFoundException;

public class DatabaseConnector {

	boolean databaseConnected = false;
	
	public void ConnectDatabase() throws DatabaseDownException{
		Random rand = new Random();
		// simulate database failure
		
		if (rand.nextDouble() < 0.5)
			throw new DatabaseDownException();
		
		databaseConnected = true;
	}
	
	public User GetUser(String username) throws LoginSystemBaseException {
		
		if (!databaseConnected)
			throw new DatabaseDownException();
		
		for (int i = 0; i < simulatedDatabase.length; i += 3) {
			
			if (simulatedDatabase[i].equalsIgnoreCase(username)) {
				return new User(simulatedDatabase[i],
						simulatedDatabase[i+1],
						Boolean.parseBoolean(simulatedDatabase[i+2]));
				
			}
		}
		
		throw new UsernameNotFoundException();
	}
	
	private static String [] simulatedDatabase = {"kbogert", "pass", "true"};
}
