package model;

/**
 * A class containing of MyDate object.
 * @author Nancy
 * @version 1.0
 */
public class MyDate
{
  private int day;
  private int month;
  private int year;

  //Constructor
  /**
   * Constructs a new MyDate object with specified details including the day, month and year.
   * @param day the day of the date
   * @param month the month of the date
   * @param year the year of the date
   */
  public MyDate(int day, int month, int year)
  {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  //Methods

  /**
   * Compares two dates to each other.
   * @param other the other date to compare with
   * @return the difference between the two dates
   */
  public int compareTo(MyDate other) {
    if (year != other.year) {
      return year - other.year;
    } else if (month != other.month) {
      return month - other.month;
    } else {
      return day - other.day;
    }
  }
  /**
   * Returns a string representation of the date.
   * @return a string representation of the date
   */
  public String toString()
  {
    return day + "/" + month + "/" + year;
  }

  /**
   * Creates a copy of the MyDate object.
   * @return a copy of the MyDate object
   */
  public MyDate copy()
  {
    return new MyDate(day, month, year);
  }

  /**
   * Compares the MyDate object with another object to determine if they are equal.
   * @param obj the object to compare
   * @return true if the objects are equal, false otherwise
   */
  public boolean equals(Object obj)
  {
    if (obj == null || obj.getClass() != getClass())
    {
      return false;
    }

    MyDate other = (MyDate) obj;
    return day == other.day && month == other.month && year == other.year;
  }



}

