package utils;

public class Math {

  public static double randomDouble(double min, double max) {
    return min + (max - min) * java.lang.Math.random();
  }

  public static double random() {
    return java.lang.Math.random();
  }

}
