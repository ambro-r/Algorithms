package BackPropagation;

public class BackPropagation {

    private Layer[] layers;

    public BackPropagation(int inputSize, int hiddenSize, int outputSize) {
        layers = new Layer[2];
        layers[0] = new Layer(inputSize, hiddenSize);
        layers[1] = new Layer(hiddenSize, outputSize);
    }

    public Layer getLayer(int index) {
        return layers[index];
    }

    public float[] run(float[] input) {
        float[] activations = input;
        for(int i = 0; i < layers.length; i++) {
            activations = layers[i].run(activations);
        }
        return activations;
    }

    public void train(float[][] input, float[][] output, float learningRate, float momentum, int iterations) {
        for(int iteration = 0; iteration < iterations; iteration++) {
            for(int i = 0; i < input.length; i++) {
             train(input[i],  output[i] , learningRate, momentum);
            }
        }
    }

    private void train(float[] input, float[] output, float learningRate, float momentum) {
        float[] calculatedOutput = run(input);
        float[] error = new float[calculatedOutput.length];
        for (int i = 0; i < error.length; i++) {
            error[i] = output[i] - calculatedOutput[i];
        }
        for (int i = layers.length - 1; i >= 0; i--) {
            error = layers[i].train(error, learningRate, momentum);
        }
    }


}
