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
   * Gets the day of the date.
   * @return the day of the date
   */
  public int getDay()
  {
    return day;
  }

  /**
   * Gets the month of the date.
   * @return the month of the date
   */
  public int getMonth()
  {
    return month;
  }

  /**
   * Gets the year of the date.
   * @return the year of the date
   */
  public int getYear()
  {
    return year;
  }

  /**
   * Sets the day of the date.
   * @param day the day of the date
   */
  public void setDay(int day)
  {
    this.day = day;
  }

  /**
   * Sets the month of the date.
   * @param month the month of the date
   */
  public void setMonth(int month)
  {
    this.month = month;
  }

  /**
   * Sets the year of the date.
   * @param year the year of the date
   */
  public void setYear(int year)
  {
    this.year = year;
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

  public boolean isLeapYear()
  {
    return (year % 4 == 0 && (year % 400 == 0 || year % 100 != 0));
  }

  public int daysInMonth(int month)
  {
    if (isLeapYear())
    {
      if (month == 2)
      {
        return 29;
      }
    }
    else
    {
      if (month == 2)
      {
        return 28;
      }
    }
    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
        || month == 10 || month == 12)
    {
      return 31;
    }
    else if (month == 4 || month == 6 || month == 9 || month == 11)
    {
      return 30;
    }
    return 0;
  }

  public int dayCounter()
  {
    int days = 0;
    days += day;
    //System.out.println("Days after adding days: " + days);
    for (int i = month; i >= 0; i--)
    {
      days += daysInMonth(i);
      //System.out.println(days);
    }
    //System.out.println("Days after adding months: " + days);
    if (isLeapYear())
    {
      //System.out.println("Is Leap year!");
      days += ((year / 4) * 365 * 3) + ((year / 4) * 366)
          + 365; //there was never Year Zero
    }
    else if (year % 4 == 1)
    {
      //System.out.println("Is Leap year + 1");
      days += (((year - 1) / 4) * 365 * 3) + ((year / 4) * 366) + (2 * 365);
    }
    else if (year % 4 == 2)
    {
      //System.out.println("Is Leap year + 2");
      days += (((year - 2) / 4) * 365 * 3) + ((year / 4) * 366) + (3 * 365);
    }
    else if (year % 4 == 3)
    {
      //System.out.println("Is Leap year + 3");
      days += (((year - 3) / 4) * 365 * 3) + ((year / 4) * 366) + (4 * 365);
    }
    //System.out.println("Final days: " + days);
    return days;
  }

  public boolean isBefore(MyDate obj)
  {
    if(dayCounter()>obj.dayCounter())
    {
      return true;
    }
    return false;
  }
}

