public class Various extends Pet
{

  public Various(String species, int age, String gender, String color,
      String name, String comment, double price)
  {
    super(species, age, gender, color, name, comment, price);
  }

  public String toString()
  {
    return super.toString();
  }

  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }
    Various other = (Various) obj;
    return super.equals(other);
  }
}
