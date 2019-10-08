import java.util.List;

/**
 * Class computing the Minkowski distance between two vectors.
 */
public class MinkowskiDistance implements DistanceMetric {

    private double power;

    public MinkowskiDistance(double power) {
        this.power = power;
    }

    public double compare(List<Double> vector1, List<Double> vector2) {
        double sum = 0.0;
        int numDimensions = Math.min(vector1.size(), vector2.size());

        for (int i = 0; i < numDimensions; i++) {
            sum += Math.pow(Math.abs(vector1.get(i) - vector2.get(i)), power);
        }

        return Math.pow(sum, 1.0 / power);
    }
}
