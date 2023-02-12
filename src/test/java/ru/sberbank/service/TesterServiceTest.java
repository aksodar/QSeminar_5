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
    public void create_successful(){
        Tester actual = service.create(1, "Peter", "Ivanov");

        Assertions.assertNotNull(actual);
        Assertions.assertEquals(1, actual.getId());
        Assertions.assertEquals(1, service.getListOfTesters().size());
    }

    @Test
    public void get_successful(){
        service.create(1, "Peter", "Ivanov");
        service.create(2, "Ivan", "Ivanov").setFree(true);

        Tester actual = service.get("Peter", "Ivanov");

        Assertions.assertNotNull(actual);
        Assertions.assertEquals(1, actual.getId());
        Assertions.assertEquals("Peter", actual.getFirstName());
    }

    @Test
    public void getListOfFree_successful(){
        ArrayList<Tester> expected;

        service.create(1, "Ivan", "Ivanov").setFree(true);
        service.create(2, "Peter", "Petrov").setFree(false);

        expected = service.getListOfFree();

        Assertions.assertEquals(expected.size(), 1);
        Assertions.assertEquals(expected.get(0), service.get("Ivan", "Ivanov"));
    }
}
