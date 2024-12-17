package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A class containing of Sale object.
 * @author Bence Antal Orbán
 * @version 1.0
 */
public class Sale
{
  private double finalPrice;
  private Customer customer;
  private Pet pet;
  private MyDate date;
  private String time;

  //Constructor
  /**
   * Constructs a new Sale object with specified details including the final price, customer, pet and date.
   * @param finalPrice the final price of the sale
   * @param customer the customer object
   * @param pet the pet object
   * @param date the date of the sale
   */
  public Sale(double finalPrice, Customer customer, Pet pet, MyDate date)
  {
    this.finalPrice = finalPrice;
    this.customer = customer;
    this.pet = pet;
    this.date = date.copy();

    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    this.time = now.format(formatter);
  }

  // Getters and Setters
  /**
   * Gets the final price of the sale.
   * @return the final price of the sale
   */
  public double getFinalPrice()
  {
    return finalPrice;
  }

  /**
   * Sets the final price of the sale.
   * @param finalPrice the final price of the sale
   */
  public void setFinalPrice(double finalPrice)
  {
    if (finalPrice < 0)
    {
      throw new IllegalArgumentException("Price cannot be negative");
    }
    this.finalPrice = finalPrice;
  }

  /**
   * Gets the time of the sale.
   * @return the time of the sale
   */
  public String getTime()
  {
    return time;
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
   * Gets the pet object.
   * @return the pet object
   */
  public Pet getPet()
  {
    return pet;
  }

  /**
   * Gets the date of the sale.
   * @return the date of the sale
   */
  public MyDate getDate()
  {
    return date;
  }

  /**
   * Sets the time of the sale.
   * @param time the customer object
   */
  public void setTime(String time)
  {
    this.time = time;
  }

  /**
   *
   * Returns a string representation of the Sale object.
   * @return a string representation of the Sale object
   * */
  public String toString()
  {
    return "Final Price: " + finalPrice + "\n" + customer + "\n" + pet
        + "\nDate: " + date + "\nTime: " + time + "\n";
  }

  /**
   * Compares the Sale object to another object
   * @param obj the object to compare to
   * @return true if the object is equal to the CustomerList
   */
  public boolean equals(Object obj)
  {
    if (obj == null || obj.getClass() != getClass())
    {
      return false;
    }
    Sale tempSale = (Sale) obj;
    return finalPrice == tempSale.finalPrice && customer.equals(
        tempSale.customer) && pet.equals(tempSale.pet) && date.equals(
        tempSale.date) && time.equals(tempSale.time);
  }
}
