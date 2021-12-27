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
        System.out.println("Admin section");
        IUser user1=new User("Nada","123","011","Nada@",null);
        IUser user2=new User("Yomna","345","010","Yomna@",null);
        IUser driver1=new Driver("Noura","456","000","5555","012","Noura@");
        IUser driver2=new Driver("Samaa","789","111","6666","015","Samaa@");
        Registration reg=new UserRegister();
        reg.Register(user1);
        reg.Register(user2);
        reg=new DriverRegister();
        reg.Register(driver1);
        reg.Register(driver2);
        System.out.println("users");
        System.out.println(saving.retrieveUsers());
        System.out.println("list pending users");
        System.out.println(((admin)admin1).listPendingRegistration());
        System.out.println("After verifying");
        ((admin)admin1).verify(driver1);
        ((admin)admin1).verify(driver2);
        System.out.println(saving.retrieveUsers());
        System.out.println("After suspending user");
        ((admin)admin1).suspend( user2);
        ((admin)admin1).suspend(driver1);
        System.out.println(saving.retrieveUsers());


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

                    ((admin) admin1).verify(driver);

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
                if (iuser == null) {
                    System.out.println("You should register before log in.");
                    continue;
                }
                iuser = saving.searchIUser(userName, Password);
                // User login.
                if (loginChoice == 1) {

                    Registration userRegister = new UserRegister();

                    if (userRegister.login(iuser) == false) continue;
                    while (true){

                        System.out.println("1:would like to Request a ride?\n" + "2:Exit");
                        int ch;
                        Scanner sc = new Scanner(System.in);
                        ch = sc.nextInt();


                        if (ch == 1) { //req ride
                            String source, destination;

                            Scanner charSc = new Scanner(System.in);
                            System.out.println("Enter the source area name:");
                            source = charSc.nextLine();
                            System.out.println("Enter the destination area name:");
                            destination = charSc.nextLine();
                            IArea Source = saving.searchArea(source);
                            IArea Destination = saving.searchArea(destination);
                            if (Source == null) {
                                IArea Sour = new Area();
                                Sour.setName(source);
                                Source = Sour;
                                saving.save((Area) Sour);
                            }
                            if (Destination == null) {
                                IArea Dest = new Area();
                                Dest.setName(destination);
                                Destination = Dest;
                                saving.save((Area) Dest);
                            }
                            Ride ride = ((User) iuser).requestRide(Source, Destination);
                            saving.save(ride);
                            if (saving.retrieveRide().isEmpty()) {
                                System.out.println("there is no offer for this ride, please try again later!");
                                System.out.println("2bl continue " + saving.retrieveRide());
                                continue;
                            }

                            for (Ride r : saving.retrieveRide()) {

                                if (ride.getSource().equals(r.getSource())&&ride.getDestenation().equals(r.getDestenation())) { //la2etha
                                    if (!r.getOffers().isEmpty()) { // feh offer
                                        System.out.println("Offer");
                                        Offer offer = ((User)iuser).chooseOffer(r);
                                        System.out.println("Please rate the driver of the Ride from 1 to 5:");
                                        Scanner sin = new Scanner(System.in);
                                        int rate = sin.nextInt();
                                        offer.getDriver().rateMe(rate);
                                        // System.out.println(offer.getDriver().toString());

                                    } else { //mfesh offer

                                        System.out.println("there is no offer for this ride, please try again later!");
                                    }
                                    break;

                                }

                            }



                        } else if (ch == 2) { //exit
                            break;

                        }

                    }}
                // Driver login.
                else if (loginChoice == 2) {
                    Registration driverRegister = new DriverRegister();
                    if (driverRegister.login(iuser) == false) continue;
                    while (true){
                        System.out.println("1:Add Area\n2:List all rides\n3:list user rating\n4:Exit");
                        Scanner sc = new Scanner(System.in);
                        int driverCh = sc.nextInt();
                        if (driverCh == 1) {// add area
                            System.out.println("Enter the name of the area you want to add:");
                            Scanner scar = new Scanner(System.in);
                            String area = scar.nextLine();
                            IArea ar = saving.searchArea(area);
                            if (ar == null) {
                                IArea area1 = new Area();
                                area1.setName(area);
                                saving.save((Area) area1);
                                ar = area1;
                            }
                            ((Driver) iuser).AddNewFavArea((Area) ar);
                            ((Driver) iuser).getFavAreas();


                        } else if (driverCh == 2) {// list all rides
                            ((Driver) iuser).listRides();
                            System.out.println("Enter the no. of Ride you want to add an offer to it:");
                            Scanner sin = new Scanner(System.in);
                            int rideNo = sin.nextInt();
                            IRide ride = ((Driver) iuser).getRides().get(rideNo - 1);
                            ((Driver) iuser).makeOffer((Ride) ride);

                        } else if (driverCh == 3) {// list rating


                            for(int rate:((Driver) iuser).getRate().getRates()){
                                System.out.println(rate);
                            }
                        }else{
                            break;
                        }

                    }} else {
                    System.out.println("invalid input!");
                }

            } else {
                System.out.println("thank you for using our amazing app!!!");
                System.exit(0);
            }
        }
    }
}