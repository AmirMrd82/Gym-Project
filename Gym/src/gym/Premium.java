/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gym;

/**
 *
 * @author Admin
 */
public class Premium extends Membership {

    
    public Premium(int memberID, String memberName, String memberLastName) {
        super(memberID, memberName, memberLastName);
        this.type = "Premium";
    }
    
    @Override
    public double monthlyCalculation(){
        return 35.00;
    }
    
    @Override
    public double yearlyCalculation(){
        return monthlyCalculation() * 12;
    }
}
