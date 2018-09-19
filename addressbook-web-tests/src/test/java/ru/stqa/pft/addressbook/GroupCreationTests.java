package ru.stqa.pft.addressbook;

import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test1", "test2", "test3"));
    submitGroupCreation();
    returnToGroupPage();
    wd.findElement(By.linkText("Logout")).click();
    //wd.findElement(By.name("user")).clear();
    //wd.findElement(By.name("user")).sendKeys("admin");
  }

}
