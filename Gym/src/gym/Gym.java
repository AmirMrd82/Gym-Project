package gym;

import java.io.*;
import java.util.*;

/**
 *
 * @author Seyedamirhossein Moradi
 */
public class Gym {
//STAFF ID: PublicGym
//STAFF PASSWORD: 12345    

    private static final String pathForMember = "Members.ser";
    private static final String pathForAccount = "Accounts.ser";
    private static final String pathForPayments = "Payments.ser";
    private static final String pathForMembersships = "memberships.ser";
    private static final String pathForUsers = "Users.ser";
    private static int premiumAndRegular; //1 for regular -- 2 for premium
    private static final String alertMessage = "Please choose between available options!";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        displayMenu();

    }

    private static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        //the main menu of app
        int userAnswer1;
        do {
            System.out.println("What kind of user are you?");
            System.out.println("[1] For member\n[2] For user");
            userAnswer1 = scanner.nextInt();
            if (userAnswer1 != 1 && userAnswer1 != 2) {
                System.out.println("Please choose between 1 and 2!");
                userAnswer1 = 0;
            } else {
                break;
            }
        } while (userAnswer1 == 0);
        
        //All the member options
        if (userAnswer1 == 1) {
            //make membership
            //compare memberships
            //terms and conditions
            int condition = 0;
            do {
                System.out.println("Press [1] for making a membership");
                System.out.println("Press [2] to compare different memberships");
                System.out.println("Press [3] to see the terms and conditions");

                int choice = scanner.nextInt();
                if (choice != 1 && choice != 2 && choice != 3) {
                    System.out.println("\nPlease choose between available options!\n");
                    condition = 0;
                } else {
                    condition = 1;
                }
                switch (choice) {
                    //options
                    case 1:
                        makeMembershipAndAccount();
                        break;
                    case 2:
                        System.out.println(comparePlans());//needs to be completed
                        break;
                    case 3:
                        System.out.println(termsAndConditions());//needs to be completed
                        break;
                }
            } while (condition == 0);
        }
        
        //All the user options
        if (userAnswer1 == 2) {
            //make member
            //if manager aible to create staff and trainer object
            staffLogin();

            int condition = 0;
            int answer;
            do {
                System.out.println("Press [1] to add a membership");
                System.out.println("Press [2] to add a staff");
                System.out.println("Press [3] to get all the members");
                System.out.println("Press [4] to find a specific member");
                System.out.println("Press [5] to find a member's account");
                answer = scanner.nextInt();
                if (answer != 1 && answer != 2 && answer != 3 && answer != 4 && answer != 5) {
                    System.out.println("Please choose between available options!");
                    condition = 0;
                } else {
                    condition++;
                }
            } while (condition == 0);
            switch (answer) {
                case 1:
                    makeMembershipAndAccount();
                    break;
                case 2:
                    makeStaff();
                    break;
                case 3:
                    showAllMembers();
                    break;
                case 4:
                    findSpecificMember();
                    break;
                case 5:
                    findMembersAccount();
                    break;
            }
        }
    }

    private static String termsAndConditions() {
        String str = "";
        str += "\n1-Membership is open to individuals aged 16 and over.";
        str += "\n2-We offer various membership plans including regular and premium";
        str += "\n3-Members can cancel their membership at any time. ";
        str += "\n4-The gym reserves the right to suspend or terminate membership for\nviolation of these terms and conditions or for conduct deemed inappropriate by gym management.";
        str += "\n5-The gym is open 24/7, however there might be some changes on holidays";
        str += "\n6-Members must behave respectfully towards staff and other gym users.\nAbusive, aggressive, or disruptive behavior will not be tolerated.";
        str += "\n7-Members must use equipment properly and as intended. Instructions and\nguidelines provided by staff or displayed on equipment must be followed. Members are responsible for damages caused by misuse.";
        str += "\n8-Members are required to wipe down equipment after use and to maintain\npersonal hygiene. Gym attire, including appropriate footwear, must be worn at all times.";
        str += "\n9-Class bookings must be canceled at least 24 hours in advance to avoid a cancellation fee.";
        return str;
    }

    private static void makeStaff() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("Press [1] to add a normal staff member");
            System.out.println("Press [2] to add a trainer");
            choice = scanner.nextInt();
            if (choice == 1) {
                //ask informations of staff and create and add to arraylist
                staffLogin();
                addStaff();
            } else if (choice == 2) {
                //ask informations of trainer and create and add to arraylist
                staffLogin();
                addTrainer();
            } else {
                choice = 0;
                System.out.println("Please choose between [1] and [2]");
            }
        } while (choice == 0);
    }

    private static String comparePlans() {
        String str = "\n";
        str += """
               
               *-------Regular Plan-------*
               Access to gym equipment
               Access to locker room
               Access to group classes (limited)
               Limited personal training sessions
               Basic customer support""";

        str += """
               
               
               *-------Premuims Plan-------*
               Access to gym equipment
               Access to locker room
               Access to all group classes
               Unlimited personal training sessions
               Advanced customer support (priority)
               Access to premium facilities (sauna, pool, etc.)
               Free fitness assessment and nutrition plan""";
        return str;
    }

    private static void addStaff() {
        Scanner scanner = new Scanner(System.in);
        int status = 0;
        String name = null;
        String lastName = null;
        do {
            try {
                System.out.println("Enter the staff name: ");
                name = scanner.nextLine();
                System.out.println("Enter the staff last name: ");
                lastName = scanner.nextLine();
                Staff staff = new Staff(name, lastName);
                Staff.users.add(staff);
                serializeUsers(User.users);
                status++;
                if (name == null || lastName == null || name.trim().isEmpty() || lastName.trim().isEmpty()) {
                    status = 0;
                    System.out.println("Please enter valid name and last name!");
                }
            } catch (InputMismatchException ime) {
                status = 0;
                System.out.println(ime.getMessage());
            } catch (IllegalArgumentException iae) {
                status = 0;
                System.out.println(iae.getMessage());
            }

        } while (status == 0);
    }

    private static void addTrainer() {
        Scanner scanner = new Scanner(System.in);
        int status = 0;
        String name = null;
        String lastName = null;
        do {
            //TO be completed
            try {
                System.out.println("Enter the trainer name: ");
                name = scanner.nextLine();
                System.out.println("Enter the trainer last name: ");
                lastName = scanner.nextLine();
                Trainer trainer = new Trainer(name, lastName);
                Staff.users.add(trainer);
                status++;
                if (name == null || lastName == null || name.trim().isEmpty() || lastName.trim().isEmpty()) {
                    status = 0;
                    System.out.println("Please enter valid name and last name!");
                }
            } catch (InputMismatchException ime) {
                System.out.println(ime.getMessage());
                status = 0;
            }

        } while (status == 0);
    }

    private static void staffLogin() {
        Scanner scanner = new Scanner(System.in);
        String id = null;
        String password = null;
        do {
            System.out.println("Enter the ID: ");
            id = scanner.nextLine();

            System.out.println("Enter the password: ");
            password = scanner.nextLine();

            if (!staffLoginVerification(id, password)) {
                System.out.println("Wrong ID or password! Try again");
            }
        } while (id == null || password == null || id.trim().isEmpty() || password.trim().isEmpty() || !staffLoginVerification(id, password));

    }

    private static boolean staffLoginVerification(String id, String password) {
        //Checks if id and pass are valid
        if (id.equals("PublicGym") && password.equals("12345")) {
            return true;
        }
        return false;
    }

    private static void makeMembershipAndAccount() {
        //Ask for all the member informations, same account number and memeber number will be used for account and member
        Scanner scanner = new Scanner(System.in);
        String name = null;
        String lastName = null;
        String street = null;
        String buildingNumber = null;
        String province = null;
        String postalCode = "Postal Code";
        String phoneNumber = "Phone Number";
        char gender = ' ';
        int dayOfBirth = 0;
        int monthOfBirth = 0;
        int yearOfBirth = 0;

        //name
        while (name == null || name.trim().isEmpty()) {
            try {
                System.out.println("Enter your name: ");
                name = scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        //lastName
        while (lastName == null || lastName.trim().isEmpty()) {
            try {
                System.out.println("Enter your last name: ");
                lastName = scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        //street
        while (street == null || street.trim().isEmpty()) {
            try {
                System.out.println("Enter your street name: ");
                street = scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        //buildingNumber
        while (buildingNumber == null || buildingNumber.trim().isEmpty()) {
            try {
                System.out.println("Enter your building number: ");
                buildingNumber = scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        //province
        while (province == null || province.trim().isEmpty()) {
            try {
                System.out.println("Enter your province: ");
                province = scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        //postalCode
        while (!Member.isPostalCodeValid(postalCode)) {
            postalCode = scanner.nextLine();
            if (!Member.isPostalCodeValid(postalCode)) {
                postalCode = "Postal Code";
            }
        }

        //phoneNumber
        while (!Member.isPhoneNumberValid(phoneNumber)) {
            System.out.println("Enter your phone number: ");
            phoneNumber = scanner.nextLine();
            if (!Member.isPhoneNumberValid(phoneNumber)) {
                phoneNumber = "Phone Number";
                Member.isPhoneNumberValid(phoneNumber);
            }
        }

        //gender
        while (gender == ' ') {
            System.out.println("Enter your gender (M/F): ");
            gender = scanner.next().charAt(0);
            if (!Member.isGenderValid(gender)) {
                gender = ' ';
                Member.isGenderValid(gender);
            }
        }

        //dayOfBirth
        while (dayOfBirth == 0) {
            System.out.println("Enter the day of your birth: ");
            dayOfBirth = scanner.nextInt();
            if (!Member.isDayOfBirthValid(dayOfBirth)) {
                dayOfBirth = 0;
                Member.isDayOfBirthValid(dayOfBirth);
            }
        }

        //monthOfBirth
        while (monthOfBirth == 0) {
            System.out.println("Enter the month of your birth: ");
            monthOfBirth = scanner.nextInt();
            if (!Member.isMonthOfBirthValid(monthOfBirth)) {
                monthOfBirth = 0;
                Member.isMonthOfBirthValid(monthOfBirth);
            }
        }

        //yearOfBirth
        while (yearOfBirth == 0) {
            System.out.println("Enter the year of your birth: ");
            yearOfBirth = scanner.nextInt();
            if (!Member.isYearOfBirthValid(yearOfBirth)) {
                yearOfBirth = 0;
                Member.isYearOfBirthValid(yearOfBirth);
            }
        }
        Member member = new Member(name, lastName, street, buildingNumber, province, postalCode, phoneNumber, gender, dayOfBirth, monthOfBirth, yearOfBirth);
        Member.members.add(member);
        serializeMembers(Member.members);

        boolean membershipTypeQuestion = true;
        boolean paidForTrainer;
        System.out.println("\nNow we create you account");
        while (membershipTypeQuestion) {
            System.out.println("\nWhat kind of memberships are you choosing?\n[1] for regular\n[2] for premium");
            int question = scanner.nextInt();
            if (question != 1 && question != 2) {
                System.out.println("Choose between available options!");
                membershipTypeQuestion = true;
            } else {
                membershipTypeQuestion = false;
                if (question == 1) {
                    premiumAndRegular = 1;
                }
                if (question == 2) {
                    premiumAndRegular = 2;
                }
            }
        }

        //Regular Membership
        if (premiumAndRegular == 1) {
            System.out.println("\n*-------Regular-------*");
            //create regular membership
            Regular regular = new Regular(member.getId(), member.getFirstName(), member.getLastName());
            Membership.memberships.add(regular);
            System.out.println("Your membership details: ");
            System.out.println(regular.toString());

            double trainer = 0;
            Account account = null;
            boolean askingForTrainer = true;
            while (askingForTrainer) {
                System.out.println("\nDo you also need a trainer?\n[1] for yes\n[2] for no\n20$ for trainer");
                int answer = scanner.nextInt();
                if (answer == 1) {
                    askingForTrainer = false;
                    account = new Account(member.getId(), 25.00, true);
                    Account.accounts.add(account);
                    System.out.println(account);
                }
                if (answer == 2) {
                    askingForTrainer = false;
                    trainer = 20;
                    account = new Account(member.getId(), 25 + trainer, false);
                    Account.accounts.add(account);
                    System.out.println(account);
                }
                if (answer != 1 && answer != 2) {
                    askingForTrainer = true;
                    System.out.println("PLease choose between available options");
                }
            }

            //Making a payment for the first month
            int method = 0;
            String payingMethod = "";
            do {
                System.out.println("\nAre you paying by cash or by creadit card?");
                System.out.println("[1] for cash");
                System.out.println("[2] for credit card");
                int answer = scanner.nextInt();
                if (answer == 1 || answer == 2) {
                    method++;
                    if (answer == 1) {
                        payingMethod = "Cash";
                        method++;
                    }
                    if (answer == 2) {
                        payingMethod = "Credit card";
                        method++;
                    }
                } else {
                    System.out.println(alertMessage);
                    method = 0;
                }
            } while (method == 0);

            //Paying
            double balance = 0;
            if (payingMethod.equals("Cash")) {
                double cash = 0;
                do {
                    System.out.println("Put the amount of cash: ");
                    cash = scanner.nextDouble();
                    balance += cash;
                } while (balance == 0 || cash < 1);
            }
            String cardNumber = null;
            String date = null;
            int cvv = 0;
            if (payingMethod.equals("Credit card")) {
                double amount = 0;
                do {
                    System.out.println("Put your card number: ");
                    cardNumber = scanner.nextLine();

                    System.out.println("Put expiration date (YY/MM): ");
                    date = scanner.nextLine();

                    System.out.println("Put CVV: ");
                    cvv = scanner.nextInt();

                    System.out.println("Enter the amount: ");
                    amount = scanner.nextDouble();

                    balance += amount;
                } while (balance == 0 || amount < 1);
            }

            //Displaying
            Payment payment = new Payment(balance, payingMethod, member, account);
            System.out.println(payment);
            System.out.println("Balance to pay: " + (account.getBalanceToPay() - balance));
            Payment.payments.add(payment);
            serializePayments(Payment.payments);
        }

        //Premium Membership
        if (premiumAndRegular == 2) {
            Account account = null;
            System.out.println("\n*-------Premium-------*");
            //create premium membership
            Premium premium = new Premium(member.getId(), member.getFirstName(), member.getLastName());
            Membership.memberships.add(premium);
            System.out.println("Your membership details: ");
            System.out.println(premium.toString());
            //Creating account
            boolean askingForTrainer = true;
            while (askingForTrainer) {
                System.out.println("\nDo you also need a trainer?\n[1] for yes\n[2] for no\n20$ for trainer");
                int answer = scanner.nextInt();
                if (answer == 1) {
                    askingForTrainer = false;
                    account = new Account(member.getId(), 35.00, true);
                    Account.accounts.add(account);
                    System.out.println(account);
                }
                if (answer == 2) {
                    askingForTrainer = false;
                    account = new Account(member.getId(), 55.00, false);
                    Account.accounts.add(account);
                    System.out.println(account);
                }
                if (answer != 1 && answer != 2) {
                    askingForTrainer = true;
                    System.out.println(alertMessage);
                }
            }

            int method = 0;
            String payingMethod = "";
            do {
                System.out.println("\nAre you paying by cash or by creadit card?");
                System.out.println("[1] for cash");
                System.out.println("[2] for credit card");
                int answer = scanner.nextInt();
                if (answer == 1 || answer == 2) {
                    method++;
                    if (answer == 1) {
                        payingMethod = "Cash";
                        method++;
                    }
                    if (answer == 2) {
                        payingMethod = "Credit card";
                        method++;
                    }
                } else {
                    System.out.println(alertMessage);
                    method = 0;
                }
            } while (method == 0);

            //Paying
            double balance = 0;
            if (payingMethod.equals("Cash")) {
                double cash = 0;
                do {
                    System.out.println("Put the amount of cash: ");
                    cash = scanner.nextDouble();
                    balance += cash;
                } while (balance == 0 || cash < 1);
            }
            String cardNumber = null;
            String date = null;
            int cvv = 0;
            if (payingMethod.equals("Credit card")) {
                double amount = 0;
                do {
                    System.out.println("Put your card number: ");
                    cardNumber = scanner.nextLine();

                    System.out.println("Put expiration date (YY/MM): ");
                    date = scanner.nextLine();

                    System.out.println("Put CVV: ");
                    cvv = scanner.nextInt();

                    System.out.println("Enter the amount: ");
                    amount = scanner.nextDouble();

                    balance += amount;
                } while (balance == 0 || amount < 1);
            }

            //Displaying
            Payment payment = new Payment(balance, payingMethod, member, account);
            System.out.println(payment);
            System.out.println("Balance to pay: " + (account.getBalanceToPay() - balance));
            Payment.payments.add(payment);
            serializePayments(Payment.payments);

            Account.accounts.add(account);
            serializeAccounts(Account.accounts);
        }
    }

    private static boolean serializeMembers(ArrayList<Member> list) {
        File file = new File(pathForMember);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private static boolean serializePayments(ArrayList<Payment> list) {
        File file = new File(pathForPayments);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private static boolean serializeAccounts(ArrayList<Account> list) {
        File file = new File(pathForAccount);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private static boolean serializeUsers(ArrayList<User> list) {
        File file = new File(pathForUsers);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private static ArrayList<Member> deserializeMembers() {
        File file = new File(pathForMember);
        Object obj = null;
        try (FileInputStream fis = new FileInputStream(file)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            obj = ois.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ArrayList<Member>) obj;
    }

    private static ArrayList<Account> deserializeAccounts() {
        File file = new File(pathForAccount);
        Object obj = null;
        try (FileInputStream fis = new FileInputStream(file)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            obj = ois.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ArrayList<Account>) obj;
    }

    private static ArrayList<User> deserializeUsers() {
        File file = new File(pathForUsers);
        Object obj = null;
        try (FileInputStream fis = new FileInputStream(file)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            obj = ois.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ArrayList<User>) obj;
    }

    private static ArrayList<Payment> deserializePayments() {
        File file = new File(pathForPayments);
        Object obj = null;
        try (FileInputStream fis = new FileInputStream(file)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            obj = ois.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ArrayList<Payment>) obj;
    }

    private static Member findSpecificMember() {
        Scanner scanner = new Scanner(System.in);
        Member member = null;
        System.out.println("Enter the member's ID: ");
        int memberID = scanner.nextInt();
        ArrayList<Member> members = deserializeMembers();
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId() == memberID) {
                return members.get(i);
            }
        }
        return member;
    }

    private static Account findMembersAccount() {
        Scanner scanner = new Scanner(System.in);
        Account account = null;
        System.out.println("Enter the member's ID: ");
        int memberID = scanner.nextInt();
        ArrayList<Account> accounts = deserializeAccounts();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == memberID) {
                return accounts.get(i);
            }
        }
        return account;
    }

    private static void showAllMembers() {
        //print the arraylist stored in the file
        printMemberList(deserializeMembers());
    }

    private static void printMemberList(ArrayList<Member> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static void printAccountList(ArrayList<Account> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
