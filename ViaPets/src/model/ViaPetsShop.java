package model;

public class ViaPetsShop
 {

  private KennelReservationList kennelReservationList;
  private SaleList saleList;
  private CustomerList customerList;
  private PetList petList;

  // Constructor
  public ViaPetsShop() {
    this.kennelReservationList = new KennelReservationList(10);
    this.saleList = new SaleList();
    this.customerList = new CustomerList();
    this.petList = new PetList();
  }

  // Getters
  public KennelReservationList getKennelReservationList() {
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

   public void setKennelReservationList(KennelReservationList kennelReservationList)
   {
     this.kennelReservationList = kennelReservationList;
   }

   public void setCustomerList(CustomerList customerList)
   {
     this.customerList = customerList;
   }

   public void setSaleList(SaleList saleList)
   {
     this.saleList = saleList;
   }

   public void setPetList(PetList petList)
   {
     this.petList = petList;
   }
 }

