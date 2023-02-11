package ru.sberbank.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sberbank.data.Task;
import ru.sberbank.data.Tester;


public class TesterServiceTest {
    private TesterService testerService;


    @BeforeEach
    void setUp() {
        // создаём окружение
        this.testerService = new TesterService();
    }

    // create
    @Test
    public void createTesterServiceTest_successful() {
        testerService.create(1, "one", "two");
        Assertions.assertEquals(testerService.getListOfTesters().size(), 1);
    }

    // get
    @Test
    public void getTesterServiceTest_successful() {
        testerService.create(1, "one", "two");
        Assertions.assertNotNull(testerService.get("one", "two"));
    }

    // getListOfFree
    @Test
    public void getListOfFreeTesterServiceTest_successful() {
        testerService.create(1, "one", "two");
        Assertions.assertEquals(testerService.getListOfFree().size(), 1);
    }
}
