package model;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomerList implements Serializable
{
  ArrayList<Customer> customers;

  /**
   * Constructor initializing the CustomerList
   */
  public CustomerList()
  {
    customers = new ArrayList<Customer>();
  }

  /**
   * Adds a customer to the CustomerList
   * @param customer the customer to be added
   */
  public void addCustomer(Customer customer)
  {
    customers.add(customer);
  }

  /**
   * Sets a customer at a specific index in the CustomerList
   * @param customer the customer to be set
   * @param index the index of the customer to be set
   */
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

  /**
   * Removes a customer from the CustomerList
   * @param index the index of the customer to be removed
   */
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


  /**
   * Removes a customer from the CustomerList
   * @param customer the customer to be removed
   */
  public void removeCustomer(Customer customer)
  {
    if (customer != null)
    {
      customers.remove(customer);
    }
  }

  /**
   * Sets a customer at a specific index in the CustomerList
   * @param index the index of the customer to be set
   * @param customer the customer to be set
   */
  public void setCustomer(int index, Customer customer)
  {
    if (index >= 0 && index < customers.size())
    {
      customers.set(index, customer);
    }
  }

  /**
   * Returns a customer at a specific index in the CustomerList
   * @param index the index of the customer to be returned
   * @return the customer at the specified index
   */
  public Customer getCustomer(int index)
  {
    if (index < 0 || index >= customers.size())
    {
      return null;
    }
    return customers.get(index);
  }

  /**
   * Returns the number of customers in the CustomerList
   * @return the number of customers in the CustomerList
   */
  public int getAllNumberOfCustomers()
  {
    return customers.size();
  }

  //  need this as an array list to show the customers

  /**
   * Returns all customers in the CustomerList
   * @return all customers in the CustomerList
   */
  public Customer[] getAllCustomers()
  {
    return customers.toArray(new Customer[customers.size()]);
  }

  /**
   * Returns a string representation of the CustomerList
   * @return a string representation of the CustomerList
   */
  public String toString()
  {
    String rtnString = "";
    for (int i = 0; i < customers.size(); i++)
    {
      rtnString += (customers.get(i) + "\n");
    }
    return rtnString;
  }

  /**
   * Compares the CustomerList to another object
   * @param obj the object to compare to
   * @return true if the object is equal to the CustomerList
   */
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
