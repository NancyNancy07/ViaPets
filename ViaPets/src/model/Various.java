package model;

import java.io.Serializable;
/**
 * Represents a category of various pets. This class extends the generic Pet class
 * and adds no additional attributes, but provides a foundation for possibly varied
 * pet types in the future.
 * @author Kamin Khan Rahmany
 * @version 1.0
 */
public class Various extends Pet implements Serializable
{

  /**
   * Constructs a new Various instance by initializing it with the specified parameters.
   * This constructor utilizes the superclass Pet constructor to initialize inherited fields.
   * @param species the species of the pet
   * @param age the age of the pet
   * @param gender the gender of the pet
   * @param color the color of the pet
   * @param name the name of the pet
   * @param comment any additional comments about the pet
   * @param price the purchase price of the pet
   */
  public Various(String species, int age, String gender, String color,
      String name, String comment, double price)
  {
    super(species, age, gender, color, name, comment, price);
  }

  /**
   * Returns a string representation of this Various object. It simply calls the toString method
   * of the superclass (Pet) to get a string representation that includes all the inherited fields.
   * @return a string representation of this Various object.
   */
  public String toString()
  {
    return super.toString();
  }

  /**
   * Compares this Various object to another object for equality. This method first checks if the
   * provided object is not null and of the Various class. It then calls the superclass equals
   * method to compare attributes inherited from Pet.
   * @param obj the object to compare with this Various.
   * @return true if the given object is a Various instance with all attributes equal to this Various instance;
   * false otherwise.
   */
  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }
    Various other = (Various) obj;
    return super.equals(other);
  }

  public String getAdditionalInformation()
  {
    return "";
  }
}
