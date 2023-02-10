package ru.sberbank.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.sberbank.data.Developer;

class DeveloperServiceTest {
    private DeveloperService service = new DeveloperService();
    @Test
    void createTest_successful() {
        Developer expected = new Developer(1, "Ivan", "Ivanov");

        Developer actual = service.create(1, "Ivan", "Ivanov");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void createTest_failValidation(){
        String expectedMessage = "Входные данные не валидны";

        Exception actualException = Assertions.assertThrows(
                IllegalStateException.class,
                () -> {
                    service.create(0, "", "");
                }
        );

        Assertions.assertEquals(actualException.getMessage(), expectedMessage);
    }


}