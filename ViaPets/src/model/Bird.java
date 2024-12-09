package model;

import java.io.Serializable;

public class Bird extends Pet implements Serializable
{
  private String preferredFood;

  public Bird(String species, int age, String gender, String color, String name,
      String comment, double price, String preferredFood)
  {
    super(species, age, gender, color, name, comment, price);
    this.preferredFood = preferredFood;
  }

  public Bird(String species, int age, String gender, String color,
      String comment, double price, String preferredFood)
  {
    super(species, age, gender, color, comment, price);
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
    return super.toString() + ", preferredFood='" + preferredFood + '\'';
  }

  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }
    Bird other = (Bird) obj;
    return super.equals(other) && preferredFood.equals(other.preferredFood);
  }
}
