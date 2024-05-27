/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gym;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Admin
 */
public abstract class Membership {

    public static ArrayList<Membership> memberships = new ArrayList<>();
    protected int memberID;
    protected int paymentNumber;
    protected static int counter = 1000;
    protected String memberName;
    protected String memberLastName;
    protected String type;

    public Membership(int memberID, String memberName, String memberLastName) {
        this.memberID = memberID;
        this.paymentNumber = ++counter;
        this.memberName = memberName;
        this.memberLastName = memberLastName;
    }

    public abstract double monthlyCalculation();

    public abstract double yearlyCalculation();

    public static ArrayList<Membership> getMemberships() {
        return memberships;
    }

    public int getMemberID() {
        return memberID;
    }

    public int getPaymentNumber() {
        return paymentNumber;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getMemberLastName() {
        return memberLastName;
    }

    public String getType() {
        return type;
    }

    public String getAssignedMemberName() {
        if (Member.members.size() < 1) {
            return "Member hasn't been found!";
        } else {
            for (int i = 0; i < Member.members.size(); i++) {
                if (memberships.get(i).getMemberID() == Member.members.get(i).getId()) {
                    return Member.members.get(i).getFirstName();
                }
            }
        }
        return "Member hasn't been found!";
    }

    public String getAssignedMemberLastName() {
        if (Member.members.size() < 1) {
            return "Member hasn't been found!";
        } else {
            for (int i = 0; i < Member.members.size(); i++) {
                if (memberships.get(i).getMemberID() == Member.members.get(i).getId()) {
                    return Member.members.get(i).getLastName();
                }
            }
        }
        return "Member hasn't been found!";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.memberID;
        hash = 53 * hash + this.paymentNumber;
        hash = 53 * hash + Objects.hashCode(this.memberName);
        hash = 53 * hash + Objects.hashCode(this.memberLastName);
        hash = 53 * hash + Objects.hashCode(this.type);
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
        final Membership other = (Membership) obj;
        if (this.memberID != other.memberID) {
            return false;
        }
        if (this.paymentNumber != other.paymentNumber) {
            return false;
        }
        if (!Objects.equals(this.memberName, other.memberName)) {
            return false;
        }
        if (!Objects.equals(this.memberLastName, other.memberLastName)) {
            return false;
        }
        return Objects.equals(this.type, other.type);
    }

    @Override
    public String toString() {
        String str = "\n";
        str += "\nMember ID: " + this.memberID;
        str += "\nPayment number: " + this.paymentNumber;
        str += "\nMember name: " + getAssignedMemberName();
        str += "\nMember last name: " + getAssignedMemberLastName();
        str += "\nMembership type: " + this.type;
        return str;
    }
}
