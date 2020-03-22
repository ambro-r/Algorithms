package Hopfield;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Test_Pattern {

    @Test
    public void test_toBiPolar() {
        double[] result = Pattern.toBiPolar(new double[] { 1, 0, 1, 0});
        assertArrayEquals(new double[] {1, -1, 1, -1}, result);
    }
}
