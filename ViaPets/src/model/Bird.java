package model;

import java.io.Serializable;
/**
 * A class containing of Bird object.
 * @author Kamin Khan Rahmany
 * @version 1.0
 */
public class Bird extends Pet implements Serializable
{
  private String preferredFood;

  /**
   * Constructs a new Bird instance with detailed information about the bird including
   * its preferred food.
   * @param species the species of the bird
   * @param age the age of the bird
   * @param gender the gender of the bird
   * @param color the color of the bird
   * @param name the name of the bird
   * @param comment additional comments about the bird
   * @param price the price of the bird
   * @param preferredFood the preferred food of the bird
   */
  public Bird(String species, int age, String gender, String color, String name,
      String comment, double price, String preferredFood)
  {
    super(species, age, gender, color, name, comment, price);
    this.preferredFood = preferredFood;
  }

  /**
   * Constructs a new Bird instance with detailed information about the bird including
   * its preferred food.
   * @param species the species of the bird
   * @param age the age of the bird
   * @param gender the gender of the bird
   * @param color the color of the bird
   * @param comment additional comments about the bird
   * @param price the price of the bird
   * @param preferredFood the preferred food of the bird
   */
  public Bird(String species, int age, String gender, String color,
      String comment, double price, String preferredFood)
  {
    super(species, age, gender, color, comment, price);
    this.preferredFood = preferredFood;
  }

  /**
   * Gets the preferred food of the bird.
   * @return the preferred food of the bird
   */
  public String getPreferredFood()
  {
    return preferredFood;
  }

  /**
   * Sets the preferred food of the bird.
   * @param preferredFood the preferred food to set
   */
  public void setPreferredFood(String preferredFood)
  {
    this.preferredFood = preferredFood;
  }

  /**
   * Returns a string representation of this Bird, including information from the superclass
   * and the bird's preferred food.
   * @return a string description of the bird
   */
  public String toString()
  {
    return super.toString() + ", preferredFood='" + preferredFood + '\'';
  }

  /**
   * Compares this bird with another object for equality. This method considers all
   * attributes from the superclass as well as the preferred food specific to the Bird class.
   * @param obj the object to compare with this Bird
   * @return true if the specified object is a Bird with the same attributes and preferred food
   */
  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }
    Bird other = (Bird) obj;
    return super.equals(other) && preferredFood.equals(other.preferredFood);
  }
}
