import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateTest {

    Calculadora calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculadora();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("TESTING THE MULTIPLY METHOD")
    void multiply() {
        assertEquals(100, calculator.multiply(10, 10));
        assertEquals(1200, calculator.multiply(30, 40));
        assertEquals(25, calculator.multiply(5, 5));
        assertEquals(24, calculator.multiply(3, 8));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("TESTING THE SUM METHOD")
    void sum() {
        assertEquals(20, calculator.sum(10, 10));
        assertEquals(2000, calculator.sum(1000, 1000));
        assertEquals(0, calculator.sum(5, -5));
        assertEquals(11, calculator.sum(3, 8));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("TESTING THE SUBTRACT METHOD")
    void subtract() {
        assertEquals(0, calculator.subtract(10, 10));
        assertEquals(70, calculator.subtract(30, -40));
        assertEquals(0, calculator.subtract(-5, -5));
        assertEquals(5, calculator.subtract(8, 3));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("TESTING THE DIVIDE METHOD")
    void divide() {
        assertEquals(1, calculator.divide(10, 10));
        assertEquals(-5, calculator.divide(10, -2));
        assertEquals(1, calculator.divide(-5, -5));
        assertEquals(3, calculator.divide(999, 333));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("TESTING THE SIMPLE INTEREST METHOD")
    void simpleInterest() {
        assertEquals(1000.0, calculator.simpleInterest(1000, 0.1, 10));
        assertEquals(2000.0, calculator.simpleInterest(1000, 0.2, 10));
        assertEquals(500.0, calculator.simpleInterest(500, 0.1, 10));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("TESTING THE COMPOUND INTEREST METHOD")
    void compoundInterest() {
        assertEquals(2593.7424601000025, calculator.compoundInterest(1000, 0.1, 10));
        assertEquals(6191.7364223999975, calculator.compoundInterest(1000, 0.2, 10));
        assertEquals(1296.8712300500013, calculator.compoundInterest(500, 0.1, 10));
    }

    @Test
    @DisplayName("TESTING THE RETURN ON CDI METHOD")
    void returnOnCDI() {
        try {
            String expectedMessage = "The return on your investment of: $100.0 was: $13.15";
            String actualMessage = calculator.returnOnCDI(100.0);

            assertEquals(expectedMessage, actualMessage);
        } catch (APIConn.APIException e) {
            fail("Expected exception: " + e.getMessage());
        }
    }
}
