package cs3500.pa05.model;


/**
 * Enumerates the days of a week. This enum is used to represent days of the week in the scheduling
 * application, and it can take the values MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY,
 * and SUNDAY.
 */
public enum DayOfWeek {

  /**
   * Represents Monday.
   */
  MONDAY,

  /**
   * Represents Tuesday.
   */
  TUESDAY,

  /**
   * Represents Wednesday.
   */
  WEDNESDAY,

  /**
   * Represents Thursday.
   */
  THURSDAY,

  /**
   * Represents Friday.
   */
  FRIDAY,

  /**
   * Represents Saturday.
   */
  SATURDAY,

  /**
   * Represents Sunday.
   */
  SUNDAY;

  public String toString() {
    switch (this) {
      case SUNDAY -> {
        return "Sunday";
      }
      case MONDAY -> {
        return "Monday";
      }
      case TUESDAY -> {
        return "Tuesday";
      }
      case WEDNESDAY -> {
        return "Wednesday";
      }
      case THURSDAY -> {
        return "Thursday";
      }
      case FRIDAY -> {
        return "Friday";
      }
      default -> {
        return "Saturday";
      }
    }
  }
}
