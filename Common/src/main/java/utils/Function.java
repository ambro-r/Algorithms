package utils;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Function {

  @Getter
  private String equation;

  private Function() {}

  public Function(String equation) {
    this.equation = equation.toLowerCase();
  }

  public double evaluate(double x) {
    HashMap<String, Double> variableMap = new HashMap<>();
    variableMap.put("x", x);
    return evaluate(variableMap);
  }

  public double evaluate(double x, double y) {
    HashMap<String, Double> variableMap = new HashMap<>();
    variableMap.put("x", x);
    variableMap.put("y", y);
    return evaluate(variableMap);
  }


  public double evaluate(HashMap<String, Double> variableMap) {
    String[] variables = new String[variableMap.size()];
    int counter = 0;
    for(Map.Entry<String, Double> entry : variableMap.entrySet()) {
      variables[counter] = entry.getKey();
      counter ++;
    }
    Expression expression = new ExpressionBuilder(equation)
        .variables(variables)
        .build();

    for(Map.Entry<String, Double> entry : variableMap.entrySet()) {
      expression.setVariable(entry.getKey(), entry.getValue().doubleValue());
    }
    return expression.evaluate();
  }


}
