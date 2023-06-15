package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ScheduleTask {


  private final String name;
  private final String description;
  private boolean isComplete;

  @JsonCreator
  public ScheduleTask(@JsonProperty("name") String name,
                       @JsonProperty("description") String description,
                       @JsonProperty("complete") boolean isComplete) {
    this.name = name;
    this.description = description;

    this.isComplete = isComplete;
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
}
