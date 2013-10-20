package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.ContactFormData;

/**
 * Provides in memory repository for contact data.
 * @author marc
 *
 */
public class ContactDB {

  private static Map<Long, Contact> contacts = new HashMap<>();

  /**
   * Update repo with new contact if id = 0.
   * Creates and return new contact, storing it in repository.
   * @param formData form for data.
   * @return a contact.
   */
  public static Contact addContact(ContactFormData formData) {
    long idVal = (formData.id == 0) ? contacts.size() + 1 : formData.id;
    Contact contact = new Contact(idVal, formData.firstName, formData.lastName, formData.telephone);
    contacts.put(idVal, contact);
    return contact;
  }

  /**
   * Returns a list of all know contacts.
   * @return a list.
   */
  public static List<Contact> getContacts() {
    return new ArrayList<>(contacts.values());
  }

  /**
   * Returns a contact with given ID.
   */
  public static Contact getContact(long id) {
    Contact contact = contacts.get(id);
    if (contact == null) {
      throw new RuntimeException("Gave a bad ID" + id);
    }
    return contact;
  }

}
