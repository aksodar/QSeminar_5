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
        // создаём окружение
        this.service = new TaskService();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    public void createTaskTest_successful() throws IllegalAccessException {
        Task expected = new Task(1, "test");
        service.createTask(1, "test");
        Assertions.assertEquals(service.getTasks().size(), 1);
        // зачем expected?
    }

    @Test
    public void getTasksForDeveloping_successful() {
        ArrayList<Task> expected = new ArrayList<>();
        Task task1 = new Task(1, "test1");
        Task task2 = new Task(2, "test2");
        task2.isDeveloped = true;

        expected.add(task1);
        expected.add(task2);

        ArrayList<Task> actual = service.getTasksForDeveloping();

        Assertions.assertEquals(actual.size(), 0);
        Assertions.assertEquals(expected.get(0), task1);

        Assertions.assertEquals(expected.size(), 2);
    }
}
