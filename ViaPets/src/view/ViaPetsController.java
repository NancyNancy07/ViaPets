package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
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
  @FXML private TextField specialField;
  @FXML private TextField specialField2;
  @FXML private Label specialLabel;
  @FXML private Label specialLabel2;
  @FXML private HBox specialInfo;
  @FXML private HBox specialInfo2;
  @FXML private Button editPetButton;
  @FXML private Button updatePetButton;
  @FXML private TextField newPetName;
  @FXML private ComboBox<String> newPetSpeciesComboBox;
  @FXML private TextField newPetAge;
  @FXML private TextField newGenderField;
  @FXML private TextField newColorField;
  @FXML private TextField newCommentsField;
  @FXML private TextField newPriceField;
  @FXML private ComboBox<String> newPetSpeciesComboBox2;

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
  @FXML private Pane reservationDataDisplay;
  @FXML private TextField petNameFieldReservation;
  @FXML private TextField speciesFieldReservation;
  @FXML private TextField ageFieldReservation;
  @FXML private TextField genderFieldReservation;
  @FXML private TextField colorFieldReservation;
  @FXML private TextField commentsFieldReservation;
  @FXML private TextField priceFieldReservation;
  @FXML private TextField nameFieldReservation;
  @FXML private TextField phoneFieldReservation;
  @FXML private TextField emailFieldReservation;
  @FXML private TextField startDateReservation;
  @FXML private TextField endDateReservation;
  @FXML private TextField priceReservation;
  @FXML private Button updateButton2;
  @FXML private Button editButton2;
  @FXML private Button removeButton2;

  @FXML private Tab saleTab;
  @FXML private Button removeButton1;
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
    reservationDataDisplay.setVisible(false);
    updateButton.setVisible(false);
    updatePetButton.setVisible(false);
    updateButton2.setVisible(false);
    petSpecies();
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
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Remove Customer");
        confirmationAlert.setHeaderText(
            "Are you sure you want to remove this customer?");
        confirmationAlert.setContentText("This action cannot be undone.");

        ButtonType result = confirmationAlert.showAndWait()
            .orElse(ButtonType.CANCEL);

        if (result == ButtonType.OK)
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
      if (selectedPet instanceof Dog)
      {
        System.out.println(selectedPet);

        specialInfo.setVisible(true);
        specialInfo2.setVisible(true);
        specialField.setText(((Dog) selectedPet).getBreed());
        specialField2.setText(((Dog) selectedPet).getBreeder());

      }
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
    speciesField.setDisable(true);
    genderField.setDisable(true);
    colorField.setDisable(true);
  }

  public void UpdatePetData() throws ParserException
  {
    int currentIndex = petTable.getSelectionModel().getSelectedIndex();
    if (currentIndex != -1)
    {
      Pet selectedPet = petTable.getSelectionModel().getSelectedItem();
      selectedPet.setName(petNameField.getText());
      selectedPet.setComment(commentsField.getText());

      String ageText = ageField.getText();
      String priceText = priceField.getText();
      try
      {
        int age = Integer.parseInt(ageText);
        double price = Double.parseDouble(priceText);
        if (age < 0)
        {
          Alert alert = new Alert(Alert.AlertType.WARNING);
          alert.setTitle("Invalid Age");
          alert.setHeaderText(null);
          alert.setContentText("Cannot be negative.");
          alert.showAndWait();
          return;
        }
        selectedPet.setAge(age);

        if (price < 0)
        {
          Alert alert = new Alert(Alert.AlertType.WARNING);
          alert.setTitle("Invalid Price");
          alert.setHeaderText(null);
          alert.setContentText("Cannot be negative.");
          alert.showAndWait();
          return;
        }
        selectedPet.setPrice(price);

      }
      catch (NumberFormatException e)
      {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Invalid Format");
        alert.setHeaderText(null);
        alert.setContentText("Please enter a valid number(non-negative)");
        alert.showAndWait();
      }
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
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Remove Pet");
        confirmationAlert.setHeaderText(
            "Are you sure you want to remove this pet?");
        confirmationAlert.setContentText("This action cannot be undone.");

        ButtonType result = confirmationAlert.showAndWait()
            .orElse(ButtonType.CANCEL);

        if (result == ButtonType.OK)
        {
          Pet selectedPet = petTable.getItems().remove(currentIndex);
          KennelReservationList allReservations = modelManager.readKennelReservations();
          for (int i = 0;
               i < allReservations.getAllNumberOfKennelReservations(); i++)
          {
            if (selectedPet.equals(
                allReservations.getKennelReservation(i).getPet()))
            {

              Alert alert = new Alert(Alert.AlertType.WARNING);
              alert.setTitle("Kennel Pet");
              alert.setHeaderText(null);
              alert.setContentText(
                  "Cannot remove Kennel pet. Remove from Kennel Reservation");
              alert.showAndWait();
              return;
            }
          }

          if (selectedPet != null)
          {
            PetList allPets = modelManager.readPets();
            allPets.removePet(selectedPet);
            modelManager.savePetList(allPets);
            petDataDisplay.setVisible(false);
            System.out.println("Pet removed.");
          }
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
    String species = newPetSpeciesComboBox.getValue();
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
      try
      {
        int age = Integer.parseInt(ageText);
        double price = Double.parseDouble(priceText);

        if (age < 0 || price < 0)
        {
          Alert alert = new Alert(Alert.AlertType.WARNING);
          alert.setTitle("Invalid Value");
          alert.setHeaderText(null);
          alert.setContentText("Cannot be negative.");
          alert.showAndWait();
          return;
        }

        Pet pet = null;
        switch(species)
        {
          case "Dog":
            pet = new Dog(species, age, gender, color, name, comment,
                price, "Always same breed", "Always same breeder");
            break;
          case "Cat":
            pet = new Cat(species, age, gender, color, name, comment,
                price, "Always same breed", "Always same breeder");
            break;
          case "Bird":
            pet = new Bird(species, age, gender, color, name, comment,
                price, "Same food");
            break;
          case "Rodent":
            pet = new Rodent(species, age, gender, color, name,
                comment, price, true);
            break;
          case "Fish":
            pet = new Fish(species, age, gender, color, name, comment,
                price, true, true);
            break;
          case "Various":
            pet = new Various(species, age, gender, color, name,
                comment, price);
            break;
          default:
            break;
        }
        modelManager.addPet(pet);
      }
      catch (NumberFormatException e)
      {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Invalid Input");
        alert.setHeaderText(null);
        alert.setContentText(
            "Please enter valid numeric values for age and price.");
        alert.showAndWait();
        return;
      }
    }

    newPetName.clear();
    newPetSpeciesComboBox.getItems().clear();
    newPetSpeciesComboBox.setValue("Select Species");
    newPetAge.clear();
    newGenderField.clear();
    newColorField.clear();
    newPriceField.clear();
    newCommentsField.clear();
    updatePetBox();
  }

  public void petSpecies()
  {
    if (modelManager != null)
    {
      if (petTab.isSelected())
      {
        newPetSpeciesComboBox.getItems().clear();
        newPetSpeciesComboBox.getItems()
            .addAll("Dog", "Cat", "Bird", "Rodent", "Fish", "Various");
        newPetSpeciesComboBox.setPromptText("Select Species");
      }
      else if (kennelReservationTab.isSelected())
      {
        newPetSpeciesComboBox2.getItems().clear();
        newPetSpeciesComboBox2.getItems()
            .addAll("Dog", "Cat", "Bird", "Rodent", "Fish", "Various");
        newPetSpeciesComboBox2.setPromptText("Select Species");
      }

    }
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

      salePetDetails.setCellValueFactory(data -> new SimpleStringProperty(
          data.getValue().getPet().toString()));
      saleCustomerDetails.setCellValueFactory(data -> new SimpleStringProperty(
          data.getValue().getCustomer().toString()));
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
        String customer = allCustomers.getCustomer(i).toString();
        customerComboBox.getItems().add(customer);
      }

      for (int i = 0; i < allPets.getNumberOfPets(); i++)
      {
        String pet = allPets.getPet(i).toString();
        petComboBox.getItems().add(pet);
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
      if (customerName.equals(allCustomers.getCustomer(i).toString()))
      {
        saleCustomer = allCustomers.getCustomer(i);
      }
    }

    PetList allPets = modelManager.readPets();
    Pet salePet = null;

    for (int i = 0; i < allPets.getNumberOfPets(); i++)
    {
      if (petName.equals(allPets.getPet(i).toString()))
      {
        salePet = allPets.getPet(i);
      }
    }
    double sellPrice = Double.parseDouble(priceText);
    if (sellPrice < 0)
    {
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Invalid Price");
      alert.setHeaderText(null);
      alert.setContentText("Price cannot be negative.");
      alert.showAndWait();
      finalPrice.clear();
      return;
    }

    MyDate myDate = null;

    if (date != null)
    {
      sellDate = date.getValue();
      myDate = new MyDate(sellDate.getDayOfMonth(), sellDate.getMonthValue(),
          sellDate.getYear());
    }

    if (salePet != null && saleCustomer != null && myDate != null)
    {
      if (salePet.getPrice() == 0)
      {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Kennel Pet Selected");
        alert.setHeaderText(null);
        alert.setContentText("This pet is from Kennel and cannot be sold.");
        alert.showAndWait();
        customerComboBox.setValue("Select Customer");
        petComboBox.setValue("Select Pet");

        finalPrice.clear();
        date.setValue(null);
        return;
      }

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

      //      adding listener to know which reservation is selected
      kennelReservationTable.getSelectionModel().selectedItemProperty()
          .addListener((old, current, newK) -> {
            if (newK != null)
            {
              showReservationData(newK);
            }
          });

    }
  }

  public void showReservationData(KennelReservation selectedReservation)
  {
    if (selectedReservation != null)
    {
      //      System.out.println(selectedReservation);
      //      customer
      reservationDataDisplay.setVisible(true);
      nameFieldReservation.setText(selectedReservation.getCustomer().getName());
      phoneFieldReservation.setText(
          selectedReservation.getCustomer().getPhoneNumber());
      emailFieldReservation.setText(
          selectedReservation.getCustomer().getEmailAddress());

      //      pet
      petNameFieldReservation.setText(selectedReservation.getPet().getName());
      speciesFieldReservation.setText(
          selectedReservation.getPet().getSpecies());
      ageFieldReservation.setText(
          String.valueOf(selectedReservation.getPet().getAge()));
      genderFieldReservation.setText(selectedReservation.getPet().getGender());
      colorFieldReservation.setText(selectedReservation.getPet().getColor());
      commentsFieldReservation.setText(
          selectedReservation.getPet().getComment());
      priceFieldReservation.setText(
          String.valueOf(selectedReservation.getPet().getPrice()));

      startDateReservation.setText(
          String.valueOf(selectedReservation.getStartDate()));
      endDateReservation.setText(
          String.valueOf(selectedReservation.getEndDate()));
      priceReservation.setText(String.valueOf(selectedReservation.getPrice()));

      nameFieldReservation.setEditable(false);
      phoneFieldReservation.setEditable(false);
      emailFieldReservation.setEditable(false);
      petNameFieldReservation.setEditable(false);
      speciesFieldReservation.setEditable(false);
      ageFieldReservation.setEditable(false);
      genderFieldReservation.setEditable(false);
      colorFieldReservation.setEditable(false);
      commentsFieldReservation.setEditable(false);
      priceFieldReservation.setEditable(false);
    }
  }

  public void editReservationData()
  {
    editButton2.setVisible(false);
    updateButton2.setVisible(true);

    nameFieldReservation.setEditable(true);
    phoneFieldReservation.setEditable(true);
    emailFieldReservation.setEditable(true);
    petNameFieldReservation.setEditable(true);
    speciesFieldReservation.setDisable(true);
    ageFieldReservation.setEditable(true);
    genderFieldReservation.setDisable(true);
    colorFieldReservation.setDisable(true);
    commentsFieldReservation.setEditable(true);
    priceFieldReservation.setDisable(true);
  }

  public void UpdateReservationData() throws ParserException
  {
    int currentIndex = kennelReservationTable.getSelectionModel()
        .getSelectedIndex();
    if (currentIndex != -1)
    {
      KennelReservation selectedReservation = kennelReservationTable.getSelectionModel()
          .getSelectedItem();

      String name = nameFieldReservation.getText();
      String phone = phoneFieldReservation.getText();
      String email = emailFieldReservation.getText();
      Customer customer = new Customer(name, phone, email);
      selectedReservation.setCustomer(customer);

      String petName = petNameFieldReservation.getText();
      String species = newPetSpeciesComboBox2.getValue();
      String gender = genderFieldReservation.getText();
      String color = colorFieldReservation.getText();
      ;
      String comment = commentsFieldReservation.getText();

      String ageText = ageFieldReservation.getText();
      String priceText = priceFieldReservation.getText();
      try
      {
        int age = Integer.parseInt(ageText);
        double price = Double.parseDouble(priceText);
        if (age < 0)
        {
          Alert alert = new Alert(Alert.AlertType.WARNING);
          alert.setTitle("Invalid Age");
          alert.setHeaderText(null);
          alert.setContentText("Cannot be negative.");
          alert.showAndWait();
          return;
        }

        if (price < 0)
        {
          Alert alert = new Alert(Alert.AlertType.WARNING);
          alert.setTitle("Invalid Price");
          alert.setHeaderText(null);
          alert.setContentText("Cannot be negative.");
          alert.showAndWait();
          return;
        }

        switch(species)
        {
          case "Dog":
            Dog newDog = new Dog(species, age, gender, color, name, comment,
                price, "Always same breed", "Always same breeder");
            selectedReservation.setPet(newDog);
            break;
          case "Cat":
            Cat newCat = new Cat(species, age, gender, color, name, comment,
                price, "Always same breed", "Always same breeder");
            selectedReservation.setPet(newCat);
            break;
          case "Bird":
            Bird newBird = new Bird(species, age, gender, color, name, comment,
                price, "Same food");
            selectedReservation.setPet(newBird);
            break;
          case "Rodent":
            Rodent newRodent = new Rodent(species, age, gender, color, name,
                comment, price, true);
            selectedReservation.setPet(newRodent);
            break;
          case "Fish":
            Fish newFish = new Fish(species, age, gender, color, name, comment,
                price, true, true);
            selectedReservation.setPet(newFish);
            break;
          case "Various":
            Various newVarious = new Various(species, age, gender, color, name,
                comment, price);
            selectedReservation.setPet(newVarious);
            break;
          default:
            break;
        }
      }
      catch (NumberFormatException e)
      {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Invalid Format");
        alert.setHeaderText(null);
        alert.setContentText("Please enter a valid number(non-negative)");
        alert.showAndWait();
      }
      modelManager.updateKennelReservation(currentIndex, selectedReservation);
      setCloseButton();
      updateButton2.setVisible(false);
      editButton2.setVisible(true);
      updateKennelBox();
      updateCustomerBox();
    }
  }

  public void removeReservation() throws ParserException
  {
    if (modelManager != null)
    {
      int currentIndex = kennelReservationTable.getSelectionModel()
          .getSelectedIndex();
      if (currentIndex >= 0)
      {
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Remove Reservation");
        confirmationAlert.setHeaderText(
            "Are you sure you want to remove this reservation?");
        confirmationAlert.setContentText("This action cannot be undone.");

        ButtonType result = confirmationAlert.showAndWait()
            .orElse(ButtonType.CANCEL);

        if (result == ButtonType.OK)
        {
          KennelReservation selectedReservation = kennelReservationTable.getItems()
              .remove(currentIndex);
          Pet reservationPet = selectedReservation.getPet();
          Customer reservationCustomer = selectedReservation.getCustomer();
          if (selectedReservation != null)
          {
            KennelReservationList allReservations = modelManager.readKennelReservations();
            PetList allPets = modelManager.readPets();
            CustomerList allCustomers = modelManager.readCustomers();
            allReservations.removeReservation(selectedReservation);
            allPets.removePet(reservationPet);
            allCustomers.removeCustomer(reservationCustomer);
            modelManager.saveKennelReservationList(allReservations);
            modelManager.savePetList(allPets);
            modelManager.saveCustomerList(allCustomers);
            reservationDataDisplay.setVisible(false);
            System.out.println("Reservation removed.");
          }
        }
      }
      else
      {
        System.out.println("No reservation selected for removal.");
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

    Pet pet = null;
    switch(species)
    {
      case "Dog":
        pet = new Dog(species, age, gender, color, name, comments,
            price, "Always same breed", "Always same breeder");
        break;
      case "Cat":
        pet = new Cat(species, age, gender, color, name, comments,
            price, "Always same breed", "Always same breeder");
        break;
      case "Bird":
        pet = new Bird(species, age, gender, color, name, comments,
            price, "Same food");
        break;
      case "Rodent":
        pet = new Rodent(species, age, gender, color, name,
            comments, price, true);
        break;
      case "Fish":
        pet = new Fish(species, age, gender, color, name, comments,
            price, true, true);
        break;
      case "Various":
        pet = new Various(species, age, gender, color, name,
            comments, price);
        break;
      default:
        break;
    }

    boolean petExists = false;

    for (int i = 0; i < allPets.getNumberOfPets(); i++)
    {
      Pet existingPet = allPets.getPet(i);
      if (pet.equals(existingPet))
      {
        petExists = true;
        break;
      }
    }
    if (!petExists)
    {
      modelManager.addPet(pet);
      updateKennelBox();
      updateSaleBox();
      updatePetBox();
    }
    else
    {
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Duplicate Pet");
      alert.setHeaderText(null);
      alert.setContentText("This pet already exists in the system.");
      alert.showAndWait();
      System.out.println("Pet already exists");

    }
    reservationNewPetName.clear();
    reservationNewPetSpecies.clear();
    reservationNewPetAge.clear();
    reservationNewPetGender.clear();
    reservationNewPetComments.clear();
    reservationNewPetColor.clear();
    reservationNewPetPrice.clear();
    reservationNewPetDialog.setVisible(false);
  }

  public void addReservation() throws ParserException
  {

    KennelReservationList allReservations = modelManager.readKennelReservations();
    if (allReservations.getAllNumberOfKennelReservations() >= 10)
    {
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Capacity Full");
      alert.setHeaderText(null);
      alert.setContentText("No more kennel reservations can make.");
      alert.showAndWait();
    }
    else
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
          allPets.getPet(i).setPrice(0);
          reservationPet = allPets.getPet(i);
        }
      }
      modelManager.savePetList(allPets);
      updatePetBox();

      String priceText = reservationFieldPrice.getText();
      double kennelPrice = 0.0;
      if (priceText != null && !priceText.isEmpty())
      {
        try
        {
          kennelPrice = Double.parseDouble(priceText);
          if (kennelPrice < 0)
          {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Price");
            alert.setHeaderText(null);
            alert.setContentText("Cannot be negative.");
            alert.showAndWait();
            return;
          }
        }
        catch (NumberFormatException e)
        {
          Alert alert = new Alert(Alert.AlertType.WARNING);
          alert.setTitle("Invalid Price");
          alert.setHeaderText(null);
          alert.setContentText("Cannot be negative.");
          alert.showAndWait();
          return;
        }
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
    if (customerTab.isSelected())
    {
      customerDataDisplay.setVisible(false);
    }
    else if (kennelReservationTab.isSelected())
    {
      reservationDataDisplay.setVisible(false);
    }
    else if (petTab.isSelected())
    {
      petDataDisplay.setVisible(false);
    }
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
