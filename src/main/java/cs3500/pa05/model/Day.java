package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;


public class Day {


  private List<ScheduleEvent> events;
  private List<ScheduleTask> tasks;
  private final DayOfWeek day;

  @JsonCreator
  public Day(
      @JsonProperty("day") DayOfWeek day,
      @JsonProperty("events") ArrayList<ScheduleEvent> events,
      @JsonProperty("taks") ArrayList<ScheduleTask> tasks
      ) {
    this.day = day;
    this.events = events;
    this.tasks = tasks;

  }

  public DayOfWeek getDay() {
    return this.day;
  }

  public ArrayList<ScheduleEvent> getEvents() {
    return new ArrayList<>(this.events);
  }

  public ArrayList<ScheduleTask> getTasks() {
    return new ArrayList<>(this.tasks);
  }

}
