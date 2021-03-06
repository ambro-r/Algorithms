import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import objects.Point;
import objects.Range;
import org.junit.jupiter.api.Test;
import utils.FunctionUtils;

public class Test_TabuSearch {

  @Test
  public void test_tabuSearch() {
    TabuSearch tabuSearch = new TabuSearch();
    Range xRange = new Range("x",-10, 10);
    Range yRange = new Range("y",-10, 10);
    Point[][] points = FunctionUtils.buildPointMap("exp(-x*x-y*y) * sin(x)", xRange, yRange, 0.1);

    int row = points.length / 2;
    int col = points[row].length / 2;

    Point max = tabuSearch.tabuSearch(points, points[row][col], 400, Boolean.TRUE);
    assertEquals(0.7000, new BigDecimal(max.getX()).setScale(4, RoundingMode.HALF_UP).doubleValue());
    assertEquals(0.0000, new BigDecimal(max.getY()).setScale(4, RoundingMode.HALF_UP).doubleValue());
    assertEquals(0.3947, new BigDecimal(max.getF()).setScale(4, RoundingMode.HALF_UP).doubleValue());

    Point min = tabuSearch.tabuSearch(points, points[row][col], 400, Boolean.FALSE);
    assertEquals(-0.7000, new BigDecimal(min.getX()).setScale(4, RoundingMode.HALF_UP).doubleValue());
    assertEquals(0.0000, new BigDecimal(min.getY()).setScale(4, RoundingMode.HALF_UP).doubleValue());
    assertEquals(-0.3947, new BigDecimal(min.getF()).setScale(4, RoundingMode.HALF_UP).doubleValue());
  }
}
