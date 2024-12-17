package model;

import java.io.Serializable;
/**
 * A class containing of Dog object.
 * @author Kamin Khan Rahmany
 * @version 1.0
 */
public class Dog extends Pet implements Serializable
{
  private String breed;
  private String breeder;

  /**
   * Constructs a new Dog object with specified details including the breed and breeder's information.
   * @param species the species of the dog
   * @param age the age of the dog
   * @param gender the gender of the dog
   * @param color the color of the dog
   * @param name the name of the dog
   * @param comment any additional comments about the dog
   * @param price the price of the dog
   * @param breed the breed of the dog
   * @param breeder the breeder's name
   */
  public Dog(String species, int age, String gender, String color, String name,
      String comment, double price, String breed, String breeder)
  {
    super(species, age, gender, color, name, comment, price);
    this.breed = breed;
    this.breeder = breeder;
  }

  /**
   * Constructs a new Dog object with specified details without breed and breeder information.
   * @param species the species of the dog
   * @param age the age of the dog
   * @param gender the gender of the dog
   * @param color the color of the dog
   * @param comment any additional comments about the dog
   * @param price the price of the dog
   */
  public Dog(String species, int age, String gender, String color,
      String comment, double price)
  {
    super(species, age, gender, color, comment, price);
    this.breed = breed;
    this.breeder = breeder;
  }

  /**
   * Gets the breed of the dog.
   * @return the breed of the dog
   */
  public String getBreed()
  {
    return breed;
  }

  /**
   * Sets the breed of the dog.
   * @param breed the breed of the fog
   */
  public void setBreed(String breed)
  {
    this.breed = breed;
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
   * Sets the breeder's name.
   * @param breeder the name of the breeder
   */
  public void setBreeder(String breeder)
  {
    this.breeder = breeder;
  }

  /**
   * Returns a string representation of the Dog object, including all details inherited from the superclass
   * along with the dog's specific breed and breeder information.
   * @return a string representation of the dog's details, formatted to include superclass details, breed, and breeder
   */
  public String toString()
  {
    return super.toString() + " Breed: " + breed + " Breeder: " + breeder;
  }

  /**
   * Compares this dog to the specified object for equality. The comparison includes superclass properties
   * and checks if both the breed and breeder of the dogs are the same.
   * @param obj the object to compare this dog against
   * @return true if the given object represents a Dog equivalent to this dog, false otherwise
   */
  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }

    Dog other = (Dog) obj;
    return super.equals(other) && breed.equals(other.breed) && breeder.equals(
        other.breeder);
  }

  public String getAdditionalInformation()
  {
    return breed +"|"+ breeder;
  }

}
