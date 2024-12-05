package model;

public class Pet
{
  private String species;
  private int age;
  private String gender;
  private String color;
  private String name;
  private String comment;
  private double price;

  public Pet(String species, int age, String gender, String color, String name,
      String comment, double price)
  {
    this.species = species;
    this.age = age;
    this.gender = gender;
    this.color = color;
    this.name = name;
    this.comment = comment;
    this.price = price;
  }

  public Pet(String species, int age, String gender, String color,
      String comment, double price)
  {
    this.species = species;
    this.age = age;
    this.gender = gender;
    this.color = color;
    this.comment = comment;
    this.price = price;
  }

  public String getSpecies()
  {
    return species;
  }

  public int getAge()
  {
    return age;
  }

  public String getColor()
  {
    return color;
  }

  public String getName()
  {
    return name;
  }

  public String getComment()
  {
    return comment;
  }

  public double getPrice()
  {
    return price;
  }

  public String getGender()
  {
    return gender;
  }

  public void setSpecies(String species)
  {
    this.species = species;
  }

  public void setAge(int age)
  {
    this.age = age;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setComment(String comment)
  {
    this.comment = comment;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

  public String toString()
  {
    return "model.Pet{" + "species='" + species + '\'' + ", age=" + age + ", gender='"
        + gender + '\'' + ", color='" + color + '\'' + ", name='" + name + '\''
        + ", comment='" + comment + '\'' + ", price=" + price + '}';
  }

  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }

    Pet other = (Pet) obj;
    return species.equals(other.species) && age == other.age && gender.equals(
        other.gender) && color.equals(other.color) && name.equals(other.name)
        && comment.equals(other.comment) && price == other.price;
  }

}
