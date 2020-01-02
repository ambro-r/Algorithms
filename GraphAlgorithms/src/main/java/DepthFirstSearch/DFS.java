package DepthFirstSearch;

import Objects.Vertex;
import java.util.List;
import java.util.Stack;

public class DFS {

  private Stack<Vertex> stack;

  public DFS() {
    this.stack = new Stack<>();
  }

  public void dfs(List<Vertex> vertexList, boolean recursive) {
    for(Vertex vertex : vertexList) {
      if(!vertex.isVisited()) {
        vertex.setVisited(Boolean.TRUE);
        if (recursive) {
          dfsRecursive(vertex);
        } else {
          dfsWithStack(vertex);
        }
      }
    }
  }

  private void dfsRecursive(Vertex currentVertex) {
    System.out.print(currentVertex.getData() + " ");
    for(Vertex neighbour : currentVertex.getNeighbourList()) {
      if(!neighbour.isVisited()) {
        neighbour.setVisited(Boolean.TRUE);
        dfsRecursive(neighbour);
      }
    }
  }

  private void dfsWithStack(Vertex root) {
    stack.add(root);
    root.setVisited(Boolean.TRUE);
    while (!stack.isEmpty()) {
      Vertex currentVertex = stack.pop();
      System.out.print(currentVertex.getData() + " ");
      for(Vertex neighbour : currentVertex.getNeighbourList()) {
        if(!neighbour.isVisited()) {
          neighbour.setVisited(Boolean.TRUE);
          stack.push(neighbour);
        }
      }
    }
  }

}
