package model;

public class Bird extends Pet
{
  private String preferredFood;

  public Bird(String name, String gender, String color, String comment, int age,
      double price, String preferredFood)
  {
    super(gender, color, name, comment, age, price);
    this.preferredFood = preferredFood;
  }

  public Bird(String gender, String color, String comment, int age,
      double price, String preferredFood)
  {
    super(gender, color, comment, age, price);
    this.preferredFood = preferredFood;
  }

  public String getPreferredFood()
  {
    return preferredFood;
  }

  public void setPreferredFood(String preferredFood)
  {
    this.preferredFood = preferredFood;
  }

  public String toString()
  {
    return "Preferred Food: " + preferredFood + "\n" + super.toString();
  }

  public boolean equals(Object obj)
  {
    if(obj == null || obj.getClass() != getClass())
    {
      return false;
    }
    Bird tempBird = (Bird)obj;
    return super.equals(tempBird) && preferredFood.equals(tempBird.preferredFood);
  }
}
