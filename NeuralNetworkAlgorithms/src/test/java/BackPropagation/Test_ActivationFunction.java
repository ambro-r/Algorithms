package BackPropagation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Test_ActivationFunction {

    @Test
    public void test_sigmoid() {
        assertEquals(0.5, ActivationFunction.sigmoid(0));
        assertEquals(0.9933071732521057, ActivationFunction.sigmoid(5));
        assertEquals(0.006692850962281227, ActivationFunction.sigmoid(-5));
    }

    @Test
    public void test_derivativeSigmoid() {
        assertEquals(0.25, ActivationFunction.derivativeSigmoid(ActivationFunction.sigmoid(0)));
        assertEquals(0.0066480329260230064,ActivationFunction.derivativeSigmoid(ActivationFunction.sigmoid(5)));
        assertEquals(0.006648056674748659, ActivationFunction.derivativeSigmoid(ActivationFunction.sigmoid(-5)));
    }

}
