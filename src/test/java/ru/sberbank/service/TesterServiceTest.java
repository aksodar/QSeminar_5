package ru.sberbank.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sberbank.data.Task;
import ru.sberbank.data.Tester;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TesterServiceTest {
    private TesterService service;

    @BeforeEach
    void setUp() {
        this.service = new TesterService();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void createTester_successful() throws IllegalStateException{
        Tester expected = new Tester(0, "Elena", "Polozova");

        service.create(0, "Elena", "Polozova");

        Assertions.assertEquals(service.getListOfTesters().size(), 1);
    }

    @Test
    void getTester_successful() throws IllegalStateException{
        Tester expected = new Tester(0, "Elena", "Polozova");

        Tester actual = service.create(0,"Elena", "Polozova");

        Assertions.assertEquals(expected, service.get("Elena", "Polozova"));
    }

    @Test
    void getListOfFreeTester_successful() {
        ArrayList<Tester> expected = new ArrayList<>();

        Tester tester1 = new Tester(0, "Elena", "Polozova");
        Tester tester2 = new Tester(1, "Ivan", "Ivanov");

        tester1.setFree(true);
        tester2.setFree(true);

        expected.add(tester1);
        expected.add(tester2);

        service.setTester(expected);

        ArrayList<Tester> actual = service.getListOfFree();

        Assertions.assertEquals(actual.size(), 2);
        Assertions.assertEquals(actual.get(0), tester1);

    }
}