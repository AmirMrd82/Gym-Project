/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gym;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class MemberIT {

    /**
     * Test of isPhoneNumberValid method, of class Member.
     */
    @Test
    public void testIsPhoneNumberValid() {
        System.out.println("isPhoneNumberValid");
        String phoneNumber = "438 989 1902";
        boolean expResult = true;
        boolean result = Member.isPhoneNumberValid(phoneNumber);
        assertEquals(expResult, result);
    }

    /**
     * Test of isGenderValid method, of class Member.
     */
    @Test
    public void testIsGenderValid() {
        System.out.println("isGenderValid");
        char gender = 'D';
        boolean expResult = false;
        boolean result = Member.isGenderValid(gender);
        assertEquals(expResult, result);
    }

    /**
     * Test of isPostalCodeValid method, of class Member.
     */
    @Test
    public void testIsPostalCodeValid() {
        System.out.println("isPostalCodeValid");
        String postalCode = "H4W1B7";
        boolean expResult = false;
        boolean result = Member.isPostalCodeValid(postalCode);
        assertEquals(expResult, result);
    }

}
