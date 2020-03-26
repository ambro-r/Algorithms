package BackPropagation;

public class ActivationFunction {

    public static float sigmoid(float x) {
        return (float) (1 / (1 + Math.exp(-x)));
    }

    public static float derivativeSigmoid(float sigmoid) {
        return sigmoid * (1 - sigmoid);
    }

}
