package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ScheduleEvent {

  private final String name;
  private final String description;
  private final int startTime;
  private final int duration;

  @JsonCreator
  public ScheduleEvent(@JsonProperty("name") String name,
                       @JsonProperty("description") String description,
                       @JsonProperty("start") int startTime,
                       @JsonProperty("duration") int duration) {
    this.name = name;
    this.description = description;
    this.startTime = startTime;
    this.duration = duration;
  }

  public int getStartTime() {
    return this.startTime;
  }

  public int getDuration() {
    return this.duration;
  }

  public String getDescription() {
    return this.description;
  }

  public String getName() {
    return this.name;
  }

}
