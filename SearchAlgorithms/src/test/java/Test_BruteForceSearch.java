import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import objects.Range;
import org.junit.jupiter.api.Test;

public class Test_BruteForceSearch {

  @Test
  public void test_bruteForceSearch()  {
    BruteForceSearch bruteForceSearch = new BruteForceSearch("(x + 1)^2");
    Range xRange = new Range("x", -10, 5);
    double max = bruteForceSearch.bruteForceSearch(xRange.getMin(), xRange.getMax(), 1, Boolean.TRUE);
    double min = bruteForceSearch.bruteForceSearch(xRange.getMin(), xRange.getMax(), 1, Boolean.FALSE);
    assertEquals(81, new BigDecimal(max).setScale(2, RoundingMode.HALF_UP).doubleValue());
    assertEquals(0, new BigDecimal(min).setScale(2, RoundingMode.HALF_UP).doubleValue());
  }

}
