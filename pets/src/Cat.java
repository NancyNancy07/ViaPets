public class Cat extends Pet
{
  private String breed;
  private String breeder;

  public Cat(String species, int age, String gender, String color, String name,
      String comment, double price, String breed, String breeder)
  {
    super(species, age, gender, color, name, comment, price);
    this.breed = breed;
    this.breeder = breeder;
  }

  public Cat(String species, int age, String gender, String color,
      String comment, double price)
  {
    super(species, age, gender, color, comment, price);
    this.breed = breed;
    this.breeder = breeder;
  }

  public String getBreed()
  {
    return breed;
  }

  public void setBreed(String breed)
  {
    this.breed = breed;
  }

  public String getBreeder()
  {
    return breeder;
  }

  public void setBreeder(String breeder)
  {
    this.breeder = breeder;
  }

  public String toString()
  {
    return super.toString() + " Breed: " + breed + " Breeder: " + breeder;
  }

  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }

    Cat other = (Cat) obj;
    return super.equals(other) && breed.equals(other.breed) && breeder.equals(
        other.breeder);
  }
}