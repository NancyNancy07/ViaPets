package model;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomerList implements Serializable
{
  private ArrayList<Customer> customerList;

  public CustomerList()
  {
    customerList = new ArrayList<Customer>();
  }

  public void addCustomer(Customer customer)
  {
    customerList.add(customer);
  }

  public ArrayList<Customer> getCustomerList()
  {
    return customerList;
  }

  public Customer getCustomer(int index)
  {
    if(index < 0 || index >= customerList.size())
    {
      //Exceptions to add
      System.out.println("Invalid index");
      return null;
    }
    else
    {
      return customerList.get(index);
    }
  }

  public void setCustomer(Customer customer, int index)
  {
    if(index < 0 || index >= customerList.size())
    {
      //Exceptions to add
      System.out.println("Invalid index");
    }
    else
    {
      customerList.set(index, customer);
    }
  }

  public void removeCustomer(int index)
  {
    if(index < 0 || index >= customerList.size())
    {
      //Exceptions to add
      System.out.println("Invalid index");
    }
    else
    {
      customerList.remove(index);
    }
  }

  public int getAllNumberOfCustomers()
  {
    return customerList.size();
  }

  public String toString()
  {
    String output = "";
    for(int i = 0; i < customerList.size(); i++)
    {
      output += customerList.get(i) + "\n";
    }
    return output;
  }

  public boolean equals(Object obj)
  {
    if(obj == null || obj.getClass() != getClass())
    {
      return false;
    }
    CustomerList tempCustomerList = (CustomerList)obj;
    if(tempCustomerList.getAllNumberOfCustomers() != getAllNumberOfCustomers())
    {
      return false;
    }
    for(int i = 0; i < customerList.size(); i++)
    {
      if(!customerList.get(i).equals(tempCustomerList.getCustomer(i)))
      {
        return false;
      }
    }
    return true;
  }
}
