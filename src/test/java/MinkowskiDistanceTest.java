import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinkowskiDistanceTest {

    @ParameterizedTest
    @MethodSource("compareParams")
    void compare(List<Double> vector1, List<Double> vector2, double power, double expectedDistance) {
        DistanceMetric minkowskiDistance = new MinkowskiDistance(power);
        assertEquals(expectedDistance, minkowskiDistance.compare(vector1, vector2), 0.01);
    }

    static Stream<Arguments> compareParams() {
        return Stream.of(
            arguments(Arrays.asList(1.0, 3.0), Arrays.asList(4.0, 7.0), 1, 7.0),
            arguments(Arrays.asList(1.0, 3.0), Arrays.asList(4.0, 7.0), 2, 5.0)
        );
    }

    @Test
    void compare_FirstVectorIsNull_ThrowsException() {
        assertThrows(NullPointerException.class, () -> {
            new MinkowskiDistance(1).compare(null, Arrays.asList(4.0, 7.0));
        });
    }

    @Test
    void compare_SecondVectorIsNull_ThrowsException() {
        assertThrows(NullPointerException.class, () -> {
            new MinkowskiDistance(1).compare(Arrays.asList(4.0, 7.0), null);
        });
    }
}
