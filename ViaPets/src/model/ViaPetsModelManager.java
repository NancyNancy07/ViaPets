package model;

import utils.MyFileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ViaPetsModelManager
{
  private String customerFileName, petFileName, saleFileName, kennelReservationFileName;

  public ViaPetsModelManager(String customerFileName, String petFileName, String saleFileName, String kennelReservationFileName)
  {
    this.customerFileName = customerFileName;
    this.petFileName = petFileName;
    this.saleFileName = saleFileName;
    this.kennelReservationFileName = kennelReservationFileName;
  }

  public CustomerList getAllCustomers()
  {
    CustomerList allCustomers = new CustomerList();

    try
    {
      allCustomers = (CustomerList) MyFileHandler.readFromBinaryFile(customerFileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return allCustomers;
  }

  public void saveCustomers(CustomerList customers)
  {
    try
    {
      MyFileHandler.writeToBinaryFile(customerFileName, customers);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file");
      System.out.println(e);
      System.out.println(e.getMessage());
    }
  }
}
