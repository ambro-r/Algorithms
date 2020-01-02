package utils;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.net.URL;
import objects.Grid;
import org.junit.jupiter.api.Test;
import utis.GridUtils;

public class Test_GridUtils {

  @Test
  public void test_buildGrid() {
    URL url = Thread.currentThread().getContextClassLoader().getResource("grids/4x4.txt");
    File file = new File(url.getPath());
    Grid grid = GridUtils.buildGrid(file);

    assertFalse(grid.getGrid()[0][0].isObstacle());
    assertFalse(grid.getGrid()[1][0].isObstacle());
    assertFalse(grid.getGrid()[1][1].isObstacle());
    assertFalse(grid.getGrid()[1][3].isObstacle());

    assertTrue(grid.getGrid()[1][2].isObstacle());
    assertTrue(grid.getGrid()[2][1].isObstacle());
    assertTrue(grid.getGrid()[2][1].isObstacle());

    assertEquals(3, grid.getStartingBlock().getRowIndex());
    assertEquals(1, grid.getStartingBlock().getColIndex());

    assertEquals(0, grid.getDestinationBlock().getRowIndex());
    assertEquals(2, grid.getDestinationBlock().getColIndex());
  }

}
