import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinkowskiDistanceTest {

    @ParameterizedTest
    @MethodSource("compareParams")
    void compare(List<Double> vector1, List<Double> vector2, double power, double expectedDistance) {
        DistanceMetric minkowskiDistance = new MinkowskiDistance(power);
        assertEquals(expectedDistance, minkowskiDistance.compare(vector1, vector2));
    }

    static Stream<Arguments> compareParams() {
        return Stream.of(
            arguments(Arrays.asList(1.0, 3.0), Arrays.asList(4.0, 7.0), 1, 7.0)
        );
    }
}
