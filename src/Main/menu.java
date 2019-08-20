/*
Example of user login in Java.
Created by Cristian Molina (Shaderkill)
*/

package Main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import Main.Users;
import Main.LoginWindow;

public class menu {
	
	static Scanner input = new Scanner(System.in);
	static Map<Users, String> users = new HashMap<>();
	
	
	public static void loginUser(String userName, String pass) {
			for ( Map.Entry<Users, String> entry : users.entrySet()) {
				Users key = entry.getKey();
				String value = entry.getValue();
				if(userName.equals(value)) {
					if(key.loginUser(pass)) {
						System.out.println("Right password.");
					} else {
						System.out.println("Wrong password.");
					}
				} else {
					System.out.println("Username not found.");
				}
				
			}			
	}
	
	public static Boolean userExist(String username) {
		if(users.containsValue(username)) {
			return true;
		} else {
		return false;
		}
	}
	
	public static Boolean registerUser(String username, String pass, String name) {
		Users user = new Users(username, name, pass);
		System.out.println(user);
		users.put(user, username);
		return true;
	}
	
	
	public static void main(String[] args) throws IOException {
		Users user = new Users("admin", "Cristian Molina", "admin");
		users.put(user,"admin");
		LoginWindow.main(null);
		
		
	}

}

