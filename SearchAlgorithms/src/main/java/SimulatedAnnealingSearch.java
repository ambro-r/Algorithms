import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import objects.Range;
import utils.Function;
import utils.Math;

public class SimulatedAnnealingSearch {

  private Function function;

  public SimulatedAnnealingSearch(String equation) {
    function = new Function(equation);
  }

  public double simulatedAnnealingSearch(double startX, double endX, double minTemp, double maxTemp, double coolingRate, boolean max) {
    double temperature = maxTemp;
    double currentX = startX;
    double nextX;
    double bestX = startX;
    List<Double> temperatureTracking = new ArrayList<>();
    while (temperature > minTemp) {
      nextX = Math.randomDouble(startX, endX);
      if(acceptanceProbability(function.evaluate(currentX), function.evaluate(nextX), temperature) > Math.random()) {
        currentX = nextX;
      }
      if(max && (function.evaluate(currentX) > function.evaluate(bestX))) {
        bestX = currentX;
      } else if(!max && (function.evaluate(currentX) < function.evaluate(bestX))) {
        bestX = currentX;
      }
      temperature *= 1 - coolingRate;
      temperatureTracking.add(temperature);
    }
    System.out.println(String.format("Cooling rate: %.2f", coolingRate));
    System.out.print("Temperatures: ");
    temperatureTracking.stream().forEach(e -> System.out.print(String.format("%.2f ", e)));
    System.out.println(System.lineSeparator());
    return function.evaluate(bestX);
  }

  private double acceptanceProbability(double currentFX, double newFX, double temperature) {
    // If the new
    if(newFX < currentFX) {
      return 1;
    } else {
      // If temperature is high, then we could accept bad moves, if temperature is low then it is unlikely we'll accept a worse option.
      return java.lang.Math.exp((currentFX - newFX) / temperature);
    }
  }

  public static void main(String [] args) {
    String equation = "(x - 0.3)^3 - 5 * x + x * x - 2";
    Range xRange = new Range("x", -2, 2);
    Range tempRange = new Range("x", 1, 100);
    SimulatedAnnealingSearch simulatedAnnealingSearch = new SimulatedAnnealingSearch(equation);
    double max = simulatedAnnealingSearch.simulatedAnnealingSearch(xRange.getMin(), xRange.getMax(), tempRange.getMin(), tempRange.getMax(), 0.02, Boolean.TRUE);
    double min = simulatedAnnealingSearch.simulatedAnnealingSearch(xRange.getMin(), xRange.getMax(), tempRange.getMin(), tempRange.getMax(), 0.02, Boolean.FALSE);
    System.out.println(System.lineSeparator() + "f(x)=" + equation);
    System.out.println(String.format("Max for range %s with temperature range %s: %.4f", xRange.toString(), tempRange.toString(), max));
    System.out.println(String.format("Min for range %s with temperature range %s: %.4f", xRange.toString(), tempRange.toString(), min));
  }

}
