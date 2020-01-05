package TravelingSalesman.utils;

import TravelingSalesman.objects.World;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class WorldUtils {

  public static World buildWorld(File worldFile) {
    World root = null;
    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(World.class);
      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      root = (World) jaxbUnmarshaller.unmarshal(worldFile);
    } catch (Exception e) { }
    return root;
  }

}
