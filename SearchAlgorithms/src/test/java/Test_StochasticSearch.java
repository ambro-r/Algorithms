import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class Test_StochasticSearch {

  @Test
  public void test_stochasticSearch_MIN() throws Exception {
    assertThrows(Exception.class, () -> {
      StochasticSearch stochasticSearch = new StochasticSearch("x + y + z");
    });

    StochasticSearch stochasticSearch = new StochasticSearch("-1 * (x - 1) * (x - 1) + 2");
    assertEquals(-2, stochasticSearch.stochasticSearch_MIN(-1, 2, 10000));
  }

}
