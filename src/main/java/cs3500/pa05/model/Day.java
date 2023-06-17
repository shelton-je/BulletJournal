package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a day in a schedule. Each day is associated with a specific DayOfWeek, and contains
 * a list of ScheduleEvent and ScheduleTask objects that are scheduled to occur on that day.
 */
public class Day {

  private ArrayList<ScheduleEvent> events;
  private ArrayList<ScheduleTask> tasks;
  private final DayOfWeek day;

  /**
   * Constructs a Day object with the specified DayOfWeek, list of events, and list of tasks.
   *
   * @param day the day of the week this Day represents
   * @param events the events scheduled on this day
   * @param tasks the tasks scheduled on this day
   */
  @JsonCreator
  public Day(
      @JsonProperty("day") DayOfWeek day,
      @JsonProperty("events") ArrayList<ScheduleEvent> events,
      @JsonProperty("tasks") ArrayList<ScheduleTask> tasks
      ) {
    this.day = day;
    this.events = events;
    this.tasks = tasks;

  }

  /**
   * Returns the day of the week.
   *
   * @return the day of the week
   */
  public DayOfWeek getDay() {
    return this.day;
  }

  /**
   * Returns the list of events scheduled on this day.
   *
   * @return the list of events
   */
  public ArrayList<ScheduleEvent> getEvents() {
    return this.events;
  }

  /**
   * Returns the list of tasks scheduled on this day.
   *
   * @return the list of tasks
   */
  public ArrayList<ScheduleTask> getTasks() {
    return this.tasks;
  }

}
