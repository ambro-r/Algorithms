import utils.Function;

public class HillClimbingSearch {

  private Function function;

  public HillClimbingSearch(String equation) throws Exception {
    function = new Function(equation);
  }

  public double hillClimbingSearch_MIN(double startX, double endX, double interval) {
    double max = function.function(startX);
    if ((startX < endX) && (interval < (endX - startX))) {
      double x = startX;
      while(Boolean.TRUE) {
        x += interval;
        double value = function.function(x);
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
