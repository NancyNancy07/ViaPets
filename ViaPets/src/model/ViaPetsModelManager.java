package model;

import parser.ParserException;
import parser.XmlJsonParser;

import java.io.File;


/**
 * A class containing of SaleList object.
 * @author Nancy, Bence Antal Orbán
 * @version 1.0
 */
public class ViaPetsModelManager
{
  private String customerFileName, petFileName, saleFileName, kennelReservationFileName;
  private ViaPetsShop viaPetsShop;

  /**
   * Five-argument constructor
   * @param customerFileName the name of the file containing the customers
   * @param petFileName the name of the file containing the pets
   * @param saleFileName the name of the file containing the sales
   * @param kennelReservationFileName the name of the file containing the kennel reservations
   * @param viaPetsShop the ViaPetsShop object
   */
  public ViaPetsModelManager(String customerFileName, String petFileName,
      String saleFileName, String kennelReservationFileName,
      ViaPetsShop viaPetsShop)
  {
    this.customerFileName = customerFileName;
    this.petFileName = petFileName;
    this.saleFileName = saleFileName;
    this.kennelReservationFileName = kennelReservationFileName;
    this.viaPetsShop = viaPetsShop;
  }

  /**
   * Four-argument constructor
   * @param customerFileName the name of the file containing the customers
   * @param petFileName the name of the file containing the pets
   * @param saleFileName the name of the file containing the sales
   * @param kennelReservationFileName the name of the file containing the kennel reservations
   */
  public ViaPetsModelManager(String customerFileName, String petFileName,
      String saleFileName, String kennelReservationFileName)
  {
    this.customerFileName = customerFileName;
    this.petFileName = petFileName;
    this.saleFileName = saleFileName;
    this.kennelReservationFileName = kennelReservationFileName;
  }

  /**
   * Getter for the CustomerList from the ViaPetsShop
   * @return the CustomerList from the ViaPetsShop
   * @throws ParserException if an error occurs
   */
  public CustomerList getAllCustomers() throws ParserException
  {
    if (viaPetsShop != null)
    {
      CustomerList allCustomers = new CustomerList();
      allCustomers = viaPetsShop.getCustomerList();
      //      System.out.println(allCustomers);
      return allCustomers;
    }
    else
    {
      return null;
    }
  }

  /**
   * Getter for the PetList from the ViaPetsShop
   * @return the PetList from the ViaPetsShop
   * @throws ParserException if an error occurs
   */
  public PetList getAllPets() throws ParserException
  {
    if (viaPetsShop != null)
    {
      PetList allPets = new PetList();
      allPets = viaPetsShop.getPetList();
      return allPets;
    }
    else
    {
      return null;
    }
  }

  /**
   * Getter for the SaleList from the ViaPetsShop
   * @return the SaleList from the ViaPetsShop
   * @throws ParserException if an error occurs
   */
  public SaleList getAllSales() throws ParserException
  {
    if (viaPetsShop != null)
    {
      SaleList allSales = new SaleList();
      allSales = viaPetsShop.getSaleList();
      return allSales;
    }
    else
    {
      return null;
    }
  }

  /**
   * Getter for the KennelReservationList from the ViaPetsShop
   * @return the KennelReservationList from the ViaPetsShop
   * @throws ParserException if an error occurs
   */
  public KennelReservationList getAllKennelReservations() throws ParserException
  {
    if (viaPetsShop != null)
    {
      KennelReservationList allKennelReservations = new KennelReservationList(
          );
      allKennelReservations = viaPetsShop.getKennelReservationList();
      return allKennelReservations;
    }
    else
    {
      return null;
    }
  }

  /**
   * Writes the customers to an XML file
   * @throws ParserException if an error occurs
   */
  public void writeCustomers() throws ParserException
  {

    CustomerList allCustomers = getAllCustomers();
    if (allCustomers == null)
    {
      System.out.println("Customer list is null");
    }

    if (allCustomers.getAllNumberOfCustomers() == 0)
    {
      System.out.println("No customers to write");
    }
    XmlJsonParser parser = new XmlJsonParser();
    File customers = parser.toXml(allCustomers, "customers.xml");
    System.out.println("Wrote customers data to XML file");
  }

