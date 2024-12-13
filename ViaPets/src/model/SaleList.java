package model;

import java.util.ArrayList;

public class SaleList
{
  private ArrayList<Sale> saleList;

  /**
   * Constructor initializing the SaleList
   */
  public SaleList()
  {
    saleList = new ArrayList<Sale>();
  }
  /**
   * Adds a sale to the SaleList
   * @param sale the sale to be added
   */
  public void addSale(Sale sale)
  {
    saleList.add(sale);
  }

  /**
   * Removes a sale from the SaleList
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
   * Returns the number of sales in the SaleList
   * @return the number of sales in the SaleList
   */
  public int getNumberOfSales()
  {
    return saleList.size();
  }

  /**
   * Sets a sale at a specific index in the SaleList
   * @param sale the sale to be set
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
   * Returns a sale at a specific index in the SaleList
   * @param index the index of the sale to be returned
   * @return the sale at the specified index
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
   * Returns the number of all sales in the SaleList
   * @return the number of all sales in the SaleList
   */
  public int getAllNumberOfSales()
  {
    return saleList.size();
  }

  /**
   * Returns a string representation of the SaleList
   * @return a string representation of the SaleList
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
   * @return true if the object is equal to the SaleList, false if it is not
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
