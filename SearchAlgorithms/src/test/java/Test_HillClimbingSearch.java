import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class Test_HillClimbingSearch {

  @Test
  public void test_hillClimbingSearch_MIN() throws Exception {
    assertThrows(Exception.class, () -> {
      HillClimbingSearch  hillClimbingSearch = new HillClimbingSearch ("x + y + z");
    });

    HillClimbingSearch  hillClimbingSearch = new HillClimbingSearch("-(x - 1) * (x - 1) + 2");
    assertEquals(2, hillClimbingSearch.hillClimbingSearch_MIN(-1, 2, 0.01));
  }

}
