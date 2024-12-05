package model;

public class KennelReservation
{
  private Customer customer;
  private Pet pet;
  private Date startDate, endDate;
  private double price;

  public KennelReservation(Customer customer, Pet pet, Date startDate, Date endDate, double price)
  {
    this.customer = customer;
    this.pet = pet;
    this.startDate = startDate.copy();
    this.endDate = endDate.copy();
    this.price = price;
  }

  public double getPrice()
  {
    return price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

  public Pet getPet()
  {
    return pet;
  }

  public void setPet(Pet pet)
  {
    this.pet = pet;
  }

  public Customer getCustomer()
  {
    return customer;
  }

  public void setCustomer(Customer customer)
  {
    this.customer = customer;
  }

  public Date getStartDate()
  {
    return startDate;
  }

  public void setStartDate(Date startDate)
  {
    this.startDate = startDate;
  }

  public Date getEndDate()
  {
    return endDate;
  }

  public void setEndDate(Date endDate)
  {
    this.endDate = endDate;
  }

  public String toString()
  {
    return "Customer: " + customer + "\nPet: " + pet + "\nStart Date: " + startDate + "\nEnd Date: " + endDate + "\nPrice: " + price;
  }

  public boolean equals(Object obj)
  {
    if(obj == null || obj.getClass() != getClass())
    {
      return false;
    }
    KennelReservation tempKennelReservation = (KennelReservation)obj;
    return customer.equals(tempKennelReservation.customer) && pet.equals(tempKennelReservation.pet) && startDate.equals(tempKennelReservation.startDate) && endDate.equals(tempKennelReservation.endDate) && price == tempKennelReservation.price;
  }
}
