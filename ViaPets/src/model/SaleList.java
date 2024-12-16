package model;

import java.util.ArrayList;

/**
 * A class containing of SaleList object.
 * @author Bence Antal Orbán
 * @version 1.0
 */
public class SaleList
{
  private ArrayList<Sale> saleList;
  //Constructor
  /**
   * Constructs a new SaleList object with an ArrayList of Sale objects.
   */
  public SaleList()
  {
    saleList = new ArrayList<Sale>();
  }

  //Methods
  /**
   * Adds a new sale to the list.
   * @param sale the sale object
   */
  public void addSale(Sale sale)
  {
    saleList.add(sale);
  }

  /**
   * Removes a sale from the list.
   * @param index the index of the sale to be removed
   */
  public void removeSale(int index)
  {
    if(index < 0 || index >= saleList.size())
    {
      //Exceptions to add
      System.out.println("Invalid index");
    }
    else
    {
      saleList.remove(index);
    }
  }

  /**
   * Sets a sale at the specified index in the list.
   * @param sale the sale object
   * @param index the index of the sale to be set
   */
  public void setSale(Sale sale, int index)
  {
    if(index < 0 || index >= saleList.size())
    {
      //Exceptions to add
      System.out.println("Invalid index");
    }
    else
    {
      saleList.set(index, sale);
    }
  }

  /**
   * Gets the sale at the specified index in the list.
   * @param index the index of the sale to retrieve
   * @return the Sale at the specified index or null if the index is invalid
   */
  public Sale getSale(int index)
  {
    if(index < 0 || index >= saleList.size())
    {
      //Exceptions to add
      System.out.println("Invalid index");
      return null;
    }
    else
    {
      return saleList.get(index);
    }
  }

  /**
   * Gets the number of sales in the list.
   * @return the number of sales
   */
  public int getAllNumberOfSales()
  {
    return saleList.size();
  }

  /**
   * Returns a string representation of the SaleList object.
   * @return a string representation of the SaleList object
   */
  public String toString()
  {
    String output = "";
    for(Sale sale : saleList)
    {
      output += sale.toString() + "\n";
    }
    return output;
  }

  /**
   * Compares the SaleList to another object
   * @param obj the object to compare to
   * @return true if the object is equal to the SaleList
   */
  public boolean equals(Object obj)
  {
    if(obj == null || obj.getClass() != getClass())
    {
      return false;
    }
    SaleList tempSaleList = (SaleList)obj;
    if(tempSaleList.getAllNumberOfSales() != getAllNumberOfSales())
    {
      return false;
    }
    for(int i = 0; i < saleList.size(); i++)
    {
      if(!saleList.get(i).equals(tempSaleList.getSale(i)))
      {
        return false;
      }
    }
    return true;
  }
}
