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

  private static Map<String, Map<Long, Contact>> contacts = new HashMap<String, Map<Long,Contact>>();

  /**
   * Update repo with new contact if id = 0.
   * Creates and return new contact, storing it in repository.
   * @param formData form for data.
   * @return a contact.
   */
  public static Contact addContact(String user, ContactFormData formData) {
    long idVal = (formData.id == 0) ? contacts.size() + 1 : formData.id;
    Contact contact = new Contact(idVal, formData.firstName, formData.lastName, 
                                    formData.telephone, formData.telephoneType);
    if (!isUser(user)){
      contacts.put(user, new HashMap<Long,Contact>());
    }
    contacts.get(user).put(idVal, contact);
    return contact;
  }

  /**
   * Returns a list of all know contacts.
   * @return a list.
   */
  public static List<Contact> getContacts(String user) {
    if (!isUser(user)){
      return null;
    }
    return new ArrayList<>(contacts.get(user).values());
  }
  
  /**
   * 
   * @param user
   * @return
   */
  public static boolean isUser(String user) {
    return contacts.containsKey(user);
  }

  /**
   * @param id the ID.
   * @return Returns a contact with given ID.
   */
  public static Contact getContact(String user, long id) {
    if (!isUser(user)){
      throw new RuntimeException("Gave a bad user" + user);
    }
    Contact contact = contacts.get(user).get(id);
    if (contact == null) {
      throw new RuntimeException("Gave a bad ID" + id);
    }
    return contact;
  }

}
