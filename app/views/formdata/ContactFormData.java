package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.Contact;
import play.data.validation.Validation;
import play.data.validation.ValidationError;

/**
 * The backing class for form data.
 * @author marc
 */
public class ContactFormData {

  public static final int NUM_TELE_CHARS = 12;

  /** the id field */
  public long id;
  /** the first name form field. */
  public String firstName = "";
  /** the last name form field. */
  public String lastName = "";
  /** the telephone form field. */
  public String telephone = "";
  /** the telephone type. */
  public String telephoneType = "";

  /**
   * Default constructor.
   */
  public ContactFormData() {
   //default constructor
  }
  
  

  /**
   * @param firstName
   * @param lastName
   * @param telephone
   * @param telephoneType
   */
  public ContactFormData(String firstName, String lastName, String telephone, String telephoneType) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.telephoneType = telephoneType;
  }



  /**
   * Creates contactFormData based off contact.
   * @param contact
   */
  public ContactFormData(Contact contact) {
    this.id = contact.getId();
    this.firstName = contact.getFirstName();
    this.lastName = contact.getLastName();
    this.telephone = contact.getTelephone();
    this.telephoneType = contact.getTelephoneType();
  }

  /**
   * Validates the form input by user.
   * All field non-empty.
   * Telephone 12 characters.
   * @return null of no errors
   */
  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<>();

    if (firstName == null || firstName.length() == 0) {
      errors.add(new ValidationError("firstName", "First Name is Required"));
    }

    if (lastName == null || lastName.length() == 0) {
      errors.add(new ValidationError("lastName", "Last Name is Required"));
    }

    if (telephone == null || telephone.length() == 0) {
      errors.add(new ValidationError("telephone", "Telephone is Required"));
    }

    if (telephone.length() != NUM_TELE_CHARS) {
      errors.add(new ValidationError("telephone", "Telephone must be xxx-xxx-xxxx"));
    }

    if (!TelephoneTypes.isType(telephoneType)) {
      errors.add(new ValidationError("telephoneType", "Telephone Type is invalid"));
    }

    return errors.isEmpty() ? null : errors;
  }

}
