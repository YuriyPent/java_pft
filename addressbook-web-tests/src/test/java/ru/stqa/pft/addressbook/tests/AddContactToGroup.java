package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;


public class AddContactToGroup extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
    if (app.db().contacts().size() == 0) {
      Groups groups = app.db().groups();
      app.goTo().ContactPage();
      app.contact().create(new ContactData()
              .withFirstname("firstname")
              .withLastname("lastname")
              .withAddress("Moscow")
              .withHomePhone("85214552")
              .withMobilePhone("854125152")
              .withWorkPhone("96385")
              .withEmail("withEmail@test.ru")
              .withEmail2("withEmail2@test.ru")
              .withEmail3("withEmail3@test.ru")
              .inGroup(groups.iterator().next()));
    }
  }

  @Test
  public void addContactToGroups() {
    ContactData contact = app.db().contacts().iterator().next();
    Groups allGroups = app.db().groups();
    GroupData addedGroup = allGroups.iterator().next();
    if (allGroups.equals(contact.getGroups())) {
      app.contact().removeFromGroup(contact, addedGroup);
    }
    allGroups.removeAll(contact.getGroups());
    app.goTo().ContactPage();
    app.contact().addToGroup(contact, addedGroup);
    app.db().refresh(contact);
    assertThat(contact.getGroups(), hasItem(addedGroup));
  }
}
