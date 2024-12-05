import java.util.ArrayList;

public class KennelReservationList
{
  private final int maxNumberOfReservations;
  private final ArrayList<KennelReservation> kennelReservations;

  public KennelReservationList(int maxNumberOfReservations)
  {
    this.maxNumberOfReservations = maxNumberOfReservations;
    this.kennelReservations = new ArrayList<KennelReservation>();
  }

  // Methods
  public void addKennelReservation(KennelReservation reservation)
  {
    if (kennelReservations.size() < maxNumberOfReservations)
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
    return kennelReservations.toArray(new KennelReservation[0]);
  }
   //public boolean equals(Object obj) {
   // if (this == obj) return true; // Same reference
    //if (obj == null || getClass() != obj.getClass()) return false; // Null or different class

    //KennelReservationList other = (KennelReservationList) obj;


    //if (this.maxNumberOfReservations != other.maxNumberOfReservations) return false;


   // return this.getAllReservations().equals(other.getAllReservations());
  }



