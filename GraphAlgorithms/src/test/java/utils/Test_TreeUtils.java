package utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.net.URL;
import objects.Node;
import org.junit.jupiter.api.Test;
import utis.TreeUtils;

public class Test_TreeUtils {

  @Test
  public void test_buildGrid() {
    URL url = Thread.currentThread().getContextClassLoader().getResource("trees/testTree.xml");
    File file = new File(url.getPath());
    Node root = TreeUtils.buildTree(file);
  }

}
