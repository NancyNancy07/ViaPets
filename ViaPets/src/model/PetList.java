package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of Pet objects.
 *
 * @author Kamin Khan Rahmany
 * @version 1.0
 */
public class PetList implements Serializable
{
  private ArrayList<Pet> pets;

  /**
   * Constructs an empty list of pets.
   */
  public PetList()
  {
    pets = new ArrayList<>();
  }

  /**
   * Adds a pet to the list.
   *
   * @param pet the Pet to be added to the list
   */
  public void addPet(Pet pet)
  {
    try
    {
      pets.add(pet);
    }
    catch (IllegalArgumentException e)
    {
      System.out.println("Error: " + e.getMessage() + " Pet not added.");
    }
  }

  /**
   * Gets the pet at the specified index in the list.
   *
   * @param index the index of the pet to retrieve
   * @return the Pet at the specified index or null if the index is invalid
   */
  public Pet getPet(int index)
  {
    if (index >= 0 && index < pets.size())
    {
      return pets.get(index);
    }
    else
    {
      System.out.println("Invalid index");
      return null;
    }
  }

  /**
   * Replaces the pet at the specified index with a new pet.
   *
   * @param pet   the new Pet to set at the specified index
   * @param index the index where the pet will be set
   */
  public void setPet(Pet pet, int index)
  {
    pets.set(index, pet);
  }

  /**
   * Removes the pet at the specified index from the list.
   *
   * @param index the index of the pet to remove
   */
  public void removePet(int index)
  {
    pets.remove(index);
  }

  /**
   * Removes the specified pet from the list. Only the first occurrence
   * of the pet is removed.
   *
   * @param pet the pet to remove from the list
   */
  public void removePet(Pet pet)
  {
    pets.remove(pet);
  }

  /**
   * Returns the number of pets in the list.
   *
   * @return the total number of pets
   */
  public int getNumberOfPets()
  {
    return pets.size();
  }

  /**
   * Returns a string representation of this PetList. Each pet is represented by
   * its own toString() output, and each pet is separated by a newline.
   *
   * @return a string representation of the pet list
   */
  public String toString()
  {
    String output = "";
    for (int i = 0; i < pets.size(); i++)
    {
      Pet pet = pets.get(i);
      // If pet is a Dog, include breed and breeder info
      if (pet instanceof Dog)
      {
        Dog dog = (Dog) pet;
        output += (pet + " Breed: " + dog.getBreed() + " Breeder: " + dog.getBreeder() + "\n");
      }
      else
      {
        output += (pet + "\n");
      }
    }
    return output;
  }

  /**
   * Compares this PetList with the specified object for equality. The result is
   * true if and only if the argument is not null, is a PetList object, and
   * contains the same pets as this object.
   *
   * @param obj the object to compare with
   * @return true if the given object represents an equivalent PetList, false otherwise
   */
  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }
    PetList other = (PetList) obj;
    return pets.equals(other.pets);
  }
}
