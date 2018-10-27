package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().ContactPage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Delete").withLastname("Deletion"));
    }
  }

  @Test(enabled = false)
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();

    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Petr").withMiddlename("Petrovich").
            withLastname("Ivanov").withAddress("Moscow Red squre 1 h1").
            withHomePhone("+79153925555").withNickname("Ivan_01").inGroup(groups.iterator().next());
    app.contact().modify(contact);
    Assert.assertEquals(app.group().count(), before.size());
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));

  }
}
