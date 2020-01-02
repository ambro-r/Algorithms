import static org.junit.jupiter.api.Assertions.assertEquals;

import objects.Node;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Test_IterativeDeepingDepthFirstSearch {

  private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private static final PrintStream originalOut = System.out;
  private static final PrintStream originalErr = System.err;

  private Node node01 = new Node("A");
  private Node node02 = new Node("B");
  private Node node03 = new Node("C");
  private Node node04 = new Node("D");
  private Node node05 = new Node("E");

  @BeforeAll
  public static  void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  @AfterAll
  public static void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

  @Test
  public void test_runDeependingSearch() {
    node01.addAdjacentNode(node02);
    node01.addAdjacentNode(node03);
    node02.addAdjacentNode(node04);
    node04.addAdjacentNode(node05);

    IterativeDeepingDepthFirstSearch iddfs = new IterativeDeepingDepthFirstSearch();
    iddfs.runDeependingSearch(node01, node01);
    assertEquals("A : Node has been found...", outContent.toString().trim());

    outContent.reset();
    iddfs.runDeependingSearch(node05, node01);
    assertEquals("A | A C B | A C B D | A C B D E : Node has been found...", outContent.toString().trim());
  }

}
