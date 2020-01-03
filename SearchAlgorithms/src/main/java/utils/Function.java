package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Function {

  private String equation;

  private Function() {}

  public Function(String equation) throws Exception {
    /*
    Pattern pattern = Pattern.compile("[a-hj-uwz]+", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(equation);
    if(matcher.find()) {
      throw new Exception("Only functions with X or y variables supported for this implementation.");
    }
    */
    this.equation = equation.toLowerCase();
  }

  public double function(double x) {
    HashMap<String, Double> variableMap = new HashMap<>();
    variableMap.put("x", x);
    return function(variableMap);
  }

  public double function(double x, double y) {
    HashMap<String, Double> variableMap = new HashMap<>();
    variableMap.put("x", x);
    variableMap.put("y", y);
    return function(variableMap);
  }


  private double function(HashMap<String, Double> variableMap) {
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
