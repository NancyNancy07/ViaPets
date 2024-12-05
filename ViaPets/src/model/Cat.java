package model;

public class Cat extends Pet
{
  private String breed, breeder;

  public Cat(String name, String gender, String color, String comment, int age, double price, String breed, String breeder)
  {
    super(gender, color, name, comment, age, price);
    this.breed = breed;
    this.breeder = breeder;
  }

  public Cat(String gender, String color, String comment, int age, double price, String breed, String breeder)
  {
    super(gender, color, comment, age, price);
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
    return "Breed: " + breed + "\nBreeder: " + breeder + "\n" + super.toString();
  }

  public boolean equals(Object obj)
  {
    if(obj == null || obj.getClass() != getClass())
    {
      return false;
    }
    Cat tempCat = (Cat)obj;
    return super.equals(tempCat) && breed.equals(tempCat.breed) && breeder.equals(tempCat.breeder);
  }
}
