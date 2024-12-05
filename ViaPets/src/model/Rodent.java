package model;

public class Rodent extends Pet
{
  private boolean isAggressive;

  public Rodent(String species, int age, String gender, String color,
      String name, String comment, double price, boolean isAggressive)
  {
    super(species, age, gender, color, name, comment, price);
    this.isAggressive = isAggressive;
  }

  public Rodent(String species, int age, String gender, String color,
      String comment, double price, boolean isAggressive)
  {
    super(species, age, gender, color, comment, price);
    this.isAggressive = isAggressive;
  }

  public boolean isAggressive()
  {
    return isAggressive;
  }

  public void setAggressive(boolean aggressive)
  {
    isAggressive = aggressive;
  }

  public String toString()
  {
    return super.toString() + ", isAggressive=" + isAggressive;
  }

  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }
    Rodent other = (Rodent) obj;
    return super.equals(other) && isAggressive == other.isAggressive;
  }
}
