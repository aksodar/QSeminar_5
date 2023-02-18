package ru.sberbank.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sberbank.data.Task;
import ru.sberbank.data.Tester;

import java.util.ArrayList;

public class TesterServiceTest {
    private TesterService service;

    @BeforeEach
    void setUp() {
        // создаем окружение, которое будет использоваться каждый раз для каждого теста
        this.service = new TesterService();
    }

    @AfterEach
    void tearDown() {
        // очищение
    }

    @Test
    public void createTesterTest_successful() throws IllegalAccessException {
        Tester expected = new Tester(1, "Иван", "Иванов");
        service.create(1, "Иван", "Иванов");
        Assertions.assertEquals(service.getListOfTesters().size(), 1);
        Assertions.assertEquals(expected, service.getListOfTesters().get(0));
    }
    @Test
    public void getTesterTest_successful() throws IllegalStateException{
        Tester expected = new Tester(1, "Иван", "Иванов");
        service.create(1, "Иван", "Иванов");
        Assertions.assertEquals(expected, service.get("Иван", "Иванов"));
    }

    @Test
    public void getListOfFreeTest_successful(){
        ArrayList<Tester> expected = new ArrayList<>();
        Tester tester1 = new Tester(1, "Иван", "Иванов");
        Tester tester2 = new Tester(2, "Иван2", "Иванов2");
        tester1.setFree(true);
        tester2.setFree(false);

        expected.add(tester1);
        expected.add(tester2);

        service.setTester(expected);
        Assertions.assertEquals(service.getListOfFree().size(), 1);
        Assertions.assertEquals(service.getListOfFree().get(0), tester1);
    }
}

