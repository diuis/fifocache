package com.demisgallisto.fifocache;

import java.util.List;

public interface Cache<T> {

  void put(T item);

  List<T> getAll();
}
