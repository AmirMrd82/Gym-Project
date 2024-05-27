/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gym;

/**
 *
 * @author Admin
 */
public class Regular extends Membership {

    public Regular(int memberID, String memberName, String memberLastName) {
        super(memberID, memberName, memberLastName);
        this.type = "Regular";
    }

    @Override
    public double monthlyCalculation() {
        return 25.00;
    }

    @Override
    public double yearlyCalculation() {
        return monthlyCalculation() * 12;
    }
}
