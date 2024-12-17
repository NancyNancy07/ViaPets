import model.*;
import parser.ParserException;
import parser.XmlJsonParser;

public class test
{
  public static void main(String[] args) throws ParserException
  {
/*    Pet[] pets = new Pet[7];
    Dog dog1 = new Dog( "Fido", "Female", "Brown", "A good dog", 3, 1000.0, "Golden Retriever", "John Doe");
    Dog dog2 = new Dog( "Male", "Brown", "A better dog", 7, 103300.0, "Golden Retriever", "John Doe");
    Cat cat1 = new Cat( "Havas", "Male", "White", "A good cat", 3, 1000.0, "Siamese", "Jane Doe");
    Fish fish1 = new Fish( "Nemo", "Male", "Orange", "A good fish", 3, 1000.0, true, true);
    Rodent rodent1 = new Rodent( "Jerry", "Female", "Grey", "A good rodent", 3, 1000.0, true);
    Bird bird1 = new Bird( "Tweety","Male", "Yellow", "A good bird", 3, 1000.0, "Seeds");
    Pet pet1 = new Pet("Female", "Black", "Molly", "A good various pet", 3, 1000.0);
    pets[0] = dog1;
    pets[1] = dog2;
    pets[2] = cat1;
    pets[3] = fish1;
    pets[4] = rodent1;
    pets[5] = bird1;
    pets[6] = pet1;

    for (Pet pet : pets)
    {
      System.out.println(pet);
      System.out.println("\n");
    }*/

//    CustomerList customers = new CustomerList();
//    PetList pets = new PetList();
//
//    Customer customer1 = new Customer("John Doe", "98765432",
//        "asd321@gmail.com");
//    Customer customer2 = new Customer("Jane Doe", "98765432",
//        "turbobbo@gmail.com");
//    Customer customer3 = new Customer("John Doe", "98765432",
//        "bangarang@gmail.com");
//    Customer customer4 = new Customer("John Doe", "98765432",
//        "bangarang@gmail.com");
//    Customer customer5 = new Customer("John Doe", "98765432",
//        "bangarang@gmail.com");
//    Customer customer6 = new Customer("Nancy", "71765432", "nancy@gmail.com");
//    Customer customer7 = new Customer("Maya", "44765432", "maya@gmail.com");
//
//    Dog pet1 = new Dog("Dog", 5, "Male", "Brown", "Beton", "Good boy", 4502,
//        "Golden Retriever", "John Doe");
//    Cat pet2 = new Cat("Cat", 5, "Male", "Brown", "Beton", "Good boy", 4502,
//        "Maine Coon", "John Doe");
//    Rodent pet3 = new Rodent("Rodent", 5, "Male", "Brown", "Beton", "Good boy",
//        4502, true);
//    Fish pet4 = new Fish("Fish", 5, "Male", "Brown", "Beton", "Good boy", 4502,
//        true, true);
//    Bird pet5 = new Bird("Bird", 5, "Male", "Brown", "Beton", "Good boy", 4502,
//        "Seeds");
//    Various pet6 = new Various("Giraffe", 5, "Male", "Brown", "Beton",
//        "Good boy", 4502);
//
//    pets.addPet(pet1);
//    pets.addPet(pet2);
//    pets.addPet(pet3);
//    pets.addPet(pet4);
//    pets.addPet(pet5);
//    pets.addPet(pet6);
//
//  /*  customers.addCustomer(customer1);
//    customers.addCustomer(customer2);
//    customers.addCustomer(customer3);
//    customers.addCustomer(customer4);*/
//    /*  customers.addCustomer(customer5);*/
//    customers.addCustomer(customer6);
//    customers.addCustomer(customer7);
//
//    ViaPetsShop viaPetsShop = new ViaPetsShop();
//
//    viaPetsShop.setCustomerList(customers);
//    viaPetsShop.setPetList(pets);
//
//    ViaPetsModelManager modelManager = new ViaPetsModelManager("customers.xml",
//        "pets.xml", "sales.bin", "kennelReservations.bin", viaPetsShop);
//    modelManager.writeCustomers();
//    CustomerList customersFromFile = modelManager.readCustomers();
//    System.out.println(customersFromFile);
//
//
//    //    modelManager.writePets();
//    //    PetList petsFromFile = modelManager.readPets();
//    //    System.out.println(petsFromFile);
    KennelReservation kennelReservation = new KennelReservation(100.0,
        new Dog("Dog", 12, "Male", "Brown", "Foltos", "Good Boy", 0, "Golden Retriever", "John Doe"),
        new Customer("John Doe", "+36304542324", "asdasd@gmail.com"),
        new MyDate(17,12,2024),
        new MyDate(20,12,2024));

    KennelReservationList kennelReservationList = new KennelReservationList();
    kennelReservationList.addKennelReservation(kennelReservation);


  }
}
