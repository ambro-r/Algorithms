package Hopfield;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class Test_HopfieldNetwork {

    private static final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private static final PrintStream originalStream = System.out;

    @BeforeAll
    public static void init() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterAll
    public static void destroy() {
        System.setOut(new PrintStream(originalStream));
    }

    @Test
    public void test_recall() {
        HopfieldNetwork hopfieldNetwork = new HopfieldNetwork(4);
        hopfieldNetwork.train(new double[] {1, 0, 1, 0});
        hopfieldNetwork.recall(new double[] {1, 0, 1, 0});
        assertEquals("Pattern recognized...", outputStream.toString().trim());
        outputStream.reset();
        hopfieldNetwork.recall(new double[] {1, 0, 1, 1});
        assertEquals("Pattern not recognized...", outputStream.toString().trim());
        outputStream.reset();
        hopfieldNetwork.recall(new double[] {0, 1, 0, 1});
        assertEquals("Pattern recognized...", outputStream.toString().trim());
        hopfieldNetwork.train(new double[] {1, 1, 1, 1});
        outputStream.reset();
        hopfieldNetwork.recall(new double[] {1, 0, 1, 0});
        assertEquals("Pattern recognized...", outputStream.toString().trim());
        outputStream.reset();
        hopfieldNetwork.recall(new double[] {1, 1, 1, 1});
        assertEquals("Pattern recognized...", outputStream.toString().trim());
        outputStream.reset();
        hopfieldNetwork.recall(new double[] {1, 0, 1, 1});
        assertEquals("Pattern not recognized...", outputStream.toString().trim());
    }
}
