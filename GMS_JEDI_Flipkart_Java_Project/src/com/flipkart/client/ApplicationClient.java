package com.flipkart.client;

import java.util.*;
import com.flipkart.bean.User;
import com.flipkart.DAO.UserDAO;

public class ApplicationClient {
	public static void login() throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Email: ");
        String username = in.next();
        System.out.println("Enter password: ");
        String password = in.next();
        User user = new User(username,password,0);
        UserDAO authicated = new UserDAO();
        if(authicated.authenticateUser(user)!=null)
        {
            System.out.println("Welcome " + username + "! You are logged in.");
            int role = user.getRoleId();
            switch(role)
            {
            case 1: 
                CustomerClient customer = new CustomerClient();
                customer.customerMenu(username);
                break;
            case 2:
                GymOwnerClient gymOwner = new GymOwnerClient();
                gymOwner.gymOwnerMenu(in);
                break;
            case3:
                AdminClient admin = new AdminClient();
                admin.viewAllGyms();
                break;
            
            }
        }
        else
        {
            login();
        }
    }

	public static void applicationMenu() throws Exception {
		System.out.println("Welcome to FlipFit");
		System.out.println("Choose your action:");
		System.out.println("1. Login");
		System.out.println("2. User Registration");
		System.out.println("3. Gym Owner Registration");
		System.out.println("4. exit");

		Scanner in = new Scanner(System.in);

		int choice = in.nextInt();
		switch (choice) {
		case 1:
			login();
			break;
		case 2:
			CustomerClient Customer = new CustomerClient();
			Customer.registerCustomer();
			break;
		case 3:
			GymOwnerClient Owner = new GymOwnerClient();
			Owner.gymOwnerRegistration(in);
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
