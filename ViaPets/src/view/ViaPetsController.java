package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.*;
import parser.ParserException;

import javax.xml.parsers.ParserConfigurationException;
import java.time.LocalDate;

public class ViaPetsController
{

  @FXML private Tab petTab;
  @FXML private Tab kennelReservationTab;
  @FXML private Tab saleTab;
  @FXML private TableView<Pet> saleTable;
  @FXML private TableColumn<Pet, String> salePetName;
  @FXML private TableColumn<Pet, String> salePetSpecies;
  @FXML private TableColumn<Pet, String> salePetAge;
  @FXML private TableColumn<Pet, String> salePetGender;
  @FXML private TableColumn<Pet, String> salePetColor;
  @FXML private TableColumn<Pet, String> salePetComments;
  @FXML private TableColumn<Pet, String> salePetPrice;
  @FXML private Button removeButton1;
  @FXML private Button saleCustomer;
  @FXML private TableView<Sale> saleListTable;
  @FXML private TableColumn<Sale, String> salePetDetails;
  @FXML private TableColumn<Sale, String> saleCustomerDetails;
  @FXML private TableColumn<Sale, String> saleDateDetails;
  @FXML private TableColumn<Sale, String> salePriceDetails;

  @FXML private TableView<Customer> saleListCustomerTable;
  @FXML private TableColumn<Customer, String> saleListCustomerName;
  @FXML private TableColumn<Customer, String> saleListCustomerPhone;
  @FXML private TableColumn<Customer, String> saleListCustomerEmail;
  @FXML private ComboBox<String> customerComboBox;
  @FXML private AnchorPane saleNewCustomerDialog;
  @FXML private TextField saleNewCustomerName;
  @FXML private TextField saleNewCustomerPhone;
  @FXML private TextField saleNewCustomerEmail;

  @FXML private ComboBox<String> petComboBox;
  @FXML private TextField finalPrice;
  @FXML private DatePicker date;

  @FXML private Tab customerTab;
  @FXML private TableView<Customer> customerTable;
  @FXML private TableColumn<Customer, String> customerName;
  @FXML private TableColumn<Customer, String> customerPhone;
  @FXML private TableColumn<Customer, String> customerEmail;
  @FXML private Pane customerDataDisplay;
  @FXML private Button editButton;
  @FXML private Button updateButton;
  @FXML private TextField nameField;
  @FXML private TextField phoneField;
  @FXML private TextField emailField;
  @FXML private TextField newCName;
  @FXML private TextField newCPhone;
  @FXML private TextField newCEmail;

  @FXML private TableView<Pet> petTable;
  @FXML private TableColumn<Pet, String> petName;
  @FXML private TableColumn<Pet, String> petSpecies;
  @FXML private TableColumn<Pet, String> petAge;
  @FXML private TableColumn<Pet, String> petGender;
  @FXML private TableColumn<Pet, String> petColor;
  @FXML private TableColumn<Pet, String> petComments;
  @FXML private TableColumn<Pet, String> petPrice;
  @FXML private Pane petDataDisplay;
  @FXML private TextField petNameField;
  @FXML private TextField speciesField;
  @FXML private TextField ageField;
  @FXML private TextField genderField;
  @FXML private TextField colorField;
  @FXML private TextField commentsField;
  @FXML private TextField priceField;
  @FXML private Button closeButton2;
  @FXML private Button editPetButton;
  @FXML private Button updatePetButton;
  @FXML private TextField newPetName;
  @FXML private TextField newPetSpecies;
  @FXML private TextField newPetAge;
  @FXML private TextField newGenderField;
  @FXML private TextField newColorField;
  @FXML private TextField newCommentsField;
  @FXML private TextField newPriceField;

  private ViaPetsModelManager modelManager;
  private ViaPetsShop viaPetsShop;

  public void initialize() throws ParserException
  {
    viaPetsShop = new ViaPetsShop();
    modelManager = new ViaPetsModelManager("customers.xml", "pets.xml",
        "sales.bin", "kennelReservation.bin");
    updatePetBox();
    customerDataDisplay.setVisible(false);
    petDataDisplay.setVisible(false);
    updateButton.setVisible(false);
    updatePetButton.setVisible(false);
    saleCustomer.setVisible(false);

  }

