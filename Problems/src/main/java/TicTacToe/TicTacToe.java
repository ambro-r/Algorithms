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
      System.out.println("User move:");;
      Cell userCell = new Cell(1,2);
      board.move(userCell, CellState.PLAYER);
      board.displayBoard();
      if(!board.isRunning()) break;
      board.callMinimax(0, CellState.COMPUTER);
      board.move(board.getBestMove(), CellState.PLAYER);
      board.displayBoard();
    }
    checkStatus();
  }

  private void checkStatus() {
    if(board.isWinning(CellState.COMPUTER)) {
      System.out.println("Computer has won...");
    } else if(board.isWinning(CellState.PLAYER)) {
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
