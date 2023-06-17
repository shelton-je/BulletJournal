package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class is a Java Record that encapsulates a Week object. This can be used for
 * serialization/deserialization with JSON, to encapsulate the week information within another
 * object, providing an additional layer of hierarchy or structure.
 */
public record WeekRecord(
    @JsonProperty("week") Week week) {

  /**
   * Retrieves the encapsulated Week object.
   *
   * @return the encapsulated Week object
   */
  public Week getWeek() {
    return this.week;
  }
}

