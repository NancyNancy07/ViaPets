package model;

public class Fish extends Pet
{
  private boolean IsPredator, IsFreshWater;


  public Fish(String name, String gender, String color, String comment, int age, double price, boolean IsPredator, boolean IsFreshWater)
  {
    super(gender, color, name, comment, age, price);
    this.IsPredator = IsPredator;
    this.IsFreshWater = IsFreshWater;
  }

  public Fish(String gender, String color, String comment, int age, double price, boolean IsPredator, boolean IsFreshWater)
  {
    super(gender, color, comment, age, price);
    this.IsPredator = IsPredator;
    this.IsFreshWater = IsFreshWater;
  }

  public boolean isPredator()
  {
    return IsPredator;
  }

  public boolean isFreshWater()
  {
    return IsFreshWater;
  }

  public void setPredator(boolean IsPredator)
  {
    this.IsPredator = IsPredator;
  }

  public void setFreshWater(boolean IsFreshWater)
  {
    this.IsFreshWater = IsFreshWater;
  }

  public String toString()
  {
    return "Predator: " + IsPredator + "\nFresh Water: " + IsFreshWater + "\n" + super.toString();
  }

  public boolean equals(Object obj)
  {
    if(obj == null || obj.getClass() != getClass())
    {
      return false;
    }
    Fish tempFish = (Fish)obj;
    return super.equals(tempFish) && IsPredator == tempFish.IsPredator && IsFreshWater == tempFish.IsFreshWater;
  }
}
