package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.io.File;

public class ContactCreationTests extends TestBase{

  @Test(enabled = false)
  public void testNewContactCreate() {
    app.goTo().gotoHomePage();
    app.getNewContactHelper().initNewContactCreatePage();
    File photo = new File("src/test/resources/Sinner.jpg");
    app.getNewContactHelper().fillContactForm(new NewContactData().withFirstname("test_name").withLastname("test_surname").withPhoto(photo),true);
    app.getNewContactHelper().submitNewContactCreation();
    app.getNewContactHelper().returnToHomePage();
  }

}
