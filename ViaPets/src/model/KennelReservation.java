package model;

import java.util.Objects;

/**
 * A class containing of KennelReservation object.
 * @author Harshit Sharma
 * @version 1.0
 */
public class KennelReservation
{
  private double price;
  private Pet pet;
  private Customer customer;
  private MyDate startDate, endDate;

  // Constructor
  /**
   * Constructs a new KennelReservation object with specified details including the price, pet, customer, start date and end date.
   * @param price the price of the reservation
   * @param pet the pet object
   * @param customer the customer object
   * @param startDate the start date of the reservation
   * @param endDate the end date of the reservation
   */
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
  /**
   * Gets the price of the reservation.
   * @return the price of the reservation
   */
  public double getPrice()
  {
    return price;
  }

  /**
   * Sets the price of the reservation.
   * @param price the price of the reservation
   */
  public void setPrice(double price)
  {
    if (price < 0)
    {
      throw new IllegalArgumentException("Price cannot be negative");
    }
    this.price = price;
  }

  /**
   * Gets the pet object.
   * @return the pet object
   */
  public Pet getPet()
  {
    return pet;
  }

  /**
   * Sets the pet object.
   * @param pet the pet object
   */
  public void setPet(Pet pet)
  {

    if (pet != null)
    {
      this.pet = pet;
    }
  }

  /**
   * Gets the customer object.
   * @return the customer object
   */
  public Customer getCustomer()
  {
    return customer;
  }

  /**
   * Sets the customer object.
   * @param customer the customer object
   */
  public void setCustomer(Customer customer)
  {
    if (customer != null)
    {
      this.customer = customer;
    }
  }

  /**
   * Gets the start date of the reservation.
   * @return the start date of the reservation
   */
  public MyDate getStartDate()
  {
    return startDate;
  }

  /**
   * Gets the end date of the reservation.
   * @return the end date of the reservation
   */
  public MyDate getEndDate()
  {
    return endDate;
  }

  /**
   * Returns a string representation of the KennelReservation object.
   * @return a string representation of the KennelReservation object
   */
  public String toString()
  {
    return "KennelReservation: \nPrice: " + price + "\n" + pet + "\n" + customer
        + "\nStart Date: " + startDate + ", End Date: " + endDate;
  }

  /**
   * Compares the KennelReservation object with another object for equality.
   * @param obj the object to compare with
   * @return true if the objects are equal, false if they are not
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

