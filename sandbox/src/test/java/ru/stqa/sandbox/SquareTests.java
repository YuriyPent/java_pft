package ru.stqa.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by yurap on 17.09.2018.
 */
public class SquareTests {
  @Test
  public void testArea() {
    Square s = new Square(5);
    Assert.assertEquals(s.area(),25.0);

  }
}
