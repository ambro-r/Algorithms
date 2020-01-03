package utils;
import static org.junit.jupiter.api.Assertions.assertEquals;

import objects.Point;
import objects.Range;
import org.junit.jupiter.api.Test;

public class Test_FunctionUtils {

  @Test
  public void test_buildPointMap() throws Exception {
    Range xRange = new Range("x",-10, 10);
    Range yRange = new Range("y",-10, 10);
    Point[][] points = FunctionUtils.buildPointMap("x + y", xRange, yRange, 1);
    assertEquals(21, points.length);
    assertEquals(21, points[0].length);
    assertEquals(-10, points[0][0].getX());
    assertEquals(-10, points[0][0].getY());
    assertEquals(-10 + -10, points[0][0].getF());

    assertEquals(0, points[10][10].getX());
    assertEquals(0, points[10][10].getY());
    assertEquals(0, points[10][10].getF());

    assertEquals(10, points[20][20].getX());
    assertEquals(10, points[20][20].getY());
    assertEquals(10 + 10, points[20][20].getF());
  }

}
