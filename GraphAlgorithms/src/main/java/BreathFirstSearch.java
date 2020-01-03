import java.io.File;
import java.net.URL;
import objects.Node;
import java.util.LinkedList;
import java.util.Queue;
import utis.TreeUtils;

public class BreathFirstSearch {

  public void breathFirstSearch(Node root) {
    Queue<Node> queue = new LinkedList<>();
    root.setVisited(Boolean.TRUE);
    queue.add(root);

    while (!queue.isEmpty()) {
      Node currentNode = queue.remove();
      System.out.print(currentNode.getValue() + " ");
      for(Node leaf : currentNode.getLeaves()) {
        if(!leaf.isVisited()) {
          leaf.setVisited(Boolean.TRUE);
          queue.add(leaf);
        }
      }
    }
  }

  public static void main(String [] args) {
    URL url = Thread.currentThread().getContextClassLoader().getResource("trees/customTree.xml");
    File file = new File(url.getPath());
    Node root = TreeUtils.buildTree(file);
    BreathFirstSearch breathFirstSearch = new BreathFirstSearch();
    breathFirstSearch.breathFirstSearch(root);
  }

}
