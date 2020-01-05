package TravelingSalesman.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.SerializationUtils;

public class Tour {

  @Getter @Setter
  private List<City> tour = new ArrayList<>();

  @Getter
  private double tourDistance;

  private Tour() {}

  public Tour(List<City> cities) {
    tour = cities.stream().map(city -> SerializationUtils.clone(city)).collect(Collectors.toList());
    calculateTourDistance();
  }

  private void calculateTourDistance() {
    tourDistance = 0;
    for (int i = 0; i < (tour.size() - 1); i++) {
      tourDistance += tour.get(i).distanceBetweenCities(tour.get(i + 1));
    }
    // Need to return to the original city
    tourDistance += tour.get(0).distanceBetweenCities(tour.get(tour.size() - 1));
  }

  public void swapTwoRandomCities() {
    int position01 = 0;
    int position02 = 0;
    while (position01 == position02) {
      position01 = ThreadLocalRandom.current().nextInt(0, tour.size() - 1);
      position02 = ThreadLocalRandom.current().nextInt(0, tour.size() - 1);
    }

    City city01 = tour.get(position01);
    City city02 = tour.get(position02);

    tour.set(position01, city02);
    tour.set(position02, city01);

    calculateTourDistance();
  }

  public void printTour() {
    System.out.println(System.lineSeparator() + "Tour");
    for(int i = 0; i < tour.size(); i++) {
      City nextCity;
      if((i + 1) == tour.size()) {
        nextCity = tour.get(0);
      } else {
        nextCity = tour.get(i + 1);
      }
      System.out.println(String.format("%s, -> %s : %.2f", tour.get(i).toString(), nextCity.getIdentifier(), tour.get(i).distanceBetweenCities(nextCity)));
    }
    System.out.println(String.format("Tour distance: %.2f",tourDistance));
  }


}
