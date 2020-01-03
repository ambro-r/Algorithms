package objects;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "node")
public class Node {

  private List<Node> leaves = new ArrayList<>();
  private String value;

  @Getter @Setter
  private boolean visited;

  @Getter @Setter
  private int depthLevel = 0;

  public List<Node> getLeaves() {
    return leaves;
  }

  @XmlElement(name = "node")
  public void setLeaves(List<Node> leaves) {
    this.leaves = leaves;
  }

  public String getValue() {
    return value;
  }

  @XmlAttribute
  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }

}
