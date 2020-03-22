package Hopfield;

public class HopfieldNetwork {

    private double[][] weightMatrix;

    public HopfieldNetwork(int dimension) {
        this.weightMatrix = new double[dimension][dimension];
    }

    public void train(double[] pattern) {
        double[] bioPolarPatter = Pattern.toBiPolar(pattern);
        double[][] matrix = Matrix.outerProduct(bioPolarPatter);
        matrix = Matrix.clearDiagonals(matrix);
        this.weightMatrix = Matrix.addMatrix(weightMatrix, matrix);
    }

    public void recall(double[] pattern) {
        double[] bioPolarPatter = Pattern.toBiPolar(pattern);
        double[] result = Matrix.matrixVectorMultiplication(this.weightMatrix, bioPolarPatter);
        for(int i = 0; i < bioPolarPatter.length; i++) {
            result[i] = ActivationFunction.setFunction(result[i]);
        }

        boolean recognized = Boolean.TRUE;
        for(int i = 0; i < bioPolarPatter.length; i++) {
            if(bioPolarPatter[i] != result[i]) {
                recognized = Boolean.FALSE;
                break;
            }
        }

        if(recognized) {
            System.out.println("Pattern recognized...");
        } else {
            System.out.println("Pattern not recognized...");
        }

    }


}
