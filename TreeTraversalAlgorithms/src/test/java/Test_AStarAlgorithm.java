import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.net.URL;
import objects.Block;
import objects.Grid;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utis.GridUtils;

public class Test_AStarAlgorithm {

  private static Grid grid;

  @BeforeAll
  public static  void setUpStreams() {
    URL url = Thread.currentThread().getContextClassLoader().getResource("grids/5x8.txt");
    File file = new File(url.getPath());
    grid = GridUtils.buildGrid(file);
  }

  @Test
  public void test_establishShortestPath() {
    AStarAlgorithm aStarAlgorithm = new AStarAlgorithm();
    aStarAlgorithm.establishShortestPath(grid, 10, 14);
    Block predecessor = grid.getDestinationBlock().getPredecessor();
    int counter = 0;
    while (predecessor != null) {
      counter ++;
      predecessor = predecessor.getPredecessor();
    }
    assertEquals(10, counter);
  }

}