  public void updateCustomerBox()
      throws ParserException, ParserConfigurationException
  {
    if (modelManager != null)
    {
      CustomerList allCustomers = modelManager.readCustomers();

      customerTable.getItems().clear();

      for (int i = 0; i < allCustomers.getAllNumberOfCustomers(); i++)
      {
        Customer customerData = allCustomers.getCustomer(i);
        customerTable.getItems().add(customerData);
      }

      customerName.setCellValueFactory(
          data -> new SimpleStringProperty(data.getValue().getName()));
      customerPhone.setCellValueFactory(
          data -> new SimpleStringProperty(data.getValue().getPhoneNumber()));
      customerEmail.setCellValueFactory(
          data -> new SimpleStringProperty(data.getValue().getEmailAddress()));
      ;

      //      adding a listener to know which row is selected
      customerTable.getSelectionModel().selectedItemProperty()
          .addListener((old, current, newC) -> {
            if (newC != null)
            {
              System.out.println(newC);
              showCustomerData(newC);
            }
          });
    }
  }

  public void showCustomerData(Customer selectedCustomer)
  {
    if (selectedCustomer != null)
    {
      customerDataDisplay.setVisible(true);
      //     customerTextArea.setText(selectedCustomer.toString());
      nameField.setText(selectedCustomer.getName());
      phoneField.setText(selectedCustomer.getPhoneNumber());
      emailField.setText(selectedCustomer.getEmailAddress());
      nameField.setEditable(false);
      phoneField.setEditable(false);
      emailField.setEditable(false);

    }
  }

  public void editData() throws ParserException
  {
    editButton.setVisible(false);
    updateButton.setVisible(true);
    nameField.setEditable(true);
    phoneField.setEditable(true);
    emailField.setEditable(true);
  }

  public void updateCustomerData()
      throws ParserException, ParserConfigurationException
  {
    int currentIndex = customerTable.getSelectionModel().getSelectedIndex();
    if (currentIndex != -1)
    {
      Customer selectedCustomer = customerTable.getSelectionModel()
          .getSelectedItem();
      selectedCustomer.setName(nameField.getText());
      selectedCustomer.setPhoneNumber(phoneField.getText());
      selectedCustomer.setEmailAddress(emailField.getText());

      System.out.println(selectedCustomer);
      modelManager.updateCustomer(currentIndex, selectedCustomer);
      setCloseButton();
      updateCustomerBox();
    }

  }

  public void removeCustomer() throws ParserException
  {
    if (modelManager != null)
    {
      int currentIndex = customerTable.getSelectionModel().getSelectedIndex();
      if (currentIndex >= 0)
      {
        Customer selectedCustomer = customerTable.getItems()
            .remove(currentIndex);
        if (selectedCustomer != null)
        {
          CustomerList allCustomers = modelManager.readCustomers();
          allCustomers.removeCustomer(selectedCustomer);
          modelManager.saveCustomerList(allCustomers);
          customerDataDisplay.setVisible(false);
          System.out.println("Customer removed.");
        }
      }
      else
      {
        System.out.println("No customer selected for removal.");
      }
    }
  }

  public void addCustomer() throws ParserException, ParserConfigurationException
  {
    String name = newCName.getText();
    String phone = newCPhone.getText();
    String email = newCEmail.getText();

    Customer newCustomer = new Customer(name, phone, email);
    System.out.println(newCustomer);

    if ((!name.equals(" ")) && (!phone.equals(" ")) && (!email.equals(" ")))
    {
      modelManager.addCustomer(newCustomer);
    }
    else
    {
      System.out.println("Fill the all fields.");
    }
    newCName.clear();
    newCPhone.clear();
    newCEmail.clear();

    updateCustomerBox();
  }

