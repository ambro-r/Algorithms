public class BruteForceSearch extends Function {

  public BruteForceSearch(String function) throws  Exception {
    super(function);
  }

  public double bruteForceSearch(double startX, double endX, double interval) {
    double max = -1;
    if ((startX < endX) && (interval < (endX - startX))) {
      for (double i = startX; i < endX; i += interval) {
        double value = function(i);
        if (value > max) {
          max = value;
        }
      }
    }
    return max;
  }

}
