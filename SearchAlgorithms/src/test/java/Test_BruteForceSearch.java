import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Test_BruteForceSearch {

  @Test
  public void test_bruteForceSearch()  {
    BruteForceSearch bruteForceSearch = new BruteForceSearch("(x + 1)^2");
    assertEquals(81, bruteForceSearch.bruteForceSearch(-10, 5, 1, Boolean.TRUE));
    assertEquals(0, bruteForceSearch.bruteForceSearch(-10, 5, 1, Boolean.FALSE));
  }

}
