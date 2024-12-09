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
  @FXML private TextField nameField;
  @FXML private TextField phoneField;
  @FXML private TextField emailField;

  private ViaPetsModelManager modelManager;
  private ViaPetsShop viaPetsShop;

  public void initialize()
  {
    viaPetsShop = new ViaPetsShop();
    modelManager = new ViaPetsModelManager("customers.xml", "pets.bin",
        "sales.bin", "kennelReservation.bin");
    //    updateCustomerBox();
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

  public void editData()
  {
    nameField.setEditable(true);
    phoneField.setEditable(true);
    emailField.setEditable(true);
    editButton.setText("Update");

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

      }
    }
  }

  public void updatePetBox()
  {
    if (modelManager != null)
    {
      System.out.println("pet is here");
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