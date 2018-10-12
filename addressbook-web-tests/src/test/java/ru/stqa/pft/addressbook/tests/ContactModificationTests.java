package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

public class ContactModificationTests extends TestBase {

  @Test(enabled = false)
  public void testContactModification() {
    app.getNewContactHelper().gotoHomePage();
 /*   if(! app.getNewContactHelper().isThereAContact()){
      app.getNewContactHelper().createContact(new NewContactData());
    }*/
    app.getNewContactHelper().initContactModification();
    app.getNewContactHelper().fillNewContact(new NewContactData("First name",
            "Middle name", "Last name", "Nickname",
            "Title", "Company", "Address", "Home",
            "Mobile", "Work", "Fax", "one@one.fox", null), false);
    app.getNewContactHelper().submitContactModification();
    app.getNavigationHelper().returnToHomePage();

  }
}
