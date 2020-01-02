package DepthFirstSearch;

import static org.junit.jupiter.api.Assertions.*;

import Objects.Vertex;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Test_DFS {

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
  public void test_dfs() {
    vertex01.addNeighbour(vertex02);
    vertex01.addNeighbour(vertex03);
    vertex03.addNeighbour(vertex04);
    vertex04.addNeighbour(vertex05);

    List<Vertex> vertexList = new ArrayList<>();
    vertexList.add(vertex01);
    vertexList.add(vertex02);
    vertexList.add(vertex03);
    vertexList.add(vertex04);
    vertexList.add(vertex05);

    DFS dfs = new DFS();
    dfs.dfs(vertexList, Boolean.FALSE);
    assertEquals("1 3 4 5 2", outContent.toString().trim());

    outContent.reset();
    for(Vertex vertex : vertexList) {
      vertex.setVisited(Boolean.FALSE);
    }
    dfs.dfs(vertexList, Boolean.TRUE);
    assertEquals("1 2 3 4 5", outContent.toString().trim());
  }
}
