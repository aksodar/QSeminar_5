package ru.sberbank.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sberbank.data.Tester;

import java.util.ArrayList;

public class TesterServiceTest {

    private TesterService service;

    @BeforeEach
    void setUp() {
        //создаем окружение
        this.service = new TesterService();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    public void createTesterTest_successful() throws IllegalAccessException {
        Tester expected = new Tester(1, "Ivan", "Ivanov");

        service.create(1, "Ivan", "Ivanov");

        Assertions.assertEquals(service.getListOfTesters().size(), 1);
        Assertions.assertEquals(expected, service.getListOfTesters().get(0));
    }

    @Test
    public void getTesterTest_successful() throws IllegalAccessException {
        Tester expected = new Tester(1, "Ivan", "Ivanov");

        service.create(1, "Ivan", "Ivanov");

        Assertions.assertEquals(expected, service.get("Ivan", "Ivanov"));

    }

    @Test
    public void getListOfFreeTest_successful() throws IllegalAccessException {
        ArrayList<Tester> expected = new ArrayList<>();
        Tester tester1 = new Tester(1, "Ivan", "Ivanov");
        Tester tester2 = new Tester(2, "Petr", "Petrov");
        tester1.setFree(true);
        tester2.setFree(false);

        expected.add(tester1);
        expected.add(tester2);

        service.setTester(expected);

        Assertions.assertEquals(service.getListOfFree().size(), 1);
        Assertions.assertEquals(service.getListOfFree().get(0), tester1);
    }
}