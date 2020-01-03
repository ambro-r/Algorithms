import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class Test_StochasticSearch {

  @Test
  public void test_bruteForceSearch() {
    StochasticSearch stochasticSearch = new StochasticSearch("-1 * (x - 1) * (x - 1) + 2");
    assertEquals(-2, stochasticSearch.stochasticSearch(-1, 2, 10000));
  }

}
