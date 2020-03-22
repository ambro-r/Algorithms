package Hopfield;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Test_ActivationFunction {

    @Test public void test_setFunction() {
        assertEquals(1, ActivationFunction.setFunction(0));
        assertEquals(-1, ActivationFunction.setFunction(-10));
        assertEquals(1, ActivationFunction.setFunction(10));
    }

}
