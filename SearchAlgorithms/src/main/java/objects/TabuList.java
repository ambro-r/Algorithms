package objects;

import java.util.List;
import java.util.Queue;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.collections4.queue.CircularFifoQueue;

public class TabuList {

  private static int TABU_TENURE_QUEUE_SIZE = 400;

  private Queue<Point> tabuQueue;

  public TabuList() {
    this.tabuQueue = new CircularFifoQueue<>(TABU_TENURE_QUEUE_SIZE);
  }

  public void add(Point point) {
    tabuQueue.add(point);
  }

  public boolean contains(Point point) {
    return tabuQueue.contains(point);
  }

  public List<Point> getTabuItems() {
    return IteratorUtils.toList(tabuQueue.iterator());
  }

}
