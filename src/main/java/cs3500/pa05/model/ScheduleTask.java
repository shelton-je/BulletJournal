package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a task in a scheduling context. The ScheduleTask class contains a name, a description,
 * and a flag indicating whether the task is complete.
 */
public class ScheduleTask {
  private String name;
  private String category;
  private String description;
  private boolean isComplete;

  /**
   * Constructs a new instance of ScheduleTask with the provided parameters.
   *
   * @param name        the name of the task
   * @param category    type of categories task can be in
   * @param description a description of the task
   * @param isComplete  a boolean flag indicating if the task is complete
   */
  @JsonCreator
  public ScheduleTask(@JsonProperty("name") String name,
                       @JsonProperty("category") String category,
                       @JsonProperty("description") String description,
                       @JsonProperty("complete") boolean isComplete) {
    this.name = name;
    this.description = description;
    this.category = category;
    this.isComplete = isComplete;
  }

  /**
   * Retrieves the description of the task.
   *
   * @return the description of the task
   */
  public String getDescription() {
    return description;
  }

  /**
   * Retrieves the name of the task.
   *
   * @return the name of the task
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the category of the event.
   *
   * @return the category of the event
   */
  public String getCategory() {
    return category;
  }

  /**
   * Checks if the task is complete.
   *
   * @return a boolean value indicating if the task is complete
   */
  public boolean isComplete() {
    return isComplete;
  }

  /**
   * Toggles the completion status of the event.
   * If the event is complete, it will be marked as incomplete, and vice versa.
   */
  public void toggleComplete() {
    isComplete = !isComplete;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}
