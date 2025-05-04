package org.example;

public class Cat implements Animal
{
  @Override
  public String getVoice() {
    return "Miay";
  }

  @Override
  public String toString() {
    return "Hello, I'm Cat";
  }
}
