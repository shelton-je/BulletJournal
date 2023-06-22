package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents a scheduled event.
 * It includes fields for the event's name, category, description, start time, and duration.
 * The class provides methods to access these properties.
 */
public class ScheduleEvent {

  private String name;
  private String category;
  private String description;
  private String startTime;
  private String duration;

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

  /**
   * Set a name for the current task
   *
   * @param name String object use to get the field
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Set a description of what the task is about
   *
   * @param description String object that describe the task
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Set a category for the current task
   *
   * @param category String object use to set a category
   */
  public void setCategory(String category) {
    this.category = category;
  }

  /**
   * Set when the Event will start
   *
   * @param startTime Take String object of time
   */
  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }


  /**
   * Set a duration of how long the Event will last
   *
   * @param duration String object of the time for duration
   */
  public void setDuration(String duration) {
    this.duration = duration;
  }

}
