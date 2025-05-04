package org.example;

public class Main
{
  public static void main( String[] args ) {
    Animal cat = new Cat();
    Animal dog = new Dog();

    System.out.println(cat);
    System.out.println(cat.getVoice());
    System.out.println(dog.getVoice());



  }
}