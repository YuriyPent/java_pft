package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {super(wd);}

  public void initNewContactCreatePage() {
    click(By.linkText("add new"));
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void submitNewContactCreation() {
    click(By.name("submit"));
  }
  public void initContactModification(){
    click(By.cssSelector("img[alt='Edit']"));
  }
  public void submitContactModification(){
    click(By.name("update"));
  }


  public void fillContactForm(NewContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("fax"), contactData.getFax());
    type(By.name("email"), contactData.getEmail());
    attach(By.name("photo"), contactData.getPhoto());

    if (creation) {
      if (contactData.getGroup() != null) {
        new Select(wd.findElement(By.name("new_group")))
                .selectByVisibleText(contactData.getGroup());
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value = '" + id + "']")).click();
  }


  public void editContact(int index) {
    wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
//    click(By.xpath("//img[@alt='Edit']"));
  }

  public void editContactById(int id) {
    wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
  }


  public void create(NewContactData contactData) {
    initNewContactCreatePage();
    fillContactForm(contactData, true);
    submitNewContactCreation();
    returnToHomePage();
  }

  public void modify(NewContactData contact) {
    editContactById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    returnToHomePage();
  }

  public void delete(int index) {
    selectContact(index);
    deleteContact();
  }

  public void delete(NewContactData contact) {
    selectContactById(contact.getId());
    deleteContact();
  }


  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size(); //метод возвращает количество элементов в списке
  }

  public List<NewContactData> list() {

    List<NewContactData> contacts = new ArrayList<NewContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {  //переменная пробегает по строкам таблицы
      List<WebElement> trs = element.findElements(By.tagName("td")); //массив из элементов строки
      List<String> strings = new ArrayList<String>(); //массив для преобразования вебэлемент в стринг
      for (WebElement e : trs) {
        strings.add(e.getText()); //метод переводит вебэлемент в стринг
      }
      String firstname = strings.get(2);
      String lastname = strings.get(1);
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      NewContactData contact = new NewContactData().withId(id).withFirstname(firstname).withLastname(lastname);
      contacts.add(contact); //присвоение переменной возвращаемому массиву
    }
    return contacts;
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {  //переменная пробегает по строкам таблицы
      List<WebElement> trs = element.findElements(By.tagName("td")); //массив из элементов строки
      List<String> strings = new ArrayList<String>(); //массив для преобразования вебэлемент в стринг
      for (WebElement e : trs) {
        strings.add(e.getText()); //метод переводит вебэлемент в стринг
      }
      String firstname = strings.get(2);
      String lastname = strings.get(1);
      String address = strings.get(3);
      String allEmail = strings.get(4);
      String allPhones = strings.get(5);
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value")); //присвоение уникального идентификатора
      contacts.add(new NewContactData().withId(id).withFirstname(firstname).withLastname(lastname)
              .withAddress(address).withAllEmail(allEmail).withAllPhones(allPhones));
      /*   String[] phones = strings.get(5).split("\n");
      ContactData contact = new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
              .withHomephone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]);
      contacts.add(contact); //присвоение переменной возвращаемому массиву */
    }
    return contacts;
  }

  public NewContactData infoFromEditForm(NewContactData contact) {
    editContactById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String homePhone = wd.findElement(By.name("home")).getAttribute("value");
    String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
    String workPhone = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    wd.navigate().back(); //команда на возврат драйверу.
    return new NewContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
            .withHomephone(homePhone).withMobilePhone(mobilePhone).withWorkPhone(workPhone).
                    withEmail(email).withEmail2(email2).withEmail3(email3).withAddress(address);
  }

  public void addToGroup(NewContactData contact, GroupData group) {
    selectContactById(contact.getId());
    new Select(wd.findElement(By.name("to_group"))).selectByValue(Integer.toString(group.getId()));
    click(By.name("add"));
    returnToHomePage();
  }

  public void selectGroupFromList(String group, String element) {
    new Select(wd.findElement(By.name(element))).selectByVisibleText(group);
  }

  public void removeFromGroup (NewContactData contact, GroupData group) {
    selectGroupFromList("[all]", "group");
    selectGroupFromList(group.getName(), "group");
    selectContactById(contact.getId());
    click(By.name("remove"));
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

}
