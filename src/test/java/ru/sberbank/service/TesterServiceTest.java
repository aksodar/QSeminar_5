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
    void setUp(){
        this.service = new TesterService();
    }

    @AfterEach
    void tearDown(){
    }

    @Test
    public void createTesterTest_successful() throws IllegalAccessException {
        Tester expected = new Tester (1 , "Иван", "Иванов");
        service.create(1, "Иван", "Иванов");
        Assertions.assertEquals(service.getListOfTesters().size(),1);

    }

    @Test
    public void getTesterTest_successful() throws IllegalAccessException{
        Tester expected = new Tester (1 , "Иван", "Иванов");
        service.create(1, "Иван", "Иванов");
        service.get("Иван", "Иванов");
        Assertions.assertEquals(service.getListOfTesters().size(),1);
    }

    @Test
    public void getListOfFreeTest_successful(){
        ArrayList<Tester> expected = new ArrayList<>();
        Tester tester1 = new Tester (1, "Иван", "Иван");
        Tester tester2 = new Tester (2, "Ivan2", "Ivan3");
        tester1.setFree(true);
        tester2.setFree(false);

        expected = service.getListOfTesters();

        expected.add(tester1);
        expected.add(tester2);

        ArrayList<Tester> actual = service.getListOfFree();

        Assertions.assertEquals(actual.size(), 1);
        Assertions.assertEquals(actual.get(0), tester1);
    }
}