// ***************************************
// Jesse Tripp
// COSC 211
// Assignment 1 - Refactoring Date.java
// (second attempt)
// ***************************************

import java.util.Scanner;

public class Date {
  private String month;
  private int day;
  private int year; // a four digit number.

  public Date() {
    month = "January";
    day = 1;
    year = 1000;
  }

  public Date(int monthInt, int day, int year) {
    setDate(monthInt, day, year);
  }

  public Date(String monthString, int day, int year) {
    setDate(monthString, day, year);
  }

  // removed date method

  public Date(Date aDate) {
    if (aDate == null)// Not a real date.
    {
      System.out.println("Fatal Error.");
      System.exit(0);
    }

    month = aDate.month;
    day = aDate.day;
    year = aDate.year;
  }

  public void setDate(int monthInt, int day, int year) {
    if (dateConfirmed(monthInt, day, year)) {
      this.month = monthString(monthInt);
      this.day = day;
      this.year = year;
    } else {
      System.out.println("Fatal Error");
      System.exit(0);
    }
  }

  public void setDate(String monthString, int day, int year) {
    if (dateOK(monthString, day, year)) {
      this.month = monthString;
      this.day = day;
      this.year = year;
    } else {
      System.out.println("Fatal Error");
      System.exit(0);
    }
  }

  // removed setDate method

  public void setYear(int year) {
    if ((year < 1000) || (year > 9999)) {
      System.out.println("Fatal Error");
      System.exit(0);
    } else
      this.year = year;
  }

  public void setMonth(int monthNumber) {
    if ((monthNumber <= 0) || (monthNumber > 12)) {
      System.out.println("Fatal Error");
      System.exit(0);
    } else
      month = monthString(monthNumber);
  }

  public void setDay(int day) {
    if ((day <= 0) || (day > 31)) {
      System.out.println("Fatal Error");
      System.exit(0);
    } else
      this.day = day;
  }

  // Re-written getMonth() using new Switch statement expression
  public int getMonth() {
    return switch (month) {
      case "January" -> 1;
      case "February" -> 2;
      case "March" -> 3;
      case "April" -> 4;
      case "May" -> 5;
      case "June" -> 6;
      case "July" -> 7;
      case "August" -> 8;
      case "September" -> 9;
      case "October" -> 10;
      case "November" -> 11;
      case "December" -> 12;
      default -> {
        System.out.println("Fatal Error");
        System.exit(0);
        yield 0;
      }
    };
  }

  public int getDay() {
    return day;
  }

  public int getYear() {
    return year;
  }

  public String toString() {
    return (month + " " + day + ", " + year);
  }

  public boolean equals(Date otherDate) {
    return ((month.equals(otherDate.month)) && (day == otherDate.day) && (year == otherDate.year));
  }

  public boolean precedes(Date otherDate) {
    return ((year < otherDate.year) || (year == otherDate.year && getMonth() < otherDate.getMonth())
        || (year == otherDate.year && month.equals(otherDate.month) && day < otherDate.day));
  }

  public void readInput() {
    var tryAgain = true; // changed from type 'boolean'
    var input = new Scanner(System.in); // changed from type 'scanner' //changed name from
                                        // 'keyboard'
    while (tryAgain) {
      System.out.println("Enter month, day, and year.");
      System.out.println("Do not use a comma.");
      var monthInput = input.next(); // changed from type 'String'
      var dayInput = input.nextInt(); // changed from type 'int'
      var yearInput = input.nextInt(); // changed from type 'int'
      if (dateOK(monthInput, dayInput, yearInput)) {
        setDate(monthInput, dayInput, yearInput);
        tryAgain = false;
      } else
        System.out.println("Illegal date. Reenter input.");
    }
  }

  public boolean dateConfirmed(int monthInt, int dayInt, int yearInt) { // changed from 'dateOK'
    return ((monthInt >= 1) && (monthInt <= 12) && (dayInt >= 1) && (dayInt <= 31)
        && (yearInt >= 1000) && (yearInt <= 9999));
  }

  public boolean dateOK(String monthString, int dayInt, int yearInt) {
    return (monthConfirmed(monthString) && (dayInt >= 1) && (dayInt <= 31) && (yearInt >= 1000)
        && (yearInt <= 9999));
  }

  // Re-written monthOK using Switch statement expression
  private boolean monthConfirmed(String month) { // changed from 'monthOK'
    switch (month) {
      case "Janurary", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December":
        return true;
    }
    return true; // not sure if this line (or statement) is entirely correct - have to double check
                 // with prof
  }

  // Re-written monthString() using new Switch statement expression
  private String monthString(int monthNumber) {
    return switch (monthNumber) {
      case 1 -> "January";
      case 2 -> "February";
      case 3 -> "March";
      case 4 -> "April";
      case 5 -> "May";
      case 6 -> "June";
      case 7 -> "July";
      case 8 -> "August";
      case 9 -> "September";
      case 10 -> "October";
      case 11 -> "November";
      case 12 -> "December";
      default -> {
        System.out.println("Fatal Error");
        System.exit(0);
        yield "Error";
      }
    };
  }
}
