package TicTacToe.enums;

public enum CellState {

  COMPUTER("C"), HUMAN("H"), EMPTY("-");

  private String text;

  private CellState(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return this.text;
  }

}
