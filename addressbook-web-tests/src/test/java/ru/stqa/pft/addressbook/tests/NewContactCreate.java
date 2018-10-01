package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

public class NewContactCreate extends TestBase{

  @Test
  public void testNewContactCreate() {
    app.getNavigationHelper().gotoHomePage();
    app.getNewContactHelper().initNewContactCreatePage();
    app.getNewContactHelper().fillNewContact(new NewContactData("First name", "Middle name", "Last name",
            "Nickname", "Title", "Company", "Address", "Home", "Mobile",
            "Work", "Fax", "one@one.fox", "test1"),true);
    app.getNewContactHelper().submitNewContactCreation();
    //app.getNavigationHelper().returnToHomePage();
    //app.logout();
  }

}
