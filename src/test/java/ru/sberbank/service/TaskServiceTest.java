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
        //создаем окружение
        this.service = new TaskService();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    public void createTaskTest_successfull() throws IllegalAccessException {
        Task expected = new Task(1, "My task 1");

        service.createTask(1, "My task 1");

        Assertions.assertEquals(service.getTasks().size(), 1);

    }

    @Test
    public void getTasksForDevelopingTest_successful() {
        ArrayList<Task> expected = new ArrayList<>();

        Task task1 = new Task(1, "My task 1");
        Task task2 = new Task(2, "My task 2");

        task1.setDeveloped(false);
        task2.setDeveloped(true);

        expected.add(task1);
        expected.add(task2);

        service.setTasks(expected);

        ArrayList<Task> actual = service.getTasksForDeveloping();

        Assertions.assertEquals(actual.size(),1);
        Assertions.assertEquals(actual.get(0), task1);

    }
}