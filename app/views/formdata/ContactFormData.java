package views.formdata;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.Validation;
import play.data.validation.ValidationError;

/**
 * The backing class for form data.
 * @author marc
 */
public class ContactFormData {

  public static final int NUM_TELE_CHARS = 12;
  public static final int NUM_ADDRESS_CHARS = 25;
  
  /** the first name form field. */
  public String firstName = "";
  /** the last name form field. */
  public String lastName = "";
  /** the telephone form field. */
  public String telephone = "";
  /** the address form field. */
  public String address = "";
  
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
      errors.add(new ValidationError("telephone", "Telephone must be xxx-xxx-xxx"));
    }
    
    if (address == null || address.length() == 0) {
      errors.add(new ValidationError("address", "Address is Required"));
    }

    if (address.length() < NUM_ADDRESS_CHARS) {
      errors.add(new ValidationError("address", "Address must be at least 25 characters"));
    }

    return errors.isEmpty() ? null : errors;
  }

}
