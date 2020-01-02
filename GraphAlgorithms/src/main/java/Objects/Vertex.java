package Objects;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class Vertex {

  @Getter @Setter
  private String data;

  @Getter @Setter
  private boolean visited;

  @Getter @Setter
  private List<Vertex> neighbourList;

  public Vertex(String data) {
    this.data = data;
    this.neighbourList = new ArrayList<Vertex>();
  }

  public void addNeighbour(Vertex vertex) {
    neighbourList.add(vertex);
  }

  @Override
  public String toString() {
    return data;
  }

}
