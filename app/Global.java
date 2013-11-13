import models.ContactDB;
import models.UserInfoDB;
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
    
    UserInfoDB.addUserInfo("John Smith", "smith@example.com", "password");
    ContactDB.addContact("smith@example.com", new ContactFormData("A", "Smith", "111-222-3333", "Home"));
    ContactDB.addContact("smith@example.com", new ContactFormData("B", "Smith", "222-333-4444", "Work"));
    
    UserInfoDB.addUserInfo("John Smithy", "smithy@example.com", "password");
    ContactDB.addContact("smithy@example.com", new ContactFormData("C", "Smithy", "333-444-5555", "Mobile"));
    ContactDB.addContact("smithy@example.com", new ContactFormData("D", "Smithy", "444-555-6666", "Home"));

  }
}
