package utils;

public class Math {

  public static double randomDouble(double min, double max) {
    return min + (max - min) * java.lang.Math.random();
  }

}
