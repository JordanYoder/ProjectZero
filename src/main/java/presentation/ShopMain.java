package presentation;

import pojo.PhonePojo;
import pojo.UserPojo;
import service.PhoneService;
import service.PhoneServiceImpl;
import service.UserService;
import service.UserServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ShopMain {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        UserService userService = new UserServiceImpl();
        int accountOption = 0;

        while (accountOption == 0) {
            System.out.println("Would you like to sign in or create a new account?");
            System.out.println("*****************************************************************************************");
            System.out.println("* 1) Login");
            System.out.println("* 2) Create new account");
            System.out.println("*****************************************************************************************");

            // Make sure we get an integer value
            if(userInput.hasNextInt() ) {
                accountOption = userInput.nextInt();
            } else {
                System.out.println("Please enter 1 or 2");
            }

            // Log in
            switch (accountOption) {
                case 1:
                    accountOption = 1;
                    UserPojo userLoginAttempt = new UserPojo();
                    UserPojo loggedInUser = new UserPojo();
                    String email;
                    String password;

                    System.out.println("*****************************************************************************************");
                    System.out.print("* Email: ");
                    email = userInput.next();

                    System.out.print("* Password: ");
                    password = userInput.next();

                    System.out.println("*****************************************************************************************");

                    // Capture credentials into user object
                    userLoginAttempt.setUserEmail(email);
                    userLoginAttempt.setUserPassword(password);

                    // Take retrieved user information and store into a login
                    loggedInUser = userService.getUser(userLoginAttempt);

                    // Determine what menu's user gets by logging.
                    String accountType = loggedInUser.getAccountType();

                    switch (accountType) {
                        case "customer":
                            customerMenu(loggedInUser);
                            break;
                        case "employee":
                            employeeMenu();
                            break;
                        case "manager":
                            managerMenu();
                            break;
                        default:
                            System.out.println("Invalid account type. Please attempt to re-login");
                            break;
                    }
                break;

                // Create a new account
                case 2: accountOption = 2;
                    UserPojo userPojo = new UserPojo();
                    System.out.print("Email: ");
                    userPojo.setUserEmail(userInput.next());
                    userInput.nextLine();

                    System.out.print("Password: ");
                    userPojo.setUserPassword(userInput.next());
                    userInput.nextLine();

                    System.out.print("First Name: ");
                    userPojo.setUserFirstName(userInput.next());
                    userInput.nextLine();

                    System.out.print("Last Name: ");
                    userPojo.setUserLastName(userInput.next());
                    userInput.nextLine();

                    System.out.print("Address: ");
                    userPojo.setUserAddress(userInput.next());
                    userInput.nextLine();

                    System.out.print("City: ");
                    userPojo.setUserCity(userInput.next());
                    userInput.nextLine();

                    System.out.print("State: ");
                    userPojo.setUserState(userInput.next());
                    userInput.nextLine();

                    System.out.print("Zip: ");
                    userPojo.setUserZip(userInput.next());
                    userInput.nextLine();

                    UserPojo successfullyAdd = userService.addCustomer(userPojo);
                    System.out.println("Successfully added " + successfullyAdd.getUserEmail());
                    break;

                // Catch integers outside desired range
                default:
                    System.out.println("Please select 1) for login or 2) to create a new account");
                    System.out.println();
                    userInput.nextLine();
                    accountOption = 0;
                    break;
            }
        }
        userInput.close();
    }

    // Customer user interface menu
    public static void customerMenu(UserPojo loggedInUser) {
        Scanner userInput = new Scanner(System.in);
        int menuChoice = 0;
        boolean logout = false;

        while (!logout) {
            System.out.println("*** Welcome @customer ***************************************************");
            System.out.println("*** Please selection from the following options: ");
            System.out.println("*** 1) View available items");
            System.out.println("*** 2) View purchase history ");
            System.out.println("*** 3) Logout");

            if(userInput.hasNextInt() ) {
                menuChoice = userInput.nextInt();
            } else {
                System.out.println("Please enter 1, 2, or 3");
            }

            // View all items
            switch (menuChoice) {
                case 1: menuChoice = 1;
                    PhoneService phoneService = new PhoneServiceImpl();
                    List<PhonePojo> phoneList = new ArrayList<PhonePojo>();
                    phoneList = phoneService.getAllPhones();
                    Iterator<PhonePojo> itr = phoneList.iterator();
                    int i = 1;

                    System.out.println("Current available phones:");

                    while(itr.hasNext()) {
                        System.out.println("*************************************************************************");
                        System.out.println(i + "). " + itr.next().toString());
                        System.out.println("*************************************************************************");
                        i++;
                    }

                    // Does the user want to make an offer on any of these items
                    System.out.println("Enter a number to make an offer on item or 0 to go back");

                    // Make an offer on an item or go back to previous menu
                    if(userInput.hasNextInt()) {
                        menuChoice = userInput.nextInt();
                        BigDecimal bid;
                        if(menuChoice < i && i > 0) {
                            System.out.println("What would you like to bid for current item: ");
                            bid = userInput.nextBigDecimal();

                        } else {
                            System.out.println("Please enter a valid item or enter 0");
                        }
                    } else {
                        System.out.println("Please enter a valid item or enter 0");
                    }

                    break;
                case 2: menuChoice = 2;
                    System.out.println("Viewing purchase history...");
                    break;
                case 3: menuChoice = 3;
                    System.out.println("Logging out...");
                    logout = true;
                    break;
                default:
                    System.out.println("Please enter 1, 2, or 3");
                    break;
            }
        }
        userInput.close();
    }

    // Employee user interface menu
    public static void employeeMenu() {
        Scanner userInput = new Scanner(System.in);
        int menuChoice = 0;
        boolean logout = false;

        while (!logout) {
            System.out.println("*** Welcome @employee ***************************************************");
            System.out.println("*** Please selection from the following options: ");
            System.out.println("*** 1) View available items");
            System.out.println("*** 2) View Offers ");
            System.out.println("*** 3) Add new phone");
            System.out.println("*** 4) Logout");

            if(userInput.hasNextInt() ) {
                menuChoice = userInput.nextInt();
            } else {
                System.out.println("Please enter 1, 2, 3, or 4");
            }

            switch (menuChoice) {
                case 1: menuChoice = 1;
                    System.out.println("Viewing available items...");
                    break;
                case 2: menuChoice = 2;
                    System.out.println("Viewing offers...");
                    break;
                case 3: menuChoice = 3;
                    PhonePojo newPhone = new PhonePojo();
                    PhoneService phoneService = new PhoneServiceImpl();
                    boolean successfullyAdded;

                    System.out.println("Please enter new phone information below:");
                    System.out.print("Phone Brand: ");
                    newPhone.setPhoneBrand(userInput.next());
                    userInput.nextLine();

                    System.out.print("Phone Model: ");
                    newPhone.setPhoneModel(userInput.next());
                    userInput.nextLine();


                    System.out.print("Phone Notes: ");
                    newPhone.setPhoneNotes(userInput.next());
                    userInput.nextLine();

                    System.out.print("Phone MSRP: ");
                    if (userInput.hasNextBigDecimal()) {
                        newPhone.setPhoneMsrp(userInput.nextBigDecimal());
                    } else {
                        userInput.nextLine();
                        System.out.println("Please enter a valid amount.");
                    }

                    successfullyAdded = phoneService.addPhone(newPhone);

                    if(successfullyAdded == true) {
                        System.out.println("New phone successfully added");
                    } else {
                        System.out.println("Phone not added. Please press enter to continue");
                        userInput.next();
                    }
                    break;

                case 4: menuChoice = 4;
                    logout = true;
                    break;

                default:
                    System.out.println("Please enter 1, 2, or 3");
                    break;
            }
        }
        userInput.close();
    }

    // Manager user interface menu
    public static void managerMenu() {
        Scanner userInput = new Scanner(System.in);
        int menuChoice = 0;
        boolean logout = false;

        while (!logout) {
            System.out.println("*** Welcome @manager ***************************************************");
            System.out.println("*** Please selection from the following options: ");
            System.out.println("*** 1) View available items");
            System.out.println("*** 2) View Offers ");
            System.out.println("*** 3) All sales history");
            System.out.println("*** 4) Fire employee");
            System.out.println("*** 5) Logout");

            if(userInput.hasNextInt() ) {
                menuChoice = userInput.nextInt();
            } else {
                System.out.println("Please enter 1, 2, 3, 4, 5");
            }

            switch (menuChoice) {
                case 1: menuChoice = 1;
                    System.out.println("Viewing available items...");
                    break;
                case 2: menuChoice = 2;
                    System.out.println("Viewing offers...");
                    break;
                case 3: menuChoice = 3;
                    System.out.println("Viewing sales history...");
                    break;
                case 4: menuChoice = 4;
                    System.out.println("Firing Employee...");
                    break;
                case 5: menuChoice = 5;
                    System.out.println("Logging out...");
                    logout = true;
                    break;
                default:
                    System.out.println("Please enter 1, 2, or 3");
                    break;
            }
        }
        userInput.close();
    }
}
