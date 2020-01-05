package utis;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import objects.Block;
import objects.Grid;
import org.apache.commons.io.IOUtils;

public class GridUtils {

  public static Grid buildGrid(File gridFile) {
    Grid grid = null;
    try {
      List<String> rows = IOUtils.readLines(new InputStreamReader(new FileInputStream(gridFile)));
      int maxColumns = 0;
      for(String row : rows) {
        String [] columns = row.split(" ");
        if(columns.length > maxColumns) {
          maxColumns = columns.length;
        }
      }
      grid = new Grid(rows.size(), maxColumns);

      for(int row = 0; row < rows.size(); row++) {
        String [] columns = rows.get(row).split(" ");
        for(int col = 0; col < columns.length; col++) {
          Block block = new Block(row, col);
          if("#".equalsIgnoreCase(columns[col])) {
            block.setObstacle(Boolean.TRUE);
          } else if("S".equalsIgnoreCase(columns[col])) {
            grid.setStartingBlock(block);
          } else if("D".equalsIgnoreCase(columns[col])) {
            grid.setDestinationBlock(block);
          }
          grid.getGrid()[row][col] = block;
        }
      }
    } catch (Exception e) { }
    return grid;
  }

  public static void printGrid(Grid grid) {
    String[][] outputGrid = new String[grid.getRows()][grid.getColumns()];
    for(int row = 0; row < grid.getRows(); row ++) {
      for(int col = 0; col < grid.getColumns(); col ++) {
        Block block = grid.getGrid()[row][col];
        if (block == null) {
          outputGrid[row][col] = "";
        } else if  (block.isObstacle()) {
          outputGrid[row][col] = "#";
        } else if (block.equals(grid.getStartingBlock())) {
          outputGrid[row][col] = "S";
        } else if (block.equals(grid.getDestinationBlock())) {
          outputGrid[row][col] = "D";
        } else {
          outputGrid[row][col] = "*";
        }
      }
    }
    Block predecessor = grid.getDestinationBlock().getPredecessor();
    while (predecessor != null) {
      if(!predecessor.equals(grid.getStartingBlock()) && !predecessor.equals(grid.getDestinationBlock())) {
        outputGrid[predecessor.getRowIndex()][predecessor.getColIndex()] = "@";
      }
      predecessor = predecessor.getPredecessor();
    }
    for (int row = 0; row < outputGrid.length; row++) {
      for (int col = 0; col < outputGrid[row].length; col++) {
        System.out.print(outputGrid[row][col] + " ");
      }
      System.out.println();
    }
  }

}
