import static org.junit.jupiter.api.Assertions.*;

import Objects.Node;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Test_DepthFirstSearch {

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
  public void test_dfs() {
    node01.addAdjacentNode(node02);
    node01.addAdjacentNode(node03);
    node03.addAdjacentNode(node04);
    node04.addAdjacentNode(node05);

    List<Node> nodes = new ArrayList<>();
    nodes.add(node01);
    nodes.add(node02);
    nodes.add(node03);
    nodes.add(node04);
    nodes.add(node05);

    DepthFirstSearch dfs = new DepthFirstSearch();
    dfs.dfs(nodes, Boolean.FALSE);
    assertEquals("A C D E B", outContent.toString().trim());

    outContent.reset();
    for(Node node : nodes) {
      node.setVisited(Boolean.FALSE);
    }
    dfs.dfs(nodes, Boolean.TRUE);
    assertEquals("A B C D E", outContent.toString().trim());
  }
}
