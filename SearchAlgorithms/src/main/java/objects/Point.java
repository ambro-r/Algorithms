package objects;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class Point {

  @Getter @Setter
  private double x;

  @Getter @Setter
  private double y;

  @Getter @Setter
  private double f; // f(x,y)

  @Getter @Setter
  private List<Point> adjacentPoints;

  public Point(double x, double y, double f) {
    this.x = x;
    this.y = y;
    this.f = f;
    this.adjacentPoints = new ArrayList<>();
  }

  public void addAdjacentPoint(Point point) {
    adjacentPoints.add(point);
  }

  @Override
  public String toString() {
    return String.format("f(x,y)=%.4f, where x=%.4f & y=%.4f", f, x, y);
  }

}
