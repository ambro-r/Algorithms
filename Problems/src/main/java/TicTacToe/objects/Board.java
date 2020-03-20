package TicTacToe.objects;

import TicTacToe.enums.CellState;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public class Board {

  @Getter
  private int boardSize;

  private CellState[][] board;

  private List<Cell> rootValues = new ArrayList<>();

  public Board(int boardSize) {
    this.boardSize = boardSize;
    this.board = new CellState[boardSize][boardSize];
  }

  public boolean isRunning() {
    boolean isRunning = Boolean.TRUE;
    if (isWinning(CellState.COMPUTER) || isWinning(CellState.PLAYER) || getEmptyCells().isEmpty()) {
      isRunning = Boolean.FALSE;
    }
    return isRunning;
  }

  public boolean isWinning(CellState player) {
    boolean winner = Boolean.FALSE;

    // Check rows and columns
    for(int i = 0; i < boardSize; i ++) {
      boolean row = Boolean.TRUE;
      boolean column = Boolean.TRUE;
      for(int j = 0; j < boardSize; i ++) {
        row = Boolean.logicalAnd(row, board[i][j] == player);
        column = Boolean.logicalAnd(column, board[j][i] == player);
      }
      winner = Boolean.logicalOr(row, column);
      if(winner) break;
    }

    if(!winner) {
      // check diagonals
      boolean downwardsDiagonal = Boolean.TRUE;
      boolean upwardsDiagonal = Boolean.TRUE;
      for(int i = 0; i < boardSize; i ++) {
        downwardsDiagonal = Boolean.logicalAnd(downwardsDiagonal, board[i][i] == player);
        upwardsDiagonal = Boolean.logicalAnd(upwardsDiagonal, board[i][boardSize - i] == player);
      }
      winner = Boolean.logicalOr(downwardsDiagonal, upwardsDiagonal);
    }

    return winner;
  }

  private List<Cell> getEmptyCells() {
    List<Cell> emptyCells = new ArrayList<>();
    for(int i = 0; i < boardSize; i ++) {
      for(int j = 0; j < boardSize; j++) {
        if(board[i][j] == CellState.EMPTY) {
          emptyCells.add(new Cell(i, j));
        }
      }
    }
    return emptyCells;
  }

  public void move(Cell move, CellState player) {
    board[move.getX()][move.getY()] = player;
    displayBoard();
  }

  public void displayBoard() {
    System.out.println();
    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

}
