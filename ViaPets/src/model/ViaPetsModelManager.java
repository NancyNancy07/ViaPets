package model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import parser.ParserException;
import parser.XmlJsonParser;
import utils.MyFileHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ViaPetsModelManager
{
  private String customerFileName, petFileName, saleFileName, kennelReservationFileName;
  private ViaPetsShop viaPetsShop;

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

  public ViaPetsModelManager(String customerFileName, String petFileName,
      String saleFileName, String kennelReservationFileName)
  {
    this.customerFileName = customerFileName;
    this.petFileName = petFileName;
    this.saleFileName = saleFileName;
    this.kennelReservationFileName = kennelReservationFileName;
  }

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

  public KennelReservationList getAllKennelReservations() throws ParserException
  {
    if (viaPetsShop != null)
    {
      KennelReservationList allKennelReservations = new KennelReservationList(10);
      allKennelReservations = viaPetsShop.getKennelReservationList();
      return allKennelReservations;
    }
    else
    {
      return null;
    }
  }

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

  public void writePets() throws ParserException
  {
    PetList allPets = getAllPets();
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

  public void writeKennelReservations() throws ParserException
  {
    KennelReservationList allKennelReservations = getAllKennelReservations();
    if (allKennelReservations == null)
    {
      System.out.println("Kennel reservation list is null");
    }

    if (allKennelReservations.getAllNumberOfKennelReservations() == 0)
    {
      System.out.println("No kennel reservation to write");
    }

    XmlJsonParser parser = new XmlJsonParser();
    File kennelReservations = parser.toXml(allKennelReservations,
        "kennelReservations.xml");
    System.out.println("Wrote kennel reservations data to XML file");
  }

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

  public void saveCustomerList(CustomerList allCustomers) throws ParserException
  {
    System.out.println("new list");
    XmlJsonParser parser = new XmlJsonParser();
    File customers = parser.toXml(allCustomers, "customers.xml");
  }

  public void savePetList(PetList allPets) throws ParserException
  {
    System.out.println("new list");
    XmlJsonParser parser = new XmlJsonParser();
    File pets = parser.toXml(allPets, "pets.xml");
  }

  public void saveSaleList(SaleList allSales) throws ParserException
  {
    System.out.println("new list");
    XmlJsonParser parser = new XmlJsonParser();
    File sales = parser.toXml(allSales, "sales.xml");
  }

  public void saveKennelReservationList(KennelReservationList allKennelReservations)
      throws ParserException
  {
    System.out.println("new list");
    XmlJsonParser parser = new XmlJsonParser();
    File kennelReservations = parser.toXml(allKennelReservations,
        "kennelReservations.xml");
  }

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

  public void updateSale(int index, Sale updatedSale) throws ParserException
  {
    SaleList allSales = readSales();
    if (index >= 0 && index < allSales.getAllNumberOfSales())
    {
      allSales.setSale(updatedSale, index);
      saveSaleList(allSales);

      System.out.println("Updated sale and saved to XML file.");
    }
    else
    {
      System.out.println("Invalid sale index: " + index);
    }
  }

  public void updateKennelReservation(int index, KennelReservation updatedKennelReservation)
      throws ParserException
  {
    KennelReservationList allKennelReservations = readKennelReservations();
    if (index >= 0 && index < allKennelReservations.getAllNumberOfKennelReservations())
    {
      allKennelReservations.setKennelReservation(index, updatedKennelReservation);
      saveKennelReservationList(allKennelReservations);

      System.out.println("Updated kennel reservation and saved to XML file.");
    }
    else
    {
      System.out.println("Invalid kennel reservation index: " + index);
    }
  }

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
  /*public void writePets()
  {
    DocumentBuilder builder = null;
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    try
    {
      builder = factory.newDocumentBuilder();
    }
    catch (ParserConfigurationException e)
    {
      System.out.println("Error");
      System.exit(1);
    }

    //create the XML document
    Document doc = builder.newDocument();

    Element rootElement = doc.createElement("pets");

    //Add each Student object from the list as XML tags
    for (int i = 0;
         i < viaPetsShop.getCustomerList().getAllNumberOfCustomers(); i++)
    {
      Element subElement = doc.createElement("pet");
      rootElement.appendChild(subElement);

      Element subSubElement = doc.createElement("name");
      subSubElement.appendChild(
          doc.createTextNode(viaPetsShop.getPetList().getPet(i).getName()));
      subElement.appendChild(subSubElement);

      subSubElement = doc.createElement("species");
      subSubElement.appendChild(
          doc.createTextNode(viaPetsShop.getPetList().getPet(i).getSpecies()));
      subElement.appendChild(subSubElement);

      subSubElement = doc.createElement("age");
      subSubElement.appendChild(doc.createTextNode(
          Integer.toString(viaPetsShop.getPetList().getPet(i).getAge())));
      subElement.appendChild(subSubElement);

      subSubElement = doc.createElement("gender");
      subSubElement.appendChild(
          doc.createTextNode(viaPetsShop.getPetList().getPet(i).getGender()));
      subElement.appendChild(subSubElement);

      subSubElement = doc.createElement("color");
      subSubElement.appendChild(
          doc.createTextNode(viaPetsShop.getPetList().getPet(i).getColor()));
      subElement.appendChild(subSubElement);

      subSubElement = doc.createElement("comment");
      subSubElement.appendChild(
          doc.createTextNode(viaPetsShop.getPetList().getPet(i).getComment()));
      subElement.appendChild(subSubElement);

      subSubElement = doc.createElement("price");
      subSubElement.appendChild(doc.createTextNode(
          Double.toString(viaPetsShop.getPetList().getPet(i).getPrice())));
      subElement.appendChild(subSubElement);

    }

    doc.appendChild(rootElement);

    //Format and save as XML file
    try
    {
      Transformer transformer = TransformerFactory.newInstance()
          .newTransformer();

      //make new lines and indent the elements in the XML file
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");

      //write the XML file
      File file = new File("pets.xml");
      transformer.transform(new DOMSource(doc), new StreamResult(file));
    }
    catch (TransformerConfigurationException e)
    {
      System.out.println("Error configuring XML file");
    }
    catch (TransformerException e)
    {
      System.out.println("Error creating XML file");
    }
  }*/

/*  public PetList readPets()
  {
    PetList pets = new PetList();
    DocumentBuilder builder2 = null;
    DocumentBuilderFactory factory2 = DocumentBuilderFactory.newInstance();

    try
    {
      builder2 = factory2.newDocumentBuilder();
    }
    catch (ParserConfigurationException e)
    {
      System.out.println("Error");
      System.exit(1);
    }

    Document doc2 = null;
    try
    {
      doc2 = builder2.parse("pets.xml");
    }
    catch (SAXException e)
    {
      System.out.println("Error parsing");
      System.exit(1);
    }
    catch (IOException e)
    {
      System.out.println("Error reading file");
      System.exit(1);
    }

    NodeList rootList = doc2.getElementsByTagName("pet");

    for (int i = 0; i < rootList.getLength(); i++)
    {
      Node rootNode = rootList.item(i);
      NodeList subNodes = rootNode.getChildNodes();

      String name = "";
      String species = "";
      String age = "";
      String gender = "";
      String color = "";
      String comment = "";
      String price = "";

      for (int j = 0; j < subNodes.getLength(); j++)
      {
        Node subNode = subNodes.item(j);
        if (subNode.getNodeName().equals("name"))
        {
          name = subNode.getTextContent();
        }
        else if (subNode.getNodeName().equals("species"))
        {
          species = subNode.getTextContent();
        }
        else if (subNode.getNodeName().equals("age"))
        {
          age = subNode.getTextContent();
        }
        else if (subNode.getNodeName().equals("gender"))
        {
          gender = subNode.getTextContent();
        }
        else if (subNode.getNodeName().equals("color"))
        {
          color = subNode.getTextContent();
        }
        else if (subNode.getNodeName().equals("comment"))
        {
          comment = subNode.getTextContent();
        }
        else if (subNode.getNodeName().equals("price"))
        {
          price = subNode.getTextContent();
        }
      }
      pets.addPet(
          new Pet(species, Integer.parseInt(age), gender, color, name, comment,
              Double.parseDouble(price)));
    }
    return pets;
  }*/

/*  public void writeKennelReservations()
  {
    DocumentBuilder builder = null;
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    try
    {
      builder = factory.newDocumentBuilder();
    }
    catch (ParserConfigurationException e)
    {
      System.out.println("Error");
      System.exit(1);
    }

    //create the XML document
    Document doc = builder.newDocument();

    Element rootElement = doc.createElement("kennelReservations");

    //Add each Student object from the list as XML tags
    for (int i = 0;
         i < viaPetsShop.getCustomerList().getAllNumberOfCustomers(); i++)
    {
      Element subElement = doc.createElement("kennelReservation");
      rootElement.appendChild(subElement);

      Element subSubElement = doc.createElement("name");
      subSubElement.appendChild(doc.createTextNode(
          viaPetsShop.getCustomerList().getCustomer(i).getName()));
      subElement.appendChild(subSubElement);

      subSubElement = doc.createElement("phoneNumber");
      subSubElement.appendChild(doc.createTextNode(
          viaPetsShop.getCustomerList().getCustomer(i).getPhoneNumber()));
      subElement.appendChild(subSubElement);

      subSubElement = doc.createElement("email");
      subSubElement.appendChild(doc.createTextNode(
          viaPetsShop.getCustomerList().getCustomer(i).getEmailAddress()));
      subElement.appendChild(subSubElement);
    }

    doc.appendChild(rootElement);

    //Format and save as XML file
    try
    {
      Transformer transformer = TransformerFactory.newInstance()
          .newTransformer();

      //make new lines and indent the elements in the XML file
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");

      //write the XML file
      File file = new File("kennelReservations.xml");
      transformer.transform(new DOMSource(doc), new StreamResult(file));
    }
    catch (TransformerConfigurationException e)
    {
      System.out.println("Error configuring XML file");
    }
    catch (TransformerException e)
    {
      System.out.println("Error creating XML file");
    }
  }*/

/*  public KennelReservationList readKennelReservations()
  {
    return null;
  }*/

}
