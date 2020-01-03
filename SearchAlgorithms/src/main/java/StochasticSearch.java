import java.util.concurrent.ThreadLocalRandom;
import objects.Range;
import utils.Function;

public class StochasticSearch {

  private Function function;

  public StochasticSearch(String equation) {
    function = new Function(equation);
  }

  public double stochasticSearch(Range range, int iterations, boolean max) {
    double result  = function.evaluate(range.getMin());
    if ((range.getMin() < range.getMax()) && (iterations > 0)) {
      for (int i = 0; i < iterations; i++) {
        double randomX = ThreadLocalRandom.current().nextDouble(range.getMin(), range.getMax());
        double output = function.evaluate(randomX);
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
    Range xRange = new Range("x", -10, 10);
    StochasticSearch stochasticSearch = new StochasticSearch(equation);
    double max = stochasticSearch.stochasticSearch(xRange, 10, Boolean.TRUE);
    double min = stochasticSearch.stochasticSearch(xRange, 10, Boolean.FALSE);
    System.out.println(System.lineSeparator() + "f(x)=" + equation);
    System.out.println(String.format("Max for range %s with 10 iterations: %.2f", xRange.toString(), max));
    System.out.println(String.format("Min for range %s with 10 iterations: %.2f", xRange.toString(), min));
  }

}
