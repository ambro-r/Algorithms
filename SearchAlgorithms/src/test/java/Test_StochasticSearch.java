import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import objects.Range;
import org.junit.jupiter.api.Test;

public class Test_StochasticSearch {

  @Test
  public void test_stochasticSearch() {
    StochasticSearch stochasticSearch = new StochasticSearch("-1 * (x - 1)^2 + 2");
    Range xRange = new Range("x", -10, 10);
    double max = stochasticSearch.stochasticSearch(xRange.getMin(), xRange.getMax(), 10000, Boolean.TRUE);
    double min = stochasticSearch.stochasticSearch(xRange.getMin(), xRange.getMax(), 10000, Boolean.FALSE);
    assertEquals(2.00, new BigDecimal(max).setScale(2, RoundingMode.HALF_UP).doubleValue());
    assertEquals(-119.00, new BigDecimal(min).setScale(2, RoundingMode.HALF_UP).doubleValue());
  }

}
