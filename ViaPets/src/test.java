import model.*;

public class test
{
  public static void main(String[] args)
  {
    Pet[] pets = new Pet[7];
    Dog dog1 = new Dog( "Fido", "Female", "Brown", "A good dog", 3, 1000.0, "Golden Retriever", "John Doe");
    Dog dog2 = new Dog( "Male", "Brown", "A better dog", 7, 103300.0, "Golden Retriever", "John Doe");
    Cat cat1 = new Cat( "Havas", "Male", "White", "A good cat", 3, 1000.0, "Siamese", "Jane Doe");
    Fish fish1 = new Fish( "Nemo", "Male", "Orange", "A good fish", 3, 1000.0, true, true);
    Rodent rodent1 = new Rodent( "Jerry", "Female", "Grey", "A good rodent", 3, 1000.0, true);
    Bird bird1 = new Bird( "Tweety","Male", "Yellow", "A good bird", 3, 1000.0, "Seeds");
    Pet pet1 = new Pet("Female", "Black", "Molly", "A good various pet", 3, 1000.0);
    pets[0] = dog1;
    pets[1] = dog2;
    pets[2] = cat1;
    pets[3] = fish1;
    pets[4] = rodent1;
    pets[5] = bird1;
    pets[6] = pet1;

    for (Pet pet : pets)
    {
      System.out.println(pet);
      System.out.println("\n");
    }
  }
}
