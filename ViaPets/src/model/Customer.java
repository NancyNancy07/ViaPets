package model;

import java.io.Serializable;

/**
 * A class containing of Customer object.
 *
 * @author Nancy
 * @version 1.0
 */
public class Customer implements Serializable
{
  private String name;
  private String phoneNumber;
  private String emailAddress;

  /**
   * Three-argument constructor
   *
   * @param name         name of the customer
   * @param phoneNumber  phone number of the customer
   * @param emailAddress email address of the customer
   */
  public Customer(String name, String phoneNumber, String emailAddress)
  {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.emailAddress = emailAddress;
  }

  /**
   * Getter for the name of the customer
   *
   * @return the name of the customer
   */
  public String getName()
  {
    return name;
  }

  /**
   * Getter for the phone number of the customer
   *
   * @return the phone number of the customer
   */
  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  /**
   * Getter for the email address of the customer
   *
   * @return the email address of the customer
   */
  public String getEmailAddress()
  {
    return emailAddress;
  }

  /**
   * Setter for the name of the customer
   *
   * @param name the name of the customer
   */
  public void setName(String name)
  {
    this.name = name;
  }

  /**
   * Setter for the phone number of the customer
   *
   * @param phoneNumber the phone number of the customer
   */
  public void setPhoneNumber(String phoneNumber)
  {
    if (phoneNumber != null && !phoneNumber.startsWith("-"))
    {
      this.phoneNumber = phoneNumber;
    }
    else
    {
      throw new IllegalArgumentException(
          "Phone number cannot be negative or null.");
    }
  }

  /**
   * Setter for the email address of the customer
   *
   * @param emailAddress the email address of the customer
   */
  public void setEmailAddress(String emailAddress)
  {
    if (emailAddress != null && emailAddress.contains("@")
        && emailAddress.contains("."))
    {
      this.emailAddress = emailAddress;
    }
    else
    {
      throw new IllegalArgumentException(
          "Invalid email address format. Make sure it contains '@' and '.'");
    }
  }

  /**
   * Returns a string representation of the Customer
   *
   * @return a string representation of the Customer
   */
  public String toString()
  {
    return name + ", " + phoneNumber + ", " + emailAddress;
  }

  /**
   * Compares two Customer objects
   *
   * @param obj the object to compare with
   * @return true if the given object is equal to this Customer object
   */
  public boolean equals(Object obj)
  {
    if (obj == null || obj.getClass() != getClass())
    {
      return false;
    }

    Customer other = (Customer) obj;
    return name.equals(other.name) && phoneNumber.equals(other.phoneNumber)
        && emailAddress.equals(other.emailAddress);
  }
}
