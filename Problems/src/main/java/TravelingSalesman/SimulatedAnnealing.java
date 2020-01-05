package TravelingSalesman;

import TravelingSalesman.objects.Tour;
import TravelingSalesman.objects.World;
import TravelingSalesman.utils.WorldUtils;
import java.io.File;
import java.net.URL;

public class SimulatedAnnealing {

  public SimulatedAnnealing() {}

  public Tour findShortestTour(World world, double temperature, double coolingRate) {
    Tour shortestTour = new Tour(world.getCities());
    Tour currentTour = shortestTour;
    while (temperature > 1) {
      Tour newTour = new Tour(currentTour.getTour());
      newTour.swapTwoRandomCities();
      if(acceptanceProbability(currentTour.getTourDistance(), newTour.getTourDistance(), temperature) > Math.random()) {
        currentTour = newTour;
      }
      if(currentTour.getTourDistance() < shortestTour.getTourDistance()) {
        shortestTour = currentTour;
      }

      temperature *= 1 - coolingRate;
    }
    return shortestTour;
  }

  private double acceptanceProbability(double currentEnergy, double newEnergy, double temperature) {
    // If the new solution is the better, take it.
    if(newEnergy < currentEnergy) {
      return 1;
    } else {
      // If temperature is high, then we could accept bad moves, if temperature is low then it is unlikely we'll accept a worse option.
      return Math.exp((currentEnergy - newEnergy) / temperature);
    }
  }

  public static void main(String [] args) {
    URL url = Thread.currentThread().getContextClassLoader().getResource("worlds/world01.xml");
    File file = new File(url.getPath());
    World world = WorldUtils.buildWorld(file);
    System.out.println(System.lineSeparator() + "Traveling Salesman world supplied: ");
    System.out.println(String.format("Total number of cities: %d", world.getCities().size()));
    SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing();
    Tour shortestTour = simulatedAnnealing.findShortestTour(world, 10000, 0.0003);
   shortestTour.printTour();
  }

}
