package com.flipkart.client;

import java.util.*;
import com.flipkart.bean.User;
import com.flipkart.DAO.*;

public class ApplicationClient {
	public static void login() throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Email: ");
        String username = in.next();
        System.out.println("Enter password: ");
        String password = in.next();
        System.out.println("Enter role Id: ");
        String roleId = in.next();
        User user = new User(username, password, roleId);
        UserDAO authicated = new UserDAO();
        if(authicated.isAuthenticated(user))
        {
            System.out.println("Welcome " + username + "! You are logged in.");
            
            if(roleId.equals("Customer")) {
          
                CustomerClient customer = new CustomerClient();
                customer.customerMenu(username);
                
            }
            else if(roleId.equals("GymOwner")) {
            
                GymOwnerClient gymOwner = new GymOwnerClient();
                gymOwner.gymOwnerMenu(in);
                
            }
            else if(roleId.equals("Admin")) {
                AdminClient admin = new AdminClient();
                admin.adminMenu(in);
 
           
            }
        }
        else
        {
        	System.out.println("Sorry! You are not Registered!");
        	applicationMenu();
        }
    }

	public static void applicationMenu() throws Exception {
		System.out.println("Welcome to FlipFit");
		System.out.println("Choose your action:");
		System.out.println("1. Login");
		System.out.println("2. Customer Registration");
		System.out.println("3. Gym Owner Registration");
		System.out.println("4. exit");

		Scanner in = new Scanner(System.in);

		int choice = in.nextInt();
		switch (choice) {
		case 1:
			login();
			
			break;
		case 2:
			CustomerClient customer = new CustomerClient();
			customer.registerCustomer();
			break;
		case 3:
			GymOwnerClient owner = new GymOwnerClient();
			owner.gymOwnerRegistration(in);
			break;
		case 4:
			System.out.println("Exiting.....");
			System.exit(0);
			break;
		default:
			System.out.println("Wrong choice");
			applicationMenu();
		}

	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		applicationMenu();
	}

}
