package TicTacToe.objects;

import lombok.Getter;
import lombok.Setter;

public class Cell {

  @Getter
  private int x;

  @Getter
  private int y;

  @Getter @Setter
  private int minmax;

  public Cell(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return String.format("Cell at position [%d,%d]", x, y);
  }

}
