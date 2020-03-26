package SinglePerceptron;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Test_ActivationFunction {

    @Test
    public void test_stepFunction() {
        assertEquals(0, ActivationFunction.stepFunction(0));
        assertEquals(0, ActivationFunction.stepFunction(-10));
        assertEquals(1, ActivationFunction.stepFunction(10));
    }

}
