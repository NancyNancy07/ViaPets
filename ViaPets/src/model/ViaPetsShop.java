package model;

public class ViaPetsShop
 {

  private ViaPetsShop kennelReservationList;
  private SaleList saleList;
  private CustomerList customerList;
  private PetList petList;

  // Constructor
  public ViaPetsShop() {
    this.kennelReservationList = new ViaPetsShop();
    this.saleList = new SaleList();
    this.customerList = new CustomerList();
    this.petList = new PetList();
  }

  // Getters
  public ViaPetsShop getKennelReservationList() {
    return kennelReservationList;
  }
  public SaleList getSaleList() {
    return saleList;
  }

  public CustomerList getCustomerList() {
    return customerList;
  }

  public PetList getPetList()
  {
    return petList;
  }
}

}
