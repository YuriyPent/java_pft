package ru.stqa.sandbox;

/**
 * Created by yurap on 08.09.2018.
 */
public class Square {
  public double l;

  public Square(double l){
    this.l = l;
  }
  public double area () {
    return this.l * this.l;
  }
}
