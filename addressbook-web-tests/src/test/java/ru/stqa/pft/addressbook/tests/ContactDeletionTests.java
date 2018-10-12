package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test(enabled = false)

  public void testContactDeletion(){
    app.getNavigationHelper().gotoHomePage();
    app.getNewContactHelper().initContactModification();
    app.getNewContactHelper().initDeleteContact();

    //app.getNavigationHelper().returnToHomePage();
    //app.logout();
  }
}
