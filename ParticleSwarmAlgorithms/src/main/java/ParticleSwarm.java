import utils.Function;

public class ParticleSwarm {

  private Function function;

  public ParticleSwarm(String equation) {
    function = new Function(equation);
  }

  public void runParticleSwarm(String function, int numberOfParticles) {
  }

  public static void main(String [] args) {
    String equation = "exp(-x * x - y * y) * sin(x)";
    ParticleSwarm particleSwarm = new ParticleSwarm(equation);
  }

}
