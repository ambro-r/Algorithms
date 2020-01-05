import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import objects.Range;
import org.junit.jupiter.api.Test;

public class Test_SimulatedAnnealingSearch {

  @Test
  public void test_simulatedAnnealingSearch()  {
    SimulatedAnnealingSearch  simulatedAnnealingSearch = new SimulatedAnnealingSearch("-1 * (x - 1)^2 + 2");
    Range xRange = new Range("x", -10, 10);
    Range tempRange = new Range("temp", 1, 100);
    double max = simulatedAnnealingSearch.simulatedAnnealingSearch(xRange.getMin(), xRange.getMax(), tempRange.getMin(), tempRange.getMax(), 0.01, Boolean.TRUE);
    double min = simulatedAnnealingSearch.simulatedAnnealingSearch(xRange.getMin(), xRange.getMax(), tempRange.getMin(), tempRange.getMax(), 0.01, Boolean.FALSE);
    assertEquals(2.00, new BigDecimal(max).setScale(2, RoundingMode.HALF_UP).doubleValue());
    assertEquals(-119.00, new BigDecimal(min).setScale(2, RoundingMode.HALF_UP).doubleValue());
  }

}
