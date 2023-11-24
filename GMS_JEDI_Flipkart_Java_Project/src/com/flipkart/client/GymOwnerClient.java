package com.flipkart.client;

import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.GymOwnerBusiness;
import com.flipkart.business.UserBusiness;
import com.flipkart.constants.ColorConstants;

public class GymOwnerClient {

    GymOwner gymOwner = new GymOwner();
    GymOwnerBusiness gymOwnerBusiness = new GymOwnerBusiness();

    public void gymOwnerRegistration(Scanner in) {
        System.out.println("Enter GymOwner Details: ");
        System.out.print("Enter Name: ");
        gymOwner.setName(in.next());
        System.out.print("Enter Phone Number: ");
        gymOwner.setPhoneNumber(in.next());
        System.out.print("Enter PAN: ");
        gymOwner.setPanNumber(in.next());
        System.out.print("Enter Aadhaar: ");
        gymOwner.setAadharNumber(in.next());
        System.out.print("Enter Email: ");
        gymOwner.setEmail(in.next());
        System.out.print("Enter Password: ");
        gymOwner.setPassword(in.next());
        gymOwner.setRoleId("GymOwner");

        UserBusiness userBusiness = new UserBusiness();
        userBusiness.registerGymOwner(gymOwner);

        System.out.println("\n" + ColorConstants.CYAN + "Customer registered successfully!" + ColorConstants.RESET);
    }

    public void editProfile(Scanner in, String email) {
        System.out.println("Enter Details: ");
        System.out.print("Enter Name: ");
        gymOwner.setName(in.next());
        System.out.print("Enter Phone Number: ");
        gymOwner.setPhoneNumber(in.next());
        System.out.print("Enter PAN: ");
        gymOwner.setPanNumber(in.next());
        System.out.print("Enter Aadhaar: ");
        gymOwner.setAadharNumber(in.next());

        gymOwnerBusiness.editProfile(gymOwner, email);
    }

    public void viewProfile(Scanner in, String email) {
        gymOwner = gymOwnerBusiness.getProfile(email);
        System.out.println("______________________________________________________________");
        System.out.printf("%15s%15s%15s%15s", "Gym Owner Name", "Phone Number", "PAN Number", "Aadhaar Number");
        System.out.println();
        System.out.printf("%15s%15s%15s%15s", gymOwner.getName(), gymOwner.getPhoneNumber(),
                gymOwner.getPanNumber(), gymOwner.getAadharNumber());
        System.out.println("______________________________________________________________");

    }

    public void addGym(Scanner in, String email) {
        System.out.println("Enter Gym Details: ");

        Gym gym = new Gym();
        System.out.print("Enter GymName: ");
        gym.setGymName(in.next());
        gym.setOwnerEmail(email);
        System.out.print("Enter Address: ");
        gym.setAddress(in.next());
        System.out.print("Enter SlotCount: ");
        gym.setSlotCount(in.nextInt());
        System.out.print("Enter seatsPerSlotCount: ");
        gym.setSeatsPerSlotCount(in.nextInt());
        gym.setVerified(false);

        gymOwnerBusiness.addGym(gym);

    }

    public void editGym(Scanner in, String email) {
        System.out.println("Enter Gym Details: ");

        Gym gym = new Gym();
        System.out.print("Enter GymId: ");
        gym.setGymId(in.next());
        System.out.print("Enter GymName: ");
        gym.setGymName(in.next());
        gym.setOwnerEmail(email);
        System.out.print("Enter Address: ");
        gym.setAddress(in.next());
        System.out.print("Enter SlotCount: ");
        gym.setSlotCount(in.nextInt());
        System.out.print("Enter seatsPerSlotCount: ");
        gym.setSeatsPerSlotCount(in.nextInt());
        gym.setVerified(false);

        gymOwnerBusiness.editGym(gym);
    }

    public void getGymDetails(Scanner in, String email) {
        List<Gym> gymDetails = gymOwnerBusiness.getGymDetail(email);
        for (Gym gym : gymDetails) {
            System.out.println(gym);
        }
    }

    public void gymOwnerMenu(Scanner in, String email) {
        boolean recur = true;
        while (recur) {

            System.out.println("\nHere are the actions you can perform!");

            System.out.println("1. View Profile");
            System.out.println("2. Edit Profile");
            System.out.println("3. Add Gym");
            System.out.println("4. Edit Gym");
            System.out.println("5. View All Gym Details");
            System.out.println("6. Exit\n");

            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    viewProfile(in, email);
                    break;
                case 2:
                    editProfile(in, email);
                    break;
                case 3:
                    addGym(in, email);
                    break;
                case 4:
                    editGym(in, email);
                    break;
                case 5:
                    getGymDetails(in, email);
                    break;

                case 6:
                    recur = false;
                    break;
            }
        }

    }

}
