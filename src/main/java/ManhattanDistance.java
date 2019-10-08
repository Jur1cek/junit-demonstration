import java.util.List;

/**
 * Class computing the Manhattan distance between two vectors.
 */
public class ManhattanDistance implements DistanceMetric {

    public double compare(List<Double> vector1, List<Double> vector2) {
        double sum = 0.0;
        int numDimensions = Math.min(vector1.size(), vector2.size());

        for (int i = 0; i < numDimensions; i++) {
            sum += Math.abs(vector1.get(i) - vector2.get(i));
        }

        return sum;
    }
}
