

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class Test_BruteForceSearch {

  @Test
  public void test_bruteForceSearch_MAX() throws Exception {
    assertThrows(Exception.class, () -> {
      BruteForceSearch bruteForceSearch = new BruteForceSearch("x + y + z");
    });

    BruteForceSearch bruteForceSearch = new BruteForceSearch("-1 * (x - 1) * (x - 1) + 2");
    assertEquals(2, bruteForceSearch.bruteForceSearch_MAX(-1, 2, 0.01));
  }

}
