package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.*;
import parser.ParserException;

import javax.xml.parsers.ParserConfigurationException;

public class ViaPetsController
{

  @FXML private Tab petTab;
  @FXML private Tab kennelReservationTab;
  @FXML private Tab saleTab;
  @FXML private Tab customerTab;
  @FXML private TableView<Customer> customerTable;
  @FXML private TableColumn<Customer, String> customerName;
  @FXML private TableColumn<Customer, String> customerPhone;
  @FXML private TableColumn<Customer, String> customerEmail;
  @FXML private TableView<Pet> petTable;
  @FXML private TableColumn<Pet, String> petName;
  @FXML private TableColumn<Pet, String> petSpecies;
  @FXML private TableColumn<Pet, String> petAge;
  @FXML private TableColumn<Pet, String> petGender;
  @FXML private TableColumn<Pet, String> petColor;
  @FXML private TableColumn<Pet, String> petComments;
  @FXML private TableColumn<Pet, String> petPrice;
  @FXML private Pane customerDataDisplay;
  @FXML private TextArea customerTextArea;
  @FXML private Button closeButton;
  @FXML private Button editButton;
  @FXML private Button removeButton;
  @FXML private Button updateButton;
  @FXML private TextField nameField;
  @FXML private TextField phoneField;
  @FXML private TextField emailField;

  private ViaPetsModelManager modelManager;
  private ViaPetsShop viaPetsShop;

  public void initialize() throws ParserException
  {
    viaPetsShop = new ViaPetsShop();
    modelManager = new ViaPetsModelManager("customers.xml", "pets.xml",
        "sales.bin", "kennelReservation.bin");
    updatePetBox();
    customerDataDisplay.setVisible(false);

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

  public void setCloseButton()
  {
    customerDataDisplay.setVisible(false);
  }

  public void editData() throws ParserException
  {
    if (editButton.getText().equals("Edit"))
    {
      nameField.setEditable(true);
      phoneField.setEditable(true);
      emailField.setEditable(true);
      editButton.setText("Update");
    }
    else if (editButton.getText().equals("Update"))
    {
      int currentIndex = customerTable.getSelectionModel().getSelectedIndex();
      if(currentIndex!=-1){
        Customer selectedCustomer = customerTable.getSelectionModel().getSelectedItem();
        selectedCustomer.setName(nameField.getText());
        selectedCustomer.setPhoneNumber(phoneField.getText());
        selectedCustomer.setEmailAddress(emailField.getText());

        modelManager.updateCustomer(currentIndex,selectedCustomer);
      }
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

  public void removeCustomer() throws ParserException
  {
    if (viaPetsShop != null && modelManager != null)
    {
      int currentIndex = customerTable.getSelectionModel().getSelectedIndex();
      System.out.println(currentIndex);
      if (currentIndex != -1)
      {
        customerTable.getItems().remove(currentIndex);
        modelManager.removeCustomer(currentIndex);
        customerDataDisplay.setVisible(false);

      }
    }
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
              //              showCustomerData(newC);
            }
          });
    }

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
  }
}