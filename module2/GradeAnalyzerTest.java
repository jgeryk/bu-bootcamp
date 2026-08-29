import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GradeAnalyzerTest {
    @Test
    void calculateAverage_returnsZero_whenListIsEmpty() {
        ArrayList<Integer> scores = new ArrayList<>();
        assertEquals(0.0, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    void calculateAverage_returnsCorrectAverage_forTypicalScores() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(80, 90, 100));
        assertEquals(90.0, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    void calculateAverage_returnsSingleValue_whenListHasOneItem() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(75));
        assertEquals(75.0, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    void calculateAverage_returnsDouble_notInteger() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(1, 2));
        assertEquals(1.5, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    void calculateAverage_handlesAllSameValues() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(88, 88, 88));
        assertEquals(88.0, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    void calculateAverage_returnsExactAverage_forTenScores() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50,
                60, 70, 80, 90, 100));
        assertEquals(55.0, GradeAnalyzer.calculateAverage(scores));
    }
}
