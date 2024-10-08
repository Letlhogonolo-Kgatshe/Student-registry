package poe_st10445158_part1;

import javax.swing.JOptionPane;

public class POE_ST10445158_PART1 {

    Task_Class TaskClass = new Task_Class(); // Importing Task Class

    public static void main(String[] args) {
        ///////////////////////// WELCOME PAGE ///////////////////////////////////////////
        JOptionPane.showMessageDialog(null, "WELCOME TO SIGN_IN PAGE ");

        // Get total number of users or exit if user cancels
        Integer totalUsers = getTotalUsers();
        if (totalUsers == null) {
            return; // Exit program if user cancels
        }

        Registration[] registrations = new Registration[totalUsers]; // GETS THE TOTAL NUMBER OF USERS TO BE ADDED
        // Capture user Welcome_Login details
        for (int i = 0; i < totalUsers; i++) {
            // Exit if user cancels
            if (!User_Details(i + 1, registrations)) {
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "UserName and Password Captured");

        ///////////////////////// CHOOSE OPTION TO Login or exit ///////////////////////////////////////////
        int selection = JOptionPane.showConfirmDialog(null, "Do you want to continue to log in?", "LOG_IN",
                JOptionPane.YES_NO_OPTION);
        if (selection != JOptionPane.YES_OPTION) {
            return; // Exit program if user cancels
        }

        Welcome_Login(registrations); // WELCOME PAGE IF THE USER CHOSE TO LOGIN
        Task_Class.Welcome_Easykanban(); // AFTER SUCCESSFUL LOGIN THE USER MOVES TO THE EASYKANBAN PAGE TO PERFORM TASKS
    }

    ///////////////////////// GET TOTAL NUMBER OF USERS TO BE ADDED ///////////////////////////////////////////
    public static Integer getTotalUsers() {
        Integer totalUsers = null;
        do {
            String input = JOptionPane.showInputDialog(null,
                    "Enter the number of users \nEnter 0 to exit the program");
            if (input == null) {
                return null; // Exit loop if user cancels
            }
            try {
                totalUsers = Integer.parseInt(input);
                if (totalUsers < 0) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number greater than 0");
                    continue; // Restart loop
                }
                if (totalUsers > 20) {
                    JOptionPane.showMessageDialog(null, "Error: Maximum number of users exceeded (20)");
                    continue; // Restart loop
                }
                if (totalUsers == 0) {
                    JOptionPane.showMessageDialog(null, "Goodbye");
                    System.exit(0);
                }
                break; // Exit loop if input is valid
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number");
            }
        } while (true);
        return totalUsers;
    }
    ///////////////////////// END OF TOTAL NUMBER OF USER TASK ///////////////////////////////////////////

    ///////////////////////// GET THE USER DETAILS ///////////////////////////////////////////
    public static boolean User_Details(int userIndex, Registration[] registrations) {
        String firstName = JOptionPane.showInputDialog(null, "Enter first name for user " + userIndex);
        if (firstName == null) {
            return false; // Exit method if user cancels
        }
        String lastName = JOptionPane.showInputDialog(null, "Enter last name for user " + userIndex);
        if (lastName == null) {
            return false; // Exit method if user cancels
        }

        registrations[userIndex - 1] = new Registration(firstName, lastName);
        return true;
    }
    //-----------------------------------END OF USER DETAILS METHOD--------------------------------------------------//

    //-----------------------------------START OF USER LOGIN METHOD--------------------------------------------------//
    public static void Welcome_Login(Registration[] registrations) {
        boolean userFound = false;
        while (!userFound) {
            JOptionPane.showMessageDialog(null, "WELCOME TO LOG_IN PAGE ");
            // User Welcome_Login
            String userNameInput = JOptionPane.showInputDialog(null, "Enter your username");
            String userPasswordInput = JOptionPane.showInputDialog(null, "Enter your password");

            for (Registration registration : registrations) {
                if (registration != null && registration.getRegistrationUserName().equals(userNameInput)
                        && registration.getRegistrationPassword().equals(userPasswordInput)) {
                    JOptionPane.showMessageDialog(null, "Welcome back: " + registration.getUserFirstName() + " "
                            + registration.getUserLastName() + "\nIt is great to see you again");
                    userFound = true;
                    break;
                }
            }

            if (!userFound) {
                JOptionPane.showMessageDialog(null, "Username or Password Incorrect \nPlease try Again");
                int selection = JOptionPane.showConfirmDialog(null, "Do you want to try to log in again?", "LOG_IN",
                        JOptionPane.YES_NO_OPTION);
                if (selection != JOptionPane.YES_OPTION) {
                    return;
                }
            }
        }
    }
    //-----------------------------------END OF USER LOGIN METHOD--------------------------------------------------//
}
