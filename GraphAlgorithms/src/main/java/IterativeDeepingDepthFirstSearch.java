import java.io.File;
import java.net.URL;
import objects.Node;
import java.util.Stack;
import utis.TreeUtils;

public class IterativeDeepingDepthFirstSearch {

  private String targetValue;
  private volatile boolean isTargetFound;

  public IterativeDeepingDepthFirstSearch() { }

  // NOTE: If the targetValue does not exist this will run indefinitely as there is no check.
  public void runDeependingSearch(Node root, String targetValue) {
    int depth = 0;
    this.targetValue = targetValue;
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
      if(current.getValue().equalsIgnoreCase(targetValue)) {
        System.out.println(": " + targetValue + " has been found...");
        isTargetFound = Boolean.TRUE;
        return;
      }

      if(current.getDepthLevel() >= depth) {
        continue;
      }

      for(Node leaf : current.getLeaves()) {
        leaf.setDepthLevel(current.getDepthLevel() + 1);
        stack.push(leaf);
      }
    }
  }

  public static void main(String [] args) {
    URL url = Thread.currentThread().getContextClassLoader().getResource("trees/customTree.xml");
    File file = new File(url.getPath());
    Node root = TreeUtils.buildTree(file);
    IterativeDeepingDepthFirstSearch iterativeDeepingDepthFirstSearch = new IterativeDeepingDepthFirstSearch();
    iterativeDeepingDepthFirstSearch.runDeependingSearch(root, "A");
    iterativeDeepingDepthFirstSearch.runDeependingSearch(root, "ACA");
    iterativeDeepingDepthFirstSearch.runDeependingSearch(root, "ADBAA");
  }

}
