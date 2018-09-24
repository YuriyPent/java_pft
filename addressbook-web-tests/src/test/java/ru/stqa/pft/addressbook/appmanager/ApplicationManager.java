package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.concurrent.TimeUnit;

/**
 * Created by yurap on 21.09.2018.
 */
public class ApplicationManager {

  FirefoxDriver wd;

  private NavigationHelper navigationHelper = new NavigationHelper();
  private GroupHelper groupHelper;

  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost:8080/addressbook/");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    login("admin", "secret");
  }

  private void login(String username, String password) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  public void submitNewContactCreation() {
    groupHelper.wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  public void fillNewContact(NewContactData newContactData) {
    groupHelper.wd.findElement(By.name("firstname")).click();
    groupHelper.wd.findElement(By.name("firstname")).clear();
    groupHelper.wd.findElement(By.name("firstname")).sendKeys(newContactData.getFirstname());
    groupHelper.wd.findElement(By.name("middlename")).click();
    groupHelper.wd.findElement(By.name("middlename")).clear();
    groupHelper.wd.findElement(By.name("middlename")).sendKeys(newContactData.getMiddlename());
    groupHelper.wd.findElement(By.name("lastname")).click();
    groupHelper.wd.findElement(By.name("lastname")).clear();
    groupHelper.wd.findElement(By.name("lastname")).sendKeys(newContactData.getLastname());
    groupHelper.wd.findElement(By.name("nickname")).click();
    groupHelper.wd.findElement(By.name("nickname")).clear();
    groupHelper.wd.findElement(By.name("nickname")).sendKeys(newContactData.getNickname());
    groupHelper.wd.findElement(By.name("title")).click();
    groupHelper.wd.findElement(By.name("title")).clear();
    groupHelper.wd.findElement(By.name("title")).sendKeys(newContactData.getTitle());
    groupHelper.wd.findElement(By.name("company")).click();
    groupHelper.wd.findElement(By.name("company")).clear();
    groupHelper.wd.findElement(By.name("company")).sendKeys(newContactData.getCompany());
    groupHelper.wd.findElement(By.name("address")).click();
    groupHelper.wd.findElement(By.name("address")).clear();
    groupHelper.wd.findElement(By.name("address")).sendKeys(newContactData.getAddress());
    groupHelper.wd.findElement(By.name("home")).click();
    groupHelper.wd.findElement(By.name("home")).clear();
    groupHelper.wd.findElement(By.name("home")).sendKeys(newContactData.getHome());
    groupHelper.wd.findElement(By.name("mobile")).click();
    groupHelper.wd.findElement(By.name("mobile")).clear();
    groupHelper.wd.findElement(By.name("mobile")).sendKeys(newContactData.getMobile());
    groupHelper.wd.findElement(By.name("work")).click();
    groupHelper.wd.findElement(By.name("work")).clear();
    groupHelper.wd.findElement(By.name("work")).sendKeys(newContactData.getWork());
    groupHelper.wd.findElement(By.name("fax")).click();
    groupHelper.wd.findElement(By.name("fax")).clear();
    groupHelper.wd.findElement(By.name("fax")).sendKeys(newContactData.getFax());
    groupHelper.wd.findElement(By.name("email")).click();
    groupHelper.wd.findElement(By.name("email")).clear();
    groupHelper.wd.findElement(By.name("email")).sendKeys(newContactData.getEmail());
    groupHelper.wd.findElement(By.name("bday")).click();
    new Select(groupHelper.wd.findElement(By.name("bday"))).selectByVisibleText("10");
    groupHelper.wd.findElement(By.xpath("//option[@value='10']")).click();
    groupHelper.wd.findElement(By.name("bmonth")).click();
    new Select(groupHelper.wd.findElement(By.name("bmonth"))).selectByVisibleText("February");
    groupHelper.wd.findElement(By.xpath("//option[@value='February']")).click();
    groupHelper.wd.findElement(By.name("byear")).click();
    groupHelper.wd.findElement(By.name("byear")).clear();
    groupHelper.wd.findElement(By.name("byear")).sendKeys("2010");
    groupHelper.wd.findElement(By.name("new_group")).click();
    new Select(groupHelper.wd.findElement(By.name("new_group"))).selectByVisibleText("test1");
  }

  public void initNewContactCreatePage() {
    groupHelper.wd.findElement(By.linkText("add new")).click();
  }

  public void stop() {
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      groupHelper.wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      groupHelper.wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = groupHelper.wd.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }

  public void logout() {
      groupHelper.wd.findElement(By.linkText("Logout")).click();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
