import models.ContactDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.ContactFormData;

/**
 * 
 * @author marc
 *
 */
public class Global extends GlobalSettings {
  /**
   *
   *@param app the application.
   */
  public void onStart(Application app) {
    ContactDB.addContact(new ContactFormData("A", "B", "111-222-3333", "Home"));
    ContactDB.addContact(new ContactFormData("B", "C", "222-333-4444", "Work"));
    ContactDB.addContact(new ContactFormData("C", "D", "333-444-5555", "Mobile"));
    ContactDB.addContact(new ContactFormData("D", "E", "444-555-6666", "Home"));

  }
}
