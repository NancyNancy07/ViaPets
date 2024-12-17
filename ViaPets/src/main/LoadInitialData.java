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

    //    sale data
    Pet pet1 = new Pet("Dog", 2, "Male", "Brown", "Buddy",
        "Very energetic and playful", 600.0);
    Pet pet2 = new Pet("Cat", 3, "Female", "White", "Whiskers",
        "Loves cuddling and napping", 500.0);
    Pet pet3 = new Pet("Rabbit", 1, "Male", "Grey", "Thumper",
        "Curious and loves carrots", 900.0);
    Pet pet4 = new Pet("Parrot", 4, "Female", "Green", "Polly",
        "Likes to mimic sounds", 1000.0);
    Pet pet5 = new Pet("Dog", 5, "Male", "Black", "Rex", "Loyal and friendly",
        500.0);

    Customer customer1 = new Customer("John Doe", "12345678",
        "johndoe@email.com");
    Customer customer2 = new Customer("Jane Smith", "23456789",
        "janesmith@email.com");
    Customer customer3 = new Customer("Bob Brown", "45689123",
        "bobbrown@email.com");
    Customer customer4 = new Customer("Charlie White", "56790234",
        "charliew@email.com");
    Customer customer5 = new Customer("David Green", "67801345",
        "davidg@email.com");

    MyDate saleDate1 = new MyDate(1, 3, 2024);
    MyDate saleDate2 = new MyDate(1, 3, 2024);
    MyDate saleDate3 = new MyDate(1, 3, 2024);
    MyDate saleDate4 = new MyDate(1, 3, 2024);
    MyDate saleDate5 = new MyDate(1, 3, 2024);

    Sale sale1 = new Sale(1000.0, customer1, pet1, saleDate1);
    Sale sale2 = new Sale(400.0, customer2, pet2, saleDate2);
    Sale sale3 = new Sale(600.0, customer3, pet3, saleDate3);
    Sale sale4 = new Sale(800.0, customer4, pet4, saleDate4);
    Sale sale5 = new Sale(300.0, customer5, pet5, saleDate5);

    SaleList sales = new SaleList();
    sales.addSale(sale1);
    sales.addSale(sale2);
    sales.addSale(sale3);
    sales.addSale(sale4);
    sales.addSale(sale5);

    MyDate startDate1 = new MyDate(5, 3, 2025);
    MyDate startDate2 = new MyDate(9, 12, 2024);
    MyDate startDate3 = new MyDate(12, 4, 2025);
    MyDate startDate4 = new MyDate(30, 11, 2024);
    MyDate startDate5 = new MyDate(16, 10, 2025);

    MyDate endDate1 = new MyDate(5, 5, 2025);
    MyDate endDate2 = new MyDate(30, 12, 2024);
    MyDate endDate3 = new MyDate(30, 4, 2025);
    MyDate endDate4 = new MyDate(30, 12, 2024);
    MyDate endDate5 = new MyDate(16, 12, 2025);
    //    kennel data
    KennelReservation reservation1 = new KennelReservation(100.0, pet1,
        customer1, startDate1, endDate1);
    KennelReservation reservation2 = new KennelReservation(100.0, pet2,
        customer2, startDate2, endDate2);
    KennelReservation reservation3 = new KennelReservation(100.0, pet3,
        customer3, startDate3, endDate3);
    KennelReservation reservation4 = new KennelReservation(100.0, pet4,
        customer4, startDate4, endDate4);
    KennelReservation reservation5 = new KennelReservation(100.0, pet5,
        customer5, startDate5, endDate5);

    KennelReservationList reservations = new KennelReservationList(10);

    reservations.addKennelReservation(reservation1);
    reservations.addKennelReservation(reservation2);
    reservations.addKennelReservation(reservation3);
    reservations.addKennelReservation(reservation4);
    reservations.addKennelReservation(reservation5);

    for (int i = 0; i < reservations.getAllNumberOfKennelReservations(); i++)
    {
      KennelReservation reservation = reservations.getKennelReservation(i);
      reservation.getPet().setPrice(0);
    }

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
      MyFileHandler.writeToBinaryFile("sales.bin", sales);
      MyFileHandler.writeToBinaryFile("reservations.bin", sales);
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
    viaPetsShop.setSaleList(sales);
    viaPetsShop.setKennelReservationList(reservations);

    ViaPetsModelManager modelManager = new ViaPetsModelManager("customers.xml",
        "pets.xml", "sales.xml", "kennelReservations.xml", viaPetsShop);
    modelManager.writeCustomers();
    modelManager.writePets();
    modelManager.writeSales();
    modelManager.writeKennelReservations();
    CustomerList customersFromFile = modelManager.readCustomers();
    PetList petsFromFile = modelManager.readPets();
    SaleList saleFromFile = modelManager.readSales();
    KennelReservationList reservationsFromFile = modelManager.readKennelReservations();
//      System.out.println(reservationsFromFile);
    System.out.println("Done");
  }
}