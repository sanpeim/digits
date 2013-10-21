package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.Contact;
import models.GradeLevel;
import play.data.validation.Validation;
import play.data.validation.ValidationError;

/**
 * The backing class for form data.
 * @author marc
 */
public class ContactFormData {

  /** the telephone limit. */
  public static final int NUM_TELE_CHARS = 12;

  /** the id field. */
  public long id;
  /** the first name form field. */
  public String firstName = "";
  /** the last name form field. */
  public String lastName = "";
  /** the telephone form field. */
  public String telephone = "";
  /** the telephone type. */
  public String telephoneType = "";
  
  public String level = "";

  /**
   * Default constructor.
   */
  public ContactFormData() {
   //default constructor
  }
  
  

  /**
   * @param firstName first name.
   * @param lastName last name.
   * @param telephone telephone.
   * @param telephoneType telephone type.
   */
  public ContactFormData(String firstName, String lastName, String telephone, String telephoneType, String level) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.telephoneType = telephoneType;
    this.level = level;
  }



  /**
   * Creates contactFormData based off contact.
   * @param contact the contact.
   */
  public ContactFormData(Contact contact) {
    this.id = contact.getId();
    this.firstName = contact.getFirstName();
    this.lastName = contact.getLastName();
    this.telephone = contact.getTelephone();
    this.telephoneType = contact.getTelephoneType();
    this.level = contact.getLevel();
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
