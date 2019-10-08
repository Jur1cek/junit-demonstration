import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ManhattanDistanceTest {

    @Test
    void compare_ManhattanDistance() {
        // Arrange
        DistanceMetric distance = new ManhattanDistance();
        List<Double> vector1 = Arrays.asList(1.0, 3.0);
        List<Double> vector2 = Arrays.asList(4.0, 7.0);

        // Act
        double actualDistance = distance.compare(vector1, vector2);

        // Assert
        assertEquals(7.0, actualDistance);
    }
}
