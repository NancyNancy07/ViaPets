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

  /**
   * Constructs a new CustomerList object.
   */
  public CustomerList()
  {
    customers = new ArrayList<Customer>();
  }

  /**
   * Adds a customer to the list.
   * @param customer the Customer to be added to the list
   */
  public void addCustomer(Customer customer)
  {
    customers.add(customer);
  }


  /**
   * Removes the specified customer from the list.
   * @param customer the index of the customer to retrieve
   */
  public void removeCustomer(Customer customer)
  {
    if (customer != null)
    {
      customers.remove(customer);
    }
  }

  /**
   * Replaces the customer at the specified index with a new customer.
   * @param customer the new Customer to set at the specified index
   * @param index the index where the customer will be set
   */
  public void setCustomer(int index, Customer customer)
  {
    if (index >= 0 && index < customers.size())
    {
      customers.set(index, customer);
    }
  }

  /**
   * Gets the customer at the specified index in the list.
   * @param index the index of the customer to retrieve
   * @return the Customer at the specified index or null if the index is invalid
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
   * Gets the number of customers in the list.
   * @return the number of customers in the list
   */
  public int getAllNumberOfCustomers()
  {
    return customers.size();
  }

  /**
   * Returns a string representation of this CustomerList, including information from all customers.
   * @return a string description of the kennel customer list
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
   * Compares this CustomerList to the specified object.
   * The result is true if and only if the argument is not null and is a CustomerList object that contains the same customers as this CustomerList.
   * @param obj the object to compare this CustomerList against
   * @return true if the given object represents a CustomerList equivalent to this CustomerList, false otherwise
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
