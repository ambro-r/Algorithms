import static org.junit.jupiter.api.Assertions.*;

import objects.Node;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Test_BreathFirstSearch {

  private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private static final PrintStream originalOut = System.out;
  private static final PrintStream originalErr = System.err;

  private Node vertex01 = new Node("A");
  private Node vertex02 = new Node("B");
  private Node vertex03 = new Node("C");
  private Node vertex04 = new Node("D");
  private Node vertex05 = new Node("E");

  @BeforeAll
  public static void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  @AfterAll
  public static void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

  @Test
  public void test_bfs() {
    vertex01.addAdjacentNode(vertex02);
    vertex01.addAdjacentNode(vertex04);
    vertex02.addAdjacentNode(vertex03);
    vertex04.addAdjacentNode(vertex05);

    BreathFirstSearch bfs = new BreathFirstSearch();
    bfs.bfs(vertex01);
    assertEquals("A B D C E", outContent.toString().trim());
  }

}
