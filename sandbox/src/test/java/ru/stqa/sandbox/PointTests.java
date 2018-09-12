package ru.stqa.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by yurap on 12.09.2018.
 */
@Test
public class PointTests {
  public void testDistance(){
    Point p1 = new Point(10,10);
    Point p2 = new Point(10,20);
    Assert.assertEquals(p1.distance(p2),10.0);
    System.out.println("Тест #1 пройден !");
  }
  public void testDistance2(){
    Point p1 = new Point(0,0);
    Point p2 = new Point(100,0);
    Assert.assertEquals(p1.distance(p2),100.0);
    System.out.println("Тест #2 пройден !");
  }

}
