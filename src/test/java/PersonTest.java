import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    Person person;

    @BeforeEach
    public void person_객체생성() {
        person = new Person("Park", 12);
    }

    @Test
    public void person_테스트() {
        assertEquals("Park", person.getName());

        assertTrue(person.getName().equals("Park"));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Person("Park", 51));

        assertAll(
                () -> {
                    assertTimeout(Duration.ofMillis(100), () -> {
                        Thread.sleep(400);
                    });
                    System.out.println("assertTimeout 실행됨");
                },
                () -> {
                    assertEquals("Park", person.getName());
                    System.out.println("assertEquals 실행됨");
                },
                () -> {
                    assertFalse(person.getName().equals("Park"));
                    System.out.println("assertFalse 실행됨");
                }
        );
    }
}