  /**
   * Writes the pets to an XML file
   * @throws ParserException if an error occurs
   */
  public void writePets() throws ParserException
  {
    PetList allPets = getAllPets();
    System.out.println("model manager 174"+allPets.getPet(0));
    if (allPets == null)
    {
      System.out.println("Pet list is null");
    }

    if (allPets.getNumberOfPets() == 0)
    {
      System.out.println("No pet to write");
    }

    XmlJsonParser parser = new XmlJsonParser();
    File pets = parser.toXml(allPets, "pets.xml");
    System.out.println("Wrote pets data to XML file");
  }

  /**
   * Writes the sales to an XML file
   * @throws ParserException if an error occurs
   */
  public void writeSales() throws ParserException
  {
    SaleList allSales = getAllSales();
    if (allSales == null)
    {
      System.out.println("Sale list is null");
    }

    if (allSales.getAllNumberOfSales() == 0)
    {
      System.out.println("No sale to write");
    }

    XmlJsonParser parser = new XmlJsonParser();
    File sales = parser.toXml(allSales, "sales.xml");
    System.out.println("Wrote sales data to XML file");
  }

  /**
   * Writes the kennel reservations to an XML file
   * @throws ParserException if an error occurs
   */
  public void writeKennelReservations() throws ParserException
  {
    // We get all kennel reservations
    KennelReservationList allKennelReservations = getAllKennelReservations(); // O(1)

    // We check if there are any reservations to write
    if (allKennelReservations == null || allKennelReservations.getAllNumberOfKennelReservations() == 0) // O(1) + O(1)
    {
      System.out.println("No kennel reservation to write"); // O(1)
      return; // O(1)
    }

    // We read all pets
    PetList allPets = readPets(); // O(1)

    // We loop through all kennel reservations
    for (int i = 0; i < allKennelReservations.getAllNumberOfKennelReservations(); i++) // O(r), where r = number of kennel reservations
    {
      KennelReservation reservation = allKennelReservations.getKennelReservation(i); // O(1)
      Pet reservationPet = reservation.getPet(); // O(1)

      // We check if the pet exists in the list of all pets
      boolean petExists = false; // O(1)
      for (int j = 0; j < allPets.getNumberOfPets(); j++) // O(p), where p = number of pets
      {
        if (allPets.getPet(j).equals(reservationPet)) // O(1) for get + O(3) for equals
        {
          petExists = true; // O(1)
          break; // O(1)
        }
      }

      // If the pet does not exist, add it to the list of pets
      if (!petExists) // O(1)
      {
        allPets.addPet(reservationPet); // O(1)

        // We write the updated list of pets to an XML file
        XmlJsonParser parser = new XmlJsonParser(); // O(1)
        File petsFile = parser.toXml(allPets, "pets.xml"); // O(w), where w = complexity of writing to XML
        System.out.println("Wrote new kennel pet data to pets.xml"); // O(1)
      }
    }

    /*
    Complexity Analysis:
    Getting all kennel reservations -> O(1).
    Null check and logging -> O(1).
    Reading all pets -> O(1).
    Looping through all kennel reservations -> O(r), where r = number of kennel reservations.
        - Each iteration involves:
            1. `getKennelReservation(i)` and `getPet()` -> O(1) each.
            2. Inner loop over all pets -> O(p), where p = number of pets.
                - Each iteration performs:
                  -`getPet(j)` -> 0(1).
                  -`equals()` -> O(7).
            - Total for inner loop: O(p * 7).
            - Simplified: O(p).
        - Outer loop: O(r * p).
    Adding a new pet and writing to XML -> O(1) + O(w), where w = complexity of writing to XML.

    Dominating Term Analysis:
    - The dominating term is the nested loop: O(r * p).

    Time Complexity:
    - T(n) = O(1) + O(1) + O(1) + O(r * p) + O(w).
    - Simplifying: O(r * p + w).

    Optimization Suggestion:
    - If XML writing (w) can be optimized, the overall complexity will decrease.
    - Caching previously checked pets to avoid repeated comparisons could reduce inner loop complexity [ O(r*p) -> O(r) ].
    */
  }


