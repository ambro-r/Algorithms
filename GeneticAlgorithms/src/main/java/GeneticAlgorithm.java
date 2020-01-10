import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import objects.Individual;
import objects.Population;

public class GeneticAlgorithm {

  public GeneticAlgorithm() { }

  public void runGeneticAlgorithm(int [] solutionSequence, double crossOverRate, double mutationRate, int tournamentSize) {
    runGeneticAlgorithm(solutionSequence, crossOverRate, mutationRate, tournamentSize, solutionSequence.length);
  }

  public void runGeneticAlgorithm(int [] solutionSequence, double crossOverRate, double mutationRate, int tournamentSize, int maximumFitness) {
    int solutionMaximum = Arrays.stream(solutionSequence).max().getAsInt();
    int solutionMinimum = Arrays.stream(solutionSequence).min().getAsInt();
    int iterations = 0;
    Population population = new Population(solutionSequence.length, crossOverRate, mutationRate);
    population.generatePopulation(solutionSequence.length);
    population.doFitnessTest(solutionSequence);
    Individual fittestIndividual = population.getFittestIndividual();

    while (fittestIndividual.getFitness() < maximumFitness) {
      population = evolvePopulation(population, tournamentSize);
      mutatePopulation(population, solutionMinimum, solutionMaximum);

      population.doFitnessTest(solutionSequence);
      fittestIndividual = population.getFittestIndividual();
      iterations ++ ;
      System.out.println(String.format("Iteration %3d: %s", iterations, fittestIndividual.toString()));
    }
  }

  private Population evolvePopulation(Population population, int tournamentSize) {
    Population evolvedPopulation = population.getEmptyPopulation();
    for(int i = 0; i < population.getPopulationSize(); i++) {
      Individual firstIndividual = population.getTournamentWinner(tournamentSize);
      Individual secondIndividual = population.getTournamentWinner(tournamentSize);
      Individual child = evolveIndividuals(firstIndividual, secondIndividual, population.getCrossOverRate());
      evolvedPopulation.addIndividual(child);
    }
    return evolvedPopulation;
  }

  private Individual evolveIndividuals(Individual individual01, Individual individual02, double crossOverRate) {
    int chromosomeLength = individual01.getChromosomeLength();
    Individual child = new Individual(chromosomeLength);
    for(int i = 0; i < chromosomeLength; i ++) {
      if(Math.random() <= crossOverRate) {
        child.setGene(i, individual01.getGenes()[i]);
      } else {
        child.setGene(i, individual02.getGenes()[i]);
      }
    }
    return child;
  }

  private void mutatePopulation(Population population, int min, int max) {
    for(Individual individual : population.getIndividuals()) {
      mutateIndividual(individual, population.getMutationRate(), min, max);
    }
  }

  private void mutateIndividual(Individual individual, double mutationRate, int min, int max) {
    for(int i = 0; i < individual.getChromosomeLength(); i++) {
      if(Math.random() <= mutationRate) {
        // Need the +1 here because we want to possibly random max (as a bound it's exclusive)
        int mutatedGene = ThreadLocalRandom.current().nextInt(min, max + 1);
        individual.setGene(i, mutatedGene);
      }
    }
  }

  public static void main(String [] args) {
    GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();
    int[] solutionSequence = {0, 1, 2, 3, 4, 5, 6, 7, 8 ,9 };
    double crossOverRate = 0.5;
    double mutationRate = 0.15;
    int tournamentSize = 5;
    System.out.println(System.lineSeparator() + String.format("Target Solution Sequence: %s", Arrays.toString(solutionSequence)));
    geneticAlgorithm.runGeneticAlgorithm(solutionSequence, crossOverRate, mutationRate, tournamentSize);

    solutionSequence = new int [] {0, 1, 1, 1, 0, 0, 1, 0, 1, 0 };
    System.out.println(System.lineSeparator() + String.format("Target Solution Sequence: %s", Arrays.toString(solutionSequence)));
    geneticAlgorithm.runGeneticAlgorithm(solutionSequence, crossOverRate, mutationRate, tournamentSize);

    solutionSequence = new int [] {-1, 10, 100, 15, -34, 44, 32 };
    System.out.println(System.lineSeparator() + String.format("Target Solution Sequence: %s", Arrays.toString(solutionSequence)));
    geneticAlgorithm.runGeneticAlgorithm(solutionSequence, crossOverRate, mutationRate, tournamentSize);
  }


}
