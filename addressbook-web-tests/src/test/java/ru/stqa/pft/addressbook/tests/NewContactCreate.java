package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

public class NewContactCreate extends TestBase{

  @Test
  public void testNewContactCreate() throws Exception {
    app.initNewContactCreatePage();
    app.fillNewContact(new NewContactData("First name", "Middle name", "Last name", "Nickname", "Title", "Company", "Address", "Home", "Mobile", "Work", "Fax", "one@one.fox"));
    app.submitNewContactCreation();
    app.logout();
  }

}
