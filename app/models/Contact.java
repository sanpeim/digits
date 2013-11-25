package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import play.db.ebean.Model;

/**
 * Provides a model for contact data.
 * @author marc
 *
 */
@Entity
public class Contact extends Model{

  private static final long serialVersionUID = 1L;
  
  @Id
  private long id;
  private String firstName;
  private String lastName;
  private String telephone;
  private String telephoneType;
  
  //Many of Me(Contact) maps to One of the Following(UserInfo)
  @ManyToOne
  private UserInfo userInfo;

  /**
   * Creates a contact.
   * @param firstName first name.
   * @param lastName last name.
   * @param telephone telephone.
   * @param telephoneType telephone type.
   */
  public Contact(String firstName, String lastName, String telephone, String telephoneType) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.telephoneType = telephoneType;
  }
  
  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method for Contacts.
   */
  public static Finder<Long, Contact> find() {
    return new Finder<Long, Contact>(Long.class, Contact.class);
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

  /**
   * @return the userInfo
   */
  public UserInfo getUserInfo() {
    return userInfo;
  }

  /**
   * @param userInfo the userInfo to set
   */
  public void setUserInfo(UserInfo userInfo) {
    this.userInfo = userInfo;
  }

}
