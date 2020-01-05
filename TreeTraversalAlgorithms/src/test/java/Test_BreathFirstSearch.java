import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.net.URL;
import objects.Node;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utis.TreeUtils;

public class Test_BreathFirstSearch {

  private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private static final PrintStream originalOut = System.out;
  private static final PrintStream originalErr = System.err;

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
  public void test_breathFirstSearch() {
    URL url = Thread.currentThread().getContextClassLoader().getResource("trees/testTree.xml");
    File file = new File(url.getPath());
    Node root = TreeUtils.buildTree(file);

    BreathFirstSearch bfs = new BreathFirstSearch();
    bfs.breathFirstSearch(root);
    assertEquals("A AA AB AC AAA AAB AAC ABA ACA ACB ACAA", outContent.toString().trim());
  }

}
