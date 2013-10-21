package models;

/**
 * Provides a model for contact data.
 * @author marc
 *
 */
public class Contact {

  private long id;
  private String firstName;
  private String lastName;
  private String telephone;
  private String telephoneType;

  /**
   * Creates a contact.
   * @param id the id.
   * @param firstName first name.
   * @param lastName last name.
   * @param telephone telephone.
   * @param telephoneType telephone type.
   */
  public Contact(long id, String firstName, String lastName, String telephone, String telephoneType) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.telephoneType = telephoneType;
  }

  /**
   * @return gets first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName sets first name.
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
   * @param lastName sets last name.
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
   * @param telephone sets telephone.
   */
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  /**
   * @return gets id.
   */
  public long getId() {
    return id;
  }

  /**
   * @return gets telephone type.
   */
  public String getTelephoneType() {
    return telephoneType;
  }

  /**
   * @param telephoneType sets telephone type.
   */
  public void setTelephoneType(String telephoneType) {
    this.telephoneType = telephoneType;
  }

}
