package ru.stqa.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {

    Point first = new Point(20, 30);
    Point second = new Point(10, 30);

    System.out.println("Расстояние между двумя точками = " + first.distance(second));
  }

}


