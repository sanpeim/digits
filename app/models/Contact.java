package models;

/**
 * Provides a model for contact data.
 * @author marc
 *
 */
public class Contact {

  private String firstName;
  private String lastName;
  private String telephone;

  /**
   * Creates a contact.
   * @param firstName
   * @param lastName
   * @param telephone
   */
  public Contact(String firstName, String lastName, String telephone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
  }

  /**
   * @return gets first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param sets first name.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return gets last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param sets last name.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return gets telephone.
   */
  public String getTelephone() {
    return telephone;
  }

  /**
   * @param sets telephone.
   */
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

}
