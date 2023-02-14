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
    public void createTaskTest_successful() throws IllegalAccessException {
        Task expected = new Task(1, "Task");

        service.createTask(1, "Task");

        Assertions.assertEquals(service.getTasks().size(), 1);
        Assertions.assertEquals(expected, service.getTasks().get(0));
    }

    @Test
    public void getTasksForDeveloping_successful() throws IllegalAccessException {
        ArrayList<Task> expected = new ArrayList<>();
        Task task1 = new Task(1, "Task1");
        Task task2 = new Task(2, "Task2");
        task2.isDeveloped = true;

        expected.add(task1);
        expected.add(task2);

        service.setTasks(expected);

        ArrayList<Task> actual = service.getTasksForDeveloping();

        Assertions.assertEquals(actual.size(), 1);
        Assertions.assertEquals(actual.get(0), task1);
    }

}
