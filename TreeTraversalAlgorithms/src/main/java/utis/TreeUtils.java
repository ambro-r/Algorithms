package utis;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import objects.Node;

public class TreeUtils {

  public static Node buildTree(File treeFile) {
    Node root = null;
    try {
        JAXBContext jaxbContext = JAXBContext.newInstance(Node.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        root = (Node) jaxbUnmarshaller.unmarshal(treeFile);
    } catch (Exception e) { }
    return root;
  }

}
