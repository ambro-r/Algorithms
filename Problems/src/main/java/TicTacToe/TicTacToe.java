package TicTacToe;

import TicTacToe.enums.CellState;
import TicTacToe.objects.Board;
import TicTacToe.objects.Cell;
import java.util.Random;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

public class TicTacToe {

  private Board board;

  private TicTacToe(int boardSize) {
    board = new Board(boardSize);
  }

  private void playGame(String whoStarts) {
    firstMove(whoStarts);
    while(board.isRunning()) {
      Cell userCell = getUserMove();
      board.move(userCell, CellState.PLAYER);
      if(!board.isRunning()) break;
      board.callMinimax(0, CellState.COMPUTER);
      board.move(board.getBestMove(), CellState.PLAYER);
      break;
    }
    checkStatus();
  }

  private void checkStatus() {
    if(board.isWinner(CellState.COMPUTER)) {
      System.out.println("Computer has won...");
    } else if(board.isWinner(CellState.PLAYER)) {
      System.out.println("Player has won...");
    } else {
      System.out.println("Game is a draw...");
    }
  }

  private void firstMove(String whoStarts) {
    if(whoStarts.equalsIgnoreCase(CellState.COMPUTER.toString())) {
      Cell randomCell = new Cell(new Random().nextInt(board.getBoardSize()), new Random().nextInt(board.getBoardSize()));
      board.move(randomCell, CellState.COMPUTER);
    }
  }

  private Cell getUserMove() {
    while (true) {
      int x = getCoordinate("X");
      int y = getCoordinate("Y");
      Cell move = new Cell(x, y);
      if(!board.isMoveTaken(move)) {
        return move;
      } else {
        System.out.println("Move taken already, please enter another move.");
      }
    }
  }

  private int getCoordinate(String coordinate) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.print(String.format("User move %s co-ordinate (0 to %d):", coordinate.toUpperCase(), board.getBoardSize() - 1));
      String input = scanner.nextLine();
      if(StringUtils.isNumericSpace(input)) {
        int value = Integer.parseInt(input);
        if(value < board.getBoardSize()) return value;
      }
    }
  }

  public static void main (String ... args) {
    Scanner scanner = new Scanner(System.in);
    int boardSize = -1;
    while(boardSize < 3) {
      System.out.print("Enter board size (minimum size is 3): ");
      String input = scanner.nextLine();
      if(StringUtils.isNumericSpace(input)) {
        boardSize = Integer.parseInt(input);
      }
    }
    String whoStarts;
    while (true) {
      System.out.print("Who starts? (C)omputer or (P)layer: ");
      whoStarts = scanner.nextLine();
      if("p".equalsIgnoreCase(whoStarts) || "c".equalsIgnoreCase(whoStarts)) {
        break;
      }
    }

    TicTacToe ticTacToe = new TicTacToe(boardSize);
    ticTacToe.playGame(whoStarts);
   }

}
