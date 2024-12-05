package model;

public class ViaPetsShop
{
  private CustomerList customerList;
  private PetList petList;
  private SaleList saleList;
  private KennelReservationList kennelReservationList;

  public ViaPetsShop()
  {
    customerList = new CustomerList();
    petList = new PetList();
    saleList = new SaleList();
    kennelReservationList = new KennelReservationList(10);
  }

  public CustomerList getCustomerList()
  {
    return customerList;
  }

  public PetList getPetList()
  {
    return petList;
  }

  public KennelReservationList getKennelReservationList()
  {
    return kennelReservationList;
  }

  public SaleList getSaleList()
  {
    return saleList;
  }
}
