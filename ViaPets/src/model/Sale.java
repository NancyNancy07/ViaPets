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
    // We check if the object is null or of a different class
    if (obj == null || obj.getClass() != getClass()) // O(1) + O(1)
    {
      return false; // O(1)
    }

    // We cast the object to Sale after making sure it is a Sale
    Sale tempSale = (Sale) obj; // O(1)

    // We compare all fields of Sale
    return finalPrice == tempSale.finalPrice // O(1)
        && customer.equals(tempSale.customer) // O(3), where 3 = three string comparisons in customer.equals()
        && pet.equals(tempSale.pet) // O(7), where 7 = six string comparisons and one numeric comparison in pet.equals()
        && date.equals(tempSale.date) // O(3), where 3 = three numeric comparisons in date.equals()
        && time.equals(tempSale.time); // O(1), for string equals

    /*
    Complexity Analysis:
    We do a null check and class check -> O(1).
    We are casting the object -> O(1).
    Comparing all fields of Sale:
        - `finalPrice == tempSale.finalPrice`: O(1).
        - `customer.equals(tempSale.customer)`: O(3).
        - `pet.equals(tempSale.pet)`: O(7).
        - `date.equals(tempSale.date)`: O(1).
        - `time.equals(tempSale.time)`: O(1).

    Dominating Term Analysis:
    - The dominating term is the pet comparison with O(7).

    Time Complexity:
    - T(n) = O(1) + O(1) + O(3) + O(7) + O(1) + O(1).
    - Simplifying: O(7).
     */
  }

}
