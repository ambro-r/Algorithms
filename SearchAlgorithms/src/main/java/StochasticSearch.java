import java.util.concurrent.ThreadLocalRandom;
import utils.Function;

public class StochasticSearch {

  private Function function;

  public StochasticSearch(String equation) throws  Exception {
    function = new Function(equation);
  }

  public double stochasticSearch_MIN(double startX, double endX, int iterations) {
    double min = function.function(startX);
    if ((startX < endX) && (iterations > 0)) {
      for (int i = 0; i < iterations; i++) {
        double randomX = ThreadLocalRandom.current().nextDouble(startX, endX);
        double value = function.function(randomX);
        if (value < min) {
          min = value;
        }
      }
    }
    return min;
  }

}
