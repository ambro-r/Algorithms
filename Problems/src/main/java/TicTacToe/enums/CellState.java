package TicTacToe.enums;

public enum CellState {

  COMPUTER("C"), PLAYER("P"), EMPTY("-");

  private String text;

  private CellState(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return this.text;
  }

}
