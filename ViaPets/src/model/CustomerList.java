package model;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * A class containing of CustomerList object.
 * @author Nancy
 * @version 1.0
 */
public class CustomerList implements Serializable
{
  ArrayList<Customer> customers;

  public CustomerList()
  {
    customers = new ArrayList<Customer>();
  }

  public void addCustomer(Customer customer)
  {
    customers.add(customer);
  }

  public void setCustomers(Customer customer, int index)
  {
    if (index < 0 || index >= customers.size())
    {
      System.out.println("Invalid index");
    }
    else
    {
      customers.set(index, customer);

    }
  }

  public void removeCustomer(int index)
  {
    if (index < 0 || index >= customers.size())
    {
      System.out.println("Invalid index");
    }
    else
    {
      customers.remove(index);
    }
  }

  public void removeCustomer(Customer customer)
  {
    if (customer != null)
    {
      customers.remove(customer);
    }
  }

  public void setCustomer(int index, Customer customer)
  {
    if (index >= 0 && index < customers.size())
    {
      customers.set(index, customer);
    }
  }

  public Customer getCustomer(int index)
  {
    if (index < 0 || index >= customers.size())
    {
      return null;
    }
    return customers.get(index);
  }

  public int getAllNumberOfCustomers()
  {
    return customers.size();
  }

  public String toString()
  {
    String rtnString = "";
    for (int i = 0; i < customers.size(); i++)
    {
      rtnString += (customers.get(i) + "\n");
    }
    return rtnString;
  }

  public boolean equals(Object obj)
  {
    if (obj == null || obj.getClass() != getClass())
    {
      return false;
    }

    CustomerList other = (CustomerList) obj;
    return customers.equals(other.customers);
  }
}
