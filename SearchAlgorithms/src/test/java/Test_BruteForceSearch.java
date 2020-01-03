import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Test_BruteForceSearch {

  @Test
  public void test_bruteForceSearch() {
    assertThrows(Exception.class, () -> {
      BruteForceSearch bruteForceSearch = new BruteForceSearch("x + y");
    });

    try{
      BruteForceSearch bruteForceSearch = new BruteForceSearch("-1 * (x - 1) * (x - 1) + 2");
     assertEquals(2, bruteForceSearch.bruteForceSearch(-1, 2, 0.01));
    } catch (Exception e) { }
  }

}
