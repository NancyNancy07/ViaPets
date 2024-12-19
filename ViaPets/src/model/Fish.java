package model;

import java.io.Serializable;
/**
 * A class representing a fish as a pet. It extends the Pet class and includes additional
 * characteristics specific to fish, such as whether the fish is a predator and whether it
 * lives in freshwater. This class implements Serializable allowing fish objects to be saved
 * to a file or transferred over a network.
 * @author Kamin Khan Rahmany
 * @version 1.0
 */
public class Fish extends Pet implements Serializable
{
  private boolean isPredator;
  private boolean isFreshWater;

  /**
   * Constructs a new Fish instance with detailed information about the fish.
   *
   * @param species the species of the fish
   * @param age the age of the fish
   * @param gender the gender of the fish
   * @param color the color of the fish
   * @param name the name of the fish
   * @param comment any comments about the fish
   * @param price the price of the fish
   * @param isPredator true if the fish is a predator; false otherwise
   * @param isFreshWater true if the fish is a freshwater fish; false otherwise
   */
  public Fish(String species, int age, String gender, String color, String name,
      String comment, double price, boolean isPredator, boolean isFreshWater)
  {
    super(species, age, gender, color, name, comment, price);
    this.isFreshWater = isFreshWater;
    this.isPredator = isPredator;
  }

  /**
   * Returns true if the fish lives in freshwater.
   * @return true if this is a freshwater fish; false otherwise.
   */
  public boolean isFreshWater()
  {
    return isFreshWater;
  }

  /**
   * Returns true if the fish is a predator.
   * @return true if this fish is a predator; false otherwise.
   */
  public boolean isPredator()
  {
    return isPredator;
  }

  /**
   * Returns a string representation of this Fish object. It first calls the superclass
   * toString method to get the Pet attributes' representation and then appends the specific
   * attributes of the Fish class, namely whether the fish is freshwater and a predator.
   * @return a string representation of this Fish object, including its type, whether it is freshwater,
   * and whether it is a predator.
   */
  public String toString()
  {
    return super.toString() + ", isFreshWater=" + isFreshWater + ", Predator='"
        + isPredator + '\'';
  }

  /**
   * Compares this Fish object to another object for equality. This method first checks if the
   * provided object is not null and is an instance of the Fish class. It then calls the superclass's
   * equals method to compare the Pet attributes, and if they are equal, it checks the Fish-specific
   * attributes for equality.
   * @param obj the object to compare with this Fish.
   * @return true if the given object represents a Fish equivalent to this fish, including Pet attributes
   * and Fish-specific attributes; false otherwise.
   */
  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }
    Fish other = (Fish) obj;
    return super.equals(other) && isPredator == other.isPredator
        && isFreshWater == other.isFreshWater;
  }
}
