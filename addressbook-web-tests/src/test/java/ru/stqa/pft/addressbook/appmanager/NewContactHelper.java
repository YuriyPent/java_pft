package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.NewContactData;

/**
 * Created by yurap on 24.09.2018.
 */
public class NewContactHelper extends HelperBase {

  public NewContactHelper(WebDriver wd) {super(wd);}

  public void submitNewContactCreation() {
    click(By.name("submit"));
  }
  public void initNewContactCreatePage() {
    click(By.linkText("add new"));
  }
  public void returnToHomePage(){
    click(By.linkText("home page"));
  }
  public void initContactModification(){
    click(By.cssSelector("img[alt='Edit']"));
  }
  public void submitContactModification(){
    click(By.name("update"));
  }
  public void fillNewContact(NewContactData newContactData,boolean creation) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(newContactData.getFirstname());
    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys(newContactData.getMiddlename());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(newContactData.getLastname());
    wd.findElement(By.name("nickname")).click();
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys(newContactData.getNickname());
    wd.findElement(By.name("title")).click();
    wd.findElement(By.name("title")).clear();
    wd.findElement(By.name("title")).sendKeys(newContactData.getTitle());
    wd.findElement(By.name("company")).click();
    wd.findElement(By.name("company")).clear();
    wd.findElement(By.name("company")).sendKeys(newContactData.getCompany());
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(newContactData.getAddress());
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(newContactData.getHome());
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(newContactData.getMobile());
    wd.findElement(By.name("work")).click();
    wd.findElement(By.name("work")).clear();
    wd.findElement(By.name("work")).sendKeys(newContactData.getWork());
    wd.findElement(By.name("fax")).click();
    wd.findElement(By.name("fax")).clear();
    wd.findElement(By.name("fax")).sendKeys(newContactData.getFax());
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(newContactData.getEmail());
    wd.findElement(By.name("bday")).click();
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText("10");
    wd.findElement(By.xpath("//option[@value='10']")).click();
    wd.findElement(By.name("bmonth")).click();
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText("February");
    wd.findElement(By.xpath("//option[@value='February']")).click();
    wd.findElement(By.name("byear")).click();
    wd.findElement(By.name("byear")).clear();
    wd.findElement(By.name("byear")).sendKeys("2010");
    //wd.findElement(By.name("new_group")).click();


    if(creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(NewContactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void gotoHomePage() {
    click(By.linkText("home"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void initDeleteContact() {
    wd.findElement(By.name("Delete")).click();
  }

 /*ublic void createContact(NewContactData contact){
    initContactModification();
    fillNewContact(contact);
    submitContactModification();
    returnToHomePage();
  }*/
}
