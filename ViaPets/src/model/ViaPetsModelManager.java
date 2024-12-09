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

/*
  public void saveCustomers(CustomerList customers) throws ParserException
  {
    XmlJsonParser parser = new XmlJsonParser();
    try
    {
      File customersFile = parser.toXml(customers, "customers.xml");
      System.out.println("Customers saved to customers.xml");
    }
    catch (ParserException e)
    {
      System.err.println(
          "Error parsing customer data to XML: " + e.getMessage());
    }
    */
/*try
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
    }*//*

  }
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
    System.out.println("Wrote customer data to XML file");
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

  public void removeCustomer(int index) throws ParserException
  {
    CustomerList allCustomers = readCustomers();
    if (index >= 0 && index < allCustomers.getAllNumberOfCustomers())
    {
      Customer removeCustomer = allCustomers.getCustomer(index);
      if (removeCustomer != null)
      {
        //        System.out.println(removeCustomer);
        allCustomers.removeCustomer(removeCustomer);
        saveCustomerList(allCustomers);
      }
    }
  }

  public void saveCustomerList(CustomerList allCustomers) throws ParserException
  {
    System.out.println("new list");
    XmlJsonParser parser = new XmlJsonParser();
    File customers = parser.toXml(allCustomers, "customers.xml");
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

  public void writeSales()
  {

  }

  public SaleList readSales()
  {
    return null;
  }
}
