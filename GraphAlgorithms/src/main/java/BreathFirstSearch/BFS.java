package BreathFirstSearch;

import Objects.Vertex;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

  public void bfs(Vertex root) {

    Queue<Vertex> queue = new LinkedList<Vertex>();
    root.setVisited(Boolean.TRUE);
    queue.add(root);

    while (!queue.isEmpty()) {
      Vertex currentVertex = queue.remove();
      System.out.print(currentVertex.getData() + " ");
      for(Vertex neighbour : currentVertex.getNeighbourList()) {
        if(!neighbour.isVisited()) {
          neighbour.setVisited(Boolean.TRUE);
          queue.add(neighbour);
        }
      }
    }
  }

}
