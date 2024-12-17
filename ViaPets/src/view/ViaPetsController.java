package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.*;
import parser.ParserException;

import java.time.LocalDate;

public class ViaPetsController
{

  @FXML private Tab petTab;
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
  @FXML private Button editPetButton;
  @FXML private Button updatePetButton;
  @FXML private TextField newPetName;
  @FXML private TextField newPetSpecies;
  @FXML private TextField newPetAge;
  @FXML private TextField newGenderField;
  @FXML private TextField newColorField;
  @FXML private TextField newCommentsField;
  @FXML private TextField newPriceField;

  @FXML private Tab kennelReservationTab;
  @FXML private TableView<KennelReservation> kennelReservationTable;
  @FXML private TableColumn<KennelReservation, String> reservationPetName;
  @FXML private TableColumn<KennelReservation, String> reservationCustomerName;
  @FXML private TableColumn<KennelReservation, String> reservationPrice;
  @FXML private TableColumn<KennelReservation, String> reservationStartDate;
  @FXML private TableColumn<KennelReservation, String> reservationEndDate;
  @FXML private ComboBox<String> reservationPetComboBox;
  @FXML private ComboBox<String> reservationCustomerComboBox;
  @FXML private AnchorPane reservationNewCustomerDialog;
  @FXML private TextField reservationNewCustomerName;
  @FXML private TextField reservationNewCustomerPhone;
  @FXML private TextField reservationNewCustomerEmail;
  @FXML private AnchorPane reservationNewPetDialog;
  @FXML private TextField reservationNewPetName;
  @FXML private TextField reservationNewPetSpecies;
  @FXML private TextField reservationNewPetAge;
  @FXML private TextField reservationNewPetGender;
  @FXML private TextField reservationNewPetColor;
  @FXML private TextField reservationNewPetComments;
  @FXML private TextField reservationNewPetPrice;
  @FXML private TextField reservationFieldPrice;
  @FXML private DatePicker startDate;
  @FXML private DatePicker endDate;

  @FXML private Tab saleTab;
  @FXML private Button removeButton1;
  @FXML private Button saleCustomer;
  @FXML private TableView<Sale> saleListTable;
  @FXML private TableColumn<Sale, String> salePetDetails;
  @FXML private TableColumn<Sale, String> saleCustomerDetails;
  @FXML private TableColumn<Sale, String> saleDateDetails;
  @FXML private TableColumn<Sale, String> salePriceDetails;
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

  private ViaPetsModelManager modelManager;

  public void initialize() throws ParserException
  {
    modelManager = new ViaPetsModelManager("customers.xml", "pets.xml",
        "sales.bin", "kennelReservation.bin");
    updatePetBox();
    customerDataDisplay.setVisible(false);
    petDataDisplay.setVisible(false);
    updateButton.setVisible(false);
    updatePetButton.setVisible(false);
    saleCustomer.setVisible(false);

  }

  public void updateCustomerBox() throws ParserException
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

  public void editData()
  {
    editButton.setVisible(false);
    updateButton.setVisible(true);
    nameField.setEditable(true);
    phoneField.setEditable(true);
    emailField.setEditable(true);
  }

  public void updateCustomerData() throws ParserException
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

