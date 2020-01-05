package comparators;

import java.util.Comparator;
import objects.Block;

public class BlockComparator implements Comparator<Block> {

  @Override
  public int compare(Block block01, Block block02) {
    if(block01.getF() < block02.getF()) return -1;
    if(block01.getF() > block02.getF()) return 1;
    return 0;

  }

}
