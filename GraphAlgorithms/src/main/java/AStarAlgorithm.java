import comparators.BlockComparator;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import objects.Block;
import objects.Grid;
import utis.GridUtils;

public class AStarAlgorithm {

  private List<Block> closedSet;

  private Queue<Block> openSet;

  private int hvCost;

  private int dCost;

  public AStarAlgorithm() {
    this.openSet = new PriorityQueue<>(new BlockComparator());
    this.closedSet = new ArrayList<>();
  }

  public void establishShortestPath(Grid grid, int hvCost, int dCost) {
    this.hvCost = hvCost;
    this.dCost = dCost;

    Block start = grid.getStartingBlock();
    start.setH(manhattanHeuristic(start, grid.getDestinationBlock()));
    openSet.add(start);

    while(!openSet.isEmpty()) {
      // Returns the block with the smallest F value possible
      Block current = openSet.poll();
      System.out.println(current + " Predecessor is: " + current.getPredecessor());

      if(!current.equals(grid.getDestinationBlock())) {
        // Update the sets because the current block is not our destination block
        openSet.remove(current);
        closedSet.add(current);

        for(Block neighbour : getAllNeighbours(grid, current)) {
          // We've already considered this block, so continue
          if(closedSet.contains(neighbour)) continue;

          // Since we've not considered this as part of the closed set, add it to the open set
          if(!openSet.contains(neighbour)) openSet.add(neighbour);

          // Set predecessor so we can track shortest path
          neighbour.setPredecessor(current);
        }
      } else {
        break;
      }
    }
  }

  // Note: This implementation is for Horizontal and Vertical paths, diagonal have been excluded for now.
  private List<Block> getAllNeighbours(Grid grid, Block block) {
    List<Block> neighbours =new ArrayList<>();
    int row = block.getRowIndex();
    int col = block.getColIndex();

    // Check the row above the block
    if((row - 1) >= 0) {
      Block above = grid.getGrid()[row - 1][col];
      if ((above != null) && !above.isObstacle()) {
        above.setG(block.getG() + hvCost);
        above.setH(manhattanHeuristic(above, grid.getDestinationBlock()));
        neighbours.add(above);
      }
    }

    // Check the row below the block
    if((row + 1) < grid.getRows()) {
      Block below = grid.getGrid()[row + 1][col];
      if ((below != null) && !below.isObstacle()) {
        below.setG(block.getG() + hvCost);
        below.setH(manhattanHeuristic(below, grid.getDestinationBlock()));
        neighbours.add(below);
      }
    }

    // Check block to the left
    if ((col - 1) >= 0) {
      Block left = grid.getGrid()[row][col - 1];
      if ((left != null) && !left.isObstacle()) {
        left.setG(block.getG() + hvCost);
        left.setH(manhattanHeuristic(left, grid.getDestinationBlock()));
        neighbours.add(left);
      }
    }

    // Check block to the right
    if ((col + 1) < grid.getColumns()) {
      Block right = grid.getGrid()[row][col + 1];
      if ((right != null) && !right.isObstacle()) {
        right.setG(block.getG() + hvCost);
        right.setH(manhattanHeuristic(right, grid.getDestinationBlock()));
        neighbours.add(right);
      }
    }

    return neighbours;
  }


  private int manhattanHeuristic(Block block01, Block block02) {
    return Math.abs(block01.getRowIndex() - block02.getRowIndex()) + Math.abs(block01.getColIndex() - block02.getColIndex());
  }

  public static void main(String [] args) {
    URL url = Thread.currentThread().getContextClassLoader().getResource("grids/10x10_irregular.txt");
    File file = new File(url.getPath());
    Grid grid = GridUtils.buildGrid(file);
    System.out.println(System.lineSeparator() + "Grid supplied to find shortest path: ");
    GridUtils.printGrid(grid);
    AStarAlgorithm aStarAlgorithm = new AStarAlgorithm();
    aStarAlgorithm.establishShortestPath(grid, 10, 14);
    System.out.println(System.lineSeparator() + "Shortest Path: ");
    GridUtils.printGrid(grid);
  }

}
