package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Duration;
import java.time.LocalTime;

public class ScheduleEvent implements ScheduleItem{

  private final String name;
  private final String description;
  private final DaysOfWeek day;
  private final int startTime;
  private final int duration;

  @JsonCreator
  public ScheduleEvent(@JsonProperty("name") String name,
                       @JsonProperty("description") String description,
                       @JsonProperty("day") DaysOfWeek day,
                       @JsonProperty("start") int startTime,
                       @JsonProperty("duration") int duration) {
    this.name = name;
    this.description = description;
    this.day = day;
    this.startTime = startTime;
    this.duration = duration;
  }

  public int getStartTime() {
    return this.startTime;
  }

  public int getDuration() {
    return this.duration;
  }

  public DaysOfWeek getDay() {
    return this.day;
  }

  public String getDescription() {
    return this.description;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public String getInfo() {
    return null;
  }
}
