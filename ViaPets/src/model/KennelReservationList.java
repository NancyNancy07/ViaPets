package model;

import java.util.ArrayList;

/**
 * A class containing of KennelReservation object.
 *
 * @author Harshit Sharma
 * @version 1.0
 */
public class KennelReservationList
{
  private int currentNumberOfReservations;
  private ArrayList<KennelReservation> kennelReservations;

  // Constructor

  /**
   * Constructs a new KennelReservationList object with specified details including the maximum number of reservations.
   *
   * @param maxNumberOfReservations the maximum number of reservations
   */
  public KennelReservationList(int maxNumberOfReservations)
  {
    this.currentNumberOfReservations = 0;
    this.kennelReservations = new ArrayList<KennelReservation>(
        maxNumberOfReservations);
  }

  // Methods

  /**
   * Adds a new reservation to the list.
   *
   * @param reservation the reservation object
   */
  public void addKennelReservation(KennelReservation reservation)
  {
    if (kennelReservations.size() < 10)
    {
      kennelReservations.add(reservation);
      currentNumberOfReservations++;
    }
    else
    {
      System.out.println(
          "Cannot add more reservations. Maximum capacity reached.");
    }
  }

  /**
   * Removes a reservation from the list.
   *
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
   * Sets a reservation at a specific index.
   *
   * @param index       the index of the reservation to be set
   * @param reservation the reservation object
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

  public void removeReservation(KennelReservation reservation)
  {
    if (reservation != null)
    {
      kennelReservations.remove(reservation);
    }
  }

  /**
   * Gets the number of reservations in the list.
   *
   * @return the number of reservations
   */
  public int getAllNumberOfKennelReservations()
  {
    return kennelReservations.size();
  }

  /**
   * Gets a reservation at a specific index.
   *
   * @param index the index of the reservation
   * @return the reservation object
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
   * Gets all reservations in the list.
   *
   * @return an array of all reservations
   */
  public KennelReservation[] getAllKennelReservations()
  {
    return kennelReservations.toArray(
        new KennelReservation[currentNumberOfReservations]);
  }

  /**
   * Returns a string representation of this KennelReservationList, including information from all reservations.
   *
   * @return a string description of the kennel reservation list
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
   * Compares this KennelReservationList with another object for equality.
   *
   * @param obj the object to compare
   * @return true if the objects are equal, false otherwise
   */
  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
      return false;

    KennelReservationList other = (KennelReservationList) obj;

    if (this.currentNumberOfReservations != other.currentNumberOfReservations)
      return false;

    for (int i = 0; i < currentNumberOfReservations; i++)
    {
      if (!kennelReservations.get(i).equals(other.kennelReservations.get(i)))
        return false;
    }
    return true;
  }
}



