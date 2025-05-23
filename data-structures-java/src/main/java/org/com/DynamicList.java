package org.com;

import java.util.AbstractList;

public class DynamicList extends AbstractList<Integer>
{
  private       Integer[] items;
  private       int       count;
  private final int       INITIAL_SIZE = 9;

  public DynamicList() {
    items = new Integer[INITIAL_SIZE];
  }

  @Override
  public boolean add( Integer integer ) {
    if ( isFull() ) {
      Integer[] newArray = new Integer[count + 4];

      for ( int i = 0; i < count; i++ ) {
        newArray[i] = items[i];
      }

      items = newArray;
    }

    items[count] = integer;

    count++;

    return true;
  }

  @Override
  public Integer get( int index ) {
    try {
      return items[index - 1];
    }
    catch ( Exception ex ) {
      throw new IndexOutOfBoundsException( "Such array item doesn't exist" );
    }
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append( "[ " );
    for ( int i = 0; i < count; i++ ) {
      stringBuilder.append( items[i] );
      stringBuilder.append( " " );
    }
    stringBuilder.append( "]" );

    return stringBuilder.toString();
  }

  @Override
  public int size() {
    return count;
  }

  @Override
  public Integer remove( int itemOrderNumber ) {
    try {
      int index = itemOrderNumber - 1;

      System.out.println("Index: " + items[index]);
      if ( items[index] == null ) {
        throw new IndexOutOfBoundsException( "Such array item doesn't exist" );
      }

      System.out.println("Index: " + items[index]);

      Integer removedItem = items[index];

      for ( int i = index; i < count - 1; i++ ) {
       items[i] = items[i + 1];
      }

      count--;

      return removedItem;
    }
    catch ( Exception ex ) {
      throw new IndexOutOfBoundsException( "Such array item doesn't exist" );
    }
  }

  @Override
  public void clear() {

  }

  private boolean isFull() {
    return count + 1 > items.length;
  }
}