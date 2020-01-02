import objects.Node;
import java.util.Stack;

public class IterativeDeepingDepthFirstSearch {

  private Node targetNode;
  private volatile boolean isTargetFound;

  public IterativeDeepingDepthFirstSearch() { }

  public void runDeependingSearch(Node targetNode, Node root) {
    int depth = 0;
    this.targetNode = targetNode;
    this.isTargetFound = Boolean.FALSE;
    while (!isTargetFound) {
      dfs(root, depth);
      depth++;
      if(!isTargetFound) {
        System.out.print("| ");
      }
    }
  }

  private void dfs(Node root, int depth) {
    Stack<Node> stack = new Stack<>();
    root.setDepthLevel(0);
    stack.push(root);

    while (!stack.isEmpty()) {
      Node current = stack.pop();
      System.out.print(current + " ");
      if(current.getData().equalsIgnoreCase(targetNode.getData())) {
        System.out.println(": Node has been found...");
        isTargetFound = Boolean.TRUE;
        return;
      }

      if(current.getDepthLevel() >= depth) {
        continue;
      }

      for(Node node : current.getAdjacenciesList()) {
        node.setDepthLevel(current.getDepthLevel() + 1);
        stack.push(node);
      }
    }
  }
}
