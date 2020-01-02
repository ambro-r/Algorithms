import Objects.Node;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

  private Stack<Node> stack;

  public DepthFirstSearch() {
    this.stack = new Stack<>();
  }

  public void dfs(List<Node> nodes, boolean recursive) {
    for(Node node : nodes) {
      if(!node.isVisited()) {
        node.setVisited(Boolean.TRUE);
        if (recursive) {
          dfsRecursive(node);
        } else {
          dfsWithStack(node);
        }
      }
    }
  }

  private void dfsRecursive(Node currentNode) {
    System.out.print(currentNode.getData() + " ");
    for(Node neighbour : currentNode.getAdjacenciesList()) {
      if(!neighbour.isVisited()) {
        neighbour.setVisited(Boolean.TRUE);
        dfsRecursive(neighbour);
      }
    }
  }

  private void dfsWithStack(Node root) {
    stack.add(root);
    root.setVisited(Boolean.TRUE);
    while (!stack.isEmpty()) {
      Node currentNode = stack.pop();
      System.out.print(currentNode.getData() + " ");
      for(Node neighbour : currentNode.getAdjacenciesList()) {
        if(!neighbour.isVisited()) {
          neighbour.setVisited(Boolean.TRUE);
          stack.push(neighbour);
        }
      }
    }
  }

}
