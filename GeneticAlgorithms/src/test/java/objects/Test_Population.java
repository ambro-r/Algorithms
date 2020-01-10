package objects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Test_Population {

  private static Population population;
  private static Individual individual01;
  private static Individual individual02;
  private static Individual individual03;


  @BeforeAll
  public static void init() {
    int chromosomeLength = 3;
    population = new Population(chromosomeLength, 0.5, 0.15);
    individual01 = new Individual(chromosomeLength);
    individual01.setGene(0, 1);
    individual01.setGene(1, 4);
    individual01.setGene(2, 8);
    population.addIndividual(individual01);

    individual02 = new Individual(chromosomeLength);
    individual02.setGene(0, 1);
    individual02.setGene(1, 2);
    individual02.setGene(2, 4);
    population.addIndividual(individual02);

    individual03 = new Individual(chromosomeLength);
    individual03.setGene(0, 1);
    individual03.setGene(1, 2);
    individual03.setGene(2, 3);
    population.addIndividual(individual03);
  }

  @Test
  public void test_getFittestIndividual() {
    int[] solutionSequence = {1, 2, 3};
    population.doFitnessTest(solutionSequence);
    assertEquals(individual03, population.getFittestIndividual());

    solutionSequence = new int[]{1, 4, 8};
    population.doFitnessTest(solutionSequence);
    assertEquals(individual01, population.getFittestIndividual());
  }

  @Test
  public void test_getPopulationSize() {
    assertEquals(3, population.getPopulationSize());
  }

  @Test
  public void test_getTournamentWinner() {
    int[] solutionSequence = {1, 2, 3};
    population.doFitnessTest(solutionSequence);
    assertEquals(individual03, population.getTournamentWinner(10));
  }

  @Test
  public void test_getEmptyPopulation() {
    Population emptyPopulation = population.getEmptyPopulation();
    assertEquals(population.getChromosomeLength(), emptyPopulation.getChromosomeLength());
    assertEquals(population.getCrossOverRate(), emptyPopulation.getCrossOverRate());
    assertEquals(population.getMutationRate(), emptyPopulation.getMutationRate());
    assertEquals(0, emptyPopulation.getPopulationSize());
    assertEquals(null, emptyPopulation.getFittestIndividual());
  }


}
