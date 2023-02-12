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
    }

    @Test
    public void createTaskTest_successful() throws IllegalAccessException {
        Task expected = new Task(1, "newTask");
        service.createTask(1, "NewTask");

        Assertions.assertEquals(service.getTasks().size(), 1);
    }

    @Test
    public void getTaskForDeveloping_successful(){
        ArrayList<Task> expected = new ArrayList<>();
        Task task1 = new Task (1, "task1");
        Task task2 = new Task (2, "task2");
        task2.isDeveloped = true;

        expected.add(task1);
        expected.add(task2);

        service.setTasks(expected);
        // подготовили окружение (добавили значение для воспроизведения логики метода)


        ArrayList<Task> actual = service.getTasksForDeveloping();

        Assertions.assertEquals(actual.size(), 1);
        Assertions.assertEquals(actual.get(0), task1);
    }

}
