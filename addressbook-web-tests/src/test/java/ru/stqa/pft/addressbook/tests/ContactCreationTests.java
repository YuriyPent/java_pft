package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

public class ContactCreationTests extends TestBase{

  @Test(enabled = false)
  public void testNewContactCreate() {
    app.goTo().gotoHomePage();
    app.getNewContactHelper().initNewContactCreatePage();
    app.getNewContactHelper().fillNewContact(new NewContactData("First name", "Middle name",
            "Last name", "Nickname", "Title", "Company", "Address",
            "Home", "Mobile", "Work", "Fax", "one@one.fox","test1"),false);
    app.getNewContactHelper().submitNewContactCreation();
    //app.getNewContactHelper().returnToHomePage();
  }

}
