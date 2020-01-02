package objects;

import lombok.Getter;
import lombok.Setter;

public class Block {

  // g(x) How far away the block is from the starting point
  @Getter @Setter
  private int g;

  // h(x) How far away the block is from the end point
  @Getter @Setter
  private int h;

  @Getter @Setter
  private int rowIndex;

  @Getter @Setter
  private int colIndex;

  // Previous node to point to shortest path.
  @Getter @Setter
  private Block predecessor;

  // Is the block and obstacle / blocker
  @Getter @Setter
  private boolean obstacle;

  public Block(int rowIndex, int colIndex) {
    this.rowIndex = rowIndex;
    this.colIndex = colIndex;
  }

  public int getF() {
    return g + h;
  }

  @Override
  public boolean equals(Object object) {
    Block block = (Block) object;
    return (rowIndex == block.getRowIndex()) && (colIndex == block.getColIndex());
  }

  @Override
  public String toString() {
    return String.format("Block (%d;%d) h(x)=%d g(x)=%d f(x)=%d", rowIndex, colIndex, h, g, getF());
  }


}