  public void updatePetBox() throws ParserException
  {
    if (modelManager != null)
    {
      PetList allPets = modelManager.readPets();

      petTable.getItems().clear();

      for (int i = 0; i < allPets.getNumberOfPets(); i++)
      {
        Pet petData = allPets.getPet(i);
        petTable.getItems().add(petData);
      }

      petName.setCellValueFactory(
          data -> new SimpleStringProperty(data.getValue().getName()));
      petSpecies.setCellValueFactory(
          data -> new SimpleStringProperty(data.getValue().getSpecies()));
      petAge.setCellValueFactory(data -> new SimpleStringProperty(
          String.valueOf(data.getValue().getAge())));
      petGender.setCellValueFactory(
          data -> new SimpleStringProperty(data.getValue().getGender()));
      petColor.setCellValueFactory(
          data -> new SimpleStringProperty(data.getValue().getColor()));
      petComments.setCellValueFactory(data -> new SimpleStringProperty(
          String.valueOf(data.getValue().getComment())));
      petPrice.setCellValueFactory(data -> new SimpleStringProperty(
          String.valueOf(data.getValue().getPrice())));

      //      adding a listener to know which row is selected
      petTable.getSelectionModel().selectedItemProperty()
          .addListener((old, current, newP) -> {
            if (newP != null)
            {
              //              System.out.println(newP);
              showPetData(newP);
            }
          });
    }

  }

  public void showPetData(Pet selectedPet)
  {
    if (selectedPet != null && petTab.isSelected())
    {
      petDataDisplay.setVisible(true);
      petNameField.setText(selectedPet.getName());
      speciesField.setText(selectedPet.getSpecies());
      ageField.setText(String.valueOf(selectedPet.getAge()));
      genderField.setText(selectedPet.getGender());
      colorField.setText(selectedPet.getColor());
      commentsField.setText(selectedPet.getComment());
      priceField.setText(String.valueOf(selectedPet.getPrice()));

      petNameField.setEditable(false);
      speciesField.setEditable(false);
      ageField.setEditable(false);
      genderField.setEditable(false);
      colorField.setEditable(false);
      commentsField.setEditable(false);
      priceField.setEditable(false);

    }
    else if (selectedPet != null && saleTab.isSelected())
    {
      saleCustomer.setVisible(true);
      petDataDisplay.setVisible(true);
      editPetButton.setVisible(false);
      updatePetButton.setVisible(false);
      removeButton1.setVisible(false);

      petNameField.setText(selectedPet.getName());
      speciesField.setText(selectedPet.getSpecies());
      ageField.setText(String.valueOf(selectedPet.getAge()));
      genderField.setText(selectedPet.getGender());
      colorField.setText(selectedPet.getColor());
      commentsField.setText(selectedPet.getComment());
      priceField.setText(String.valueOf(selectedPet.getPrice()));

      petNameField.setEditable(false);
      speciesField.setEditable(false);
      ageField.setEditable(false);
      genderField.setEditable(false);
      colorField.setEditable(false);
      commentsField.setEditable(false);
      priceField.setEditable(true);

    }
  }

  public void editPetData() throws ParserException
  {
    editPetButton.setVisible(false);
    updatePetButton.setVisible(true);
    petNameField.setEditable(true);
    ageField.setEditable(true);
    commentsField.setEditable(true);
    priceField.setEditable(true);
  }

  public void UpdatePetData() throws ParserException
  {
    int currentIndex = petTable.getSelectionModel().getSelectedIndex();
    if (currentIndex != -1)
    {
      Pet selectedPet = petTable.getSelectionModel().getSelectedItem();
      selectedPet.setName(petNameField.getText());
      //        selectedPet.setSpecies(speciesField.getText());
      selectedPet.setAge(Integer.parseInt(ageField.getText()));
      selectedPet.setComment(commentsField.getText());
      selectedPet.setPrice(Double.parseDouble(priceField.getText()));

      modelManager.updatePet(currentIndex, selectedPet);
      setCloseButton();
      updatePetBox();
    }
  }

  public void removePet() throws ParserException
  {
    if (modelManager != null)
    {
      int currentIndex = petTable.getSelectionModel().getSelectedIndex();
      if (currentIndex >= 0)
      {
        Pet selectedPet = petTable.getItems().remove(currentIndex);
        if (selectedPet != null)
        {
          PetList allPets = modelManager.readPets();
          allPets.removePet(selectedPet);
          modelManager.savePetList(allPets);
          petDataDisplay.setVisible(false);
          System.out.println("Pet removed.");
        }
      }
      else
      {
        System.out.println("No pet selected for removal.");
      }
    }
  }

