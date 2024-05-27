package gym;

import java.io.Serializable;
import java.time.*;
import java.util.*;

/**
 *
 * @author Admin
 */
public class Member implements Serializable {

    public static ArrayList<Member> members = new ArrayList<>();
    private String firstName;
    private String lastName;
    private String street;
    private String buildingNumber;
    private String province;
    private String postalCode;
    private String address = street + " " + buildingNumber + " " + province + " " + postalCode;
    private String phoneNumber;
    private char gender;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private String dateOfBirth;
    private String membershipType;
    private int age;
    private int id;
    private static int counter = 1000;

    public Member(String firstName, String lastName, String street, String buildingNumber, String province, String postalCode, String phoneNumber, char gender, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.id = ++counter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.province = province;
        if (isPostalCodeValid(postalCode)) {
            this.postalCode = postalCode;
        } else {
            System.out.println("Invalid Postal Code!");
        }
        if (isPhoneNumberValid(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Invalid Phone Number!");
        }
        if (isGenderValid(gender)) {
            this.gender = gender;
        } else {
            System.out.println("Invalid Gender!");
        }
        if (isDayOfBirthValid(dayOfBirth)) {
            this.dayOfBirth = dayOfBirth;
        } else {
            System.out.println("Choose a number between 1 and 31!");
        }
        if (isMonthOfBirthValid(monthOfBirth)) {
            this.monthOfBirth = monthOfBirth;
        } else {
            System.out.println("Choose a number between 1 and 12!");
        }
        if (isYearOfBirthValid(yearOfBirth)) {
            this.yearOfBirth = yearOfBirth;
        } else {
            System.out.println("Invalid year of birth!");
        }
        this.age = ageCalculator();
        this.address = street + ", " + buildingNumber + ", " + province + ", " + postalCode;
    }

    /*Getters*/
    public static ArrayList<Member> getMembers() {
        return members;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        String year = Integer.toString(this.yearOfBirth);
        String month = Integer.toString(this.monthOfBirth);
        String day = Integer.toString(this.dayOfBirth);
        String dateOfBirth = day + "/" + month + "/" + year;
        return dateOfBirth;
    }

    public int getAge() {
        return ageCalculator();
    }

    public int getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public String getProvince() {
        return province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getMembershipType() {
        return "";
    }

    /*Setters*/
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isPhoneNumberValid(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Phone number is invalid!");
        }
    }

    public void setGender(char gender) {
        if (isGenderValid(gender)) {
            this.gender = gender;
        } else {
            System.out.println("Use M or F for gender!");
        }
    }

    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String formatDateOfBirth() {
        String str = "";
        String year = Integer.toString(this.getYearOfBirth());
        String month = Integer.toString(this.getMonthOfBirth());
        String day = Integer.toString(this.getDayOfBirth());
        str += day + "/" + month + "/" + year;
        return str;
    }

    /**
     * To check if the phone number is valid
     *
     * @param phoneNumber
     * @return status
     */
    public static boolean isPhoneNumberValid(String phoneNumber) {
        if (phoneNumber.length() < 12) {
            System.out.println("Long phone number!");
            return false;
        }
        if (phoneNumber.length() < 12) {
            System.out.println("Short phone number!");
            return false;
        }
        //438 989 1902
        //0123456789
        //          10 
        //           11
        String firstPart = phoneNumber.substring(0, 3);
        String secondPart = phoneNumber.substring(4, 7);
        String thirdPart = phoneNumber.substring(8, phoneNumber.length());
        if (!containsOnlyDigits(firstPart) || !containsOnlyDigits(secondPart) || !containsOnlyDigits(thirdPart)) {
            System.out.println("Phone number should only contain numbers");
            return false;
        }
        if (phoneNumber.charAt(3) != ' ' || phoneNumber.charAt(7) != ' ') {
            System.out.println("Missing space/wrong format of placing in phone number");
            return false;
        }
        if (firstPart.length() > 3) {
            System.out.println("First part of the phone number should contain 3 digits!");
            return false;
        }
        if (secondPart.length() > 3) {
            System.out.println("Second part of the phone number should contain 3 digits!");
            return false;
        }
        if (thirdPart.length() > 4) {
            System.out.println("Third part of the phone number should contain 4 digits!");
            return false;
        }
        return true;
    }

    private static boolean containsOnlyDigits(String phoneNumber) {
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * To check if gender char is valid
     *
     * @param gender
     * @return status
     */
    public static boolean isGenderValid(char gender) {
        boolean status = false;
        if (gender == 'm' || gender == 'M' || gender == 'f' || gender == 'F') {
            status = true;
        }
        return status;
    }

    /**
     * To check if age is valid
     *
     * @return status
     */
    public boolean isAgeValid() {
        boolean status = false;
        if (this.age >= 16) {
            status = true;
        }
        return status;
    }

    public static boolean isPostalCodeValid(String postalCode) {
        System.out.println("Enter your postal code: ");
        if (postalCode.length() < 7) {
            System.out.println("Short postal code!");
            return false;
        }
        //H4W 1B7
        //0123456
        String firstPart = postalCode.substring(0, 3);
        String secondPart = postalCode.substring(4, postalCode.length());
        String format = "Proper format = X1X 1X1";
        String space = "/Don't forget the space!";
        if (postalCode.charAt(3) != ' ') {
            System.out.println(format + space);
            return false;
        }
        if (postalCode.length() != 7) {
            System.out.println(format + space);
            return false;
        }
        if (!Character.isAlphabetic(firstPart.charAt(0)) || !Character.isDigit(firstPart.charAt(1)) || !Character.isAlphabetic(firstPart.charAt(2))) {
            System.out.println(format);
            return false;
        }
        if (!Character.isDigit(secondPart.charAt(0)) || !Character.isAlphabetic(secondPart.charAt(1)) || !Character.isDigit(secondPart.charAt(2))) {
            System.out.println(format);
            return false;
        }
        return true;
    }

    public static boolean isDayOfBirthValid(int day) {
        if (day > 0 && day <= 31) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isMonthOfBirthValid(int month) {
        if (month > 0 && month <= 12) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isYearOfBirthValid(int year) {
        Year currentYear = Year.now();
        int currentYearValue = currentYear.getValue();
        if (year > 1900 && year <= currentYearValue) {
            return true;
        } else {
            return false;
        }
    }

    public int ageCalculator() {
        int dayOfMonth = 0;
        switch (this.monthOfBirth) {
            case 1, 3, 5, 7, 8, 10, 12:
                dayOfMonth = 31;
                break;
            case 2:
                dayOfMonth = 28;
                break;
            case 4, 6, 9, 11:
                dayOfMonth = 30;
                break;
            default:
                dayOfMonth = 0;
        }
        LocalDate startDate = LocalDate.of(this.yearOfBirth, this.monthOfBirth, dayOfMonth);
        LocalDate endDate = LocalDate.now();
        Period period = Period.between(startDate, endDate);
        return period.getYears();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.firstName);
        hash = 29 * hash + Objects.hashCode(this.lastName);
        hash = 29 * hash + Objects.hashCode(this.address);
        hash = 29 * hash + Objects.hashCode(this.phoneNumber);
        hash = 29 * hash + this.gender;
        hash = 29 * hash + this.dayOfBirth;
        hash = 29 * hash + this.monthOfBirth;
        hash = 29 * hash + this.yearOfBirth;
        hash = 29 * hash + this.age;
        hash = 29 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Member other = (Member) obj;
        if (this.gender != other.gender) {
            return false;
        }
        if (this.dayOfBirth != other.dayOfBirth) {
            return false;
        }
        if (this.monthOfBirth != other.monthOfBirth) {
            return false;
        }
        if (this.yearOfBirth != other.yearOfBirth) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return Objects.equals(this.phoneNumber, other.phoneNumber);
    }

    @Override
    public String toString() {
        String str = "";
        if (isAgeValid() && isDayOfBirthValid(this.dayOfBirth) && isGenderValid(this.gender) && isMonthOfBirthValid(this.monthOfBirth) && isPhoneNumberValid(this.phoneNumber) && isPostalCodeValid(this.postalCode) && isYearOfBirthValid(this.yearOfBirth)) {
            str += "\nMember Informations\n----------------";
            str += "\nID: " + this.id;
            str += "\nFirst name: " + this.firstName;
            str += "\nLast name: " + this.lastName;
            str += "\nGender: " + this.gender;
            str += "\nDate Of Birth: " + formatDateOfBirth();
            str += "\nAge: " + this.ageCalculator();
            str += "\nAddress: " + getAddress();
        } else {
            str = "There is an invalid input that needs to be fixed!";
        }
        return str;
    }
}
