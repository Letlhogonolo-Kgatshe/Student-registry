
package poe_st10445158_part1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
 
public class Registration 
{
  private String RegistrationUserName;
    private String RegistrationPassword;
    private String userFirstName; 
    private String userLastName;
  
    public Registration(String userFirstName, String userLastName)
    {
        // Capture user's userfirstname and userlastname
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        // Capture user's username and password
        this.RegistrationUserName = UserName();
        this.RegistrationPassword = UserPassword();
    }

    public String getRegistrationUserName() 
    {
        return RegistrationUserName;
    }

    public String getRegistrationPassword() 
    {
        return RegistrationPassword;
    }

    public String getUserFirstName() 
    {
       return userFirstName;
    }

    public void setUserFirstName(String userFirstName) 
    {
       this.userFirstName = userFirstName;
    }

    public String getUserLastName() 
    {
       return userLastName;
    }

    public void setUserLastName(String userLastName) 
    {
        this.userLastName = userLastName;
    }

    ///////////////////////////////START OF UserName Method to capture user's password  ////////////////////////////////////////////
    public static String UserName() 
    {
        Boolean checkUserName = false;
        String userName = "";
        while (!checkUserName)
        {
            // Prompt user for username input
            userName = JOptionPane.showInputDialog(null, """
                                                    Please Enter A UserName 
                                                    Hint: Must Contain an Underscore 
                                                    Be no longer than 5 Characters""");
       
            // Validate username format
            if (userName != null && userName.contains("_") && userName.length() <= 5 ) 
            {
                System.out.println("UserName successfully captured");
                checkUserName = true ;
            }
            else 
            {
                JOptionPane.showMessageDialog(null,"UserName is not correctly formatted, please ensure that "
                        + "your UserName contains an underscore and"
                        + " is no more than 5 characters in length");
            }    
        }
        return userName;
    }  
    ///////////////////////////////START OF UserName Method to capture user's password  ////////////////////////////////////////////
    // 
    ///////////////////////////////START OF UserPassword Method to capture user's password  ////////////////////////////////////////////
    public static String UserPassword() 
    {
        Boolean checkPasswordComplexity = false;
        String userPassword = "";
        while (!checkPasswordComplexity)
        {
            // Prompt user for password input
            userPassword = JOptionPane.showInputDialog(null, """
                                                    Please Enter A Password 
                                                    Hint: Must Contain a Capital Letter 
                                                    Be at least 8 Characters longer 
                                                    Contain a number 
                                                    Contain a special Character""");
            if (userPassword != null)
            {
                Boolean containCapital = false;
                for (int i = 0; i < userPassword.length(); i++) 
                {
                    char capital = userPassword.charAt(i);
                    if (Character.isUpperCase(capital))
                    {
                        containCapital = true;
                        break;
                    }
                }
                
                Pattern norm = Pattern.compile("[^a-zA-Z0-9\\s]");
                Matcher match = norm.matcher(userPassword);
                Boolean containSpecial = match.find();
                
                Pattern numPattern = Pattern.compile("\\d");
                Matcher numMatcher = numPattern.matcher(userPassword);
                Boolean containNumber = numMatcher.find();
                
                // Validate password complexity
                if  ( userPassword.length() >= 8  && containCapital && containSpecial && containNumber)
                {
                    System.out.println("Password successfully captured");
                    checkPasswordComplexity = true;
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Password is not correctly formatted,"
                            + "please ensure that the password contains 8 characters,"
                            + "a capital letter, a number and a special character");
                }    
            }
        }
        return userPassword;
    }  
    ///////////////////////////////END OF UserPassword Method to capture user's password  ////////////////////////////////////////////
}




    ///////////////////////////////END OF PROGRAM  ////////////////////////////////////////////
