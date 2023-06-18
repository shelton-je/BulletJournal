package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents a scheduled event.
 * It includes fields for the event's name, category, description, start time, and duration.
 * The class provides methods to access these properties.
 */
public class ScheduleEvent {

  private final String name;
  private final String category;
  private final String description;
  private final String startTime;
  private final String duration;

  /**
   * Constructs a new ScheduleEvent with the given parameters.
   *
   * @param name        the name of the event
   * @param category    the category of the event
   * @param description a brief description of the event
   * @param startTime   the time the event starts
   * @param duration    the duration of the event
   */
  @JsonCreator
  public ScheduleEvent(@JsonProperty("name") String name,
                       @JsonProperty("category") String category,
                       @JsonProperty("description") String description,
                       @JsonProperty("start") String startTime,
                       @JsonProperty("duration") String duration) {
    this.name = name;
    this.category = category;
    this.description = description;
    this.startTime = startTime;
    this.duration = duration;
  }

  /**
   * Returns the description of the event.
   *
   * @return the description of the event
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Returns the name of the event.
   *
   * @return the name of the event
   */
  public String getName() {
    return this.name;
  }

  /**
   * Returns the category of the event.
   *
   * @return the category of the event
   */
  public String getCategory() {
    return category;
  }

  /**
   * Returns the start time of the event.
   *
   * @return the start time of the event
   */
  public String getStartTime() {
    return this.startTime;
  }

  /**
   * Returns the duration of the event.
   *
   * @return the duration of the event
   */
  public String getDuration() {
    return this.duration;
  }

}
