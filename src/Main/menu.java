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

public class menu {
	
	static Scanner input = new Scanner(System.in);
	static Map<Users, String> users = new HashMap<>();
	
	
	public static void login() {
		
		System.out.println("Welcome, please enter your username.");
		String userName = input.nextLine();
			for ( Map.Entry<Users, String> entry : users.entrySet()) {
				Users key = entry.getKey();
				String value = entry.getValue();
				if(userName.equals(value)) {
					System.out.println("Enter your password.");
					String pass = input.nextLine();
					if(key.loginUser(pass)) {
						System.out.println(key.mostrarNombre());
					} else {
						System.out.println("Wrong password.");
					}
				} else {
					System.out.println("Username not found.");
				}
				
			}			
	}
	
	public static void register() {
	    Boolean loop = true;
	    System.out.println("Register new user");
	    while(loop == true) {
			System.out.println("Please enter a username");
			String username = input.nextLine();
			if(!users.containsValue(username)) {
				System.out.println("Please enter a password");
				String pass = input.nextLine();
				System.out.println("Please enter your real name");
				String name = input.nextLine();	
				Users user = new Users(username, name, pass);
				System.out.println(user);
				users.put(user, username);
				loop = false;
			} else {
				System.out.println("Please enter another username");
			}
	    }
	}
	
	
	public static void main(String[] args) throws IOException {
		
		while(true) {
			System.out.println("Welcome, please choose a option");
			System.out.println("1. Register user\n2. Login user");
			int opt = Integer.parseInt(input.nextLine());
			switch(opt) {
			case 1: 
				 register();
				 break;
			case 2: 
				 login();
				 break;
			}
		}
		
	}

}

