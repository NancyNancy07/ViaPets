package model;

public class Rodent extends Pet
{
  private boolean IsAggressive;

  public Rodent(String name, String gender, String color, String comment, int age,
      double price, boolean IsAggressive)
  {
    super(gender, color, name, comment, age, price);
    this.IsAggressive = IsAggressive;
  }

  public Rodent(String gender, String color, String comment, int age,
      double price, boolean IsAggressive)
  {
    super(gender, color, comment, age, price);
    this.IsAggressive = IsAggressive;
  }

  public boolean isAggressive()
  {
    return IsAggressive;
  }

  public void setAggressive(boolean aggressive)
  {
    IsAggressive = aggressive;
  }

  public String toString()
  {
    return "Aggressive: " + IsAggressive + "\n" + super.toString();
  }

  public boolean equals(Object obj)
  {
    if(obj == null || obj.getClass() != getClass())
    {
      return false;
    }
    Rodent tempRodent = (Rodent)obj;
    return super.equals(tempRodent) && IsAggressive == tempRodent.IsAggressive;
  }
}
