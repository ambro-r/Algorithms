package objects;

import lombok.Getter;
import lombok.Setter;

public class Grid {

  @Getter
  private Block[][] grid;

  @Getter @Setter
  private Block startingBlock;

  @Getter @Setter
  private Block destinationBlock;

  @Getter
  private int rows;

  @Getter
  private int columns;

  public Grid(int rows, int columns) {
    grid = new Block[rows][columns];
    this.rows = rows;
    this.columns = columns;
  }

}
