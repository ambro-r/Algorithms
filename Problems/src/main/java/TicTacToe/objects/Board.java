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
    for(int i = 0; i < boardSize; i ++) {
      for(int j = 0; j < boardSize; j++) {
        board[i][j] = CellState.EMPTY;
      }
    }
  }

  public boolean isMoveTaken(Cell move) {
    return board[move.getX()][move.getY()] != CellState.EMPTY;
  }

  public boolean isRunning() {
    boolean isRunning = Boolean.TRUE;
    if (isWinner(CellState.COMPUTER) || isWinner(CellState.HUMAN) || getEmptyCells().isEmpty()) {
      isRunning = Boolean.FALSE;
    }
    return isRunning;
  }

  public boolean isWinner(CellState player) {
    boolean winner = Boolean.FALSE;

    // Check rows and columns
    for(int i = 0; i < boardSize; i ++) {
      boolean row = Boolean.TRUE;
      boolean column = Boolean.TRUE;
      for(int j = 0; j < boardSize; j ++) {
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
        upwardsDiagonal = Boolean.logicalAnd(upwardsDiagonal, board[i][boardSize - (i + 1)] == player);
      }
      winner = Boolean.logicalOr(downwardsDiagonal, upwardsDiagonal);
    }

    return winner;
  }


  public void runMiniMax(CellState player) {
    rootValues.clear();
    miniMax(0, player);
  }

  private int miniMax(int depth, CellState player) {
    if(isWinner(CellState.COMPUTER)) return 1;
    else if(isWinner(CellState.HUMAN)) return -1;
    else {
      List<Cell> availableCells = getEmptyCells();
      if(availableCells.isEmpty()) return 0;
      List<Integer> scores = new ArrayList<>();
      for(Cell cell : availableCells) {
        if(CellState.COMPUTER == player) {
          move(cell, CellState.COMPUTER, Boolean.FALSE);
          int currentScore = miniMax(depth + 1, CellState.HUMAN);
          scores.add(currentScore);
          if(depth == 0) {
            cell.setMinmax(currentScore);
            rootValues.add(cell);
          }
        } else if (CellState.HUMAN == player) {
          move(cell, CellState.HUMAN, Boolean.FALSE);
          scores.add(miniMax(depth + 1, CellState.COMPUTER));
        }
        board[cell.getX()][cell.getY()] = CellState.EMPTY;
      }

      if(CellState.COMPUTER == player)  {
        return scores.stream().mapToInt(i -> i).max().getAsInt();
      } else {
        return scores.stream().mapToInt(i -> i).min().getAsInt();
      }
    }
  }

  public Cell getBestMove() {
    int max = Integer.MIN_VALUE;
    Cell bestMove = null;
    for(Cell cell : rootValues) {
      if(max < cell.getMinmax()) {
        max = cell.getMinmax();
        bestMove = cell;
      }
    }
    return bestMove;
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

  public void move(Cell move, CellState player, boolean display) {
    board[move.getX()][move.getY()] = player;
    if (display) {
      displayBoard();
    }
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
