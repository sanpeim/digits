package controllers;

import models.ContactDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
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
   */
  public static Result newContact(long id) {
    ContactFormData data = (id == 0) ? new ContactFormData() : new ContactFormData(ContactDB.getContact(id));
    Form<ContactFormData> formData = Form.form(ContactFormData.class).fill(data);
    return ok(NewContact.render(formData));
  }

  /**
   * Handles posting of form data from user.
   * @return The NewContact Page with form data.
   */
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      System.out.println("Errors Found");
      return badRequest(NewContact.render(formData));
    }
    else {
      ContactFormData data = formData.get();
      ContactDB.addContact(data);
      return ok(NewContact.render(formData));
    }
  }
  
  public static Result deleteContact(long id){
    ContactDB.deleteContact(id);
    return ok(Index.render(ContactDB.getContacts()));
  }
}
