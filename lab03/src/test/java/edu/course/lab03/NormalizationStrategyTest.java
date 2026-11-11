package edu.course.lab03;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class NormalizationStrategyTest {
    @Test
    void minMaxShouldNormalizeValues() {
        NormalizationStrategy strategy = new MinMaxNormalization();

        double[] result = strategy.normalize(
                new double[]{10, 20, 30, 40, 50}
        );

        assertArrayEquals(
                new double[]{0, 0.25, 0.5, 0.75, 1},
                result,
                0.000001
        );
    }

    @Test
    void minMaxShouldReturnZerosForEqualValues() {
        NormalizationStrategy strategy = new MinMaxNormalization();

        double[] result = strategy.normalize(
                new double[]{5, 5, 5}
        );

        assertArrayEquals(
                new double[]{0, 0, 0},
                result,
                0.000001
        );
    }

    @Test
    void meanCenteringShouldSubtractMean() {
        NormalizationStrategy strategy =
                new MeanCenteringNormalization();

        double[] result = strategy.normalize(
                new double[]{10, 20, 30}
        );

        assertArrayEquals(
                new double[]{-10, 0, 10},
                result,
                0.000001
        );
    }

    @Test
    void meanCenteringShouldWorkWithNegativeValues() {
        NormalizationStrategy strategy =
                new MeanCenteringNormalization();

        double[] result = strategy.normalize(
                new double[]{-5, 0, 5}
        );

        assertArrayEquals(
                new double[]{-5, 0, 5},
                result,
                0.000001
        );
    }

    @Test
    void normalizationShouldNotChangeOriginalArray() {
        double[] values = {10, 20, 30};
        double[] original = values.clone();

        NormalizationStrategy strategy = new MinMaxNormalization();

        strategy.normalize(values);

        assertArrayEquals(original, values);
    }

    @Test
    void nullArrayShouldThrowException() {
        NormalizationStrategy strategy = new MinMaxNormalization();

        assertThrows(
                IllegalArgumentException.class,
                () -> strategy.normalize(null)
        );
    }
}
