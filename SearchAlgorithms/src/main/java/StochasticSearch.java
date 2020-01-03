import java.util.concurrent.ThreadLocalRandom;

public class StochasticSearch extends SearchFunction {

  public StochasticSearch(String function) throws Exception{
    super(function);
  }

  public double stochasticSearch(double startX, double endX, int iterations) {
    double min = function(startX);
    if ((startX < endX) && (iterations > 0)) {
      for (int i = 0; i < iterations; i++) {
        double randomX = ThreadLocalRandom.current().nextDouble(startX, endX);
        double value = function(randomX);
        if (value < min) {
          min = value;
        }
      }
    }
    return min;
  }

}
