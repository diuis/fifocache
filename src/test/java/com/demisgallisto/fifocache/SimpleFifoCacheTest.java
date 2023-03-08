package com.demisgallisto.fifocache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

class SimpleFifoCacheTest {

  private Cache<Integer> sut;

  @BeforeEach
  void setUp() {
    sut = new SimpleFifoCache(3);
  }

  @Test
  void whenTheCacheMaxSizeIsLowerThenZeroThenThrowsException() {
    assertThatIllegalStateException().isThrownBy(() -> new SimpleFifoCache(-1));
  }

  @Test
  void whenTheCacheMaxSizeIsEqualsToZeroThenThrowsException() {
    assertThatIllegalStateException().isThrownBy(() -> new SimpleFifoCache(0));
  }

  @Test
  void whenTheCacheIsEmptyThenReturnsAnEmptyList() {

    // when
    var result = sut.getAll();

    // then
    assertThat(result).isEmpty();
  }

  @Test
  void whenOneItemIsInsertedIntoTheCacheThenReturnsTheListWithTheSingleItem() {

    // given
    sut.put(1);

    // when
    var result = sut.getAll();

    // then
    assertThat(result).isEqualTo(List.of(1));
  }

  @Test
  void whenMoreItemsAreInsertedIntoTheCacheAndTheCacheIsntFullThenReturnsAllTheItems() {

    // given
    sut.put(1);
    sut.put(2);
    sut.put(3);

    // when
    var result = sut.getAll();

    // then
    assertThat(result).isEqualTo(List.of(3, 2, 1));
  }

  @Test
  void whenMoreItemsAreInsertedIntoTheCacheAndTheCacheIsFullThenEvictTheOldestItemsAndReturnsAllTheYoungestItems() {

    // given
    sut.put(1);
    sut.put(2);
    sut.put(3);
    sut.put(4);
    sut.put(2);

    // when
    var result = sut.getAll();

    // then
    assertThat(result).isEqualTo(List.of(2, 4, 3));
  }
}