package TravelingSalesman;

import static org.junit.jupiter.api.Assertions.*;

import TravelingSalesman.objects.Tour;
import TravelingSalesman.utils.WorldUtils;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import org.junit.jupiter.api.Test;

public class Test_SimulatedAnnealing {

  @Test
  public void test_findShortestTour() {
    URL url = Thread.currentThread().getContextClassLoader().getResource("worlds/testWorld.xml");
    File file = new File(url.getPath());

    SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing();
    Tour shortestTour = simulatedAnnealing.findShortestTour(WorldUtils.buildWorld(file), 10000, 0.003);

    assertEquals("A", shortestTour.getTour().get(0).getIdentifier());
    assertEquals("D", shortestTour.getTour().get(1).getIdentifier());
    assertEquals("B", shortestTour.getTour().get(2).getIdentifier());
    assertEquals("C", shortestTour.getTour().get(3).getIdentifier());
    assertEquals("E", shortestTour.getTour().get(4).getIdentifier());
    assertEquals(58.28, new BigDecimal(shortestTour.getTourDistance()).setScale(2, RoundingMode.HALF_UP).doubleValue());
  }

}
