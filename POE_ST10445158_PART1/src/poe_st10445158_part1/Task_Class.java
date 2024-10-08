
package poe_st10445158_part1;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import poe_st10445158_part1.Task;

public class Task_Class 
{
    public static Integer task_Duration = 0;  // Task duration is kept to ensure that the appropriate number of hours are logged
    public static Integer iCount = 0;  // Global counter variable to keep track of the number of tasks to be added by the user
    static boolean shouldExit = false;  // Flag to ensure re-prompting until the user decides to quit
    private static List<Task> tasks = new ArrayList<>();

    //-----------------------------------START OF WELCOME EASYKANBAN METHOD --------------------------------------------------//
    public static void Welcome_Easykanban()
    {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban"); // Welcome message when program starts
    int choice ; 
    do
    {
        do
        {
            try{
                    choice = Integer.parseInt(JOptionPane.showInputDialog(null, """
                            Please pick an option
                            Option 1 = Add task
                            Option 2 = Show report
                            Option 3 = Quit """));
            //-----------------------------------------------------------------------------------------------//

            switch (choice) 
            {
                        case 1:
                            option1(); // IF THE 1ST OPTION IS MADE, IT MOVES TO THE OPTION 1 METHOD 
                            break;

                        case 2:
                            option2();// Shows a report of all the added tasks and details
                            break;
                        case 3:
                            choice_3();//If he user chooses the third option the program should display a thankyou message and thenend
                            break;
                        default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please choose a valid option"); // IF ANY OTHER CHOICE IS MADE A ERROR MESSAGE IS SENT 
                    }
            }catch (NumberFormatException e ){
                JOptionPane.showMessageDialog(null,"Please Enter a valid number");
                    choice = 0;

                }
        } while (choice == 2 || choice >3 || choice < 1 && !shouldExit);
    }while (!shouldExit);
    }
    //-----------------------------------END OF WELCOME EASYKANBAN METHOD --------------------------------------------------//

    //-----------------------------------START OF OPTION 3  FOR THE CHOICE 3 METHOD--------------------------------------------------//
    public static void choice_3() 
    {
        shouldExit = true; // Set flag to exit the program
        JOptionPane.showMessageDialog(null, "Thank You, Have a nice day, Goodbye");
    }
    //-----------------------------------END OF OPTION 3  FOR THE CHOICE 3 METHOD--------------------------------------------------//

    //-----------------------------------START OF OPTION 1  FOR THE CHOICE 1 METHOD--------------------------------------------------//
    public static void option1() 
    {
        int numTasks = getNumTasks();
        for ( iCount = 0; iCount < numTasks; iCount++)  // LOOPS FROM THE 1ST OPTION TO THE LAST PERSON TO BE ENTERED
        {
            String task_Name = JOptionPane.showInputDialog(null, "Enter Task Name");

            if (task_Name == null) 
            {
                JOptionPane.showMessageDialog(null, "Task input cancelled. Exiting..."); //EXITS IF NOTHING IS ENTERED
                return; // Exit the method if task input is cancelled
            }
            String task_Description = checktask_Description(); // Retrieve the task description and cheks is its less than 50 characters
            if (task_Description == null) 
            {
                JOptionPane.showMessageDialog(null, "Task input cancelled. Exiting...");
                return; // Exit the method if task input is cancelled
            }
            String Developer_FirstName = JOptionPane.showInputDialog(null, "Enter Developer First name");
            if (Developer_FirstName == null) 
            {
                JOptionPane.showMessageDialog(null, "Task input cancelled. Exiting...");
                return; // Exit the method if task input is cancelled
            }
            String Developer_LastName = JOptionPane.showInputDialog(null, "Enter Developer last name");
            if (Developer_LastName == null) 
            {
                JOptionPane.showMessageDialog(null, "Task input cancelled. Exiting...");
                return; // Exit the method if task input is cancelled
            }
            if (returnTotal_Hours("50"))
                return;
            String task_ID =createTask_ID(task_Name, Developer_LastName, 0);
            String task_Status1 = "";
            int task_Status = 0;
          do{  
            try 
            {
                    String task_StatusSTR = (JOptionPane.showInputDialog(null, """
                            Please pick an option
                            Option 1 = To Do
                            Option 2 = Done
                            Option 3 = Doing """));       //Case statement to keep an acount of the users task status
            if (task_StatusSTR == null) 
            {
                        JOptionPane.showMessageDialog(null, "Task input cancelled. Exiting...");
                        return; // Exit the method if task input is cancelled
                    }
             task_Status = Integer.parseInt(task_StatusSTR);    //Try catch method to ensure that no faulty information is recorded resukting in errors
            switch (task_Status) 
            {
                        case 1:
                            task_Status1 = "To Do";
                            break;
                        case 2:
                            task_Status1 = "Done";
                            break;
                        case 3:
                            task_Status1 = "Doing";
                            break;
                        default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please choose a valid option"); // IF ANY OTHER CHOICE IS MADE A ERROR MESSAGE IS SENT 

                    }
            } catch (HeadlessException | NumberFormatException e) //Catches any exceptions outside of what is allowed
                {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number");
                }
            } while (task_Status < 1 || task_Status > 3);
            Task task = new Task(task_Name, task_Description, Developer_FirstName, Developer_LastName, task_Duration, task_ID, task_Status1);
            tasks.add(task);
            printTask_Details(numTasks, task_Name, task_Duration, task_Description, Developer_FirstName, Developer_LastName, task_Duration, task_ID, task_Status1); // CREATES THE REPORT FROM ALL THE ENTERED INFORMATION
        }
    }
    //-----------------------------------END OF OPTION 1  FOR THE CHOICE 1 METHOD--------------------------------------------------//