  /**
   * Reads the customers from an XML file
   * @return the CustomerList read from the XML file
   * @throws ParserException if an error occurs
   */
  public CustomerList readCustomers() throws ParserException
  {
    XmlJsonParser parser = new XmlJsonParser();
    CustomerList customers = parser.fromXml("customers.xml",
        CustomerList.class);

    try
    {
      customers = parser.fromXml("customers.xml", CustomerList.class);
    }
    catch (ParserException e)
    {
      System.err.println("Error parsing XML: " + e.getMessage());
    }
    return customers;
  }

  /**
   * Reads the pets from an XML file
   * @return the PetList read from the XML file
   * @throws ParserException if an error occurs
   */
  public PetList readPets() throws ParserException
  {
    XmlJsonParser parser = new XmlJsonParser();
    PetList pets = parser.fromXml("pets.xml", PetList.class);

    try
    {
      pets = parser.fromXml("pets.xml", PetList.class);
    }
    catch (ParserException e)
    {
      System.err.println("Error parsing XML: " + e.getMessage());
    }
    return pets;
  }

  /**
   * Reads the sales from an XML file
   * @return the SaleList read from the XML file
   * @throws ParserException if an error occurs
   */
  public SaleList readSales() throws ParserException
  {
    XmlJsonParser parser = new XmlJsonParser();
    SaleList sales = parser.fromXml("sales.xml", SaleList.class);

    try
    {
      sales = parser.fromXml("sales.xml", SaleList.class);
    }
    catch (ParserException e)
    {
      System.err.println("Error parsing XML: " + e.getMessage());
    }
    return sales;
  }

  /**
   * Reads the kennel reservations from an XML file
   * @return the KennelReservationList read from the XML file
   * @throws ParserException if an error occurs
   */
  public KennelReservationList readKennelReservations() throws ParserException
  {
    XmlJsonParser parser = new XmlJsonParser();
    KennelReservationList kennelReservations = parser.fromXml(
        "kennelReservations.xml", KennelReservationList.class);

    try
    {
      kennelReservations = parser.fromXml("kennelReservations.xml",
          KennelReservationList.class);
    }
    catch (ParserException e)
    {
      System.err.println("Error parsing XML: " + e.getMessage());
    }
    return kennelReservations;
  }

  /**
   * Saves the CustomerList to an XML file
   * @param allCustomers the CustomerList to be saved
   * @throws ParserException if an error occurs
   */
  public void saveCustomerList(CustomerList allCustomers) throws ParserException
  {
    System.out.println("new list");
    XmlJsonParser parser = new XmlJsonParser();
    File customers = parser.toXml(allCustomers, "customers.xml");
  }

  /**
   * Saves the PetList to an XML file
   * @param allPets the PetList to be saved
   * @throws ParserException if an error occurs
   */
  public void savePetList(PetList allPets) throws ParserException
  {
    System.out.println("new list");
    XmlJsonParser parser = new XmlJsonParser();
    File pets = parser.toXml(allPets, "pets.xml");
  }

  /**
   * Saves the SaleList to an XML file
   * @param allSales the SaleList to be saved
   * @throws ParserException if an error occurs
   */
  public void saveSaleList(SaleList allSales) throws ParserException
  {
    System.out.println("new list");
    XmlJsonParser parser = new XmlJsonParser();
    File sales = parser.toXml(allSales, "sales.xml");
  }

