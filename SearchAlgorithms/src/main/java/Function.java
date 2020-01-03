import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Function {

  private String function;

  private Function() {}

  public Function(String function) throws Exception{
    Pattern pattern = Pattern.compile("[a-hj-uwyz]+", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(function);
    if(matcher.find()) {
      throw new Exception("Only functions with X variables supported for this implementation.");
    }
    this.function = function.toLowerCase();
  }

  protected double function(double x) {
    Expression expression = new ExpressionBuilder(function)
        .variables("x")
        .build()
        .setVariable("x", x);
    return expression.evaluate();
  }


}
