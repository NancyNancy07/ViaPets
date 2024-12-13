package model;

import java.util.ArrayList;

public class SaleList
{
  private ArrayList<Sale> saleList;
  public SaleList()
  {
    saleList = new ArrayList<Sale>();
  }

  public void addSale(Sale sale)
  {
    saleList.add(sale);
  }

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

  public int getNumberOfSales()
  {
    return saleList.size();
  }

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

  public int getAllNumberOfSales()
  {
    return saleList.size();
  }

  public String toString()
  {
    String output = "";
    for(Sale sale : saleList)
    {
      output += sale.toString() + "\n";
    }
    return output;
  }

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
