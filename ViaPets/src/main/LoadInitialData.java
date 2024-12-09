package main;

import model.Customer;
import model.CustomerList;
import model.ViaPetsModelManager;
import model.ViaPetsShop;
import parser.ParserException;
import utils.MyFileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadInitialData
{
  public static void main(String[] args)
      throws IOException, ClassNotFoundException, ParserException
  {
    CustomerList customers = new CustomerList();
    String[] customerArr = null;

    try
    {
      customerArr = (String[]) MyFileHandler.readArrayFromTextFile(
          "customers.txt");

      for (int i = 0; i < customerArr.length; i++)
      {
        String temp = customerArr[i];
        String[] tempArr = temp.split(",");
        String name = tempArr[0];
        String phone = tempArr[1];
        String email = tempArr[2];

        customers.addCustomer(new Customer(name, phone, email));
      }
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File was not found, or could not be opened");
    }

    try
    {
      MyFileHandler.writeToBinaryFile("customers.bin", customers);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Error opening file ");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file ");
    }

    ViaPetsShop viaPetsShop = new ViaPetsShop();
    viaPetsShop.setCustomerList(customers);

    ViaPetsModelManager modelManager = new ViaPetsModelManager("customers.xml",
        "pets.xml", "sales.bin", "kennelReservations.bin", viaPetsShop);
    modelManager.writeCustomers();
    CustomerList customersFromFile = modelManager.readCustomers();
    System.out.println(customersFromFile);

    System.out.println("Done");
  }
}