package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().ContactPage();
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Delete").withLastname("Deletion"));
    }
  }

  @Test
  public void testContactPhones(){
    ContactData contact = app.contact().all().iterator().next();
    ContactData email = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    ContactData emailInfoFromEditForm = app.contact().infoFromEditForm(email);
    assertThat(contact.getAddress(), equalTo(mergeAddress(contactInfoFromEditForm)));
    assertThat(email.getAddress(), equalTo(mergeEmail(emailInfoFromEditForm)));
  }

  private String mergeAddress(ContactData contact) {
    return Arrays.asList(contact.getAddress()).
            stream().
            map(ContactAddressTests::cleaned).
            collect(Collectors.joining(""));
  }
  private String mergeEmail(ContactData email) {
    return Arrays.asList(email.getEmail()).
            stream().
            map(ContactAddressTests::cleaned).
            collect(Collectors.joining(""));
  }


  public static String cleaned(String phone){
    return phone.replaceAll("\\s{2}", "") //очишает 2 и более пробела
            .trim(); //очищает пробелы в начале и конце строки
  }
}