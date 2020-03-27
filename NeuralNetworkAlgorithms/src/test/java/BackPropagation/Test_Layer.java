package BackPropagation;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Test_Layer {

    private static float[] inputs = new float[] { 0.2f, 0.2f, 1 }; // Need to add the bias node of "1"
    private static float[] weights = new float[] { 0.01f, 0.05f, 0.10f }; // The bias node also has a weight of "0.10f"

    @Test
    public void test_runForwardPropagation() throws LayerException {
        assertThrows(LayerException.class, () -> {
            new Layer(2,1, new float[0]);
        });

        float expected = 0;
        for(int i = 0; i < inputs.length; i++) {
            expected += inputs[i] * weights[i];
        }
        expected = ActivationFunction.sigmoid(expected);
        Layer layer = new Layer(2,1, weights);
        assertEquals(expected,layer.runForwardPropagation(inputs)[0]);
    }

    @Test
    public void test_train() throws LayerException {
        Layer layer = new Layer(2,1, weights);
        float error = 1 - layer.runForwardPropagation(inputs)[0];
        float[] output = layer.train(new float[] { error }, 0.3f, 0.6f);
        float[] expected = new float[] { 0.00117638f, 0.0058819f, 0.0117638f };
        assertArrayEquals(expected, output);
    }

}