  public void addPet() throws ParserException, ParserConfigurationException
  {
    String name = newPetName.getText();
    String species = newPetSpecies.getText();
    int age = Integer.parseInt(newPetAge.getText());
    String gender = newGenderField.getText();
    String color = newColorField.getText();
    double price = Double.parseDouble(newPriceField.getText());
    String comment = newCommentsField.getText();

    Pet newPet = new Pet(species, age, gender, color, name, comment, price);

    if ((!name.equals(" ")) && (!species.equals(" ")) && (age != -1)
        && (!gender.equals(" ")) && (!color.equals(" ")) && (price != -1)
        && (!comment.equals(" ")))
    {
      modelManager.addPet(newPet);
    }
    else
    {
      System.out.println("Fill all fields");
    }
    newPetName.clear();
    newPetSpecies.clear();
    newPetAge.clear();
    newGenderField.clear();
    newColorField.clear();
    newPriceField.clear();
    newCommentsField.clear();

    updatePetBox();
  }

  public void updateSaleBox() throws ParserException
  {
    if (modelManager != null)
    {
      CustomerList allCustomers = modelManager.readCustomers();
      PetList allPets = modelManager.readPets();
      SaleList allSales = modelManager.readSales();
      saleListTable.getItems().clear();

      for (int i = 0; i < allSales.getAllNumberOfSales(); i++)
      {
        Sale saleData = allSales.getSale(i);
        saleListTable.getItems().add(saleData);
      }

      salePetDetails.setCellValueFactory(
          data -> new SimpleStringProperty(data.getValue().getPet().getName()));
      saleCustomerDetails.setCellValueFactory(data -> new SimpleStringProperty(
          data.getValue().getCustomer().getName()));
      saleDateDetails.setCellValueFactory(data -> new SimpleStringProperty(
          data.getValue().getDate().toString()));
      salePriceDetails.setCellValueFactory(data -> new SimpleStringProperty(
          String.valueOf(data.getValue().getFinalPrice())));

      customerComboBox.getItems().clear();
      petComboBox.getItems().clear();

      customerComboBox.setValue("Select Customer");
      petComboBox.setValue("Select Pet");

      for (int i = 0; i < allCustomers.getAllNumberOfCustomers(); i++)
      {
        String name = allCustomers.getCustomer(i).getName();
        customerComboBox.getItems().add(name);
      }

      for (int i = 0; i < allPets.getNumberOfPets(); i++)
      {
        String name = allPets.getPet(i).getName();
        petComboBox.getItems().add(name);
      }
    }
  }

  public void saleAddCustomerButton()
  {
    saleNewCustomerDialog.setVisible(true);
  }

  public void addSaleCustomer()
      throws ParserException, ParserConfigurationException
  {
    CustomerList allCustomers = modelManager.readCustomers();

    String name = saleNewCustomerName.getText();
    String phone = saleNewCustomerPhone.getText();
    String email = saleNewCustomerEmail.getText();

    Customer customer = new Customer(name, phone, email);

    Customer existingCustomer = null;
    for (int i = 0; i < allCustomers.getAllNumberOfCustomers(); i++)
    {
      existingCustomer = allCustomers.getCustomer(i);
    }
    if (customer != null && !customer.equals(existingCustomer))
    {
      modelManager.addCustomer(customer);
      updateCustomerBox();
      updateSaleBox();

      saleNewCustomerName.clear();
      saleNewCustomerPhone.clear();
      saleNewCustomerEmail.clear();
      saleNewCustomerDialog.setVisible(false);

    }
    else
    {
      System.out.println("Customer already exists");
    }

    //    //    if (modelManager != null)
    //    //    {
    //    //      CustomerList allCustomers = modelManager.readCustomers();
    //    //
    //    //      saleListCustomerTable.getItems().clear();
    //    //
    //    //      for (int i = 0; i < allCustomers.getAllNumberOfCustomers(); i++)
    //    //      {
    //    //        Customer customerData = allCustomers.getCustomer(i);
    //    //        saleListCustomerTable.getItems().add(customerData);
    //    //      }
    //    //
    //    //      saleListCustomerName.setCellValueFactory(
    //    //          data -> new SimpleStringProperty(data.getValue().getName()));
    //    //      saleListCustomerPhone.setCellValueFactory(
    //    //          data -> new SimpleStringProperty(data.getValue().getPhoneNumber()));
    //    //      saleListCustomerEmail.setCellValueFactory(
    //    //          data -> new SimpleStringProperty(data.getValue().getEmailAddress()));
    //    //      ;
    //    //
    //    //      //      adding a listener to know which row is selected
    //    //      saleListCustomerTable.getSelectionModel().selectedItemProperty()
    //    //          .addListener((old, current, selectedCustomer) -> {
    //    //            if (selectedCustomer != null)
    //    //            {
    //    //              System.out.println(selectedCustomer);
    //    //              showCustomerData(selectedCustomer);
    //    //              try
    //    //              {
    //    //                //                check the customer
    //    //                boolean alreadyExist = selectedCustomer.equals(
    //    //                    saleListCustomerTable.getItems());
    //    //
    //    //                System.out.println(alreadyExist);
    //    //                if (!alreadyExist)
    //    //                {
    //    //                  addCustomer();
    //    //                }
    //    //              }
    //    //              catch (ParserException | ParserConfigurationException e)
    //    //              {
    //    //                throw new RuntimeException(e);
    //    //              }
    //    //            }
    //    //          });
    //    //    }
    //    //    System.out.println("pet sold");
    //  }
  }

