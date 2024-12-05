package model;

public class Fish extends Pet
{
  private boolean isPredator;
  private boolean isFreshWater;

  public Fish(String species, int age, String gender, String color, String name,
      String comment, double price, boolean isPredator, boolean isFreshWater)
  {
    super(species, age, gender, color, name, comment, price);
    this.isFreshWater = isFreshWater;
    this.isPredator = isPredator;
  }

  public Fish(String species, int age, String gender, String color,
      String comment, double price, boolean isPredator, boolean isFreshWater)
  {
    super(species, age, gender, color, comment, price);
    this.isFreshWater = isFreshWater;
    this.isPredator = isPredator;
  }

  public boolean isFreshWater()
  {
    return isFreshWater;
  }

  public void setFreshWater(boolean freshWater)
  {
    isFreshWater = freshWater;
  }

  public boolean isPredator()
  {
    return isPredator;
  }

  public void setPredator(boolean predator)
  {
    this.isPredator = isPredator;
  }

  public String toString()
  {
    return super.toString() + ", isFreshWater=" + isFreshWater + ", Predator='"
        + isPredator + '\'';
  }

  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }
    Fish other = (Fish) obj;
    return super.equals(other) && isPredator == other.isPredator
        && isFreshWater == other.isFreshWater;
  }
}
