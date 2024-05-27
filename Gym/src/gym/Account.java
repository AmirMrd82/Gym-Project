/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gym;

import java.io.Serializable;
import java.time.*;
import java.time.format.*;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Account implements Serializable {

    public static ArrayList<Account> accounts = new ArrayList();
    private int accountNumber;
    private double balanceToPay;
    private String creationDate;
    private boolean paidForTrainer;

    public Account(int accountNumber, double balanceToPay, boolean paidForTrainer) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.creationDate = today.format(formatter);
        this.accountNumber = accountNumber;
        this.balanceToPay = balanceToPay;
        this.paidForTrainer = paidForTrainer;
    }

    public static ArrayList<Account> getAccounts() {
        return accounts;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalanceToPay() {
        return balanceToPay;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public boolean isPaidForTrainer() {
        return paidForTrainer;
    }

    @Override
    public String toString() {
        String str = "\n*-------Account Details-------*";
        str += "\nAccount Number: " + this.accountNumber;
        str += "\nCreation date: " + this.creationDate;
        str += "\nBalance: " + this.balanceToPay;
        if (this.paidForTrainer) {
            str += "\nTrainer included: YES";
        }
        if (!this.paidForTrainer) {
            str += "\nTrainer included: NO";
        }
        return str;
    }
}
