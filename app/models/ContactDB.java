package models;

import java.util.List;
import views.formdata.ContactFormData;

/**
 * Provides in memory repository for contact data.
 * @author marc
 *
 */
public class ContactDB {


  /**
   * Update repo with new contact if id = 0.
   * Creates and return new contact, storing it in repository.
   * @param formData form for data.
   * @return a contact.
   */
  public static void addContact(String user, ContactFormData formData) {
    boolean isNewContact = (formData.id == -1);
    if (isNewContact) {
      Contact contact = new Contact(formData.firstName, formData.lastName, formData.telephone, formData.telephoneType);
      UserInfo userInfo = UserInfo.find().where().eq("email", user).findUnique();
      if (userInfo == null) {
        throw new RuntimeException("Could not find user: " + user);
      }
      userInfo.addContact(contact);
      contact.setUserInfo(userInfo);
      contact.save();
      userInfo.save();
    }
    else {
      Contact contact = Contact.find().byId(formData.id);
      contact.setFirstName(formData.firstName);
      contact.setLastName(formData.lastName);
      contact.setTelephone(formData.telephone);
      contact.setTelephoneType(formData.telephoneType);
      contact.save();
    }
  }

  /**
   * Returns a list of all know contacts.
   * @return a list.
   */
  public static List<Contact> getContacts(String user) {
    UserInfo userInfo = UserInfo.find().where().eq("email", user).findUnique();
    if (userInfo == null) {
      return null;
    }
    else {
      return userInfo.getContacts();
    }
  }
  
  /**
   * 
   * @param user
   * @return
   */
  public static boolean isUser(String user) {
    return (UserInfo.find().where().eq("email", user).findUnique() != null);
  }

  /**
   * @param id the ID.
   * @return Returns a contact with given ID.
   */
  public static Contact getContact(String user, long id) {
    Contact contact = Contact.find().byId(id);
    if (contact == null) {
      throw new RuntimeException("Conact ID not found: " + id);
    }
    UserInfo userInfo = contact.getUserInfo();
    if (!user.equals(userInfo.getEmail())) {
      throw new RuntimeException("Gave a bad user" + user);
    }
    return contact;
  }

}
