import java.util.List;

/**
 * Interface for distance metrics allowing to compute the distance between two vectors.
 */
public interface DistanceMetric {
    /** Computes the distance between two vectors. */
    double compare(List<Double> vector1, List<Double> vector2);
}
