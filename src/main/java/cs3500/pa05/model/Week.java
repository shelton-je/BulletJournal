package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Week {
  private String name;
  private int maxEvent;
  private int maxTask;
  private Map<DayOfWeek, Day> days;


  @JsonCreator
  public Week(@JsonProperty("name") String name, @JsonProperty("max-events") int maxEvent,
              @JsonProperty("max-tasks") int maxTask,
              @JsonProperty("days") Map<DayOfWeek, Day> days) {
    this.name = name;
    this.maxTask = maxTask;
    this.maxEvent = maxEvent;
    this.days = days;
  }

  public Week() {
    this.name = "";
    this.maxEvent = 5;
    this.maxTask = 5;
    this.days = new HashMap<>();
    days.put(DayOfWeek.SUNDAY, new Day(DayOfWeek.SUNDAY, new ArrayList<>(), new ArrayList<>()));
    days.put(DayOfWeek.MONDAY, new Day(DayOfWeek.MONDAY, new ArrayList<>(), new ArrayList<>()));
    days.put(DayOfWeek.TUESDAY, new Day(DayOfWeek.TUESDAY, new ArrayList<>(), new ArrayList<>()));
    days.put(DayOfWeek.WEDNESDAY,
        new Day(DayOfWeek.WEDNESDAY, new ArrayList<>(), new ArrayList<>()));
    days.put(DayOfWeek.THURSDAY, new Day(DayOfWeek.THURSDAY, new ArrayList<>(), new ArrayList<>()));
    days.put(DayOfWeek.FRIDAY, new Day(DayOfWeek.FRIDAY, new ArrayList<>(), new ArrayList<>()));
    days.put(DayOfWeek.SATURDAY, new Day(DayOfWeek.SATURDAY, new ArrayList<>(), new ArrayList<>()));
  }

  public String getName() {
    return name;
  }

  public int getMaxEvent() {
    return maxEvent;
  }

  public int getMaxTask() {
    return maxTask;
  }

  public Map<DayOfWeek, Day> getDays() {
    return this.days;
  }

  public void addTask(DayOfWeek dayOfWeek, ScheduleTask task) {
    this.days.get(dayOfWeek).getTasks().add(task);
  }

  public void addEvent(DayOfWeek dayOfWeek, ScheduleEvent event) {
      this.days.get(dayOfWeek).getEvents().add(event);
    }
}
