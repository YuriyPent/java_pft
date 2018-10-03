package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by yurap on 01.10.2018.
 */
public class ContactDeletionTests extends TestBase {
  @Test

  public void testContactDeletion(){
    app.getNavigationHelper().gotoHomePage();
    app.getNewContactHelper().initContactModification();
    app.getNewContactHelper().initDeleteContact();

    //app.getNavigationHelper().returnToHomePage();
    //app.logout();
  }
}
