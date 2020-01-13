import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import objects.Particle;
import objects.Range;
import org.apache.commons.lang3.SerializationUtils;
import utils.Function;
import utils.Math;

public class ParticleSwarm {

  private Function function;
  private List<Range> variableRanges;
  private HashMap<String, Double> globalBestSolution;

  public ParticleSwarm(String equation, List<Range> variableRanges) {
    this.variableRanges = variableRanges;
    function = new Function(equation);
    globalBestSolution = new HashMap<>(variableRanges.size());
    for(Range range : variableRanges) {
      globalBestSolution.put(range.getVariable(), Math.randomDouble(range.getMin(), range.getMax()));
    }
  }

  public double runParticleSwarm(int numberOfParticles, int numberOfIterations, double w, double c1, double c2, boolean max) {
    Particle[] particles = new Particle[numberOfParticles];
    System.out.println(String.format("Generating %d particles...", numberOfParticles));
    for(int i = 0; i < particles.length; i++) {
      particles[i] = new Particle(variableRanges);
      System.out.println( particles[i]);
    }


    System.out.println(String.format("Evaluating particles over %d iterations...", numberOfIterations));
    int epochs = 0;
    while(epochs < numberOfIterations) {

      // Need to loop through each particle
      for(Particle particle : particles) {

        /* First we need to update the particles Velocity
           Velocity = W * PV + C1 * RP(PBS - PP) + C2 * RG(GBS - PP)
           Where:
            -> PV = velocity of the particle in it's current position
            -> PBS = The best solution of the particle (this establishes local optima)
            -> GBS = The global best solution (this establishes global optima)
            -> PP = The particles current position
            -> W, C1, C2 = Constants for tuning.
           -> RP, RG = Random values
        */
        for(Map.Entry<String, Double> velocity : particle.getPartcileVelocity().entrySet()) {
          double rp = java.lang.Math.random();
          double rg = java.lang.Math.random();
          double updatedVelocity = (w * velocity.getValue())
              + (c1 * rp * (particle.getBestPosition(velocity.getKey()) - particle.getParticlePosition(velocity.getKey())))
              + (c2 * rg * (globalBestSolution.get(velocity.getKey()) - particle.getParticlePosition(velocity.getKey())));
          velocity.setValue(updatedVelocity);
        }

        // Update Position based on it's velocity
        for(Map.Entry<String, Double> position : particle.getParticlePosition().entrySet()) {
          double updatedPosition = position.getValue() + particle.getParticleVelocity(position.getKey());

          // Just need to ensure the value is still in the range for the variable
          for(Range range : variableRanges) {
            if (range.getVariable().equalsIgnoreCase(position.getKey())) {
              if(updatedPosition < range.getMin()) {
                updatedPosition = range.getMin();
              } else if(updatedPosition > range.getMax()) {
                updatedPosition = range.getMax();
              }
            }
          }
          position.setValue(updatedPosition);
        }

        // Now we evaluate the particle to establish if it's at it's own best solution
        double fPC = function.evaluate(particle.getParticlePosition());
        double fPB = function.evaluate(particle.getParticleBestSolution());
        if(max && (fPC > fPB)) {
          particle.setParticleBestSolution(particle.getParticlePosition());
        } else if(!max && (fPC < fPB)) {
          particle.setParticleBestSolution(particle.getParticlePosition());
        }

        // We also evaluate the particle against the global best solution
        fPB = function.evaluate(particle.getParticleBestSolution());
        double fGB = function.evaluate(globalBestSolution);
        if(max && (fPB > fGB)) {
          globalBestSolution = SerializationUtils.clone(particle.getParticleBestSolution());
        } else if(!max && (fPB < fGB)) {
          globalBestSolution = SerializationUtils.clone(particle.getParticleBestSolution());
        }
      }
      epochs ++;
    }
    double solution =  function.evaluate(globalBestSolution);
    String expressions = variableRanges.stream().map(Range::getVariable).collect(Collectors.joining(","));
    System.out.println(String.format("f(%s)=%s", expressions, function.getEquation()));
    System.out.println(String.format("f(%s)=%.10f", expressions, solution));
    System.out.println("Global best position:" + globalBestSolution);
    return solution;
  }

  public static void main(String [] args) {
    String equation = "exp(-x * x - y * y) * sin(x)";
    List<Range> ranges = new ArrayList<>(2);
    ranges.add(new Range("x", -2, 2));
    ranges.add(new Range("y", -2 , 2));
    ParticleSwarm particleSwarm = new ParticleSwarm(equation, ranges);
    particleSwarm.runParticleSwarm(10,10000, 0.729, 1.49, 1.49, Boolean.FALSE);
    System.out.println(System.lineSeparator());
    equation = "exp(-x * x - y * y - z * z) * sin(x) + sin(z)";
    ranges.add(new Range("z", -2, 2));
    particleSwarm = new ParticleSwarm(equation, ranges);
    particleSwarm.runParticleSwarm(10,10000, 0.729, 1.49, 1.49, Boolean.FALSE);
  }

}
