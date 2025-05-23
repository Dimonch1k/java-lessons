package org.com;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicListTest
{
  @Test
  void testAdd() {
    DynamicList dynamicList = new DynamicList();

    dynamicList.add( 5 );

    assertEquals(
      1,
      dynamicList.size()
    );
  }

  @Test
  void testGet() {
    DynamicList dynamicList = new DynamicList();

    dynamicList.add( 7 );
    dynamicList.add( 3 );

    Integer integer = dynamicList.get( 0 );

    assertEquals(
      7,
      integer
    );
  }

  @Test
  void testToString() {
    DynamicList dynamicList = new DynamicList();

    dynamicList.add( 7 );
    dynamicList.add( 3 );

    String string = dynamicList.toString();

    assertEquals(
      "[ 7 3 ]",
      string
    );
  }

  @Test
  void testSize() {
    DynamicList dynamicList = new DynamicList();

    dynamicList.add( 7 );
    dynamicList.add( 3 );

    assertEquals(
      2,
      dynamicList.size()
    );
  }

  @Test
  void testRemove() {
    DynamicList dynamicList = new DynamicList();

    dynamicList.add( 7 );
    dynamicList.add( 3 );
    dynamicList.add( 15 );
    dynamicList.add( 10 );

    Integer removedInteger = dynamicList.remove( 2 );

    assertEquals(
      15,
      removedInteger
    );
  }

  @Test
  void testClear() {
    DynamicList dynamicList = new DynamicList();

    dynamicList.add( 7 );
    dynamicList.add( 3 );

    dynamicList.clear();

    assertEquals(
      "[ ]",
      dynamicList.toString()
    );
  }
}
