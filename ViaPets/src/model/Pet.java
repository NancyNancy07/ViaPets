package model;

import java.io.Serializable;

/**
 * A class containing of Pet object.
 *
 * @author Kamin Khan Rahmany
 * @version 1.0
 */
public class Pet implements Serializable
{
  private String species;
  private int age;
  private String gender;
  private String color;
  private String name;
  private String comment;
  private double price;

  /**
   * Constructs a new Pet with specified attributes.
   *
   * @param species the biological species of the pet
   * @param age     the age of the pet in years
   * @param gender  the gender of the pet
   * @param color   the primary color of the pet
   * @param name    the name given to the pet
   * @param comment additional comments or notes about the pet
   * @param price   the selling price of the pet if applicable
   */
  public Pet(String species, int age, String gender, String color, String name,
      String comment, double price)
  {
    this.species = species;
    this.age = age;
    this.gender = gender;
    this.color = color;
    this.name = name;
    this.comment = comment;
    this.price = price;
  }

  /**
   * Constructs a new Pet with specified attributes.
   *
   * @param species the biological species of the pet
   * @param age     the age of the pet in years
   * @param gender  the gender of the pet
   * @param color   the primary color of the pet
   * @param comment additional comments or notes about the pet
   * @param price   the selling price of the pet if applicable
   */
  public Pet(String species, int age, String gender, String color,
      String comment, double price)
  {
    this.species = species;
    this.age = age;
    this.gender = gender;
    this.color = color;
    this.comment = comment;
    this.price = price;
    this.name = "";
  }

  /**
   * Gets the species of the pet.
   *
   * @return the species of the pet as a String
   */
  public String getSpecies()
  {
    return species;
  }

  /**
   * Gets the age of the pet.
   *
   * @return the age of the pet in years
   */
  public int getAge()
  {
    return age;
  }

  /**
   * Gets the color of the pet.
   *
   * @return the primary color of the pet as a String
   */
  public String getColor()
  {
    return color;
  }

  /**
   * Gets the name of the pet.
   *
   * @return the name given to the pet as a String
   */
  public String getName()
  {
    return name;
  }

  /**
   * Gets any additional comments about the pet.
   *
   * @return additional comments about the pet as a String
   */
  public String getComment()
  {
    return comment;
  }

  /**
   * Gets the price of the pet.
   *
   * @return the price given to the pet as a double
   */
  public double getPrice()
  {
    return price;
  }

  /**
   * Gets the gender of the pet.
   *
   * @return the gender given to the pet as a String
   */
  public String getGender()
  {
    return gender;
  }

  /**
   * Sets the species of the pet.
   *
   * @param species the biological species to be set for the pet
   */
  public void setSpecies(String species)
  {
    this.species = species;
  }

  /**
   * Sets the age of the pet.
   *
   * @param age the age of the pet in years to be set
   */
  public void setAge(int age)
  {
    if (age < 0)
    {
      throw new IllegalArgumentException("Age cannot be negative.");
    }
    this.age = age;
  }

  /**
   * Sets the name of the pet.
   *
   * @param name the name to be set for the pet
   */
  public void setName(String name)
  {
    this.name = name;
  }

  /**
   * Sets the comment about the pet.
   *
   * @param comment comment the comment to be set for the pet
   */
  public void setComment(String comment)
  {
    this.comment = comment;
  }

  /**
   * Sets the price of the pet.
   *
   * @param price the price to be set for the pet
   */
  public void setPrice(double price)
  {
    if (price < 0)
    {
      throw new IllegalArgumentException("Price cannot be negative.");
    }
    this.price = price;
  }

  /**
   * Provides a string representation of the Pet object, including all attributes.
   *
   * @return a string detailing the pet's species, age, gender, color, name, comment, and price.
   */
  public String toString()
  {
    return "Pets Details: \n" + "Species: " + species + ", Age: " + age
        + ", Gender: " + gender + ", Color: " + color + ", Name: " + name
        + ", Comment: " + comment + ", Price: " + price;
  }

  /**
   * Compares this pet to the specified object. The result is true if and only if
   * the argument is not null and is a Pet object that has the same species, age,
   * gender, color, name, comment, and price as this object.
   *
   * @param obj the object to compare this Pet against
   * @return true if the given object represents a Pet equivalent to this pet, false otherwise
   */
  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }

    Pet other = (Pet) obj;
    return species.equals(other.species) && age == other.age && gender.equals(
        other.gender) && color.equals(other.color) && name != null
        && name.equals(other.name) && comment.equals(other.comment)
        && price == other.price;
  }

}
