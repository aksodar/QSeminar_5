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
        this.service = new TesterService();

    }

    @AfterEach
    void tearDown() {

    }
    @Test
    public void createTest_successful() {
        Tester expected = new Tester (1, "Ivan", "Ivanov");
        Tester actual = service.create(1, "Ivan", "Ivanov");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void getTest_successful() throws IllegalAccessException {
        Tester expected = new Tester (1, "Ivan", "Ivanov");
        service.create(1, "Ivan", "Ivanov");

        Assertions.assertEquals(service.get("Ivan", "Ivanov"), expected);
    }

    @Test
    public void getListOfFree_successful() {
        ArrayList<Tester> expected = new ArrayList<>();
        Tester tester1 = new Tester (1, "Ivan", "Ivanov");
        Tester tester2 = new Tester (2, "Oleg", "Smirnov");
        tester2.setFree(true);
        // не понимаю, как сделать тестера свободным

        expected.add(tester1);
        expected.add(tester2);

        service.create(1, "Ivan", "Ivanov");
        service.create(2, "Oleg", "Smirnov");

        ArrayList<Tester> actual = service.getListOfFree();

        Assertions.assertEquals(actual.size(), 1);
        Assertions.assertEquals(actual.get(0), tester1);





    }


}
