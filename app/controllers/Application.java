package controllers;

import java.util.Map;
import models.ContactDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.formdata.TelephoneTypes;
import views.html.Index;
import views.html.NewContact;
import views.formdata.ContactFormData;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page.
   * @return The resulting home page.
   */
  public static Result index() {
    return ok(Index.render(ContactDB.getContacts()));
  }

  /**
   * Returns NewContact, a simple form.
   * @return The NewContact Page.
   * @param id the ID is sent.
   */
  public static Result newContact(long id) {
    ContactFormData data = (id == 0) ? new ContactFormData() : new ContactFormData(ContactDB.getContact(id));
    Form<ContactFormData> formData = Form.form(ContactFormData.class).fill(data);
    Map<String, Boolean> telephoneTypeMap = TelephoneTypes.getTypes(data.telephoneType);
    return ok(NewContact.render(formData, telephoneTypeMap));

  }

  /**
   * Handles posting of form data from user.
   * @return The NewContact Page with form data.
   */
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      Map<String, Boolean> telephoneTypeMap = TelephoneTypes.getTypes();
      return badRequest(NewContact.render(formData, telephoneTypeMap));
    }
    else {
      ContactFormData data = formData.get();
      ContactDB.addContact(data);
      Map<String, Boolean> telephoneTypeMap = TelephoneTypes.getTypes(data.telephoneType);
      return ok(NewContact.render(formData, telephoneTypeMap));
    }
  }
}
