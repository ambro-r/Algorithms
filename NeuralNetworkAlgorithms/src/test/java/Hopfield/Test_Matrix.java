package Hopfield;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Test_Matrix {

    private static double[][] matrix = new double[4][4];
    private static double[][] doubledMatrix = new double[4][4];

    @BeforeAll
    public static void init() {
        int value = 1;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = value;
                doubledMatrix[i][j] = value + value;
                value *= -1;
            }
            value *= -1;
        }
    }

    @Test
    public void test_createMatrix() {
        double[][] matrix = Matrix.createMatrix(2,3);
        assertEquals(2, matrix.length);
        assertEquals(3, matrix[0].length);
    }

    @Test
    public void test_clearDiagonals() {
        double[][] updatedMatrix = Matrix.clearDiagonals(matrix);
        for(int i = 0; i < updatedMatrix.length; i++) {
            assertEquals(0, matrix[i][i]);
        }
    }

    @Test
    public void test_matrixVectorMultiplication() {
        double[] result = Matrix.matrixVectorMultiplication(Matrix.clearDiagonals(matrix), new double[] { 1, 0, 1, 0 });
        assertArrayEquals(new double[] {1, -2, 1, -2}, result);
    }

    @Test
    public void test_outerProduct() {
        double[][] result = Matrix.outerProduct(new double[] { 1, -1, 1, -1 });
        assertArrayEquals(matrix, result);
    }

    @Test
    public void test_addMatrix() {
        double[][] result = Matrix.addMatrix(matrix, matrix);
        assertArrayEquals(doubledMatrix, result);
    }
}
