package model;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * A class containing of PetTypeAdapter object.
 * @version 1.0
 * @author Nancy
 */
public class PetTypeAdapter extends TypeAdapter<Pet>
{

  private static final String TYPE_FIELD = "type";

  /**
   * Writes a Pet object into a JsonWriter object.
   * @param out the JsonWriter object
   * @param pet the Pet object
   * @throws IOException if an I/O error occurs
   */
  @Override public void write(JsonWriter out, Pet pet) throws IOException
  {
    out.beginObject();
    out.name(TYPE_FIELD)
        .value(pet.getClass().getSimpleName()); // Write the type of pet
    out.name("species").value(pet.getSpecies());
    out.name("age").value(pet.getAge());
    out.name("gender").value(pet.getGender());
    out.name("color").value(pet.getColor());
    out.name("name").value(pet.getName());
    out.name("comment").value(pet.getComment());
    out.name("price").value(pet.getPrice());

    // Handle subclass-specific fields
    if (pet instanceof Bird)
    {
      Bird bird = (Bird) pet;
      out.name("preferredFood").value(bird.getPreferredFood());
    }
    else if (pet instanceof Cat)
    {
      Cat cat = (Cat) pet;
      out.name("breed").value(cat.getBreed());
      out.name("breeder").value(cat.getBreeder());
    }
    else if (pet instanceof Dog)
    { // Added Dog support
      Dog dog = (Dog) pet;
      out.name("breed").value(dog.getBreed());
      out.name("breeder").value(dog.getBreeder());
    }
    else if (pet instanceof Rodent)
    { // Added Rodent support
      Rodent rodent = (Rodent) pet;
      out.name("isAggressive").value(rodent.isAggressive());
    }
    else if (pet instanceof Fish)
    { // Added Fish support
      Fish fish = (Fish) pet;
      out.name("isPredator").value(fish.isPredator());
      out.name("isFreshWater").value(fish.isFreshWater());
    }
    else if (pet instanceof Various)
    { // Added Various support
      // No subclass-specific fields to serialize for Various
    }
    out.endObject();
  }

  /**
   * Reads a JsonReader object into a Pet object.
   * @param in the JsonReader object
   * @return the Pet object
   * @throws IOException if an I/O error occurs
   */
  @Override public Pet read(JsonReader in) throws IOException
  {
    JsonObject jsonObject = parseJsonReader(in);
    String type = jsonObject.get(TYPE_FIELD).getAsString();

    Pet pet;
    switch (type)
    {
      case "Bird":
        pet = new Bird(jsonObject.get("species").getAsString(),
            jsonObject.get("age").getAsInt(),
            jsonObject.get("gender").getAsString(),
            jsonObject.get("color").getAsString(),
            jsonObject.get("name").getAsString(),
            jsonObject.get("comment").getAsString(),
            jsonObject.get("price").getAsDouble(),
            jsonObject.get("preferredFood").getAsString());
        break;
      case "Cat":
        pet = new Cat(jsonObject.get("species").getAsString(),
            jsonObject.get("age").getAsInt(),
            jsonObject.get("gender").getAsString(),
            jsonObject.get("color").getAsString(),
            jsonObject.get("name").getAsString(),
            jsonObject.get("comment").getAsString(),
            jsonObject.get("price").getAsDouble(),
            jsonObject.get("breed").getAsString(),
            jsonObject.get("breeder").getAsString());
        break;
      case "Dog": // Added Dog support
        pet = new Dog(jsonObject.get("species").getAsString(),
            jsonObject.get("age").getAsInt(),
            jsonObject.get("gender").getAsString(),
            jsonObject.get("color").getAsString(),
            jsonObject.get("name").getAsString(),
            jsonObject.get("comment").getAsString(),
            jsonObject.get("price").getAsDouble(),
            jsonObject.get("breed").getAsString(),
            jsonObject.get("breeder").getAsString());
        break;
      case "Rodent": // Added Rodent support
        pet = new Rodent(jsonObject.get("species").getAsString(),
            jsonObject.get("age").getAsInt(),
            jsonObject.get("gender").getAsString(),
            jsonObject.get("color").getAsString(),
            jsonObject.get("name").getAsString(),
            jsonObject.get("comment").getAsString(),
            jsonObject.get("price").getAsDouble(),
            jsonObject.get("isAggressive").getAsBoolean());
        break;
      case "Fish": // Added Fish support
        pet = new Fish(jsonObject.get("species").getAsString(),
            jsonObject.get("age").getAsInt(),
            jsonObject.get("gender").getAsString(),
            jsonObject.get("color").getAsString(),
            jsonObject.get("name").getAsString(),
            jsonObject.get("comment").getAsString(),
            jsonObject.get("price").getAsDouble(),
            jsonObject.get("isPredator").getAsBoolean(),
            jsonObject.get("isFreshWater").getAsBoolean());
        break;
      case "Various": // Added Various support
        pet = new Various(jsonObject.get("species").getAsString(),
            jsonObject.get("age").getAsInt(),
            jsonObject.get("gender").getAsString(),
            jsonObject.get("color").getAsString(),
            jsonObject.get("name").getAsString(),
            jsonObject.get("comment").getAsString(),
            jsonObject.get("price").getAsDouble());
        break;
      default: // Handle generic Pet
        pet = new Pet(jsonObject.get("species").getAsString(),
            jsonObject.get("age").getAsInt(),
            jsonObject.get("gender").getAsString(),
            jsonObject.get("color").getAsString(),
            jsonObject.get("name").getAsString(),
            jsonObject.get("comment").getAsString(),
            jsonObject.get("price").getAsDouble());
        break;
    }
    return pet;
  }

  /**
   * Parses a JsonReader object into a JsonObject.
   * @param in the JsonReader object
   * @return the JsonObject
   * @throws IOException if an I/O error occurs
   */
  private JsonObject parseJsonReader(JsonReader in) throws IOException
  {
    JsonParser parser = new JsonParser(); // For backward compatibility
    return parser.parse(in).getAsJsonObject();
  }
}
