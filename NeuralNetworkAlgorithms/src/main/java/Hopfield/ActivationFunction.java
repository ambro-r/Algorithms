package Hopfield;

public class ActivationFunction {

    public static int setFunction(double x) {
        if(x >= 0) return 1;
        return -1;
    }

}
