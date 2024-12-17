package model;

import java.io.Serializable;
/**
 * A class representing a rodent as a pet. This class extends the Pet class and incorporates
 * additional attributes specific to rodents, such as aggressiveness. Implements Serializable to
 * enable serialization of Rodent objects for storage or network transfer.
 * @author Kamin Khan Rahmany
 * @version 1.0
 */
public class Rodent extends Pet implements Serializable
{
  private boolean isAggressive;

  /**
   * Constructs a new Rodent instance initializing all fields including those inherited from Pet.
   * @param species the species of the rodent
   * @param age the age of the rodent
   * @param gender the gender of the rodent
   * @param color the color of the rodent
   * @param name the name of the rodent
   * @param comment any additional comments about the rodent
   * @param price the purchase price of the rodent
   * @param isAggressive whether the rodent is typically aggressive
   */
  public Rodent(String species, int age, String gender, String color,
      String name, String comment, double price, boolean isAggressive)
  {
    super(species, age, gender, color, name, comment, price);
    this.isAggressive = isAggressive;
  }

  /**
   * Constructs a new Rodent instance initializing all fields including those inherited from Pet.
   * @param species the species of the rodent
   * @param age the age of the rodent
   * @param gender the gender of the rodent
   * @param color the color of the rodent
   * @param comment any additional comments about the rodent
   * @param price the purchase price of the rodent
   * @param isAggressive whether the rodent is typically aggressive
   */
  public Rodent(String species, int age, String gender, String color,
      String comment, double price, boolean isAggressive)
  {
    super(species, age, gender, color, comment, price);
    this.isAggressive = isAggressive;
  }

  /**
   * Returns whether this rodent is aggressive.
   * @return true if this rodent is aggressive, false otherwise.
   */
  public boolean isAggressive()
  {
    return isAggressive;
  }

  /**
   * Sets the aggressive behavior of this rodent.
   * @param aggressive true to indicate the rodent is aggressive, false otherwise.
   */
  public void setAggressive(boolean aggressive)
  {
    isAggressive = aggressive;
  }

  /**
   * Returns a string representation of this Rodent object. It first calls the superclass
   * toString method to get the Pet attributes' representation and then appends the specific
   * attribute of the Rodent class, which is the aggressiveness.
   * @return a string representation of this Rodent object, including inherited Pet attributes
   * and the isAggressive attribute of the Rodent.
   */
  public String toString()
  {
    return super.toString() + ", isAggressive=" + isAggressive;
  }

  /**
   * Compares this Rodent object to another object for equality. This method first checks if the
   * provided object is not null and is an instance of the Rodent class. It then calls the superclass
   * equals method to compare the Pet attributes, and if they are equal, it further checks the
   * Rodent-specific attribute for equality.
   * @param obj the object to compare with this Rodent.
   * @return true if the given object represents a Rodent equivalent to this rodent, including Pet attributes
   * and the isAggressive attribute; false otherwise.
   */
  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }
    Rodent other = (Rodent) obj;
    return super.equals(other) && isAggressive == other.isAggressive;
  }

  public String getAdditionalInformation()
  {
    return isAggressive ? "Aggressive" : "Not aggressive";
  }
}
