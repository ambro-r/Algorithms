public class HillClimbingSearch extends Function {

  public HillClimbingSearch(String function) throws Exception{
    super(function);
  }

  public double hillClimbingSearch(double startX, double endX, double interval) {
    double max = function(startX);
    if ((startX < endX) && (interval < (endX - startX))) {
      double x = startX;
      while(Boolean.TRUE) {
        x += interval;
        double value = function(x);
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
