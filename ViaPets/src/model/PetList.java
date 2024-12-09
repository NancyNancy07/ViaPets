package model;

import java.io.Serializable;
import java.util.ArrayList;

public class PetList implements Serializable
{
  private ArrayList<Pet> pets;

  public PetList()
  {
    pets = new ArrayList<>();
  }

  public void addPet(Pet pet)
  {
    pets.add(pet);
  }

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

  public void setPet(Pet pet, int index)
  {
    pets.set(index, pet);
  }

  public void removePet(int index)
  {
    pets.remove(index);
  }

  public void removePet(Pet pet)
  {
    pets.remove(pet);
  }

  public Pet[] getPetsForSale()
  {
    ArrayList<Pet> forSaleList = new ArrayList<>();
    for (int i = 0; i < pets.size(); i++)
    {
      Pet pet = pets.get(i);
      if (pets.get(i).getPrice() != 0)
      {
        forSaleList.add(pet);
      }
    }
    return forSaleList.toArray(new Pet[0]);
  }

  public int getNumberOfPets()
  {
    return pets.size();
  }

  public String toString()
  {
    String output = "";
    for (int i = 0; i < pets.size(); i++)
    {
      output += (pets.get(i) + "\n");
    }
    return output;
  }

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
