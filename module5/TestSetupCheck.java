import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    void add_returnsSumOfTwoPositiveIntegers() {
        // Arrange
        int a = 3;
        int b = 4;

        // Act
        int result = Calculator.add(a, b);

        // Assert
        assertEquals(7, result);
    }
}
