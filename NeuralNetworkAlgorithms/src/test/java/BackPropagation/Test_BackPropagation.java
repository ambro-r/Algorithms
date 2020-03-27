package BackPropagation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Test_BackPropagation {

    private static final float LEARNING_RATE = 0.3f;
    private static final float MOMENTUM = 0.6f;
    private static final int ITERATIONS = 10000;

    float[][] logicalOperatorInput = new float[][] { {0,0}, {0,1}, {1,0}, {1,1} };
    float[] andOutput = new float[] { 0,0,0,1 };
    float[] orOutput = new float[] { 0,1,1,1 };
    float[] xorOutput = new float[] { 0,1,1,0 };

    float[][] circleClustersInput = new float[][] {
            { 0.1f, 0.2f },  { 0.3f, 0.2f }, { 0.15f, 0.58f }, { 0.45f, 0.7f }, { 0.4f, 0.9f }, // Yellow circles -> (1,0,0)
            { 0.4f, 1.2f }, { 0.45f, 0.95f }, { 0.42f, 1f }, { 0.5f, 1.1f }, { 0.52f, 1.45f },  // Green circles -> (0,1,0)
            { 0.6f, 0.2f }, { 0.75f, 0.7f }, { 0.9f, 0.34f }, { 0.85f, 0.76f }, { 0.8f, 0.34f } // Blue circles -> (0,0,1)
    };

    float[][] circleClusterOutput = new float[][] {
            { 1,0,0 }, { 1,0,0 }, { 1,0,0 }, { 1,0,0 }, { 1,0,0 }, // Yellow circles -> (1,0,0)
            { 0,1,0 }, { 0,1,0 }, { 0,1,0 }, { 0,1,0 }, { 0,1,0 }, // Green circles -> (0,1,0)
            { 0,0,1 }, { 0,0,1 }, { 0,0,1 }, { 0,0,1 }, { 0,0,1 }  // Blue circles -> (0,0,1)
    };

    @Test
    public void test_train() {
        testLogicalOperators(andOutput);
        testLogicalOperators(orOutput);
        testLogicalOperators(xorOutput);
        testCircleClusters();
    }

    private void testLogicalOperators(float[] expected) {
        BackPropagation backPropagation = new BackPropagation(2, 3, 1);
        float[][] expectedOutput = new float[expected.length][1];
        for (int i = 0; i < expectedOutput.length; i++) {
            expectedOutput[i] = new float[]{ expected[i] };
        }
        backPropagation.train(logicalOperatorInput, expectedOutput , LEARNING_RATE, MOMENTUM, ITERATIONS);

        for(int i = 0; i < expected.length; i++) {
            float[] output = backPropagation.run(logicalOperatorInput[i]);
            assertEquals(expected[i], Math.round(output[0]));
        }
    }

    private void testCircleClusters() {
        BackPropagation backPropagation = new BackPropagation(2, 4, 3);
        backPropagation.train(circleClustersInput, circleClusterOutput, LEARNING_RATE, MOMENTUM, ITERATIONS);
        float[] output = backPropagation.run(new float[] { 1.0f, 0.5f }); // A circle in the blue cluster
        assertEquals(0, Math.round(output[0]));
        assertEquals(0, Math.round(output[1]));
        assertEquals(1, Math.round(output[2]));
        output = backPropagation.run(new float[] { 0.4f, 0.5f }); // A circle in the yellow cluster
        assertEquals(1, Math.round(output[0]));
        assertEquals(0, Math.round(output[1]));
        assertEquals(0, Math.round(output[2]));
        output = backPropagation.run(new float[] { 0.8f, 1.2f }); // A circle in the green cluster
        assertEquals(0, Math.round(output[0]));
        assertEquals(1, Math.round(output[1]));
        assertEquals(0, Math.round(output[2]));
    }

}
