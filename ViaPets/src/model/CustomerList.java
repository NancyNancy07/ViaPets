package model;

import java.io.Serializable;
import java.util.ArrayList;

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

  //  need this as an array list to show the customers
  public Customer[] getAllCustomers()
  {
    return customers.toArray(new Customer[customers.size()]);
  }

  public String toString()
  {
    return "CustomerList:\n" + customers;
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
