package SinglePerceptron;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Test_SinglePerceptron {

    private float[][] input = { {0,0}, {0,1}, {1,0}, {1,1} };
    private float[] output = { 0,0,0,1 }; // Logical AND Function output for the given input

    @Test
    public void test_train() {
        SinglePerceptron singlePerceptron = new SinglePerceptron();
        singlePerceptron.train(input, output, 0.1f);
        assertArrayEquals(new float[] { 0.5f, 0.5f}, singlePerceptron.getWeights());
    }

    @Test
    public void test_calculateOutput() {
        SinglePerceptron singlePerceptron = new SinglePerceptron();
        singlePerceptron.train(input, output, 0.1f);
        assertEquals(0, singlePerceptron.calculateOutput(new float[]{0,0}));
        assertEquals(0, singlePerceptron.calculateOutput(new float[]{0,1}));
        assertEquals(0, singlePerceptron.calculateOutput(new float[]{1,0}));
        assertEquals(1, singlePerceptron.calculateOutput(new float[]{1,1}));
    }

}
