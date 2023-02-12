package ru.sberbank.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sberbank.data.Tester;

import java.util.ArrayList;

public class TesterServiceTest {
    private TesterService service;
    private int id_1, id_2;
    private String firstName_1, firstName_2;
    private String secondName_1, secondName_2;


    @BeforeEach
    void setUp() {
        this.service = new TesterService();

        this.id_1 = 1;
        this.firstName_1 = "Тестер";
        this.secondName_1 = "Прогеров";

        this.id_2 = 2;
        this.firstName_2 = "Кодер";
        this.secondName_2 = "Пакетов";

    }

    @AfterEach
    void tearDown() {
        this.service = null;
    }

    @Test
    public void createTest_successfull() {


        Tester expected = service.create(id_1, firstName_1, secondName_1);

        Assertions.assertNotNull(expected);
        Assertions.assertEquals(expected.getId(), id_1);
        Assertions.assertEquals(expected.getFirstName(), firstName_1);
        Assertions.assertEquals(expected.getSecondName(), secondName_1);

    }

    @Test
    public void getTest_successful() {
        service.create(id_1, firstName_1, secondName_1);
        service.create(id_2, firstName_2, secondName_2);

        Tester expected = service.get(firstName_1, secondName_1);

        Assertions.assertNotNull(expected);
        Assertions.assertEquals(expected.getId(), id_1);
        Assertions.assertEquals(expected.getFirstName(), firstName_1);
        Assertions.assertEquals(expected.getSecondName(), secondName_1);

    }

    @Test
    public void getListOfFreeTest_successful() {
        ArrayList<Tester> expected;

        service.create(id_1, firstName_1, secondName_1).setFree(true);
        service.create(id_2, firstName_2, secondName_2).setFree(false);

        expected = service.getListOfFree();

        Assertions.assertEquals(expected.size(), 1);
        Assertions.assertEquals(expected.get(0), service.get(firstName_1, secondName_1));


    }
}