  public void addCustomer() throws ParserException
  {
    String name = newCName.getText();
    String phone = newCPhone.getText();
    String email = newCEmail.getText();

    Customer newCustomer = new Customer(name, phone, email);
    System.out.println(newCustomer);

    if (name.isEmpty() || phone.isEmpty() || email.isEmpty())
    {
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Missing Fields");
      alert.setHeaderText(null);
      alert.setContentText("Please fill all the fields to add a customer.");
      alert.showAndWait();
    }
    else
    {
      modelManager.addCustomer(newCustomer);
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

  public void editPetData()
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

  public void addPet() throws ParserException
  {
    String name = newPetName.getText();
    String species = newPetSpecies.getText();
    String ageText = newPetAge.getText();
    String gender = newGenderField.getText();
    String color = newColorField.getText();
    String priceText = newPriceField.getText();
    String comment = newCommentsField.getText();

    if (name.isEmpty() || species.isEmpty() || ageText.isEmpty()
        || gender.isEmpty() || color.isEmpty() || priceText.isEmpty()
        || comment.isEmpty())
    {
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Missing Fields");
      alert.setHeaderText(null);
      alert.setContentText("Please fill all the fields to add a pet.");
      alert.showAndWait();
    }
    else
    {
      int age = Integer.parseInt(ageText);
      double price = Double.parseDouble(priceText);
      Pet newPet = new Pet(species, age, gender, color, name, comment, price);
      modelManager.addPet(newPet);
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

  public void addSaleCustomer() throws ParserException
  {
    CustomerList allCustomers = modelManager.readCustomers();

    String name = saleNewCustomerName.getText();
    String phone = saleNewCustomerPhone.getText();
    String email = saleNewCustomerEmail.getText();

    if (name.isEmpty() || phone.isEmpty() || email.isEmpty())
    {
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Missing Fields");
      alert.setHeaderText(null);
      alert.setContentText("Please fill out all fields to add a customer.");
      alert.showAndWait();
      return;
    }

    Customer customer = new Customer(name, phone, email);

    Customer existingCustomer = null;
    for (int i = 0; i < allCustomers.getAllNumberOfCustomers(); i++)
    {
      existingCustomer = allCustomers.getCustomer(i);
    }
    if (!customer.equals(existingCustomer))
    {
      modelManager.addCustomer(customer);
      updateCustomerBox();
      updateSaleBox();
      updateKennelBox();

      saleNewCustomerName.clear();
      saleNewCustomerPhone.clear();
      saleNewCustomerEmail.clear();
      saleNewCustomerDialog.setVisible(false);

    }
    else
    {
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Duplicate Customer");
      alert.setHeaderText(null);
      alert.setContentText("A customer with the same details already exists.");
      alert.showAndWait();

      saleNewCustomerName.clear();
      saleNewCustomerPhone.clear();
      saleNewCustomerEmail.clear();
    }
  }

  public void addSale() throws ParserException
  {
    String customerName = customerComboBox.getValue();
    String petName = petComboBox.getValue();
    String priceText = finalPrice.getText();
    LocalDate sellDate = date.getValue();

    if (customerName == null || customerName.isEmpty() || petName == null
        || petName.isEmpty() || priceText == null || priceText.isEmpty()
        || sellDate == null)
    {

      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Missing Fields");
      alert.setHeaderText(null);
      alert.setContentText(
          "Please select a customer, pet, enter a price, and choose a date.");
      alert.showAndWait();
      return;
    }

    CustomerList allCustomers = modelManager.readCustomers();
    Customer saleCustomer = null;
    for (int i = 0; i < allCustomers.getAllNumberOfCustomers(); i++)
    {
      if (customerName.equals(allCustomers.getCustomer(i).getName()))
      {
        saleCustomer = allCustomers.getCustomer(i);
      }
    }
    PetList allPets = modelManager.readPets();
    Pet salePet = null;
    for (int i = 0; i < allPets.getNumberOfPets(); i++)
    {
      if (petName.equals(allPets.getPet(i).getName()))
      {
        salePet = allPets.getPet(i);
      }
    }
    double sellPrice = Double.parseDouble(priceText);
    MyDate myDate = null;

    if (date != null)
    {
      sellDate = date.getValue();
      myDate = new MyDate(sellDate.getDayOfMonth(), sellDate.getMonthValue(),
          sellDate.getYear());
    }

    if (salePet != null && saleCustomer != null && myDate != null)
    {
      Sale sale = new Sale(sellPrice, saleCustomer, salePet, myDate);
      modelManager.addSale(sale);
      updateSaleBox();

      customerComboBox.setValue("Select Customer");
      petComboBox.setValue("Select Pet");

      finalPrice.clear();
      date.setValue(null);
      System.out.println("sale added");
    }

  }

  public void updateKennelBox() throws ParserException
  {
    if (modelManager != null)
    {
      KennelReservationList allReservations = modelManager.readKennelReservations();
      kennelReservationTable.getItems().clear();
      for (int i = 0;
           i < allReservations.getAllNumberOfKennelReservations(); i++)
      {
        KennelReservation reservationData = allReservations.getKennelReservation(
            i);
        kennelReservationTable.getItems().add(reservationData);
      }

      reservationPetName.setCellValueFactory(
          data -> new SimpleStringProperty(data.getValue().getPet().getName()));
      reservationCustomerName.setCellValueFactory(
          data -> new SimpleStringProperty(
              data.getValue().getCustomer().getName()));
      reservationPrice.setCellValueFactory(data -> new SimpleStringProperty(
          String.valueOf(data.getValue().getPrice())));
      reservationStartDate.setCellValueFactory(data -> new SimpleStringProperty(
          String.valueOf(data.getValue().getStartDate())));
      reservationEndDate.setCellValueFactory(data -> new SimpleStringProperty(
          String.valueOf(data.getValue().getEndDate())));

      CustomerList allCustomers = modelManager.readCustomers();
      PetList allPets = modelManager.readPets();

      reservationCustomerComboBox.getItems().clear();
      reservationPetComboBox.getItems().clear();

      reservationCustomerComboBox.setValue("Select Customer");
      reservationPetComboBox.setValue("Select Pet");

      for (int i = 0; i < allCustomers.getAllNumberOfCustomers(); i++)
      {
        String name = allCustomers.getCustomer(i).getName();
        reservationCustomerComboBox.getItems().add(name);
      }

      for (int i = 0; i < allPets.getNumberOfPets(); i++)
      {
        String name = allPets.getPet(i).getName();
        reservationPetComboBox.getItems().add(name);
      }
    }
  }

  public void reservationAddCustomerButton()
  {
    reservationNewCustomerDialog.setVisible(true);
  }

  public void reservationAddPetButton()
  {
    reservationNewPetDialog.setVisible(true);
  }

  public void addReservationCustomer() throws ParserException
  {
    CustomerList allCustomers = modelManager.readCustomers();

    String name = reservationNewCustomerName.getText();
    String phone = reservationNewCustomerPhone.getText();
    String email = reservationNewCustomerEmail.getText();

    if (name.isEmpty() || phone.isEmpty() || email.isEmpty())
    {
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Missing Fields");
      alert.setHeaderText(null);
      alert.setContentText("Please fill all the fields to add a customer.");
      alert.showAndWait();
      return;
    }
    Customer customer = new Customer(name, phone, email);

    Customer existingCustomer = null;
    for (int i = 0; i < allCustomers.getAllNumberOfCustomers(); i++)
    {
      existingCustomer = allCustomers.getCustomer(i);
    }
    if (!customer.equals(existingCustomer))
    {
      modelManager.addCustomer(customer);
      updateCustomerBox();
      updateKennelBox();
      updateSaleBox();
    }
    else
    {
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Duplicate Customer");
      alert.setHeaderText(null);
      alert.setContentText("A customer with the same details already exists.");
      alert.showAndWait();
    }
    reservationNewCustomerName.clear();
    reservationNewCustomerPhone.clear();
    reservationNewCustomerEmail.clear();
    reservationNewCustomerDialog.setVisible(false);

  }

  public void addReservationPet() throws ParserException
  {
    PetList allPets = modelManager.readPets();

    String name = reservationNewPetName.getText();
    String species = reservationNewPetSpecies.getText();
    int age = Integer.parseInt(reservationNewPetAge.getText());
    String gender = reservationNewPetGender.getText();
    String color = reservationNewPetColor.getText();
    double price = Double.parseDouble(reservationNewPetPrice.getText());
    String comments = reservationNewPetComments.getText();

    Pet pet = new Pet(species, age, gender, color, name, comments, price);

    Pet existingPet = null;
    for (int i = 0; i < allPets.getNumberOfPets(); i++)
    {
      existingPet = allPets.getPet(i);
    }
    if (!pet.equals(existingPet))
    {
      modelManager.addPet(pet);
      updateKennelBox();
      updateSaleBox();
      updatePetBox();
      reservationNewPetName.clear();
      reservationNewPetSpecies.clear();
      reservationNewPetAge.clear();
      reservationNewPetGender.clear();
      reservationNewPetComments.clear();
      reservationNewPetColor.clear();
      reservationNewPetPrice.clear();
      reservationNewPetDialog.setVisible(false);
    }
    else
    {
      System.out.println("Pet already exists");
    }

  }

  public void addReservation() throws ParserException
  {

    KennelReservationList allReservations = modelManager.readKennelReservations();


    if(true)
    {
      String customerName = reservationCustomerComboBox.getValue();
      CustomerList allCustomers = modelManager.readCustomers();
      Customer reservationCustomer = null;
      for (int i = 0; i < allCustomers.getAllNumberOfCustomers(); i++)
      {
        if (customerName.equals(allCustomers.getCustomer(i).getName()))
        {
          reservationCustomer = allCustomers.getCustomer(i);
        }
      }
      String petName = reservationPetComboBox.getValue();
      PetList allPets = modelManager.readPets();
      Pet reservationPet = null;
      for (int i = 0; i < allPets.getNumberOfPets(); i++)
      {
        if (petName.equals(allPets.getPet(i).getName()))
        {
          reservationPet = allPets.getPet(i);
        }
      }
      String priceText = reservationFieldPrice.getText();
      double kennelPrice = 0.0;
      if (priceText != null && !priceText.isEmpty())
      {
        kennelPrice = Double.parseDouble(priceText);
      }

      LocalDate newStartDate = null;
      MyDate myStartDate = null;

      if (startDate != null && startDate.getValue() != null)
      {
        newStartDate = startDate.getValue();
        myStartDate = new MyDate(newStartDate.getDayOfMonth(),
            newStartDate.getMonthValue(), newStartDate.getYear());
      }

      LocalDate newEndDate = null;
      MyDate myEndDate = null;

      if (endDate != null && endDate.getValue() != null)
      {
        newEndDate = endDate.getValue();
        myEndDate = new MyDate(newEndDate.getDayOfMonth(),
            newEndDate.getMonthValue(), newEndDate.getYear());
      }

      if (customerName == null || customerName.isEmpty() || petName == null
          || petName.isEmpty() || priceText == null || priceText.isEmpty()
          || newStartDate == null || newEndDate == null)
      {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Missing Fields");
        alert.setHeaderText(null);
        alert.setContentText(
            "Please fill all the fields to add a reservation.");
        alert.showAndWait();
      }

      else if (reservationPet != null && reservationCustomer != null)
      {

        KennelReservation reservation = new KennelReservation(kennelPrice,
            reservationPet, reservationCustomer, myStartDate, myEndDate);
        if (allReservations.dateChecker(reservation))
        {
          Alert alert = new Alert(Alert.AlertType.WARNING);
          alert.setTitle("Capacity Full");
          alert.setHeaderText(null);
          alert.setContentText("No more kennel reservations can make.");
          alert.showAndWait();
        }
        modelManager.addKennelReservation(reservation);
        updateKennelBox();

        reservationFieldPrice.clear();
        startDate.setValue(null);
        endDate.setValue(null);
        System.out.println("reservation added");
      }
    }
  }

  public void setCloseButton()
  {
    customerDataDisplay.setVisible(false);
    petDataDisplay.setVisible(false);
    editButton.setVisible(true);
    updateButton.setVisible(false);
    editPetButton.setVisible(true);
    updatePetButton.setVisible(false);
    saleNewCustomerDialog.setVisible(false);
    reservationNewCustomerDialog.setVisible(false);
    reservationNewPetDialog.setVisible(false);

  }

  public void tabChanged() throws ParserException
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
    else if (kennelReservationTab != null && kennelReservationTab.isSelected())
    {
      updateKennelBox();
    }
  }
}
