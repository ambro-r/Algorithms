package TravelingSalesman.objects;

import javax.xml.bind.annotation.XmlAttribute;

public class City {

  private String identifier;
  private int x;
  private int y;

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

}
