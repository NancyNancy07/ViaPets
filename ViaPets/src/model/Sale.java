package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sale
{
  private double finalPrice;
  private Customer customer;
  private Pet pet;
  private MyDate date;
  private String time;
  private String customerName;
  private String petName;

  /**
   * Four-argument constructor initializing the final price, customer, pet and date of the sale
   * @param finalPrice the final price of the sale
   * @param customer the customer who bought the pet
   * @param pet the pet that was sold
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

  public Sale(double finalPrice, String customer, String pet, MyDate date)
  {
    this.finalPrice = finalPrice;
    this.date = date.copy();
    this.customerName = customer;
    this.petName = pet;
    this.customer = new Customer();
    this.pet = new Pet();
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    this.time = now.format(formatter);
  }

  /**
   * Getter for the final price of the sale
   * @return the final price of the sale
   */
  public double getFinalPrice()
  {
    return finalPrice;
  }

  /**
   * Setter for the final price of the sale
   * @param finalPrice the final price of the sale
   */
  public void setFinalPrice(double finalPrice)
  {
    this.finalPrice = finalPrice;
  }

  /**
   * Getter for the time of the sale
   * @return the time of the sale
   */
  public String getTime()
  {
    return time;
  }

  /**
   * Getter for the name of the customer
   * @return the name of the customer
   */
  public String getCustomerName()
  {
    if (customerName != null)
    {
      return customerName;
    }
    return null;
  }

  /**
   * Getter for the name of the pet
   * @return the name of the pet
   */
  public String getPetName()
  {
    return petName;
  }

  /**
   * Getter for the customer of the sale
   * @return the customer of the sale
   */
  public Customer getCustomer()
  {
    return customer;
  }

  /**
   * Getter for the pet of the sale
   * @return the pet of the sale
   */
  public Pet getPet()
  {
    return pet;
  }

  /**
   * Getter for the date of the sale
   * @return the date of the sale
   */
  public MyDate getDate()
  {
    return date;
  }

  /**
   * Setter for the customer of the sale
   * @param time the customer of the sale
   */
  public void setTime(String time)
  {
    this.time = time;
  }

  /**
   * To String method for the Sale class
   * @return a string representation of the sale
   */
  public String toString()
  {
    return "Final Price: " + finalPrice + "\n" + customer + "\n" + pet
        + "\nDate: " + date + "\nTime: " + time + "\n";
  }

  /**
   * Equals method for the Sale class
   * @param obj the object to compare
   * @return true if the object is equal to the sale, false if it is not
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
