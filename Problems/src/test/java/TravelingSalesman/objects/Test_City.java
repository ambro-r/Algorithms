package TravelingSalesman.objects;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.jupiter.api.Test;

public class Test_City {

  @Test
  public void test_distanceBetweenCities() {
    City cityA = new City("A", 0, 0);
    City cityB = new City("B", 10, 10);
    double distanceAtoB = cityA.distanceBetweenCities(cityB);
    double distanceBtoA = cityB.distanceBetweenCities(cityA);
    assertEquals(14.14, new BigDecimal(distanceAtoB).setScale(2, RoundingMode.HALF_UP).doubleValue());
    assertEquals(14.14, new BigDecimal(distanceBtoA).setScale(2, RoundingMode.HALF_UP).doubleValue());
  }

}
