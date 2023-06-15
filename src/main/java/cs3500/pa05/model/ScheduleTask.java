package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ScheduleTask implements ScheduleItem{


  private final String name;
  private final String description;
  private final DaysOfWeek day;
  private boolean isComplete;

  @JsonCreator
  public ScheduleTask(@JsonProperty("name") String name,
                       @JsonProperty("description") String description,
                       @JsonProperty("day") DaysOfWeek day,
                       @JsonProperty("complete") boolean isComplete) {
    this.name = name;
    this.description = description;
    this.day = day;
    this.isComplete = isComplete;
  }

  public DaysOfWeek getDay() {
    return day;
  }

  public String getDescription() {
    return description;
  }

  public String getName() {
    return name;
  }

  public boolean isComplete() {
    return isComplete;
  }

  @Override
  public String getInfo() {
    return null;
  }

}
