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
  @FXML private TableColumn<Pet, String> petSpecificInfo;
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
  @FXML private HBox newSpecificBox;
  @FXML private HBox newSpecificBox2;
  @FXML private TextField newSpecificField;
  @FXML private TextField newSpecificField2;
  @FXML private Label newSpecificLabel1;
  @FXML private Label newSpecificLabel2;
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
  @FXML private HBox newSpecificBoxReservation;
  @FXML private HBox newSpecificBox2Reservation;
  @FXML private TextField newSpecificFieldReservation;
  @FXML private TextField newSpecificField2Reservation;
  @FXML private Label newSpecificLabel1Reservation;
  @FXML private Label newSpecificLabel2Reservation;

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
    customerDataDisplay.setVisible(false);
    petDataDisplay.setVisible(false);
    reservationDataDisplay.setVisible(false);
    updateButton.setVisible(false);
    updatePetButton.setVisible(false);
    updateButton2.setVisible(false);
    petSpecies();
    selectedSpecies();

    petTable.setRowFactory(tv -> new TableRow<Pet>()
    {
      @Override protected void updateItem(Pet item, boolean empty)
      {
        super.updateItem(item, empty);
        if (item != null && item.getPrice() == 0)
          setStyle("-fx-background-color: #baffba;");

        else
          setStyle("");
      }
    });
    //    petTable.setRowFactory(tableView -> {
    //      TableRow<Pet> row = new TableRow<>();
    //
    //      row.itemProperty().addListener((observable, oldValue, newValue) -> {
    //        if (newValue == null || row.isEmpty())
    //        {
    //          row.setStyle("");
    //        }
    //        else
    //        {
    //          if (isPetReserved(newValue))
    //          {
    //            row.setStyle("-fx-background-color: lightgreen;");
    //          }
    //          else
    //          {
    //            row.setStyle("");
    //          }
    //        }
    //      });
    //
    //      return row;
    //    });

    updatePetBox();

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

  private boolean isPetReserved(Pet pet)
  {
    try
    {
      KennelReservationList allReservations = modelManager.readKennelReservations();
      for (int i = 0;
           i < allReservations.getAllNumberOfKennelReservations(); i++)
      {
        Pet reservedPet = null;
        KennelReservation reservation = allReservations.getKennelReservation(i);
        if (reservation != null)
        {
          reservedPet = reservation.getPet();
        }
        if (reservedPet != null && pet.equals(reservedPet))
        {
          return true;
        }
      }
    }
    catch (ParserException e)
    {
      e.printStackTrace();
    }
    return false;
  }

  public void updatePetBox() throws ParserException
  {
    if (modelManager != null)
    {
      PetList allPets = modelManager.readPets();

      petTable.getItems().clear();
      petTable.setStyle("-fx-background-color: lightblue;");

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
      petSpecificInfo.setCellValueFactory(data -> {
        Pet pet = data.getValue();
        String specificInfo = "";

        if (pet instanceof Dog)
        {
          specificInfo = "Breed: " + ((Dog) pet).getBreed() + ", Breeder: "
              + ((Dog) pet).getBreeder();
        }
        else if (pet instanceof Cat)
        {
          specificInfo = "Breed: " + ((Cat) pet).getBreed() + ", Breeder: "
              + ((Cat) pet).getBreeder();
        }
        else if (pet instanceof Bird)
        {
          specificInfo = "Preferred Food: " + ((Bird) pet).getPreferredFood();
        }
        else if (pet instanceof Fish)
        {
          specificInfo =
              "Predator: " + (((Fish) pet).isPredator() ? "Yes" : "No")
                  + ", Fresh Water: " + (((Fish) pet).isFreshWater() ?
                  "Yes" :
                  "No");
          ;
        }
        else if (pet instanceof Rodent)
        {
          specificInfo =
              "Aggressive: " + (((Rodent) pet).isAggressive() ? "Yes" : "No");
        }
        else if (pet instanceof Various)
        {
          specificInfo = "-";
        }
        return new SimpleStringProperty(specificInfo);
      });

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
    specialInfo.setVisible(false);
    specialInfo2.setVisible(false);
    specialLabel.setText("");
    specialLabel2.setText("");
    specialField.setText("");
    specialField2.setText("");

    if (selectedPet != null && petTab.isSelected())
    {
      petDataDisplay.setVisible(true);

      if (selectedPet instanceof Dog)
      {
        specialInfo.setVisible(true);
        specialInfo2.setVisible(true);
        specialLabel.setText("Breed:");
        specialLabel2.setText("Breeder:");
        specialField.setText(((Dog) selectedPet).getBreed());
        specialField2.setText(((Dog) selectedPet).getBreeder());
      }
      else if (selectedPet instanceof Cat)
      {
        specialInfo.setVisible(true);
        specialInfo2.setVisible(true);
        specialLabel.setText("Breed:");
        specialLabel2.setText("Breeder:");
        specialField.setText(((Cat) selectedPet).getBreed());
        specialField2.setText(((Cat) selectedPet).getBreeder());
      }
      else if (selectedPet instanceof Bird)
      {
        specialInfo.setVisible(true);
        specialLabel.setText("Preferred Food:");
        specialField.setText(((Bird) selectedPet).getPreferredFood());
      }
      else if (selectedPet instanceof Fish)
      {
        specialInfo.setVisible(true);
        specialInfo2.setVisible(true);
        specialLabel.setText("Is Fresh Water:");
        specialField.setText(
            ((Fish) selectedPet).isFreshWater() ? "Yes" : "No");

        specialLabel2.setText("Is Predator:");
        specialField2.setText(((Fish) selectedPet).isPredator() ? "Yes" : "No");
      }
      else if (selectedPet instanceof Rodent)
      {
        specialInfo.setVisible(true);
        specialLabel.setText("Is Aggressive:");
        specialField.setText(
            ((Rodent) selectedPet).isAggressive() ? "Yes" : "No");
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
    specialField.setDisable(true);
    specialField2.setDisable(true);
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

      speciesField.setDisable(false);
      genderField.setDisable(false);
      colorField.setDisable(false);
      specialField.setDisable(false);
      specialField2.setDisable(false);
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

  public void selectedSpecies()
  {
    if (petTab.isSelected())
    {
      newSpecificBox.setVisible(false);
      newSpecificBox2.setVisible(false);

      String species = newPetSpeciesComboBox.getValue();

      if (species != null && species.equals("Dog"))
      {
        newSpecificBox.setVisible(true);
        newSpecificBox2.setVisible(true);
      }

      newPetSpeciesComboBox.valueProperty()
          .addListener((observable, oldValue, newValue) -> {
            if (newValue != null && newValue.equals("Dog"))
            {
              newSpecificBox.setVisible(true);
              newSpecificBox2.setVisible(true);
            }
            else if (newValue != null && newValue.equals("Cat"))
            {
              newSpecificBox.setVisible(true);
              newSpecificBox2.setVisible(true);
            }
            else if (newValue != null && newValue.equals("Bird"))
            {
              newSpecificBox.setVisible(true);
              newSpecificBox2.setVisible(false);

              newSpecificLabel1.setText("Preferred Food:");
            }
            else if (newValue != null && newValue.equals("Rodent"))
            {
              newSpecificBox.setVisible(true);
              newSpecificBox2.setVisible(false);

              newSpecificLabel1.setText("Aggressive:");
            }
            else if (newValue != null && newValue.equals("Fish"))
            {
              newSpecificBox.setVisible(true);
              newSpecificBox2.setVisible(true);
              newSpecificLabel1.setText("Predator:");
              newSpecificLabel2.setText("Fresh Water:");
            }
            else
            {
              // Hide the breed and breeder fields for any other species
              newSpecificBox.setVisible(false);
              newSpecificBox2.setVisible(false);
            }
          });
    }
    if (kennelReservationTab.isSelected())
    {
      newSpecificBoxReservation.setVisible(false);
      newSpecificBox2Reservation.setVisible(false);

      String species = newPetSpeciesComboBox2.getValue();

      if (species != null && species.equals("Dog"))
      {
        newSpecificBoxReservation.setVisible(true);
        newSpecificBox2Reservation.setVisible(true);
      }

      newPetSpeciesComboBox2.valueProperty()
          .addListener((observable, oldValue, newValue) -> {
            if (newValue != null && newValue.equals("Dog"))
            {
              newSpecificBoxReservation.setVisible(true);
              newSpecificBox2Reservation.setVisible(true);
            }
            else if (newValue != null && newValue.equals("Cat"))
            {
              newSpecificBoxReservation.setVisible(true);
              newSpecificBox2Reservation.setVisible(true);
            }
            else if (newValue != null && newValue.equals("Bird"))
            {
              newSpecificBoxReservation.setVisible(true);
              newSpecificBox2Reservation.setVisible(false);

              newSpecificLabel1Reservation.setText("Preferred Food:");
            }
            else if (newValue != null && newValue.equals("Rodent"))
            {
              newSpecificBoxReservation.setVisible(true);
              newSpecificBox2Reservation.setVisible(false);

              newSpecificLabel1Reservation.setText("Aggressive:");
            }
            else if (newValue != null && newValue.equals("Fish"))
            {
              newSpecificBoxReservation.setVisible(true);
              newSpecificBox2Reservation.setVisible(true);
              newSpecificLabel1Reservation.setText("Predator:");
              newSpecificLabel2Reservation.setText("Fresh Water:");
            }
            else
            {
              newSpecificBoxReservation.setVisible(false);
              newSpecificBox2Reservation.setVisible(false);
            }
          });
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
    String specificField = newSpecificField.getText();
    String specificField2 = newSpecificField2.getText();
    if (name.isEmpty() || species.isEmpty() || ageText.isEmpty()
        || gender.isEmpty() || color.isEmpty() || priceText.isEmpty()
        || comment.isEmpty() || (
        species.equals("Dog") || species.equals("Cat") || (species.equals(
            "Fish")) ?
            (specificField.isEmpty() || specificField2.isEmpty()) :
            specificField.isEmpty()))
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

        Pet newPet = null;

        switch (species)
        {
          case "Dog":
            newPet = new Dog(species, age, gender, color, name, comment, price,
                specificField, specificField2);
            break;
          case "Cat":
            newPet = new Cat(species, age, gender, color, name, comment, price,
                specificField, specificField2);
            break;
          case "Bird":
            newPet = new Bird(species, age, gender, color, name, comment, price,
                specificField);
            break;
          case "Fish":
            boolean fresh = Boolean.getBoolean(specificField);
            boolean predator = Boolean.getBoolean(specificField2);
            newPet = new Fish(species, age, gender, color, name, comment, price,
                fresh, predator);
            break;
          case "Rodent":
            boolean isAggressive = Boolean.getBoolean(specificField);

            newPet = new Rodent(species, age, gender, color, name, comment,
                price, isAggressive);
            break;
          default:
            newPet = new Various(species, age, gender, color, name, comment,
                price);
            break;
        }

        if (newPet != null)
        {
          modelManager.addPet(newPet);
        }
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
      allPets.removePet(salePet);
      modelManager.savePetList(allPets);
      modelManager.addSale(sale);
      updateSaleBox();
      updatePetBox();
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

      reservationPetName.setCellValueFactory(data -> new SimpleStringProperty(
          data.getValue().getPet().toString()));
      reservationCustomerName.setCellValueFactory(
          data -> new SimpleStringProperty(
              data.getValue().getCustomer().toString()));
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
        String name = allCustomers.getCustomer(i).toString();
        reservationCustomerComboBox.getItems().add(name);
      }

      for (int i = 0; i < allPets.getNumberOfPets(); i++)
      {
        String name = allPets.getPet(i).toString();
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

        if (species != null)
        {
          Pet pet = new Pet(species, age, gender, color, petName, comment,
              price);
          selectedReservation.setPet(pet);

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
      genderFieldReservation.setDisable(false);
      colorFieldReservation.setDisable(false);
      commentsFieldReservation.setEditable(false);
      priceFieldReservation.setDisable(false);
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
    String species = newPetSpeciesComboBox2.getValue();
    String ageText = (reservationNewPetAge.getText());
    String gender = reservationNewPetGender.getText();
    String color = reservationNewPetColor.getText();
    String priceText = (reservationNewPetPrice.getText());
    String comments = reservationNewPetComments.getText();
    String specificField = newSpecificFieldReservation.getText();
    String specificField2 = newSpecificField2Reservation.getText();

    if (species == null || species.trim().isEmpty())
    {
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Missing Species");
      alert.setHeaderText(null);
      alert.setContentText("Species is required. Please select a species.");
      alert.showAndWait();
      return;
    }
    if (name.isEmpty() || species.isEmpty() || ageText.isEmpty()
        || gender.isEmpty() || color.isEmpty() || priceText.isEmpty()
        || comments.isEmpty() || (
        species.equals("Dog") || species.equals("Cat") || (species.equals(
            "Fish")) ?
            (specificField.isEmpty() || specificField2.isEmpty()) :
            specificField.isEmpty()))
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

        Pet newPet = null;

        switch (species)
        {
          case "Dog":
            newPet = new Dog(species, age, gender, color, name, comments, price,
                specificField, specificField2);
            break;
          case "Cat":
            newPet = new Cat(species, age, gender, color, name, comments, price,
                specificField, specificField2);
            break;
          case "Bird":
            newPet = new Bird(species, age, gender, color, name, comments,
                price, specificField);
            break;
          case "Fish":
            boolean fresh = Boolean.getBoolean(specificField);
            boolean predator = Boolean.getBoolean(specificField2);
            newPet = new Fish(species, age, gender, color, name, comments,
                price, fresh, predator);
            break;
          case "Rodent":
            boolean isAggressive = Boolean.getBoolean(specificField);

            newPet = new Rodent(species, age, gender, color, name, comments,
                price, isAggressive);
            break;
          default:
            newPet = new Various(species, age, gender, color, name, comments,
                price);
            break;
        }

        boolean petExists = false;

        for (int i = 0; i < allPets.getNumberOfPets(); i++)
        {
          Pet existingPet = allPets.getPet(i);
          if (newPet.equals(existingPet))
          {
            petExists = true;
            break;
          }
        }
        if (!petExists)
        {
          modelManager.addPet(newPet);
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
        reservationNewPetAge.clear();
        reservationNewPetGender.clear();
        reservationNewPetComments.clear();
        reservationNewPetColor.clear();
        reservationNewPetPrice.clear();
        reservationNewPetDialog.setVisible(false);

      }
      catch (NumberFormatException e)
      {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Invalid Input");
        alert.setHeaderText(null);
        alert.setContentText(
            "Please enter valid numeric values for age and price.");
        alert.showAndWait();
      }
    }
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
        if (customerName.equals(allCustomers.getCustomer(i).toString()))
        {
          reservationCustomer = allCustomers.getCustomer(i);
        }
      }
      String petName = reservationPetComboBox.getValue();
      PetList allPets = modelManager.readPets();
      Pet reservationPet = null;
      for (int i = 0; i < allPets.getNumberOfPets(); i++)
      {
        if (petName.equals(allPets.getPet(i).toString()))
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
        updatePetBox();
        reservationFieldPrice.clear();
        startDate.setValue(null);
        endDate.setValue(null);
        System.out.println("reservation added");
      }
    }
  }

  public void setCloseButton() throws ParserException
  {
    if (customerTab.isSelected())
    {
      customerDataDisplay.setVisible(false);
      editButton.setVisible(true);
      updateButton.setVisible(false);
      updateCustomerBox();

    }
    else if (kennelReservationTab.isSelected())
    {
      reservationDataDisplay.setVisible(false);
      genderFieldReservation.setDisable(false);
      colorFieldReservation.setDisable(false);
      commentsFieldReservation.setEditable(false);
      priceFieldReservation.setDisable(false);
      reservationNewCustomerDialog.setVisible(false);
      reservationNewPetDialog.setVisible(false);
      updateKennelBox();
    }
    else if (petTab.isSelected())
    {
      petDataDisplay.setVisible(false);
      speciesField.setDisable(false);
      genderField.setDisable(false);
      colorField.setDisable(false);
      specialField.setDisable(false);
      specialField2.setDisable(false);
      editPetButton.setVisible(true);
      updatePetButton.setVisible(false);
      updatePetBox();
    }
    else if (saleTab.isSelected())
    {
      saleNewCustomerDialog.setVisible(false);
      updateSaleBox();
    }
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
