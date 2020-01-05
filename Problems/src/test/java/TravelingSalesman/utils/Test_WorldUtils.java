package TravelingSalesman.utils;

import static org.junit.jupiter.api.Assertions.*;

import TravelingSalesman.objects.World;
import java.io.File;
import java.net.URL;
import org.junit.jupiter.api.Test;

public class Test_WorldUtils {

  @Test
  public void test_buildWorld() {
    URL url = Thread.currentThread().getContextClassLoader().getResource("worlds/testWorld.xml");
    File file = new File(url.getPath());
    World world = WorldUtils.buildWorld(file);
    assertEquals(5, world.getCities().size());

    assertEquals("A", world.getCities().get(0).getIdentifier());
    assertEquals("B", world.getCities().get(1).getIdentifier());
    assertEquals("C", world.getCities().get(2).getIdentifier());
    assertEquals("D", world.getCities().get(3).getIdentifier());
    assertEquals("E", world.getCities().get(4).getIdentifier());

    assertEquals(20, world.getCities().get(1).getX());
    assertEquals(30, world.getCities().get(2).getY());
  }

}
