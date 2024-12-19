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

    Dog pet1 = new Dog("Dog", 2, "Male", "Brown", "Buddy",
        "Very energetic and playful", 600.0, "Labrador", "John's Breeder");
    Pet pet2 = new Cat("Cat", 3, "Female", "White", "Whiskers",
        "Loves cuddling and napping", 500.0, "Persian", "New Breeder");
    Pet pet3 = new Rodent("Rabbit", 1, "Male", "Grey", "Thumper",
        "Curious and loves carrots", 100.0, false);
    Pet pet4 = new Bird("Parrot", 4, "Female", "Green", "Polly",
        "Likes to mimic sounds", 1000.0, "Chilli");
    Pet pet5 = new Fish("Goldfish", 1, "Male", "Orange", "Bubbles",
        "Calm and graceful", 50.0, false, true);
    Pet pet6 = new Various("Hamster", 2, "Female", "Golden", "Squeaky",
        "Likes to run in a wheel", 20.0);
    Pet pet7 = new Dog("Dog", 5, "Male", "Black", "Rex", "Loyal and friendly",
        500.0, "German Shepherd", "Best Breeder");
    Pet pet8 = new Cat("Cat", 4, "Male", "Gray", "Shadow",
        "Independent and quiet", 400.0, "Maine Coon", "Good Breeder");
    Pet pet9 = new Rodent("Gerbil", 1, "Female", "Brown", "Nibbles",
        "Likes to burrow", 30.0, true);
    Pet pet10 = new Bird("Canary", 3, "Male", "Yellow", "Sunny",
        "Sings melodious tunes", 80.0, "Carrots");
    Pet pet11 = new Fish("Betta", 2, "Female", "Blue", "Finny",
        "Aggressive but beautiful", 25.0, true, false);
    Pet pet12 = new Various("Ferret", 3, "Male", "White", "Zippy",
        "Energetic and curious", 200.0);
    Pet pet13 = new Dog("Dog", 6, "Female", "Brown", "Bella",
        "Friendly and protective", 700.0, "Golden Retriever", "Lovely Breeder");
    Pet pet14 = new Cat("Cat", 5, "Female", "Black", "Midnight",
        "Quiet and graceful", 550.0, "Sphynx", "Joyful Breeder");
    Pet pet15 = new Rodent("Hamster", 2, "Male", "White", "Fluffy",
        "Loves to run on wheels", 15.0, false);
    Pet pet16 = new Bird("Cockatoo", 2, "Male", "White", "Charlie",
        "Very vocal and playful", 1200.0, "Strawberries");
    Pet pet17 = new Fish("Tetra", 1, "Female", "Silver", "Twinkle",
        "Peaceful community fish", 15.0, false, true);
    Pet pet18 = new Various("Chinchilla", 1, "Male", "Gray", "Dusty",
        "Loves dust baths", 350.0);
    Pet pet19 = new Dog("Dog", 4, "Female", "Spotted", "Daisy", "Loves running",
        600.0, "Dalmatian", "Elite Breeder");
    Pet pet20 = new Cat("Cat", 6, "Male", "Orange", "Marmalade",
        "Affectionate and friendly", 450.0, "British Shorthair",
        "Calm Breeder");

    pets.addPet(pet1);
    pets.addPet(pet2);
    pets.addPet(pet3);
    pets.addPet(pet4);
    pets.addPet(pet5);
    pets.addPet(pet6);
    pets.addPet(pet7);
    pets.addPet(pet8);
    pets.addPet(pet9);
    pets.addPet(pet10);
    pets.addPet(pet11);
    pets.addPet(pet12);
    pets.addPet(pet13);
    pets.addPet(pet14);
    pets.addPet(pet15);
    pets.addPet(pet16);
    pets.addPet(pet17);
    pets.addPet(pet18);
    pets.addPet(pet19);
    pets.addPet(pet20);

    //    sale data
    Pet newPet1 = new Pet("Dog", 2, "Male", "Brown", "Buddy",
        "Very energetic and playful", 600.0);
    Pet newPet2 = new Pet("Cat", 3, "Female", "White", "Whiskers",
        "Loves cuddling and napping", 500.0);
    Pet newPet3 = new Pet("Rabbit", 1, "Male", "Grey", "Thumper",
        "Curious and loves carrots", 900.0);
    Pet newPet4 = new Pet("Parrot", 4, "Female", "Green", "Polly",
        "Likes to mimic sounds", 1000.0);
    Pet newPet5 = new Pet("Dog", 5, "Male", "Black", "Rex",
        "Loyal and friendly", 500.0);

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



//    sale
    MyDate saleDate1 = new MyDate(1, 3, 2024);
    MyDate saleDate2 = new MyDate(1, 3, 2024);
    MyDate saleDate3 = new MyDate(1, 3, 2024);
    MyDate saleDate4 = new MyDate(1, 3, 2024);
    MyDate saleDate5 = new MyDate(1, 3, 2024);

    Sale sale1 = new Sale(1000.0, customer1, newPet1, saleDate1);
    Sale sale2 = new Sale(400.0, customer2, newPet2, saleDate2);
    Sale sale3 = new Sale(600.0, customer3, newPet3, saleDate3);
    Sale sale4 = new Sale(800.0, customer4, newPet4, saleDate4);
    Sale sale5 = new Sale(300.0, customer5, newPet5, saleDate5);

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
    KennelReservation reservation1 = new KennelReservation(100.0, newPet1,
        customer1, startDate1, endDate1);
    KennelReservation reservation2 = new KennelReservation(100.0, newPet2,
        customer2, startDate2, endDate2);
    KennelReservation reservation3 = new KennelReservation(100.0, newPet3,
        customer3, startDate3, endDate3);
    KennelReservation reservation4 = new KennelReservation(100.0, newPet4,
        customer4, startDate4, endDate4);
    KennelReservation reservation5 = new KennelReservation(100.0, newPet5,
        customer5, startDate5, endDate5);

    KennelReservationList reservations = new KennelReservationList();

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

//    try
//    {
//      MyFileHandler.writeToBinaryFile("customers.bin", customers);
//      MyFileHandler.writeToBinaryFile("pets.bin", pets);
//      MyFileHandler.writeToBinaryFile("sales.bin", sales);
//      MyFileHandler.writeToBinaryFile("reservations.bin", sales);
//    }
//    catch (FileNotFoundException e)
//    {
//      System.out.println("Error opening file ");
//    }
//    catch (IOException e)
//    {
//      System.out.println("IO Error writing to file ");
//    }

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
//   System.out.println(petsFromFile);
    System.out.println("Done");
  }
}