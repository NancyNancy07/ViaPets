package model;

public class ViaPetsShop
 {

  private KennelReservationList kennelReservationList;
  private SaleList saleList;
  private CustomerList customerList;
  private PetList petList;

  // Constructor

   /**
    * Constructor initializing the ViaPetsShop
    */
  public ViaPetsShop() {
    this.kennelReservationList = new KennelReservationList(10);
    this.saleList = new SaleList();
    this.customerList = new CustomerList();
    this.petList = new PetList();
  }

  //Getters
   /**
    * Getter for the kennel reservation list
    * @return the kennel reservation list
    */
  public KennelReservationList getKennelReservationList() {
    return kennelReservationList;
  }

   /**
    * Getter for the sale list
    * @return the sale list
    */
  public SaleList getSaleList() {
    return saleList;
  }

    /**
      * Getter for the customer list
      * @return the customer list
      */
  public CustomerList getCustomerList() {
    return customerList;
  }

    /**
      * Getter for the pet list
      * @return the pet list
      */
  public PetList getPetList()
  {
    return petList;
  }

  // Setters
    /**
      * Setter for the kennel reservation list
      * @param kennelReservationList the kennel reservation list
      */
   public void setKennelReservationList(KennelReservationList kennelReservationList)
   {
     this.kennelReservationList = kennelReservationList;
   }

    /**
      * Setter for the customer list
      * @param customerList the customer list
      */
   public void setCustomerList(CustomerList customerList)
   {
     this.customerList = customerList;
   }

    /**
      * Setter for the sale list
      * @param saleList the sale list
      */
   public void setSaleList(SaleList saleList)
   {
     this.saleList = saleList;
   }

    /**
      * Setter for the pet list
      * @param petList the pet list
      */
   public void setPetList(PetList petList)
   {
     this.petList = petList;
   }
 }

