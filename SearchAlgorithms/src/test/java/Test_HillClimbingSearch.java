import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import objects.Range;
import org.junit.jupiter.api.Test;

public class Test_HillClimbingSearch {

  @Test
  public void test_hillClimbingSearch_MIN() {
    HillClimbingSearch  hillClimbingSearch = new HillClimbingSearch("-1 * (x - 1)^2 + 2");
    Range xRange = new Range("x", -10, 10);
    double max = hillClimbingSearch.hillClimbingSearch(xRange.getMin(), xRange.getMax(), 0.01, Boolean.TRUE);
    double min = hillClimbingSearch.hillClimbingSearch(xRange.getMin(), xRange.getMax(), 0.01, Boolean.FALSE);
    assertEquals(2.00, new BigDecimal(max).setScale(2, RoundingMode.HALF_UP).doubleValue());
    assertEquals(-119.00, new BigDecimal(min).setScale(2, RoundingMode.HALF_UP).doubleValue());
  }

}
