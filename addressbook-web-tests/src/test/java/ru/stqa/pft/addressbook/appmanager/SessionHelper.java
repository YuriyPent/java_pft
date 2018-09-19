package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by yurap on 19.09.2018.
 */
public class SessionHelper {
  private FirefoxDriver wd;

  public SessionHelper(FirefoxDriver wd) {
    this.wd = wd;
  }
  public void login(String username, String password) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.xpath("//input[@value='Login']")).click();
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::input[2]")).click();
  }
}
