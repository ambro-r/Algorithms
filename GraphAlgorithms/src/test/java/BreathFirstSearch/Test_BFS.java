package BreathFirstSearch;

import static org.junit.jupiter.api.Assertions.*;

import Objects.Vertex;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Test_BFS {

  private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private static final PrintStream originalOut = System.out;
  private static final PrintStream originalErr = System.err;

  private Vertex vertex01 = new Vertex("1");
  private Vertex vertex02 = new Vertex("2");
  private Vertex vertex03 = new Vertex("3");
  private Vertex vertex04 = new Vertex("4");
  private Vertex vertex05 = new Vertex("5");

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
  public void test_bfs() {
    vertex01.addNeighbour(vertex02);
    vertex01.addNeighbour(vertex04);
    vertex02.addNeighbour(vertex03);
    vertex04.addNeighbour(vertex05);

    BFS bfs = new BFS();
    bfs.bfs(vertex01);
    assertEquals("1 2 4 3 5", outContent.toString().trim());
  }

}
