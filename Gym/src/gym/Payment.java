/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gym;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Payment {

    public static ArrayList<Payment> payments = new ArrayList<>();
    private double amountPaid;
    private String paymentMethod;
    private Member paymentOwner;
    private Account ownerAccount;

    public Payment(double amount, String method, Member paymentOwner, Account accountDetails) {
        if (amount >= 0) {
            this.amountPaid = amount;
            this.paymentMethod = method;
            this.paymentOwner = paymentOwner;
            this.ownerAccount = accountDetails;
        }
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    @Override
    public String toString() {
        String str = "\n";
        str += "*-------Payment Details-------*\n";
        str += "\nAmount paid: " + this.amountPaid;
        str += "\nPayment method: " + this.paymentMethod;
        str += "\n\nPayment made by: " + this.paymentOwner;
        str += "\n\nAcount details: " + this.ownerAccount;
        return str;
    }
}
