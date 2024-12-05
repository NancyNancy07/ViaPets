package model;

public class Pet
{
  private String species, gender, color, name, comment;
  private int age;
  private double price;

  public Pet(String gender, String color, String name,
      String comment, int age, double price)
  {
    this.species = getClass().getSimpleName().equals("Pet") ? "Various" : getClass().getSimpleName();
    this.gender = gender;
    this.color = color;
    this.name = name;
    this.comment = comment;
    this.age = age;
    this.price = price;
  }

  public Pet(String gender, String color, String comment,
      int age, double price)
  {
    this.species = getClass().getSimpleName().equals("Pet") ? "Various" : getClass().getSimpleName();
    this.gender = gender;
    this.color = color;
    this.name = null;
    this.comment = comment;
    this.age = age;
    this.price = price;
  }

  public String getName()
  {
    if (name == null)
      return "No name";
    return name;
  }

  public String getSpecies()
  {
    return species;
  }

  public String getGender()
  {
    return gender;
  }

  public String getColor()
  {
    return color;
  }

  public String getComment()
  {
    return comment;
  }

  public int getAge()
  {
    return age;
  }

  public double getPrice()
  {
    return price;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setSpecies(String species)
  {
    this.species = species;
  }

  public void setAge(int age)
  {
    this.age = age;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

  public void setColor(String color)
  {
    this.color = color;
  }

  public void setComment(String comment)
  {
    this.comment = comment;
  }

  public void setGender(String gender)
  {
    this.gender = gender;
  }

  //ToString fixed in subclasses
  public String toString()
  {
    return "Species: " + species + "\nGender: " + gender + "\nColor: " + color
        + "\nName: " + getName() + "\nAge: " + age + "\nPrice: " + price
        + "\nComment: " + comment;
  }

  public boolean equals(Object obj)
  {
    if(obj == null || obj.getClass() != getClass())
    {
      return false;
    }

    Pet tempPet = (Pet)obj;

    return species.equals(tempPet.species) && age == tempPet.age && price == tempPet.price && gender.equals(tempPet.gender) && color.equals(tempPet.color) && name.equals(tempPet.name) && comment.equals(tempPet.comment);
  }
}
