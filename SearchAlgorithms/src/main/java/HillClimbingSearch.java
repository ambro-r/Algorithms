import utils.Function;

public class HillClimbingSearch {

  private Function function;

  public HillClimbingSearch(String equation) {
    function = new Function(equation);
  }

  public double hillClimbingSearch_MIN(double startX, double endX, double interval) {
    double max = function.evaluate(startX);
    if ((startX < endX) && (interval < (endX - startX))) {
      double x = startX;
      while(Boolean.TRUE) {
        x += interval;
        double value = function.evaluate(x);
        if(value > max) {
          max = value;
        } else {
          break;
        }
      }
    }
    return max;
  }

}
