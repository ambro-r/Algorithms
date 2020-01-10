package objects;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import lombok.Getter;
import lombok.Setter;

public class Individual {

  @Getter
  private int[] genes;

  @Getter @Setter
  private int fitness;

  @Getter
  private int chromosomeLength;

  public Individual(int chromosomeLength) {
    this.chromosomeLength = chromosomeLength;
    genes = new int[chromosomeLength];
  }

  public void generateGenes() {
    for(int i = 0; i < genes.length; i++) {
      genes[i] = ThreadLocalRandom.current().nextInt(genes.length);
    }
  }

  public void setGene(int position, int value) {
    genes[position] = value;
  }

  @Override
  public String toString() {
    return Arrays.toString(genes);
  }

}
