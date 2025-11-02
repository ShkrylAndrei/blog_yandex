package info.shkryl.unitTest.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("Сложение двух положительных чисел")
    void shouldAddTwoPositiveNumbers() {
        // when
        int result = calculator.add(2, 3);

        // then
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Вычитание: 5 - 3 = 2")
    void shouldSubtractCorrectly() {
        int result = calculator.subtract(5, 3);
        assertEquals(2, result);
    }

    @Test
    @DisplayName("Деление на ноль должно выбрасывать исключение")
    void shouldThrowExceptionWhenDividingByZero() {
        // then
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
    }

    @Test
    @DisplayName("Деление 10 / 4 = 2.5")
    void shouldDivideCorrectly() {
        double result = calculator.divide(10, 4);
        assertEquals(2.5, result, 0.001); // delta для сравнения double
    }
}