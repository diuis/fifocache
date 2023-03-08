package com.demisgallisto.fifocache;

import java.util.LinkedList;
import java.util.List;

public class SimpleFifoCache implements Cache<Integer> {

  private final LinkedList<Integer> fifoQueue = new LinkedList<>();
  private final int                 size;

  public SimpleFifoCache(int size) {
    if (size <= 0) {
      throw new IllegalStateException("cache size must be greater than zero");
    }
    this.size = size;
  }

  @Override
  public void put(Integer item) {
    synchronized (fifoQueue) {
      if (fifoQueue.size() == size) {
        fifoQueue.removeLast();
      }
      fifoQueue.addFirst(item);
    }
  }

  @Override
  public List<Integer> getAll() {
    synchronized (fifoQueue) {
      return fifoQueue;
    }
  }
}
