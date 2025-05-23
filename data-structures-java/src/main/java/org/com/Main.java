package org.com;

import java.util.List;

public class Main
{
  public static void main( String[] args ) {
    System.out.println("----------------------\n\n");

    List<Integer> dynamicList = new DynamicList();

    dynamicList.add( 5 );
    dynamicList.add( 10 );
    dynamicList.add( 2 );
    dynamicList.add( 18 );
    dynamicList.add( 3 );


    System.out.println( "List size: " + dynamicList.size() );
    System.out.println( "Array items: " + dynamicList );

    System.out.println( "\nArray item #1: " + dynamicList.get( 2 ) );
    System.out.println( "Array item: #2: " + dynamicList.get( 4 ) );

    System.out.println( "\nRemoved item #1: " + dynamicList.remove( 1 ) );
    System.out.println( "Array items: " + dynamicList );
    System.out.println( "\nRemoved item #2: " + dynamicList.remove( 2 ) );
    System.out.println( "Array items: " + dynamicList );
    System.out.println( "\nRemoved item #3: " + dynamicList.remove( 2 ) );
    System.out.println( "Array items: " + dynamicList );

    System.out.println( "\nList size: " + dynamicList.size() );

    dynamicList.clear();
    System.out.println("\nClearing dynamic list..." );

    System.out.println( "\nList size: " + dynamicList.size() );
    System.out.println( "Array items: " + dynamicList );

    System.out.println("\n\n----------------------");
  }
}