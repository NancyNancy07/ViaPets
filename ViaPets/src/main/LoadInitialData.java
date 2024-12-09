package main;

import model.*;
import parser.ParserException;
import utils.MyFileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadInitialData
{
  public static void main(String[] args)
      throws IOException, ClassNotFoundException, ParserException
  {
    //    Customer Data
    CustomerList customers = new CustomerList();
    String[] customerArr = null;

    //    Pet Data
    PetList pets = new PetList();
    String[] petArr = null;

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
      petArr = (String[]) MyFileHandler.readArrayFromTextFile("pets.txt");

      for (int i = 0; i < petArr.length; i++)
      {
        String temp = petArr[i];
        String[] tempArr = temp.split(",");
        String species = tempArr[0];
        int age = Integer.parseInt(tempArr[1]);
        String gender = tempArr[2];
        String color = tempArr[3];
        String name = tempArr[4];
        String comment = tempArr[5];
        double price = Double.parseDouble(tempArr[6]);

        pets.addPet(new Pet(species, age, gender, color, name, comment, price));
      }
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File was not found, or could not be opened");
    }

    try
    {
      MyFileHandler.writeToBinaryFile("customers.bin", customers);
      MyFileHandler.writeToBinaryFile("pets.bin", pets);
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
    viaPetsShop.setPetList(pets);

    ViaPetsModelManager modelManager = new ViaPetsModelManager("customers.xml",
        "pets.xml", "sales.bin", "kennelReservations.bin", viaPetsShop);
    modelManager.writeCustomers();
    modelManager.writePets();
    CustomerList customersFromFile = modelManager.readCustomers();
    PetList petsFromFile = modelManager.readPets();
    //    System.out.println(customersFromFile);
    System.out.println("Done");
  }
}