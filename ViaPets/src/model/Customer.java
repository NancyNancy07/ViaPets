package model;

public class Customer
{
  private String name, phoneNumber, email;

  public Customer(String name, String phoneNumber, String email)
  {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.email = email;
  }

  public String getName()
  {
    return name;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public String getEmail()
  {
    return email;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }

  public String toString()
  {
    return "Name: " + name + "\nPhone Number: " + phoneNumber + "\nEmail: " + email;
  }

  public boolean equals(Object obj)
  {
    if(obj == null || obj.getClass() != getClass())
    {
      return false;
    }
    Customer tempCustomer = (Customer)obj;
    return name.equals(tempCustomer.name) && phoneNumber.equals(tempCustomer.phoneNumber) && email.equals(tempCustomer.email);
  }
}
