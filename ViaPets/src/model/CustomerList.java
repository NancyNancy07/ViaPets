package model;

import java.util.ArrayList;

public class CustomerList
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

  //  here should not be customer
  public void setCustomers(Customer customer, int index)
  {
    //    customers.get(index).
  }

  public void removeCustomer(int index)
  {
    customers.remove(index);
  }

  public Customer getCustomer(int index)
  {
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
