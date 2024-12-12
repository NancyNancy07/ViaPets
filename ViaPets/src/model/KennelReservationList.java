package model;

import java.util.ArrayList;

public class KennelReservationList
{
  private int currentNumberOfReservations;
  private ArrayList<KennelReservation> kennelReservations;

  public KennelReservationList(int maxNumberOfReservations)
  {
    this.currentNumberOfReservations = 0;
    this.kennelReservations = new ArrayList<KennelReservation>(maxNumberOfReservations);
  }

  // Methods
  public void addKennelReservation(KennelReservation reservation)
  {
    if (kennelReservations.size() > currentNumberOfReservations)
    {
      kennelReservations.add(reservation);
    }
    else
    {
      System.out.println(
          "Cannot add more reservations. Maximum capacity reached.");
    }
  }

  public void removeReservation(int index)
  {
    if (index >= 0 && index < kennelReservations.size())
    {
      kennelReservations.remove(index);
    }
    else
    {
      System.out.println("Invalid index. Cannot remove reservation.");
    }
  }

  public void setKennelReservation(int index, KennelReservation reservation)
  {
    if (index >= 0 && index < kennelReservations.size())
    {
      kennelReservations.set(index, reservation);
    }
    else
    {
      System.out.println("Invalid index. Cannot set reservation.");
    }
  }

  public int getAllNumberOfKennelReservations()
  {
    return kennelReservations.size();
  }


  public KennelReservation getKennelReservation(int index)
  {
    if (index >= 0 && index < kennelReservations.size())
    {
      return kennelReservations.get(index);
    }
    else
    {
      System.out.println("Invalid index. Returning null.");
      return null;
    }
  }


  public KennelReservation[] getAllKennelReservations()
  {
    return kennelReservations.toArray(new KennelReservation[currentNumberOfReservations]);
  }

  public String toString()
  {
    String str = "";
    for (int i = 0; i < currentNumberOfReservations; i++)
    {
      str += kennelReservations.get(i) + "\n";
    }
    return str;
  }

   public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass()) return false;

    KennelReservationList other = (KennelReservationList) obj;


    if (this.currentNumberOfReservations != other.currentNumberOfReservations) return false;


    for (int i = 0; i < currentNumberOfReservations; i++) {
      if (!kennelReservations.get(i).equals(other.kennelReservations.get(i))) return false;
    }
    return true;
  }
}



