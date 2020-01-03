import objects.Range;
import utils.Function;

public class BruteForceSearch {

  private Function function;

  public BruteForceSearch(String equation) {
    function = new Function(equation);
  }

  public double bruteForceSearch(double startX, double endX, double interval, boolean max) {
    double result = function.evaluate(startX);
    int iterations = 0;
    if ((startX < endX) && (interval < (endX - startX))) {
      for (double x = startX + 1; x < endX; x += interval) {
        iterations ++;
        double output = function.evaluate(x);
        if (max && (output > result)) {
          result = output;
        } else if(!max && (output < result)) {
          result = output;
        }
      }
    }
    System.out.println(String.format("Iterations run: %d", iterations));
    return result;
  }

  public static void main(String [] args) {
    String equation = "2x^4 - 9x^3 - 21x^2 + 88x + 48";
    Range xRange = new Range("x", -100, 100);
    BruteForceSearch bruteForceSearch = new BruteForceSearch(equation);
    double max = bruteForceSearch.bruteForceSearch(xRange.getMin(), xRange.getMax(), 1, Boolean.TRUE);
    double min = bruteForceSearch.bruteForceSearch(xRange.getMin(), xRange.getMax(), 1, Boolean.FALSE);
    System.out.println(System.lineSeparator() + "f(x)=" + equation);
    System.out.println(String.format("Max for range %s with interval 1: %.2f", xRange.toString(), max));
    System.out.println(String.format("Min for range %s with interval 1: %.2f", xRange.toString(), min));
  }

}
