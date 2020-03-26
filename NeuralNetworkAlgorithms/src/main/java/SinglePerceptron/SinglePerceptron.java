package SinglePerceptron;

import lombok.Getter;

import java.util.Arrays;

public class SinglePerceptron {

    @Getter
    private float[] weights;

    public SinglePerceptron() { }

    public void train(float[][] input, float[] output, float learningRate) {
        int numOfWeights = input[0].length;
        this.weights = new float[numOfWeights];
        for(int i = 0; i < weights.length; i++) weights[i] = 0;

        float totalError = 1; // 100% error at the beginning of training.
        while (totalError != 0) {
            totalError = 0;
            for(int i = 0; i < output.length; i++) {
                float calculatedOutput = calculateOutput(input[i]);
                float error = Math.abs(output[i] - calculatedOutput);
                totalError += error;
                for(int j = 0; j < numOfWeights; j++) {
                    weights[j] = weights[j] + learningRate * input[i][j] * error;
                }
            }
            System.out.println(String.format("Total error is %f, weights %s", totalError, Arrays.toString(weights)));
        }
    }

    public float calculateOutput(float[] input) {
        float sum = 0f;
        for(int i = 0; i < input.length; i++) {
            sum = sum + weights[i] * input[i];
        }
        return ActivationFunction.stepFunction(sum);
    }

}
