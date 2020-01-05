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

public class Test_DepthFirstSearch {

  private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private static final PrintStream originalOut = System.out;
  private static final PrintStream originalErr = System.err;

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
  public void test_depthFirstSearch() {
    URL url = Thread.currentThread().getContextClassLoader().getResource("trees/testTree.xml");
    File file = new File(url.getPath());
    Node root = TreeUtils.buildTree(file);

    DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
    depthFirstSearch.depthFirstSearch(root, Boolean.FALSE);
    assertEquals("A AC ACB ACA ACAA AB ABA AA AAC AAB AAA", outContent.toString().trim());

    outContent.reset();
    root = TreeUtils.buildTree(file);
    depthFirstSearch.depthFirstSearch(root, Boolean.TRUE);
    assertEquals("A AA AAA AAB AAC AB ABA AC ACA ACAA ACB", outContent.toString().trim());
  }
}
