import java.util.Objects;

public class KennelReservation
{
  private double price;
  private Pet pet;
  private Customer customer;

  // Constructor
  public KennelReservation(double price)
  {
    this.price = price;
  }

  // Getters and Setters
  public double getPrice()
  {
    return price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

  public Pet getPet()
  {
    return pet;
  }

  public void setPet(Pet pet)
  {
    this.pet = pet;
  }

  public Customer getCustomer()
  {
    return customer;
  }

  public void setCustomer(Customer customer)
  {
    this.customer = customer;
  }

  public String toString()
  {
    return "KennelReservation{" + "price=" + price + ", pet=" + pet
        + ", customer=" + customer + '}';
  }

  public boolean equals(Object obj)
  {
    if (this == obj)
    {
      return true;
    }

    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }

    KennelReservation other = (KennelReservation) obj;

    return price == other.price && pet.equals(other.pet) && customer.equals(
        other.customer);





    return true;
  }

}

