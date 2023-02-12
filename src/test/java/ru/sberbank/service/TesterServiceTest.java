package ru.sberbank.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sberbank.data.Tester;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TesterServiceTest {
    TesterService testerService;
    Tester expected;
    Tester actual;

    @BeforeEach
    void setUp() {
        expected = new Tester(1, "Damir", "Iskakov");
        testerService = new TesterService();
    }

    @Test
    void create_positive() {
        actual = testerService.create(1, "Damir", "Iskakov");
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void get_positive() {
        testerService.create(1, "Damir", "Iskakov");
        actual = testerService.get("Damir", "Iskakov");
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void getListOfFree_positive() {
        testerService.create(1, "Damir", "Iskakov");
        ArrayList<Tester> expectedList = new ArrayList<>();
        expectedList.add(expected);

        ArrayList<Tester> actualList = testerService.getListOfFree();

        assertNotNull(actualList);
        assertFalse(actualList.isEmpty());
        assertTrue(expected.isFree());
    }
}