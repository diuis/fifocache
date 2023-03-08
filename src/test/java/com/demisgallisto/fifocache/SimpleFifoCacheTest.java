package com.demisgallisto.fifocache;

class SimpleFifoCacheTest {

  private Cache<Integer> sut;

  void setUp() {
    sut = new SimpleFifoCache();
  }

  void whenTheCacheIsEmpty() {

    // when
    var result = sut.getAll();

    // then

  }

  void whenTheCacheIsntFullThenNoItemsWillBeEvicted() {

    // given
    sut.put(1);

    // when
    var result = sut.getAll();

    // then

  }

  void whenTheCacheIsFullThenTheOldestItemIsEvicted() {

    // given
    sut.put(1);
    sut.put(2);
    sut.put(3);
    sut.put(4);

    // when
    var result = sut.getAll();

    // then
    
  }
}