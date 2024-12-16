package model;

import java.util.Objects;

public class KennelReservation
{
  private double price;
  private Pet pet;
  private Customer customer;
  private MyDate startDate, endDate;

  // Constructor
  public KennelReservation(double price, Pet pet, Customer customer,
      MyDate startDate, MyDate endDate)
  {
    this.price = price;
    this.pet = pet;
    this.customer = customer;
    this.startDate = startDate.copy();
    this.endDate = endDate.copy();
  }

  // Getters and Setters
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

  public MyDate getStartDate()
  {
    return startDate;
  }

  public MyDate getEndDate()
  {
    return endDate;
  }

  public void setStartDate(MyDate startDate)
  {
    this.startDate = startDate;
  }

  public void setEndDate(MyDate endDate)
  {
    this.endDate = endDate;
  }

  public String toString()
  {
    return "KennelReservation: \nPrice: " + price + "\n" + pet + "\n" + customer
        + "\nStart Date: " + startDate + ", End Date: " + endDate;
  }

  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }

    KennelReservation other = (KennelReservation) obj;

    return price == other.price && pet.equals(other.pet) && customer.equals(
        other.customer);
  }
}

