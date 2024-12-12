package model;

import java.io.Serializable;

public class Customer implements Serializable
{
  private String name;
  private String phoneNumber;
  private String emailAddress;

  public Customer(String name, String phoneNumber, String emailAddress)
  {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.emailAddress = emailAddress;
  }

  public Customer()
  {
    this.name = "";
    this.phoneNumber = "";
    this.emailAddress = "";
  }

  public String getName()
  {
    return name;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public String getEmailAddress()
  {
    return emailAddress;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }

  public void setEmailAddress(String emailAddress)
  {
    this.emailAddress = emailAddress;
  }

  public String toString()
  {
    return "Customer Details: " + "\nName: " + name + "\nPhone Number: "
        + phoneNumber + "\nEmail Address: " + emailAddress;
  }

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
