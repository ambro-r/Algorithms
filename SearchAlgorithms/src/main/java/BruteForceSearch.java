import utils.Function;

public class BruteForceSearch {

  private Function function;

  public BruteForceSearch(String equation) {
    function = new Function(equation);
  }

  public double bruteForceSearch(double startX, double endX, double interval, boolean max) {
    double result = function.evaluate(startX);
    if ((startX < endX) && (interval < (endX - startX))) {
      for (double i = startX + 1; i < endX; i += interval) {
        double output = function.evaluate(i);
        if (max && (output > result)) {
          result = output;
        } else if(!max && (output < result)) {
          result = output;
        }
      }
    }
    return result;
  }

  public static void main(String [] args) {
    String equation = "-1 * (x - 1)^2 + 2";
    BruteForceSearch bruteForceSearch = new BruteForceSearch(equation);
    double max = bruteForceSearch.bruteForceSearch(-10, 10, 1, Boolean.TRUE);
    double min = bruteForceSearch.bruteForceSearch(-10, 10, 1, Boolean.FALSE);
    System.out.println(System.lineSeparator() + "f(x)=" + equation);
    System.out.println(String.format("Max for range -10 to 10 with interval 1: %.2f", max));
    System.out.println(String.format("Min for range -10 to 10 with interval 0.1: %.2f", min));
  }

}
