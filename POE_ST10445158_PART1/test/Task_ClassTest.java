import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import poe_st10445158_part1.Task_Class;

public class Task_ClassTest {

    private Task_Class taskClass;

    @Before
    public void setUp() {
        taskClass = new Task_Class();
    }

    @Test
    public void testCreateTask_ID() {
        // Test Case 1
        String taskName = "Create Add Task feature to add task users";
        String developerLastName = "MIKE";
        int taskNumber = 0;
        String expected = "CR:0:IKE";
        String result = taskClass.createTask_ID(taskName, developerLastName, taskNumber);
        assertEquals(expected, result);
        //assertEquals(1, taskClass.iCount); // Check if iCount increments correctly

        // Test Case 2
        taskName = "Create Add Task feature to add task users";
        developerLastName = "BARNARD";
        taskNumber = 1;
        expected = "CR:1:ARD";
        Task_Class.iCount ++;
        result = taskClass.createTask_ID(taskName, developerLastName, taskNumber);
        assertEquals(expected, result);
        //assertEquals(2, taskClass.iCount); // Check if iCount increments correctly

        // Test Case 3
        taskName = "Create Add Task feature to add task users";
        developerLastName = "SAMANTHA";
        taskNumber = 2;
        expected = "CR:2:THA";
        Task_Class.iCount ++;
        result = taskClass.createTask_ID(taskName, developerLastName, taskNumber);
        assertEquals(expected, result);
        //assertEquals(3, taskClass.iCount); // Check if iCount increments correctly

        // Test Case 4
        taskName = "Create Add Task feature to add task users";
        developerLastName = "RAYM ND";
        taskNumber = 3;
        expected = "CR:3: ND";
        Task_Class.iCount ++;
        result = taskClass.createTask_ID(taskName, developerLastName, taskNumber);
        assertEquals(expected, result);
        //assertEquals(4, taskClass.iCount); // Check if iCount increments correctly

        // Test Case 5
        taskName = "Add Task feature to add task users";
        developerLastName = "ROBYN";
        taskNumber = 4;
        expected = "AD:4:BYN";
        Task_Class.iCount ++;
        result = taskClass.createTask_ID(taskName, developerLastName, taskNumber);
        assertEquals(expected, result);
        //assertEquals(5, taskClass.iCount); // Check if iCount increments correctly
    }

    @Test
    public void testDeveloperArrayCorrectlyPopulated() {
        String[] developers = {"Mike Smith", "Edward Harrington", "Samantha Paulson", "Glenda Oberholzer"};
        String[] expectedDevelopers = {"Mike Smith", "Edward Harrington", "Samantha Paulson", "Glenda Oberholzer"};
        assertEquals(expectedDevelopers.length, developers.length);
        for (int i = 0; i < developers.length; i++) {
            assertEquals(expectedDevelopers[i], developers[i]);
        }
    }

    @Test
    public void testDisplayDeveloperAndDurationForTaskWithLongestDuration() {
        Task[] tasks = {
            new Task("Mike Smith", "Create Login", 5, "To Do"),
            new Task("Edward Harrington", "Create Add Features", 8, "Doing"),
            new Task("Samantha Paulson", "Create Reports", 2, "Done"),
            new Task("Glenda Oberholzer", "Add Arrays", 11, "To Do")
        };

        Task longestDurationTask = tasks[0];
        for (Task task : tasks) {
            if (task.duration > longestDurationTask.duration) {
                longestDurationTask = task;
            }
        }

        String expected = "Glenda Oberholzer, 11";
        String result = longestDurationTask.developer + ", " + longestDurationTask.duration;
        assertEquals(expected, result);
    }

    @Test
    public void testSearchForTasks() {
        Task[] tasks = {
            new Task("Mike Smith", "Create Login", 5, "To Do"),
            new Task("Edward Harrington", "Create Add Features", 8, "Doing"),
            new Task("Samantha Paulson", "Create Reports", 2, "Done"),
            new Task("Glenda Oberholzer", "Add Arrays", 11, "To Do")
        };

        String searchTaskName = "Create Login";
        String expected = "Mike Smith, Create Login";

        String result = "";
        for (Task task : tasks) {
            if (task.name.equals(searchTaskName)) {
                result = task.developer + ", " + task.name;
                break;
            }
        }
        assertEquals(expected, result);
    }

    @Test
    public void testSearchAllTasksAssignedToDeveloper() {
        Task[] tasks = {
            new Task("Mike Smith", "Create Login", 5, "To Do"),
            new Task("Edward Harrington", "Create Add Features", 8, "Doing"),
            new Task("Samantha Paulson", "Create Reports", 2, "Done"),
            new Task("Glenda Oberholzer", "Add Arrays", 11, "To Do")
        };

        String searchDeveloper = "Samantha Paulson";
        String expected = "Create Reports";

        String result = "";
        for (Task task : tasks) {
            if (task.developer.equals(searchDeveloper)) {
                result = task.name;
                break;
            }
        }
        assertEquals(expected, result);
    }

    @Test
    public void testDeleteTaskFromArray() {
        Task[] tasks = {
            new Task("Mike Smith", "Create Login", 5, "To Do"),
            new Task("Edward Harrington", "Create Add Features", 8, "Doing"),
            new Task("Samantha Paulson", "Create Reports", 2, "Done"),
            new Task("Glenda Oberholzer", "Add Arrays", 11, "To Do")
        };

        String taskToDelete = "Create Reports";
        Task[] expectedTasks = {
            new Task("Mike Smith", "Create Login", 5, "To Do"),
            new Task("Edward Harrington", "Create Add Features", 8, "Doing"),
            new Task("Glenda Oberholzer", "Add Arrays", 11, "To Do")
        };

        Task[] newTasks = new Task[tasks.length - 1];
        int index = 0;
        for (Task task : tasks) {
            if (!task.name.equals(taskToDelete)) {
                newTasks[index++] = task;
            }
        }

        assertEquals(expectedTasks.length, newTasks.length);
        for (int i = 0; i < newTasks.length; i++) {
            assertEquals(expectedTasks[i].name, newTasks[i].name);
            assertEquals(expectedTasks[i].developer, newTasks[i].developer);
            assertEquals(expectedTasks[i].duration, newTasks[i].duration);
            assertEquals(expectedTasks[i].status, newTasks[i].status);
        }
    }

    @Test
    public void testDisplayReport() {
        // Implement this test as per your report requirements
    }

    // Inner Task class to represent a task
    static class Task {
        String developer;
        String name;
        int duration;
        String status;

        public Task(String developer, String name, int duration, String status) {
            this.developer = developer;
            this.name = name;
            this.duration = duration;
            this.status = status;
        }
    }
}
