import Objects.Node;
import java.util.LinkedList;
import java.util.Queue;

public class BreathFirstSearch {

  public void bfs(Node root) {
    Queue<Node> queue = new LinkedList<Node>();
    root.setVisited(Boolean.TRUE);
    queue.add(root);

    while (!queue.isEmpty()) {
      Node currentNode = queue.remove();
      System.out.print(currentNode.getData() + " ");
      for(Node neighbour : currentNode.getAdjacenciesList()) {
        if(!neighbour.isVisited()) {
          neighbour.setVisited(Boolean.TRUE);
          queue.add(neighbour);
        }
      }
    }
  }

}
