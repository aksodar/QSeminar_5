package ru.sberbank.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sberbank.data.Task;

import java.util.ArrayList;

public class TaskServiceTest {

    private TaskService service;

    @BeforeEach
    void setUp() {
        this.service = new TaskService();
    }

    @AfterEach
    void tearDown() {
        this.service = null;

    }

    @Test
    public void createTaskTest_successfil() throws IllegalAccessException {
        Task expected = new Task(1, "Task 1");
        service.createTask(1, "Task 1");
        Assertions.assertEquals(service.getTasks().size(), 1);

    }

    @Test
    public void getTasksForDevelopingTest_successfil() throws IllegalAccessException {
        ArrayList<Task> expected = new ArrayList<>();

        service.createTask(1, "Task1");
        service.createTask(2, "Task2");

        Task task1 = service.getTask("Task1");
        task1.isDeveloped = true;

        expected = service.getTasksForDeveloping();

        Assertions.assertEquals(expected.size(), 1);
        Assertions.assertEquals(task1, service.getTask("Task1"));

    }

}
