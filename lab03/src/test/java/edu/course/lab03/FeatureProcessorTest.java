package edu.course.lab03;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class FeatureProcessorTest {
    @Test
    void processorShouldUseMinMaxStrategy() {
        FeatureProcessor processor =
                new FeatureProcessor(new MinMaxNormalization());

        double[] result = processor.process(
                new double[]{10, 20, 30}
        );

        assertArrayEquals(
                new double[]{0, 0.5, 1},
                result,
                0.000001
        );
    }

    @Test
    void processorShouldUseMeanCenteringStrategy() {
        FeatureProcessor processor =
                new FeatureProcessor(new MeanCenteringNormalization());

        double[] result = processor.process(
                new double[]{10, 20, 30}
        );

        assertArrayEquals(
                new double[]{-10, 0, 10},
                result,
                0.000001
        );
    }

    @Test
    void processorShouldAllowReplacingStrategy() {
        NormalizationStrategy firstStrategy =
                new MinMaxNormalization();

        NormalizationStrategy secondStrategy =
                new MeanCenteringNormalization();

        FeatureProcessor firstProcessor =
                new FeatureProcessor(firstStrategy);

        FeatureProcessor secondProcessor =
                new FeatureProcessor(secondStrategy);

        assertArrayEquals(
                new double[]{0, 0.5, 1},
                firstProcessor.process(new double[]{10, 20, 30}),
                0.000001
        );

        assertArrayEquals(
                new double[]{-10, 0, 10},
                secondProcessor.process(new double[]{10, 20, 30}),
                0.000001
        );
    }

    @Test
    void processorShouldNotModifyOriginalArray() {
        double[] values = {10, 20, 30};
        double[] original = values.clone();

        FeatureProcessor processor =
                new FeatureProcessor(new MinMaxNormalization());

        processor.process(values);

        assertArrayEquals(original, values);
    }
}
