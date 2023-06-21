package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.view.ScheduleEventBox;
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
   * Adds a new task to this day's schedule.
   *
   * @param task the task to be added
   */
  public void addTask(ScheduleTask task) {
    tasks.add(task);
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

  /**
   * Returns the number of tasks that are marked as complete.
   *
   * @return the number of complete tasks
   */
  public int numTasksComplete() {
    int numComplete = 0;
    for(ScheduleTask task : tasks) {
      if(task.isComplete()) {
        numComplete += 1;
      }
    }
    return numComplete;
  }

  /**
   * Returns the number of tasks that are marked as incomplete.
   *
   * @return the number of incomplete tasks
   */
  public int numTasksIncomplete() {
    return tasks.size() - numTasksComplete();
  }

  /**
   * Checks if the specified event is scheduled on this day.
   *
   * @param eventToFind the event to find
   * @return true if the event is scheduled on this day, false otherwise
   */
  public boolean hasEvent(ScheduleEvent eventToFind) {
    for(ScheduleEvent event : events) {
      if(event.equals(eventToFind)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Deletes the specified event from this day's schedule.
   *
   * @param event the event to delete
   */
  public void deleteEvent(ScheduleEvent event) {
    events.remove(event);
  }

/**
 * Checks if the specified task is scheduled on this day.
 *
 * @param taskToFind the task to find
 * @return true if the task is scheduled on this day
 */
  public boolean hasTask(ScheduleTask taskToFind) {
    for(ScheduleTask task : tasks) {
      if(task.equals(taskToFind)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Deletes the specified task from this day's schedule.
   *
   * @param task the task to delete
   */
  public void deleteTask(ScheduleTask task) {
    tasks.remove(task);
  }

  /*
  public void updateEvent(ScheduleEvent event) {
    event
  }

   */
}