  public void addSale() throws ParserException
  {
    String customerName = customerComboBox.getValue();
    CustomerList allCustomers = modelManager.readCustomers();
    Customer saleCustomer = null;
    for (int i = 0; i < allCustomers.getAllNumberOfCustomers(); i++)
    {
      if (customerName.equals(allCustomers.getCustomer(i).getName()))
      {
        saleCustomer = allCustomers.getCustomer(i);
      }
    }
    String petName = petComboBox.getValue();
    PetList allPets = modelManager.readPets();
    Pet salePet = null;
    for (int i = 0; i < allPets.getNumberOfPets(); i++)
    {
      if (petName.equals(allPets.getPet(i).getName()))
      {
        salePet = allPets.getPet(i);
      }
    }
    String priceText = finalPrice.getText();
    double sellPrice = 0.0;
    if (priceText != null && !priceText.isEmpty())
    {
      sellPrice = Double.parseDouble(priceText);
    }
    LocalDate sellDate = null;
    MyDate myDate = null;

    if (date != null)
    {
      sellDate = date.getValue();
      myDate = new MyDate(sellDate.getDayOfMonth(), sellDate.getMonthValue(),
          sellDate.getYear());
    }

    if (salePet != null && saleCustomer != null)
    {
      Sale sale = new Sale(sellPrice, saleCustomer, salePet, myDate);
      modelManager.addSale(sale);
      updateSaleBox();
      //      addSaleToTable(sale);

      //      customerComboBox.getItems().clear();
      //      petComboBox.getItems().clear();

      //      customerComboBox.setValue("Select Customer");
      //      petComboBox.setValue("Select Pet");

      finalPrice.clear();
      date.setValue(null);
      System.out.println("sale added");
    }

  }

  //  public void addSaleToTable(Sale sale)
  //  {
  //    saleListTable.getItems().add(sale);
  //
  //    salePetDetails.setCellValueFactory(
  //        data -> new SimpleStringProperty(data.getValue().getPet().getName()));
  //
  //    saleCustomerDetails.setCellValueFactory(data -> new SimpleStringProperty(
  //        data.getValue().getCustomer().getName()));
  //
  //    saleDateDetails.setCellValueFactory(
  //        data -> new SimpleStringProperty(data.getValue().getDate().toString()));
  //
  //    salePriceDetails.setCellValueFactory(data -> new SimpleStringProperty(
  //        String.valueOf(data.getValue().getFinalPrice())));
  //  }

  public void setCloseButton()
  {
    customerDataDisplay.setVisible(false);
    petDataDisplay.setVisible(false);
    editButton.setVisible(true);
    updateButton.setVisible(false);
    editPetButton.setVisible(true);
    updatePetButton.setVisible(false);
  }

  public void tabChanged(Event e)
      throws ParserException, ParserConfigurationException
  {
    if (customerTab != null && customerTab.isSelected())
    {
      updateCustomerBox();
    }
    else if (petTab != null && petTab.isSelected())
    {
      updatePetBox();
    }
    else if (saleTab != null && saleTab.isSelected())
    {
      updateSaleBox();
    }
  }
}
