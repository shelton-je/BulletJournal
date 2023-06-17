package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ScheduleEvent {

  private final String name;
  private final String description;
  private final String startTime;
  private final String duration;

  @JsonCreator
  public ScheduleEvent(@JsonProperty("name") String name,
                       @JsonProperty("description") String description,
                       @JsonProperty("start") String startTime,
                       @JsonProperty("duration") String duration) {
    this.name = name;
    this.description = description;
    this.startTime = startTime;
    this.duration = duration;
  }

  public String getDescription() {
    return this.description;
  }

  public String getName() {
    return this.name;
  }

  public String getStartTime() {
    return this.startTime;
  }

  public String getDuration() {
    return this.duration;
  }

}
