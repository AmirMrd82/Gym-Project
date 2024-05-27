/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gym;

/**
 *
 * @author Admin
 */
public class Staff extends User{
    public Staff(String name, String lastName){
        super(name,lastName);
        this.position = "Staff";
    }
}
