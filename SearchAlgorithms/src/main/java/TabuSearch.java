import java.util.List;
import objects.Point;
import objects.TabuList;

public class TabuSearch {

  private Point[][] points;
  private TabuList tabuList;

  public TabuSearch() {
    tabuList = new TabuList();
  }

  private Point getBestAdjacentState_MIN(List<Point> adjacentPoints) {
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
      if((bestPointFound == null) || (point.getF() < bestPointFound.getF())) {
        bestPointFound = point;
      }
    }

    return bestPointFound;
  }

  public Point tabuSearch_Min(
      Point[][] points, Point point, int iterations) {
    this.points = points;
    Point bestPointFound = point;
    int iterationCounter = 0;
    while(iterationCounter < iterations) {
      Point bestAdjacentPoint = getBestAdjacentState_MIN(point.getAdjacentPoints());
      if(bestAdjacentPoint.getF() < bestPointFound.getF()) {
        bestPointFound = bestAdjacentPoint;
      }
      tabuList.add(point);
      point = bestAdjacentPoint;
      iterationCounter ++;
    }
    return bestPointFound;
  }

}
