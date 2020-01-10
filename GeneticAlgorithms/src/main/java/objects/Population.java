package objects;

import comparators.IndividualComparator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import lombok.Getter;

public class Population {

  @Getter
  private List<Individual> individuals = new ArrayList<>();

  @Getter
  private int chromosomeLength;

  @Getter
  private double crossOverRate;

  @Getter
  private double mutationRate;

  public Population(int chromosomeLength, double crossOverRate, double mutationRate) {
    this.chromosomeLength = chromosomeLength;
    this.crossOverRate = crossOverRate;
    this.mutationRate = mutationRate;
  }

  public void generatePopulation(int populationSize) {
    for(int i = 0; i < populationSize; i++) {
      Individual individual = new Individual(chromosomeLength);
      individual.generateGenes();
      individuals.add(individual);
    }
  }

  public void addIndividual(Individual individual) {
    individuals.add(individual);
  }

  public void doFitnessTest(int[] solutionSequence) {
    for(Individual individual : individuals) {
      int fitness = 0;
      for(int i = 0; i < individual.getGenes().length; i++) {
        if(individual.getGenes()[i] == solutionSequence[i]) {
          fitness++;
        }
        individual.setFitness(fitness);
      }
    }
  }

  public Individual getFittestIndividual() {
    Optional<Individual> fittestIndividual =  individuals.stream().max(new IndividualComparator());
    if(fittestIndividual.isPresent()) {
      return fittestIndividual.get();
    } else {
      return null;
    }
   }

  public int getPopulationSize() {
    return individuals.size();
  }

  public Individual getTournamentWinner(int tournamentSize) {
    Population tournamentPopulation = getEmptyPopulation();
    for(int i = 0; i < tournamentSize; i++) {
      int randomIndividual = ThreadLocalRandom.current().nextInt(getPopulationSize());
      tournamentPopulation.addIndividual(individuals.get(randomIndividual));
    }
    return tournamentPopulation.getFittestIndividual();
  }

  public Population getEmptyPopulation() {
    return new Population(chromosomeLength, crossOverRate, mutationRate);
  }
}
