package model;

import java.util.ArrayList;

public class PetList
{
  private ArrayList<Pet> petList;

  public PetList()
  {
    petList = new ArrayList<Pet>();
  }

  public void addPet(Pet pet)
  {
    petList.add(pet);
  }

  public Pet getPet(int index)
  {
    if(index < 0 || index >= petList.size())
    {
      //Exceptions to add
      System.out.println("Invalid index");
      return null;
    }
    else
    {
      return petList.get(index);
    }
  }

  public void setPet(Pet pet, int index)
  {
    if(index < 0 || index >= petList.size())
    {
      //Exceptions to add
      System.out.println("Invalid index");
    }
    else
    {
      petList.set(index, pet);
    }
  }

  public void removePet(int index)
  {
    if(index < 0 || index >= petList.size())
    {
      //Exceptions to add
      System.out.println("Invalid index");
    }
    else
    {
      petList.remove(index);
    }
  }

  public Pet[] getPetsForSale()
  {
    ArrayList<Pet> petsForSale = new ArrayList<Pet>();
    for(int i = 0; i < petList.size(); i++)
    {
      if(petList.get(i).getPrice() > 0)
      {
        petsForSale.add(petList.get(i));
      }
    }
    Pet[] petsForSaleArray = new Pet[petsForSale.size()];
    for(int i = 0; i < petsForSale.size(); i++)
    {
      petsForSaleArray[i] = petsForSale.get(i);
    }
    return petsForSaleArray;
  }

  public int getNumberOfPets()
  {
    return petList.size();
  }

  public String toString()
  {
    String str = "";
    for(int i = 0; i < petList.size(); i++)
    {
      str += petList.get(i) + "\n";
    }
    return str;
  }

  public boolean equals(Object obj)
  {
    if(obj == null || obj.getClass() != getClass())
    {
      return false;
    }
    PetList tempPetList = (PetList)obj;
    if(tempPetList.getNumberOfPets() != getNumberOfPets())
    {
      return false;
    }
    for(int i = 0; i < petList.size(); i++)
    {
      if(!petList.get(i).equals(tempPetList.getPet(i)))
      {
        return false;
      }
    }
    return true;
  }
}
