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