    //-----------------------------------START OF getNumTasks METHOD --------------------------------------------------//
    public static int getNumTasks() //This methods gets the total number of tasks the use specified to add
        
    {
        Integer totalTasks = null;
        do {
            String task_Number = JOptionPane.showInputDialog(null, "Enter Number Of Tasks ");
                if (task_Number == null) 
            {
                return 0; // Exit loop if user cancels
            }
            try {
                totalTasks = Integer.parseInt(task_Number);
                if (totalTasks < 0) 
                {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number greater than 0");
                    continue; // Restart loop
                }
                if (totalTasks > 20) 
                {
                    JOptionPane.showMessageDialog(null, "Error: Maximum number of users exceeded (20)");
                    continue; // Restart loop
                }
                if (totalTasks == 0)
                {
                    JOptionPane.showMessageDialog(null,"Goodbye");
                    System.exit(0);
                }
                break; // Exit loop if input is valid
            } catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid number");
            }
        } while (true);
        return totalTasks;
    }
    //-----------------------------------END OF getNumTasks METHOD --------------------------------------------------//

//-----------------------------------START OF checktask_Description METHOD THAT GETS AND CHECKS THE DESCRIPTION LENGTH--------------------------------------------------//
    static String checktask_Description() 
    {
        String task_Description = JOptionPane.showInputDialog(null, "Enter Task Description \nEnsure that the description is no more than 50 characters in length");
        if (task_Description == null) {
            return null; // Return null if task input is cancelled
        }
        if (task_Description.length() > 50) 
        {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
            return null; // Return null if task description exceeds 50 characters
        }
        JOptionPane.showMessageDialog(null, "Task successfully captured");
        return task_Description; // Return task description if it's valid
    }
