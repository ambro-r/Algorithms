package SinglePerceptron;

public class ActivationFunction {

    public static int stepFunction(float x) {
        if(x >= 1) return 1;
        return 0;
    }

}