  /**
   * Saves the KennelReservationList to an XML file
   * @param allKennelReservations the KennelReservationList to be saved
   * @throws ParserException if an error occurs
   */
  public void saveKennelReservationList(KennelReservationList allKennelReservations)
      throws ParserException
  {
    System.out.println("new list");
    XmlJsonParser parser = new XmlJsonParser();
    File kennelReservations = parser.toXml(allKennelReservations,
        "kennelReservations.xml");
  }

  /**
   * Updates a customer from the CustomerList
   * @param index the index of the customer to be updated
   * @throws ParserException if an error occurs
   */
  public void updateCustomer(int index, Customer updatedCustomer)
      throws ParserException
  {
    CustomerList allCustomers = readCustomers();
    if (index >= 0 && index < allCustomers.getAllNumberOfCustomers())
    {
      allCustomers.setCustomer(index, updatedCustomer);
      saveCustomerList(allCustomers);

      System.out.println("Updated customer and saved to XML file.");
    }
    else
    {
      System.out.println("Invalid customer index: " + index);
    }
  }

  /**
   * Updates a pet from the PetList
   * @param index the index of the pet to be updated
   * @throws ParserException if an error occurs
   */
  public void updatePet(int index, Pet updatedPet) throws ParserException
  {
    PetList allPets = readPets();
    if (index >= 0 && index < allPets.getNumberOfPets())
    {
      allPets.setPet(updatedPet, index);
      savePetList(allPets);

      System.out.println("Updated pet and saved to XML file.");
    }
    else
    {
      System.out.println("Invalid pet index: " + index);
    }
  }

  /**
   * Updates a kennel reservation from the KennelReservationList
   * @param index the index of the kennel reservation to be updated
   * @throws ParserException if an error occurs
   */
  public void updateKennelReservation(int index, KennelReservation updatedKennelReservation)
      throws ParserException
  {
    KennelReservationList allKennelReservations = readKennelReservations();
    if (index >= 0
        && index < allKennelReservations.getAllNumberOfKennelReservations())
    {
      allKennelReservations.setKennelReservation(index,
          updatedKennelReservation);
      saveKennelReservationList(allKennelReservations);

      System.out.println("Updated kennel reservation and saved to XML file.");
    }
    else
    {
      System.out.println("Invalid kennel reservation index: " + index);
    }
  }

  /**
   * Adds a customer to the CustomerList
   * @param customer the customer to be added
   * @throws ParserException if an error occurs
   */
  public void addCustomer(Customer customer) throws ParserException
  {
    CustomerList allCustomers = readCustomers();
    if (customer != null)
    {
      allCustomers.addCustomer(customer);
      saveCustomerList(allCustomers);

      System.out.println("added a customer and saved to XML file.");

    }

  }

  /**
   * Adds a pet to the PetList
   * @param pet the pet to be added
   * @throws ParserException if an error occurs
   */
  public void addPet(Pet pet) throws ParserException
  {
    PetList allPets = readPets();
    if (pet != null)
    {
      allPets.addPet(pet);
      savePetList(allPets);

      System.out.println("added a pet and saved to XML file.");

    }

  }

  /**
   * Adds a sale to the SaleList
   * @param sale the sale to be added
   * @throws ParserException if an error occurs
   */
  public void addSale(Sale sale) throws ParserException
  {
    SaleList allSales = readSales();
    if (sale != null)
    {
      allSales.addSale(sale);
      saveSaleList(allSales);

      System.out.println("added a sale and saved to XML file.");

    }

  }

  /**
   * Adds a kennel reservation to the KennelReservationList
   * @param kennelReservation the kennel reservation to be added
   * @throws ParserException if an error occurs
   */
  public void addKennelReservation(KennelReservation kennelReservation) throws ParserException
  {
    KennelReservationList allKennelReservations = readKennelReservations();
    if (kennelReservation != null)
    {
      allKennelReservations.addKennelReservation(kennelReservation);
      saveKennelReservationList(allKennelReservations);

      System.out.println("added a kennel reservation and saved to XML file.");

    }
  }
}
