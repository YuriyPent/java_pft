package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class NewContactCreate extends TestBase{

  @Test
  public void testNewContactCreate() throws Exception {
    initNewContactCreatePage();
    fillNewContact(new NewContactData("First name", "Middle name", "Last name", "Nickname", "Title", "Company", "Address", "Home", "Mobile", "Work", "Fax", "one@one.fox"));
    submitNewContactCreation();
    logout();
  }

}
