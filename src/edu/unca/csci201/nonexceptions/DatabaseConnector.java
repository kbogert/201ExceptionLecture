package edu.unca.csci201.nonexceptions;

import java.util.Random;

public class DatabaseConnector {

	boolean databaseConnected = false;
	
	public boolean ConnectDatabase() {
		Random rand = new Random();
		// simulate database failure
		
		if (rand.nextDouble() < 0.5)
			return false;
		
		databaseConnected = true;
		return true;
	}
	
	public User GetUser(String username) {
		
		if (!databaseConnected)
			return null;
		
		for (int i = 0; i < simulatedDatabase.length; i += 3) {
			
			if (simulatedDatabase[i].equalsIgnoreCase(username)) {
				return new User(simulatedDatabase[i],
						simulatedDatabase[i+1],
						Boolean.parseBoolean(simulatedDatabase[i+2]));
				
			}
		}
		
		return null;
	}
	
	private static String [] simulatedDatabase = {"kbogert", "pass", "F"};
}
