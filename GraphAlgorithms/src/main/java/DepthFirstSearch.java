import java.io.File;
import java.net.URL;
import objects.Node;
import java.util.Stack;
import utis.TreeUtils;

public class DepthFirstSearch {


  public DepthFirstSearch() { }

  public void depthFirstSearch(Node root, boolean recursive) {
    root.setVisited(Boolean.TRUE);
    if (recursive) {
      dfsRecursive(root);
    } else {
      dfsWithStack(root);
    }
  }

  private void dfsRecursive(Node node) {
    System.out.print(node.getValue() + " ");
    for(Node leaf : node.getLeaves()) {
      if(!leaf.isVisited()) {
        leaf.setVisited(Boolean.TRUE);
        dfsRecursive(leaf);
      }
    }
  }

  private void dfsWithStack(Node node) {
    Stack<Node> stack = new Stack<>();
    stack.add(node);
    node.setVisited(Boolean.TRUE);
    while (!stack.isEmpty()) {
      Node currentNode = stack.pop();
      System.out.print(currentNode.getValue() + " ");
      for(Node leaf : currentNode.getLeaves()) {
        if(!leaf.isVisited()) {
          leaf.setVisited(Boolean.TRUE);
          stack.push(leaf);
        }
      }
    }
  }

  public static void main(String [] args) {
    URL url = Thread.currentThread().getContextClassLoader().getResource("trees/customTree.xml");
    File file = new File(url.getPath());
    Node root = TreeUtils.buildTree(file);
    DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
    System.out.print("Non recursive (stack implementation): ");
    depthFirstSearch.depthFirstSearch(root, Boolean.FALSE);
    System.out.println();
    root = TreeUtils.buildTree(file);
    System.out.print("Recursive: ");
    depthFirstSearch.depthFirstSearch(root, Boolean.TRUE);
  }

}
