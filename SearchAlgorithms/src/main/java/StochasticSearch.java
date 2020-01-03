import java.util.concurrent.ThreadLocalRandom;
import objects.Range;
import utils.Function;

public class StochasticSearch {

  private Function function;

  public StochasticSearch(String equation) {
    function = new Function(equation);
  }

  public double stochasticSearch(double startX, double endX, int iterations, boolean max) {
    double result  = function.evaluate(startX);
    if ((startX < endX) && (iterations > 0)) {
      for (int i = 0; i < iterations; i++) {
        double randomX = ThreadLocalRandom.current().nextDouble(startX, endX);
        double output = function.evaluate(randomX);
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
    Range xRange = new Range("x", -10, 10);
    StochasticSearch stochasticSearch = new StochasticSearch(equation);
    double max = stochasticSearch.stochasticSearch(xRange.getMin(), xRange.getMax(), 10, Boolean.TRUE);
    double min = stochasticSearch.stochasticSearch(xRange.getMin(), xRange.getMax(), 10, Boolean.FALSE);
    System.out.println(System.lineSeparator() + "f(x)=" + equation);
    System.out.println(String.format("Max for range %s with 10 iterations: %.2f", xRange.toString(), max));
    System.out.println(String.format("Min for range %s with 10 iterations: %.2f", xRange.toString(), min));
  }

}
