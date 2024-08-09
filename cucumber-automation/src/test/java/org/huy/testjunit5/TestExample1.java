package org.huy.testjunit5;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class TestExample1 {
    static Logger log = Logger.getLogger(TestExample1.class.getName());

    static {
        log.setLevel(Level.ALL);
        log.info("Thread - " + Thread.currentThread().getName());
    }

    @BeforeAll
    static void setup() {
        log.info("Thread - " + Thread.currentThread().getName());
        log.info("@BeforeAll - executes once before all test methods in this class");
    }

    @AfterAll
    static void done() {
        log.info("Thread - " + Thread.currentThread().getName());
        log.info("@AfterAll - executed after all test methods.");
    }

    @BeforeEach
    void init() {
        log.info("Thread - " + Thread.currentThread().getName());
        log.info("@BeforeEach - executes before each test method in this class");
    }

    @DisplayName("Single test successful")
    @Test
    void testSingleSuccessTest() {
        log.info("Thread - " + Thread.currentThread().getName());
        log.info("Success");
    }

    @Test
    @Disabled("Not implemented yet")
    void testShowSomething() {
        log.info("Thread - " + Thread.currentThread().getName());
        log.info("testShowSomething");
    }

    @Test
    void lambdaExpressions() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        assertTrue(numbers.stream()
                .mapToInt(Integer::intValue)
                .sum() > 5, () -> "Sum should be greater than 5");
    }

    @Test
    void groupAssertions() {
        int[] numbers = {0, 1, 2, 3, 4};
        assertAll("numbers",
                () -> assertEquals(numbers[0], 1),
                () -> assertEquals(numbers[3], 3),
                () -> assertEquals(numbers[4], 1)
        );
    }

    @Test
    void trueAssumption() {
        assumeTrue(5 > 1);
        assertEquals(5 + 2, 7);
    }

    @Test
    void falseAssumption() {
        assumeFalse(5 < 1);
        assertEquals(5 + 2, 7);
    }

    @Test
    void assumptionThat() {
        String someString = "Just a string";
        assumingThat(
                someString.equals("Just a string"),
                () -> assertEquals(2 + 2, 4)
        );
    }

    @Test
    void shouldThrowException() {
        Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
            throw new UnsupportedOperationException("Not supported");
        });
        assertEquals("Not supported", exception.getMessage());
    }

    @Test
    void assertThrowsException() {
        String str = null;
        assertThrows(IllegalArgumentException.class, () -> {
            Integer.valueOf(str);
        });
    }

    @AfterEach
    void tearDown() {
        log.info("Thread - " + Thread.currentThread().getName());
        log.info("@AfterEach - executed after each test method.");
    }
}
