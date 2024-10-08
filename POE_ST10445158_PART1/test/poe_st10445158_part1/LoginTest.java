
package poe_st10445158_part1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tlhogi Kgatshe
 */
public class LoginTest {
    
    public LoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getLoginUserName method, of class Login.
     */
    @Test
    public void testGetLoginUserName() {
        System.out.println("getLoginUserName");
        Login instance = new Login("kyl_1", "Ch&&sec@ke99!", "kyle", "");
        String expResult = "kyl_1";
        String result = instance.getLoginUserName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getLoginPassword method, of class Login.
     */
    @Test
    public void testGetLoginPassword() {
        System.out.println("getLoginPassword");
        Login instance = new Login("kyl_1", "Ch&&sec@ke99!", "kyle", "");
        String expResult = "Ch&&sec@ke99!";
        String result = instance.getLoginPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getUserFirstName method, of class Login.
     */
    @Test
    public void testGetUserFirstName() {
        System.out.println("getUserFirstName");
        Login instance = new Login("kyl_1", "Ch&&sec@ke99!", "kyle", "");
        String expResult = "kyle";
        String result = instance.getUserFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getUserLastName method, of class Login.
     */
    @Test
    public void testGetUserLastName() {
        System.out.println("getUserLastName");
        Login instance = new Login("kyl_1", "Ch&&sec@ke99!", "kyle", "");
        String expResult = "";
        String result = instance.getUserLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
