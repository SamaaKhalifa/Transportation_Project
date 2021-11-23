package com.company;

import java.util.ArrayList;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        ArrayList<Ride> currentRides;
        ISaving saving = new arraySaving();
        IUser admin1 = new admin();
        admin1.setUserName("Admin1");
        admin1.setPassword("12345");
        saving.addAdmin(admin1);
        while (true) {
            int choice;
            Scanner in = new Scanner(System.in);
            System.out.println("1:Registration.");
            System.out.println("2:Login.");
            System.out.println("3:Exit.");
            choice = in.nextInt();
            // registration.
            if (choice == 1) {

                System.out.println("1:Register as a user!");
                System.out.println("2:Register as a Driver!");
                int registerChoice;
                Scanner reqSc = new Scanner(System.in);
                registerChoice = reqSc.nextInt();
                // User Register
                if (registerChoice == 1) {
                    IUser user = new User();
                    Scanner infoSc = new Scanner(System.in);
                    String info;
                    System.out.println("Enter the userName:");
                    info = infoSc.nextLine();// info has the userName
                    user.setUserName(info);
                    System.out.println("Enter the Email:");
                    info = infoSc.nextLine();// info has the Email
                    ((User) user).setEmail(info);
                    System.out.println("Enter the Phone no.:");
                    info = infoSc.nextLine();// info has the Phone no
                    ((User) user).setPhoneNum(info);
                    System.out.println("Enter the Password:");
                    info = infoSc.nextLine();// info has the password
                    user.setPassword(info);
                    Registration registerUser = new UserRegister();
                    registerUser.Register(user);// done the registration.
                    System.out.println("User info");
                    System.out.println(user.toString());
                }
                // Driver register.
                else if (registerChoice == 2) {
                    IUser driver = new Driver();
                    Scanner infoSc = new Scanner(System.in);
                    String info;
                    System.out.println("Enter the userName:");
                    info = infoSc.nextLine();// info has the userName
                    driver.setUserName(info);
                    System.out.println("Enter the Email:");
                    info = infoSc.nextLine();// info has the Email
                    ((Driver) driver).setEmail(info);
                    System.out.println("Enter the Phone no.:");
                    info = infoSc.nextLine();// info has the Phone no
                    ((Driver) driver).setPhoneNum(info);
                    System.out.println("Enter the Driving License:");
                    info = infoSc.nextLine();// info has the DrivingLicense
                    ((Driver) driver).setDrivingLicense(info);
                    System.out.println("Enter the National ID:");
                    info = infoSc.nextLine();// info has the NationalId
                    ((Driver) driver).setNationalId(info);
                    System.out.println("Enter the Password:");
                    info = infoSc.nextLine();// info has the password
                    driver.setPassword(info);
                    Registration registerDriver = new DriverRegister();
                    registerDriver.Register(driver);// done the registration.

                    ((admin)admin1).verify(driver);

                } else {
                    System.out.println("invalid input!");
                }
            }
            // login
            else if (choice == 2) {
                Scanner infoSc = new Scanner(System.in);
                String userName, Password;
                System.out.println("Enter the userName:");
                userName = infoSc.nextLine();
                System.out.println("Enter the password:");
                Password = infoSc.nextLine();
                IUser iuser = saving.searchIUser(userName, Password);
                System.out.println("1:Login as a user!");
                System.out.println("2:Login as a Driver!");
                int loginChoice;
                Scanner reqSc = new Scanner(System.in);
                loginChoice = reqSc.nextInt();
                if (iuser==null)
                {
                    System.out.println("You should register before log in.");
                    continue;
                }
                iuser=saving.searchIUser(userName, Password);
                // User login.
                if (loginChoice == 1) {

                    Registration userRegister = new UserRegister();
                    if (userRegister.login(iuser)==false)continue;
                    System.out.println("1:would like to Request a ride?\n" + "2:Exit");
                    int ch;
                    Scanner sc = new Scanner(System.in);
                    ch = sc.nextInt();
                    if (ch == 1) { //req ride
                        String Source, destination;
                        Scanner charSc = new Scanner(System.in);
                        System.out.println("Enter the source area name:");
                        Source = charSc.nextLine();
                        System.out.println("Enter the destination area name:");
                        destination = charSc.nextLine();
                        Ride ride = ((User) iuser).requestRide(Source, destination);
                        if (saving.retrieveRide().isEmpty()) {
                            saving.save(ride);
                            System.out.println("there is no offer for this ride, please try again later!");
                            continue;
                        }
                        for (Ride r : saving.retrieveRide()) {
                            System.out.println("ForLOOP");
                            if (ride.equals(r)) {
                                System.out.println("Found ride");
                                if (r.listOffers() != null) {
                                    System.out.println("Offer");
                                    r.listOffers();

                                } else {
                                    System.out.println("there is no offer for this ride, please try again later!");
                                }
                            } else {
                                saving.save(ride);
                            }
                        }

                    } else if (ch == 2) { //exit
                        continue;
                    }

                }
                // Driver login.
                else if (loginChoice == 2) {
                    Registration driverRegister = new DriverRegister();
                    if (driverRegister.login(iuser)==false)continue;
                } else {
                    System.out.println("invalid input!");
                }

            } else {
                System.out.println("thank you for using our amazing app!!!");
                System.exit(0);

            }

        }

    }
}
