package objects;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class Node {

  @Getter @Setter
  private String data;

  @Getter @Setter
  private boolean visited;

  @Getter @Setter
  private int depthLevel = 0;

  @Getter @Setter
  private List<Node> adjacenciesList;

  public Node(String data) {
    this.data = data;
    adjacenciesList = new ArrayList<>();
  }

  public void addAdjacentNode(Node node) {
    adjacenciesList.add(node);
  }

  @Override
  public String toString() {
    return data;
  }

}
