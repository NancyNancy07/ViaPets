package model;

import java.io.Serializable;
/**
 * A class containing of Cat object.
 * @author Kamin Khan Rahmany
 * @version 1.0
 */
public class Cat extends Pet implements Serializable
{
  private String breed;
  private String breeder;

  /**
   * Constructs a new Cat object with specified details including the breed and breeder's information.
   * @param species the species of the cat
   * @param age the age of the cat
   * @param gender the gender of the cat
   * @param color the color of the cat
   * @param name the name of the cat
   * @param comment any additional comments about the cat
   * @param price the price of the cat
   * @param breed the breed of the cat
   * @param breeder the breeder's name
   */
  public Cat(String species, int age, String gender, String color, String name,
      String comment, double price, String breed, String breeder)
  {
    super(species, age, gender, color, name, comment, price);
    this.breed = breed;
    this.breeder = breeder;
  }

  /**
   * Gets the breed of the cat.
   * @return the breed of the cat
   */
  public String getBreed()
  {
    return breed;
  }

  /**
   * Gets the name of the breeder.
   * @return the breeder's name
   */
  public String getBreeder()
  {
    return breeder;
  }

  /**
   * Returns a string representation of the Cat object, including all details inherited from the superclass
   * along with the cat's specific breed and breeder information.
   * @return a string representation of the cat's details, formatted to include superclass details, breed, and breeder
   */
  public String toString()
  {
    return super.toString() + " Breed: " + breed + " Breeder: " + breeder;
  }

  /**
   * Compares this cat to the specified object for equality. The comparison includes superclass properties
   * and checks if both the breed and breeder of the cats are the same.
   * @param obj the object to compare this cat against
   * @return true if the given object represents a Cat equivalent to this cat, false otherwise
   */
  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }

    Cat other = (Cat) obj;
    return super.equals(other) && breed.equals(other.breed) && breeder.equals(
        other.breeder);
  }
}
