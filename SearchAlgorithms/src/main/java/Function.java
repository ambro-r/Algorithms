import java.util.HashMap;
import java.util.Map;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Function {

  private String function;

  private Function() {}

  public Function(String function) {
    this.function = function.toLowerCase();
  }

  protected double function(double x) {
    HashMap<String, Double> variableMap = new HashMap<>();
    variableMap.put("x", x);
    return function(variableMap);
  }

  protected double function(HashMap<String, Double> variableMap) {
    String[] variables = new String[variableMap.size()];
    int counter = 0;
    for(Map.Entry<String, Double> entry : variableMap.entrySet()) {
      variables[counter] = entry.getKey();
      counter ++;
    }
    Expression expression = new ExpressionBuilder(function)
        .variables(variables)
        .build();

    for(Map.Entry<String, Double> entry : variableMap.entrySet()) {
      expression.setVariable(entry.getKey(), entry.getValue().doubleValue());
    }
    return expression.evaluate();
  }


}
