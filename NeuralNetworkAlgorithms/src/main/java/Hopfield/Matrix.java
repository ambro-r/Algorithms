package Hopfield;

public class Matrix {

    public static double[] matrixVectorMultiplication(double[][] matrix, double[] vector) {
        double[] result = new double[vector.length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
        }
        return result;
    }

    public static double[][] createMatrix(int numOfRows, int numOfCols) {
        return new double[numOfRows][numOfCols];
    }

    public static double[][] outerProduct(double[] vector) {
        double[][] result = createMatrix(vector.length, vector.length);
        for(int i = 0; i < vector.length; i++) {
            for(int j = 0; j < vector.length; j++) {
                result[i][j] = vector[i] * vector[j];
            }
        }
        return result;
    }

    public static double[][] clearDiagonals(double[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 0;
        }
        return matrix;
    }

    public static double[][] addMatrix(double[][] matrix01, double[][] matrix02) {
        double[][] result = createMatrix(matrix01.length, matrix01.length);
        for(int i = 0; i < matrix01.length; i++) {
            for(int j = 0; j < matrix01.length; j++) {
                result[i][j] = matrix01[i][j] + matrix02[i][j];
            }
        }
        return result;
    }

}
