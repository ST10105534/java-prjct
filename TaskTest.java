import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    
    @Test
    public void testCheckTaskDescription_Success() {
        Task task = new Task("Login Feature", 1, "Create Login to authenticate users", "Robyn Harrison", 8, "", "To Do");
        assertTrue(task.checkTaskDescription(), "Task description should be valid (<= 50 characters).");
    }

    @Test
    public void testCheckTaskDescription_Failure() {
        Task task = new Task("Login Feature", 1, "This is a long description that exceeds the character limit of fifty.", "Robyn Harrison", 8, "", "To Do");
        assertFalse(task.checkTaskDescription(), "Task description should fail (exceeds 50 characters).");
    }

    @Test
    public void testCreateTaskID() {
        Task task = new Task("Login Feature", 1, "Create Login to authenticate users", "Robyn Harrison", 8, "", "To Do");
        String taskId = task.createTaskID();
        assertEquals("LO:1:SON", taskId, "The task ID should be generated correctly.");
    }

    @Test
    public void testPrintTaskDetails() {
        Task task = new Task("Login Feature", 1, "Create Login to authenticate users", "Robyn Harrison", 8, "LO:1:SON", "To Do");
        String expectedOutput = "Task Status: To Do\n" +
                                "Developer Details: Robyn Harrison\n" +
                                "Task Number: 1\n" +
                                "Task Name: Login Feature\n" +
                                "Task Description: Create Login to authenticate users\n" +
                                "Task ID: LO:1:SON\n" +
                                "Task Duration: 8 hours";
        assertEquals(expectedOutput, task.printTaskDetails(), "Task details should be printed correctly.");
    }

    @Test
    public void testReturnTotalHours() {
        Task[] tasks = {
            new Task("Login Feature", 1, "Create Login to authenticate users", "Robyn Harrison", 8, "LO:1:SON", "To Do"),
            new Task("Add Task Feature", 2, "Create Add Task feature to add task users", "Mike Smith", 10, "AD:2:TH", "Doing")
        };
        assertEquals(18, Task.returnTotalHours(tasks), "The total hours should be 18.");
    }
}