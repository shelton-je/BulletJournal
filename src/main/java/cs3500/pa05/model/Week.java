package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public class Week {
  private String name;
  private int maxEvent;
  private int maxTask;
  private ArrayList<Day> days;


  @JsonCreator
  public Week(@JsonProperty("name") String name, @JsonProperty("max-events") int maxEvent,
              @JsonProperty("max-tasks") int maxTask, @JsonProperty("days") ArrayList<Day> days) {
    this.name = name;
    this.maxTask = maxTask;
    this.maxEvent = maxEvent;
    this.days = days;


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

  public ArrayList<Day> getDays() {
    return this.days;
  }
}
