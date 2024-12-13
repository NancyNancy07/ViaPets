package model;

import java.util.Objects;

public class KennelReservation
{
  private double price;
  private Pet pet;
  private Customer customer;
  private MyDate startDate, endDate;

  // Constructor
  /**
   * Five-argument constructor initializing the price, pet, customer, start date and end date of the kennel reservation
   * @param price the price of the kennel reservation
   * @param pet the pet that is reserved
   * @param customer the customer who reserved the pet
   * @param startDate the start date of the reservation
   * @param endDate the end date of the reservation
   */
  public KennelReservation(double price, Pet pet, Customer customer, MyDate startDate, MyDate endDate)
  {
    this.price = price;
    this.pet = pet;
    this.customer = customer;
    this.startDate = startDate.copy();
    this.endDate = endDate.copy();
  }

  // Getters and Setters
  /**
   * Getter for the price of the kennel reservation
   * @return the price of the kennel reservation
   */
  public double getPrice()
  {
    return price;
  }

  /**
   * Setter for the price of the kennel reservation
   * @param price the price of the kennel reservation
   */
  public void setPrice(double price)
  {
    this.price = price;
  }

  /**
   * Getter for the pet of the kennel reservation
   * @return the pet of the kennel reservation
   */
  public Pet getPet()
  {
    return pet;
  }

  /**
   * Setter for the pet of the kennel reservation
   * @param pet the pet of the kennel reservation
   */
  public void setPet(Pet pet)
  {
    this.pet = pet;
  }

  /**
   * Getter for the customer of the kennel reservation
   * @return the customer of the kennel reservation
   */
  public Customer getCustomer()
  {
    return customer;
  }

  /**
   * Setter for the customer of the kennel reservation
   * @param customer the customer of the kennel reservation
   */
  public void setCustomer(Customer customer)
  {
    this.customer = customer;
  }

  /**
   * Getter for the start date of the kennel reservation
   * @return the start date of the kennel reservation
   */
  public MyDate getStartDate()
  {
    return startDate;
  }

  /**
   * Getter for the end date of the kennel reservation
   * @return the end date of the kennel reservation
   */
  public MyDate getEndDate()
  {
    return endDate;
  }

  /**
   * Setter for the start date of the kennel reservation
   * @param startDate the start date of the kennel reservation
   */
  public void setStartDate(MyDate startDate)
  {
    this.startDate = startDate;
  }

  /**
   * Setter for the end date of the kennel reservation
   * @param endDate the end date of the kennel reservation
   */
  public void setEndDate(MyDate endDate)
  {
    this.endDate = endDate;
  }

  /**
   * To String method for the KennelReservation class
   * @return a string representation of the sale
   */
  public String toString()
  {
    return "KennelReservation{" + "price=" + price + ", pet=" + pet
        + ", customer=" + customer + '}' + "Start Date: " + startDate + "End Date: " + endDate;
  }

  /**
   * Compares the kennel reservation to another object
   * @param obj the object to compare to
   * @return true if the object is equal to the kennel reservation, false if it is not
   */
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

