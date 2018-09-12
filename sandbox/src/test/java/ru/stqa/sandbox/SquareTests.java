package ru.stqa.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by yurap on 10.09.2018.
 */
@Test
public class SquareTests {
  public void testArea(){
    Square s = new Square(5);
    Assert.assertEquals(s.area(),25.0);
  }
}
