package model;

import java.util.ArrayList;

public class KennelReservationList
{
  private ArrayList<KennelReservation> kennelReservationList;
  private int currentSize;

  public KennelReservationList(int maxSize)
  {
    kennelReservationList = new ArrayList<KennelReservation>(maxSize);
    currentSize = 0;
  }

  public void addKennelReservation(KennelReservation kennelReservation)
  {
    if(currentSize < kennelReservationList.size())
    {
      kennelReservationList.add(kennelReservation);
      currentSize++;
    }
    else
    {
      //Exceptions to add
      System.out.println("The list is full");
    }
  }

  public void removeKennelReservation(int index)
  {
    if(index < 0 || index >= currentSize)
    {
      //Exceptions to add
      System.out.println("Invalid index");
    }
    else
    {
      kennelReservationList.remove(index);
      currentSize--;
    }
  }

  public void setKennelReservationList(KennelReservation kennelReservation, int index)
  {
    if(index < 0 || index >= currentSize)
    {
      //Exceptions to add
      System.out.println("Invalid index");
    }
    else
    {
      kennelReservationList.set(index, kennelReservation);
    }
  }

  public KennelReservation getKennelReservation(int index)
  {
    if(index < 0 || index >= currentSize)
    {
      //Exceptions to add
      System.out.println("Invalid index");
      return null;
    }
    else
    {
      return kennelReservationList.get(index);
    }
  }
  public KennelReservation[] getAllKennelReservations()
  {
    KennelReservation[] kennelReservations = new KennelReservation[currentSize];
    for(int i = 0; i < currentSize; i++)
    {
      kennelReservations[i] = kennelReservationList.get(i);
    }
    return kennelReservations;
  }

  public int getAllNumberOfKennelReservations()
  {
    return currentSize;
  }

  public String toString()
  {
    String output = "";
    for(KennelReservation kennelReservation : kennelReservationList)
    {
      output += kennelReservation.toString() + "\n";
    }
    return output;
  }

  public boolean equals(Object obj)
  {
    if(obj == null || obj.getClass() != getClass())
    {
      return false;
    }
    KennelReservationList tempKennelReservationList = (KennelReservationList)obj;
    if(currentSize != tempKennelReservationList.currentSize)
    {
      return false;
    }
    for(int i = 0; i < currentSize; i++)
    {
      if(!kennelReservationList.get(i).equals(tempKennelReservationList.kennelReservationList.get(i)))
      {
        return false;
      }
    }
    return true;
  }
}
