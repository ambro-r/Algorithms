import utils.Function;

public class BruteForceSearch {

  private Function function;

  public BruteForceSearch(String equation) throws  Exception {
    function = new Function(equation);
  }

  public double bruteForceSearch_MAX(double startX, double endX, double interval) {
    double max = -1;
    if ((startX < endX) && (interval < (endX - startX))) {
      for (double i = startX; i < endX; i += interval) {
        double value = function.function(i);
        if (value > max) {
          max = value;
        }
      }
    }
    return max;
  }

}
