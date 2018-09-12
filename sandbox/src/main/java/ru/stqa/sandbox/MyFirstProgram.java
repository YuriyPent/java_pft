package ru.stqa.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {

    Point first = new Point(200, 40);
    Point second = new Point(10, 40);

    System.out.println("Расстояние между двумя точками = " + first.distance(second));
  }

}


