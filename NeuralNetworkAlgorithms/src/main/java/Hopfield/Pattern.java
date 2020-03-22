package Hopfield;


public class Pattern {

    public static double[] toBiPolar(double [] pattern) {
        for(int i = 0; i < pattern.length; i++) {
            if(pattern[i] == 0) {
                pattern[i] = -1;
            }
        }
        return pattern;
    }

}