//-----------------------------------END OF checktask_Description METHOD--------------------------------------------------//

    //-----------------------------------START OF returnTotal_Hours METHOD THAT GETS THE HOURS IT TAKES TO COMPLETE THE TASK--------------------------------------------------//
    public static boolean returnTotal_Hours(String string) 
    {
        do 
        {
            String input = JOptionPane.showInputDialog(null, "Please enter the number of hours the task will take");
            if (input == null) 
            {
                JOptionPane.showMessageDialog(null, "Task input cancelled. Exiting...");
                return true; // Exit the method if task input is cancelled
            }
            try {
                task_Duration = Integer.parseInt(input);
                if (task_Duration < 0 || task_Duration>100) 
                {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number greater than or equal to 0 but no greater than 100");
                    continue; // Restart loop
                }
                break; // Exit loop if input is valid
            } catch (NumberFormatException e) 
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid number");
            }
        } while (true);
        return false;
    }
    //-----------------------------------END OF returnTotal_Hours METHOD--------------------------------------------------//

    //-----------------------------------START OF createTask_ID METHOD THAT CREATES THE TASK ID--------------------------------------------------//   
    public static String createTask_ID(String task_Name, String Developer_LastName, int i) 
    {
        String task_Nameprefix = task_Name.length() >= 2 ? task_Name.substring(0, 2).toUpperCase() : task_Name.toUpperCase();
        String task_ID_suffix = Developer_LastName.length() >= 3 ? Developer_LastName.substring(Developer_LastName.length() - 3).toUpperCase() : Developer_LastName.toUpperCase();
        String task_ID = task_Nameprefix + ":" + (iCount) + ":" + task_ID_suffix;
        JOptionPane.showMessageDialog(null, task_ID);
        //iCount ++;
        return task_ID;
    }
    //-----------------------------------END OF createTask_ID METHOD--------------------------------------------------//

    //-----------------------------------START OF printTask_Details METHOD THAT CREATES THE REPORT AND DISPLAYS THE REPORT-------------------------------------------------//
    public static void printTask_Details(int numTasks, String task_Name, int task_Duration, String task_Description, String Developer_FirstName, String Developer_LastName, int task_Duration1, String task_ID, String task_Status1) 
    {
        String Display = "Task Details:\n" +
                "------------------------\n" +
                "Num Tasks: \t " + (iCount+1) + " of "+ numTasks + "\n" +
                "------------------------\n" +
                "Task Name: \t " + task_Name + "\n" +
                "Task Number: \t " + (iCount+1) + "\n" +
                "Task Description: \t " + task_Description + "\n" +
                "Developer Details: \t " + Developer_FirstName + " "+ Developer_LastName + "\n" + 
                "Duration: \t " + task_Duration +"hrs" + "\n" +
                "Task ID: \t " + task_ID + "\n" +
                "Task Status: \t " + task_Status1;

        JOptionPane.showMessageDialog(null, Display);
    }
    //-----------------------------------END OF printTask_Details METHOD--------------------------------------------------//
    
    //-----------------------------------START OF OPTION 2  FOR THE CHOICE 2 METHOD--------------------------------------------------//
    public static void option2() 
    {
        while (true) 
        {
            int todo = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    What would you like to do?
                    1) Display tasks with status 'Done'
                    2) Display the task with the longest duration
                    3) Search for a task by name
                    4) Search for tasks by developer
                    5) Delete a task by name
                    6) Display all tasks
                    7) Exit to main menu """));

            switch (todo) 
            {
                case 1:
                    displayTasksWithStatusDone();
                    break;
                case 2:
                    displayTaskWithLongestDuration();
                    break;
                case 3:
                    searchTaskByName();
                    break;
                case 4:
                    searchTasksByDeveloper();
                    break;
                case 5:
                    deleteTaskByName();
                    break;
                case 6:
                    displayAllTasks();
                    break;
                case 7:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please choose a valid option");
            }
        }
    }

    private static void displayTasksWithStatusDone() 
    {
        StringBuilder result = new StringBuilder("Tasks with status 'Done':\n");
        for (Task task : tasks) 
        {
            if ("Done".equalsIgnoreCase(task.getTaskStatus())) 
            {
                result.append("Developer: ").append(task.getDeveloperFirstName()).append(" ").append(task.getDeveloperLastName())
                        .append(", Task Name: ").append(task.getTaskName())
                        .append(", Duration: ").append(task.getTaskDuration()).append(" hours\n");
            }
        }
        JOptionPane.showMessageDialog(null, result.toString());
    }

    private static void displayTaskWithLongestDuration() 
    {
        Task longestTask = null;
        for (Task task : tasks) 
        {
            if (longestTask == null || task.getTaskDuration() > longestTask.getTaskDuration()) 
            {
                longestTask = task;
            }
        }
        if (longestTask != null) 
        {
            JOptionPane.showMessageDialog(null, "Task with the longest duration:\n"
                    + "Developer: " + longestTask.getDeveloperFirstName() + " " + longestTask.getDeveloperLastName()
                    + ", Task Name: " + longestTask.getTaskName()
                    + ", Duration: " + longestTask.getTaskDuration() + " hours");
        } else 
        {
            JOptionPane.showMessageDialog(null, "No tasks available.");
        }
    }

    private static void searchTaskByName() 
    {
        String taskName = JOptionPane.showInputDialog(null, "Enter the task name to search");
        if (taskName == null) return;

        StringBuilder result = new StringBuilder("Search Results:\n");
        for (Task task : tasks) 
        {
            if (task.getTaskName().equalsIgnoreCase(taskName)) 
            {
                result.append("Developer: ").append(task.getDeveloperFirstName()).append(" ").append(task.getDeveloperLastName())
                        .append(", Task Status: ").append(task.getTaskStatus()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, result.length() > 15 ? result.toString() : "No tasks found with the given name.");
    }

    private static void searchTasksByDeveloper() 
    {
        String developerName = JOptionPane.showInputDialog(null, "Enter the developer name to search");
        if (developerName == null) return;

        StringBuilder result = new StringBuilder("Search Results:\n");
        for (Task task : tasks) 
        {
            if ((task.getDeveloperFirstName() + " " + task.getDeveloperLastName()).equalsIgnoreCase(developerName)) 
            {
                result.append("Task Name: ").append(task.getTaskName()).append(", Task Status: ").append(task.getTaskStatus()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, result.length() > 15 ? result.toString() : "No tasks found with the given developer name.");
    }

    private static void deleteTaskByName() 
    {
        String taskName = JOptionPane.showInputDialog(null, "Enter the task name to delete");
        if (taskName == null) return;

        tasks.removeIf(task -> task.getTaskName().equalsIgnoreCase(taskName));
        JOptionPane.showMessageDialog(null, "Task deleted if it existed.");
    }

    private static void displayAllTasks() 
    {
        StringBuilder result = new StringBuilder("All Tasks:\n");
        for (Task task : tasks) 
        {
            result.append("Developer: ").append(task.getDeveloperFirstName()).append(" ").append(task.getDeveloperLastName())
                    .append(", Task Name: ").append(task.getTaskName())
                    .append(", Task Status: ").append(task.getTaskStatus())
                    .append(", Duration: ").append(task.getTaskDuration()).append(" hours\n");
        }
        JOptionPane.showMessageDialog(null, result.toString());
    }
    //-----------------------------------END OF OPTION 2  FOR THE CHOICE 2 METHOD--------------------------------------------------//
    public static void main(String[] args) 
    {
        Welcome_Easykanban();
    }
}
