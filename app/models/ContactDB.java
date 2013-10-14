package models;

import java.util.ArrayList;
import java.util.List;
import views.formdata.ContactFormData;

/**
 * Provides in memory repository for contact data.
 * @author marc
 *
 */
public class ContactDB {

  private static List<Contact> contacts = new ArrayList<>();

  /**
   * Creates and return new contact, storing it in repository.
   * @param formData form for data.
   * @return a contact.
   */
  public static Contact addContact(ContactFormData formData) {
    Contact contact = new Contact(formData.firstName, formData.lastName, formData.telephone);
    contacts.add(contact);
    return contact;
  }

  /**
   * Returns a list of all know contacts.
   * @return a list.
   */
  public static List<Contact> getContacts() {
    return contacts;
  }

}
