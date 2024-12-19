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
  private ArrayList<KennelReservation> kennelReservations;

  // Constructor

  /**
   * Constructs a new KennelReservationList object
   */
  public KennelReservationList()
  {
    this.kennelReservations = new ArrayList<KennelReservation>();
  }

  // Methods



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
   * Returns a string representation of this KennelReservationList, including information from all reservations.
   *
   * @return a string description of the kennel reservation list
   */
  public String toString()
  {
    String str = "";
    for (int i = 0; i < kennelReservations.size(); i++)
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

    if (this.kennelReservations.size() != other.kennelReservations.size())
      return false;

    for (int i = 0; i < kennelReservations.size(); i++)
    {
      if (!kennelReservations.get(i).equals(other.kennelReservations.get(i)))
        return false;
    }
    return true;
  }

  /**
   * Checks if two reservations overlap.
   * @param res1 the first reservation
   * @param res2 the second reservation
   * @return true if the reservations overlap, false otherwise
   */
  private boolean reservationsOverlap(KennelReservation res1, KennelReservation res2) {
    MyDate start1 = res1.getStartDate();
    MyDate end1 = res1.getEndDate();
    MyDate start2 = res2.getStartDate();
    MyDate end2 = res2.getEndDate();

    return !(end1.compareTo(start2) < 0 || start1.compareTo(end2) > 0);
  }

  /**
   * Checks if the reservation overlaps with any other reservation.
   * @param res1 the reservation to check
   * @return true if the reservation does not overlap with any other reservation, false otherwise
   */
  public boolean dateChecker(KennelReservation res1)
  {

    int overlappingReservations = 0;

    for (KennelReservation existingReservation : kennelReservations) {
      if (reservationsOverlap(res1, existingReservation)) {
        overlappingReservations++;
      }
    }
    return overlappingReservations < 10;
  }
  /**
   * Adds a new reservation to the list.
   * @param reservation the reservation object
   */
  public void addKennelReservation(KennelReservation reservation) {
    if (reservation == null) {
      throw new IllegalArgumentException("Reservation cannot be null");
    }

    if (dateChecker(reservation)) {
      kennelReservations.add(reservation);
    } else {
      throw new IllegalArgumentException("Cannot add reservation. Overlapping reservations.");
    }
  }
}



