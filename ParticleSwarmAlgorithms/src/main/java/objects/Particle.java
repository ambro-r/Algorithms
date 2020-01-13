package objects;

import java.util.HashMap;
import java.util.List;
import lombok.Getter;
import org.apache.commons.lang3.SerializationUtils;
import utils.Math;

public class Particle {

  @Getter
  private HashMap<String, Double> partcileVelocity;

  @Getter
  private HashMap<String, Double> particlePosition;

  @Getter
  private HashMap<String, Double> particleBestSolution;

  public Particle(List<Range> variableRanges) {
    partcileVelocity = new HashMap<>(variableRanges.size());
    particlePosition = new HashMap<>(variableRanges.size());

    // Generate initial positions and velocity
    for(Range range : variableRanges) {
      particlePosition.put(range.getVariable(), Math.randomDouble(range.getMin(), range.getMax()));
      partcileVelocity.put(range.getVariable(), Math.randomDouble(range.getMax() - range.getMin(), range.getMax() - range.getMin()));
    }

    setParticleBestSolution(particlePosition);
  }

  // We always want to deepcopy this, else we might accidentally update it.
  public void setParticleBestSolution(HashMap<String, Double> newSolution) {
    particleBestSolution = SerializationUtils.clone(newSolution);
  }

  public double getBestPosition(String variable) {
    return particleBestSolution.get(variable);
  }

  public double getParticlePosition(String variable) {
    return particlePosition.get(variable);
  }

  public double getParticleVelocity(String variable) {
    return partcileVelocity.get(variable);
  }


  @Override
  public String toString() {
    StringBuilder output = new StringBuilder("Particle [")
        .append("position=").append(particlePosition)
        .append("; velocity=").append(partcileVelocity)
        .append("]");
    return output.toString();
  }

}
