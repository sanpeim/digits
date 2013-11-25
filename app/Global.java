import models.ContactDB;
import models.UserInfoDB;
import play.Application;
import play.GlobalSettings;
import play.Play;
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
    
    String adminEmail = Play.application().configuration().getString("digits.admin.email");
    String adminPassword = Play.application().configuration().getString("digits.admin.password");
    
    UserInfoDB.defineAdmin("Administrator", adminEmail, adminPassword);
    
    if (UserInfoDB.adminDefined() && UserInfoDB.getUser(adminEmail).getContacts().isEmpty()){
      ContactDB.addContact(adminEmail, new ContactFormData("A", "Smith", "111-222-3333", "Home"));
      ContactDB.addContact(adminEmail, new ContactFormData("B", "Smith", "222-333-4444", "Work"));
    }
  }
}
