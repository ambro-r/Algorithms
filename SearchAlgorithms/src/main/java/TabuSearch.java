import java.util.List;
import objects.Point;
import objects.Range;
import objects.TabuList;
import utils.FunctionUtils;

public class TabuSearch {

  private Point[][] points;
  private TabuList tabuList;

  public TabuSearch() {
    tabuList = new TabuList();
  }

  private Point getBestAdjacentState(List<Point> adjacentPoints, boolean max) {
    // Need to remove any adjacent points that are already present in the Tabu state list.
    adjacentPoints.removeAll(tabuList.getTabuItems());

    // If all adjacent points are in the Tabu state list, go to the middle
    if(adjacentPoints.size() == 0) {
      int row = points.length / 2;
      int col = points[row].length / 2;
      return points[row][col];
    }

    Point bestPointFound = null;
    for(Point point : adjacentPoints) {
      if(bestPointFound == null) {
        bestPointFound = point;
      } else if(max && (point.getF() > bestPointFound.getF())) {
        bestPointFound = point;
      } else if(!max && (point.getF() < bestPointFound.getF())) {
        bestPointFound = point;
      }
    }

    return bestPointFound;
  }

  public Point tabuSearch(Point[][] points, Point startingPoint, int iterations, boolean max) {
    this.points = points;
    Point bestPointFound = startingPoint;
    Point current = startingPoint;
    int iterationCounter = 0;
    while(iterationCounter < iterations) {
      Point bestAdjacentPoint = getBestAdjacentState(current.getAdjacentPoints(), max);
      if(max && (bestAdjacentPoint.getF() > bestPointFound.getF())) {
        bestPointFound = bestAdjacentPoint;
      } else if(!max && (bestAdjacentPoint.getF() < bestPointFound.getF())) {
        bestPointFound = bestAdjacentPoint;
      }
      tabuList.add(current);
      current = bestAdjacentPoint;
      iterationCounter ++;
    }
    return bestPointFound;
  }

  public static void main(String [] args) {
    String equation = "exp(-x * x - y * y) * sin(x)";

    Range xRange = new Range("x",-10, 10);
    Range yRange = new Range("y",-10, 10);
    Point[][] points = FunctionUtils.buildPointMap(equation, xRange, yRange, 0.1);
    int row = points.length / 2;
    int col = points[row].length / 2;

    TabuSearch tabuSearch = new TabuSearch();
    Point max = tabuSearch.tabuSearch(points, points[row][col], 400, Boolean.TRUE);
    Point min = tabuSearch.tabuSearch(points, points[row][col], 400, Boolean.FALSE);
    System.out.println(System.lineSeparator() + "f(x)=" + equation);
    System.out.println(String.format("Max for range %s & %s with 400 iterations: %s", xRange.toString(), yRange.toString(), max.toString()));
    System.out.println(String.format("Min for range %s & %s with 400 iterations: %s", xRange.toString(),yRange.toString(),  min.toString()));
  }

}
