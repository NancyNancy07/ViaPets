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
    // We check if the object is null or of a different class
    if(obj == null || obj.getClass() != getClass()) // O(1) + O(1) for the checks
    {
      return false; // O(1)
    }

    // We are casting the object to SaleList after making sure it is a SaleList
    SaleList tempSaleList = (SaleList)obj; // O(1)

    // We compare the total number of sales to check if they are equal
    if(tempSaleList.getAllNumberOfSales() != getAllNumberOfSales()) // O(1)
    {
      return false; // O(1)
    }

    // We compare each sale in the list to check if they are equal
    for(int i = 0; i < saleList.size(); i++) // O(n), where n = saleList.size()
    {
      if(!saleList.get(i).equals(tempSaleList.getSale(i))) // O(1) for get + O(7) for equals
      {
        return false; // O(1)
      }
    }

    return true; // O(1)

    /*
    Complexity Analysis:
    Null check and class check take constant time -> O(1).
    Casting an object to a specific type is constant -> O(1).
    Comparing two integers (or simple types) is constant -> O(1).
    A loop runs 'n' times (n = size of saleList).
        - Each iteration involves:
            1. `saleList.get(i)`: Constant time -> O(1).
            2. `tempSaleList.getSale(i)`: Constant time -> O(1).
            3. `equals` method on each object: O(7), based on the analysis of `Sale.equals`.
        - Therefore, each iteration is O(7).

    - Total for the loop: O(n * 7), which simplifies to O(n).

    Dominating Term Analysis:
    - The dominating term is the for loop: O(n).

    Time Complexity:
    - T(n) = O(1) + O(1) + O(1) + O(1) + O(n) + O(1) + O(7) + O(1) = O(n).

    Optimization Suggestion:
    - Since the system will not have a large amount of sales stored, the current implementation is efficient.
    - If the system is expected to have a large number of sales, consider optimizing the for loop here in SaleList equals.
    */
  }
}
