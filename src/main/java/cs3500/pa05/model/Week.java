package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a week in a scheduling context. The Week class contains a name, the maximum number
 * of events and tasks that can be assigned, and a map of days each with their assigned tasks and
 * events. It is equipped to handle adding tasks and events to specific days.
 */
public class Week {
  private String name;
  private int maxEvent;
  private int maxTask;
  private ArrayList<String> categories;
  private Map<DayOfWeek, Day> days;


  /**
   * Constructs a new instance of Week with the provided parameters.
   *
   * @param name       the name of the week
   * @param maxEvent   the maximum number of events that can be assigned in this week
   * @param maxTask    the maximum number of tasks that can be assigned in this week
   * @param categories the list of categories available for events
   * @param days       a map of the days of the week and their corresponding Day objects
   */
  @JsonCreator
  public Week(@JsonProperty("name") String name, @JsonProperty("max-events") int maxEvent,
              @JsonProperty("max-tasks") int maxTask,
              @JsonProperty("categories") ArrayList<String> categories,
              @JsonProperty("days") Map<DayOfWeek, Day> days) {
    this.name = name;
    this.maxTask = maxTask;
    this.maxEvent = maxEvent;
    this.categories = categories;
    this.days = days;
  }

  /**
   * Constructs a default instance of Week, with the name as an empty string, maximum tasks and events
   * set to 5, and days as a populated map with the seven days of the week each associated with a new Day
   * instance with empty tasks and events.
   */
  public Week() {
    this.name = "";
    this.maxEvent = 5;
    this.maxTask = 5;
    this.categories = new ArrayList<>();
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

  /**
   * Retrieves the name of the week.
   *
   * @return the name of the week
   */
  public String getName() {
    return name;
  }

  /**
   * Retrieves the maximum number of events that can be assigned in the week.
   *
   * @return the maximum number of events
   */
  public int getMaxEvent() {
    return maxEvent;
  }

  /**
   * Retrieves the maximum number of tasks that can be assigned in the week.
   *
   * @return the maximum number of tasks
   */
  public int getMaxTask() {
    return maxTask;
  }

  /**
   * Retrieves a map of the days of the week with their corresponding Day objects.
   *
   * @return the map of days
   */
  public Map<DayOfWeek, Day> getDays() {
    return this.days;
  }

  /**
   * Adds a task to a specific day in the week.
   *
   * @param dayOfWeek the day to add the task to
   * @param task      the task to be added
   */
  public void addTask(DayOfWeek dayOfWeek, ScheduleTask task) {
    this.days.get(dayOfWeek).getTasks().add(task);
  }

  /**
   * Adds an event to a specific day in the week.
   *
   * @param dayOfWeek the day to add the event to
   * @param event     the event to be added
   */
  public void addEvent(DayOfWeek dayOfWeek, ScheduleEvent event) {
    this.days.get(dayOfWeek).getEvents().add(event);
  }

  /**
   * Adds the given String to the list of categories for this week
   *
   * @param category the String to add to the list
   */
  public void addCategory(String category) {
    this.categories.add(category);
  }

  /**
   * Returns the list of categories for this week
   *
   * @return the list of categories
   */
  public ArrayList<String> getCategories() {
    return this.categories;
  }

  /**
   * Sets the name of the week.
   *
   * @param s the name to set for the week
   */
  public void setName(String s) {
    this.name = s;
  }

  /**
   * Returns the max events per day for this week.
   *
   * @return the max events per day
   */
  public int getMaxEvents() { return this.maxEvent; }

  /**
   * Sets the max events per day for the week.
   *
   * @param newMax the new max to which to set the max events per day
   */
  public void setMaxEvent(int newMax) { this.maxEvent = newMax; }

  /**
   * Returns the max tasks per day for this week.
   *
   * @return the max tasks per day
   */
  public int getMaxTasks() { return this.maxTask; }

  /**
   * Sets the max tasks per day for the week.
   *
   * @param newMax the new max to which to set the max tasks per day
   */
  public void setMaxTask(int newMax) { this.maxTask = newMax; }
}
