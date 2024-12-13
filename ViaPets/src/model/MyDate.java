package model;

public class MyDate
{
  private int day;
  private int month;
  private int year;

  /**
   * Three-argument constructor
   * @param day
   * @param month
   * @param year
   */
  public MyDate(int day, int month, int year)
  {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  /**
   * Returns the day
   * @return the day
   */
  public int getDay()
  {
    return day;
  }

  /**
   * Returns the month
   * @return the month
   */
  public int getMonth()
  {
    return month;
  }
  /**
   * Returns the year
   * @return the year
   */
  public int getYear()
  {
    return year;
  }

  /**
   * Returns the date
   * @return the date
   */
  public MyDate getDate()
  {
    return this;
  }

  /**
   * Sets the day
   * @param day the day
   */
  public void setDay(int day)
  {
    this.day = day;
  }

  /**
   * Sets the month
   * @param month the month
   */
  public void setMonth(int month)
  {
    this.month = month;
  }

  /**
   * Sets the year
   * @param year the year
   */
  public void setYear(int year)
  {
    this.year = year;
  }

  /**
   * Returns the date as a string
   * @return the date as a string
   */
  public String toString()
  {
    return day + "/" + month + "/" + year;
  }

  /**
   * Returns a copy of the date
   * @return a copy of the date
   */
  public MyDate copy()
  {
    return new MyDate(day, month, year);
  }

  /**
   * Compares two dates
   * @param obj the object to compare with
   * @return true if the object is equal to this date
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

