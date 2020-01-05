package TravelingSalesman.objects;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "world")
public class World {

  List<City> cities = new ArrayList<>();

  public List<City> getCities() {
    return cities;
  }

  @XmlElementWrapper(name="cities")
  @XmlElement(name = "city")
  public void setCities(List<City> cities) {
    this.cities = cities;
  }

}
