package TravelingSalesman.objects;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAttribute;

public class City implements Serializable {

  private String identifier;
  private int x;
  private int y;

  public City() {}

  public City(String identifier, int x, int y) {
    this.identifier = identifier;
    this.x = x;
    this.y = y;
  }

  public String getIdentifier() {
    return identifier;
  }

  @XmlAttribute
  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public int getX() {
    return x;
  }

  @XmlAttribute
  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  @XmlAttribute
  public void setY(int y) {
    this.y = y;
  }

  public double distanceBetweenCities(City city) {
    double xDistance = Math.abs(getX() - city.getX());
    double yDistance = Math.abs(getY() - city.getY());
    return Math.sqrt(Math.pow(xDistance,2) + Math.pow(yDistance,2));
  }

  @Override
  public String toString() {
    return String.format("City %s at position [%d,%d]", identifier, x, y);
  }

}
