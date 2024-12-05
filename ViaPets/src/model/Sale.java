package model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sale
{
  private double finalPrice;
  private Customer customer;
  private Pet pet;
  private Date date;
  private String time;

  public Sale(double finalPrice, Customer customer, Pet pet, Date date)
  {
    this.finalPrice = finalPrice;
    this.customer = customer;
    this.pet = pet;
    this.date = date.copy();

    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    this.time = now.format(formatter);
  }

  public double getFinalPrice()
  {
    return finalPrice;
  }

  public void setFinalPrice(double finalPrice)
  {
    this.finalPrice = finalPrice;
  }

  public String getTime()
  {
    return time;
  }

  public void setTime(String time)
  {
    this.time = time;
  }

  public String toString()
  {
    return "Final Price: " + finalPrice + "\nCustomer: " + customer + "\nPet: " + pet + "\nDate: " + date + "\nTime: " + time;
  }

  public boolean equals(Object obj)
  {
    if(obj == null || obj.getClass() != getClass())
    {
      return false;
    }
    Sale tempSale = (Sale)obj;
    return finalPrice == tempSale.finalPrice && customer.equals(tempSale.customer) && pet.equals(tempSale.pet) && date.equals(tempSale.date) && time.equals(tempSale.time);
  }
}
