import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import objects.Range;
import org.junit.jupiter.api.Test;

public class Test_ParticleSwarm {

  @Test
  public void test_runParticleSwarm()  {
    String equation = "(x + 1)^2";
    List<Range> ranges = new ArrayList<>(2);
    ranges.add(new Range("x", -10, 5));
    ParticleSwarm particleSwarm = new ParticleSwarm(equation, ranges);

    double max = particleSwarm.runParticleSwarm(10,10000, 0.729, 1.49, 1.49, Boolean.TRUE);
    double min = particleSwarm.runParticleSwarm(10,10000, 0.729, 1.49, 1.49, Boolean.FALSE);
    assertEquals(81, new BigDecimal(max).setScale(2, RoundingMode.HALF_UP).doubleValue());
    assertEquals(0, new BigDecimal(min).setScale(2, RoundingMode.HALF_UP).doubleValue());
  }

}
