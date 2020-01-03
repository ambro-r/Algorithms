import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class BruteForceSearch {

  private String function;

  private BruteForceSearch() {}

  public BruteForceSearch(String function) throws Exception{
    Pattern pattern = Pattern.compile("[a-hj-uwyz]+", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(function);
    if(matcher.find()) {
      throw new Exception("Only functions with X variables supported for this implementation.");
    }
    this.function = function.toLowerCase();
  }

  public double function(double x) {
    Expression expression = new ExpressionBuilder(function)
        .variables("x")
        .build()
        .setVariable("x", x);
    return expression.evaluate();
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
