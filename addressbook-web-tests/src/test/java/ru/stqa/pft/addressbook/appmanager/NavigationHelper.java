package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by yurap on 24.09.2018.
 */
public class NavigationHelper extends HelperBase {


  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void groupPage() {
    if(isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.tagName("new"))){
      return;
    }
    click(By.linkText("groups"));
  }

  public void gotoHomePage() {
    if(isElementPresent(By.id("maintable"))){
      return;
    }
    click(By.linkText("home"));
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  // public void returnToHomePage() {
  //  click(By.linkText("home"));
 // }
}
