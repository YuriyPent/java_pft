package ru.stqa.sandbox;
/**
 * Created by yurap on 08.09.2018.
 */
class Point {
  double x, y;
  Point(double x, double y) {
    this.x = x;
    this.y = y;
  }
  public double getX() {
    return x;
  }
  public double getY() {
    return y;
  }
  public double distance(Point p2) {
    {
      return Math.sqrt(Math.pow(p2.getX() - this.getX(), 2) + Math.pow(p2.getY() - this.getY(), 2));
    }
  }
}