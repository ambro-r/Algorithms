import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class Test_HillClimbingSearch {

  @Test
  public void test_bruteForceSearch() {
    assertThrows(Exception.class, () -> {
      HillClimbingSearch  hillClimbingSearch = new HillClimbingSearch ("x + y");
    });

    try{
      HillClimbingSearch  hillClimbingSearch = new HillClimbingSearch("-(x - 1) * (x - 1) + 2");
      assertEquals(2, hillClimbingSearch.hillClimbingSearch(-1, 2, 0.01));
    } catch (Exception e) { }
  }

}