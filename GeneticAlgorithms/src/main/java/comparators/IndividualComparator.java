package comparators;

import java.util.Comparator;
import objects.Individual;

public class IndividualComparator implements Comparator<Individual> {

    @Override
    public int compare(Individual individual01, Individual individual02) {
      if(individual01.getFitness() < individual02.getFitness()) return -1;
      if(individual01.getFitness() > individual02.getFitness()) return 1;
      return 0;
    }

  }
