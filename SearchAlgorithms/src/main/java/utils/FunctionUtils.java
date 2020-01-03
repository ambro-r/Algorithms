package utils;

import objects.Point;
import objects.Range;

public class FunctionUtils {

  public static Point[][] buildPointMap(String equation, Range xRange, Range yRange, double stepSize) {
    Function function = new Function(equation);
    int xResults = (int) Math.round((xRange.getMax() - xRange.getMin()) / stepSize) + 1;
    int yResults = (int) Math.round((yRange.getMax() - yRange.getMin()) / stepSize) + 1;
    Point[][] points = new Point[xResults][yResults];

    double x = xRange.getMin();
    for(int row = 0; row < xResults; row++) {
      double y = yRange.getMin();
      for(int col = 0; col < yResults; col++) {
        points[row][col] = new Point(x, y, function.evaluate(x, y));
        y += stepSize;
      }
      x += stepSize;
    }

    // Set Neighbours
    for(int row = 0; row < xResults; row++) {
      for(int col = 0; col < yResults; col++) {
        if((row - 1) >= 0)  {
          points[row][col].addAdjacentPoint(points[row - 1][col]);
        }
        if((row + 1) < xResults) {
          points[row][col].addAdjacentPoint(points[row + 1][col]);
        }
        if((col - 1) >= 0) {
          points[row][col].addAdjacentPoint(points[row][col - 1]);
        }
        if((col + 1) < yResults) {
          points[row][col].addAdjacentPoint(points[row][col + 1]);
        }
      }
    }
    return points;
  }

}
