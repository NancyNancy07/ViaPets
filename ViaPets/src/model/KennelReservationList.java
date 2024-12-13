package model;

import java.util.ArrayList;

public class KennelReservationList
{
  private int currentNumberOfReservations;
  private ArrayList<KennelReservation> kennelReservations;

  // Constructor
  /**
   * Constructor initializing the current number of reservations and the kennel reservations
   * @param maxNumberOfReservations the maximum number of reservations
   */
  public KennelReservationList(int maxNumberOfReservations)
  {
    this.currentNumberOfReservations = 0;
    this.kennelReservations = new ArrayList<KennelReservation>(maxNumberOfReservations);
  }

  // Methods
  /**
   * Adds a kennel reservation to the list
   * @param reservation the kennel reservation to be added
   */
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

  /**
   * Removes a kennel reservation from the list
   * @param index the index of the reservation to be removed
   */
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

  /**
   * Sets a kennel reservation at a specific index in the list
   * @param index the index of the reservation to be set
   * @param reservation the reservation to be set
   */
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

  /**
   * Returns the number of kennel reservations
   * @return the number of kennel reservations
   */
  public int getAllNumberOfKennelReservations()
  {
    return kennelReservations.size();
  }


  /**
   * Returns a kennel reservation at a specific index in the list
   * @param index the index of the reservation to be returned
   * @return the kennel reservation at the specified index
   */
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


  /**
   * Returns all kennel reservations
   * @return all kennel reservations
   */
  public KennelReservation[] getAllKennelReservations()
  {
    return kennelReservations.toArray(new KennelReservation[currentNumberOfReservations]);
  }

  /**
   * Returns a string representation of the kennel reservations
   * @return a string representation of the kennel reservations
   */
  public String toString()
  {
    String str = "";
    for (int i = 0; i < currentNumberOfReservations; i++)
    {
      str += kennelReservations.get(i) + "\n";
    }
    return str;
  }

  /**
   * Checks if the kennel reservation list is equal to another object
   * @param obj the object to compare to
   * @return true if the object is equal to the kennel reservation list, false if it is not
   */
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



