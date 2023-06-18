package pa05.model.model;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.ScheduleEvent;
import cs3500.pa05.model.ScheduleTask;
import cs3500.pa05.model.DayOfWeek;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class DayTest {
  private Day day;
  private ScheduleEvent event1;
  private ScheduleEvent event2;
  private ScheduleTask task1;
  private ScheduleTask task2;

  @BeforeEach
  void setUp() {
    // Initialize some ScheduleEvent and ScheduleTask objects for use in tests
    event1 = new ScheduleEvent("Event 1", "Category 1", "Description 1", "1000", "0130");
    event2 = new ScheduleEvent("Event 2", "Category 2", "Description 2", "1130", "0130");

    ArrayList<ScheduleEvent> events = new ArrayList<>();
    events.add(event1);
    events.add(event2);

    task1 = new ScheduleTask("Task 1", "Category 1", "Task Description 1", false);
    task2 = new ScheduleTask("Task 2", "Category 2", "Task Description 2", false);

    ArrayList<ScheduleTask> tasks = new ArrayList<>();
    tasks.add(task1);
    tasks.add(task2);

    // Initialize the Day object for use in tests
    day = new Day(DayOfWeek.MONDAY, events, tasks);
  }


  @Test
  void testGetDay() {
    assertEquals(DayOfWeek.MONDAY, day.getDay());
  }

  @Test
  void testGetEvents() {
    ArrayList<ScheduleEvent> events = day.getEvents();
    assertEquals(2, events.size());
    assertTrue(events.contains(event1));
    assertTrue(events.contains(event2));
  }

  @Test
  void testDeleteEvent() {
    assertTrue(day.hasEvent(event1));
    day.deleteEvent(event1);
    assertFalse(day.hasEvent(event1));
  }

  @Test
  void testHasTask() {
    assertTrue(day.hasTask(task1));
    assertFalse(day.hasTask(new ScheduleTask("Task 3", "Category 3", "Task Description 3", false)));
  }

  @Test
  void testGetTasks() {
    ArrayList<ScheduleTask> tasks = day.getTasks();
    assertEquals(2, tasks.size());
    assertTrue(tasks.contains(task1));
    assertTrue(tasks.contains(task2));
  }

  @Test
  void testNumTasksComplete() {
    assertEquals(0, day.numTasksComplete()); // only task2 is complete
  }

  @Test
  void testNumTasksIncomplete() {
    assertEquals(2, day.numTasksIncomplete()); // only task1 is incomplete
  }

  @Test
  void testToggleCompleteTask() {
    ScheduleTask newTask = new ScheduleTask("Task 3", "Category 3", "Task Description 3", false);
    day.addTask(newTask);
    assertEquals(3, day.numTasksIncomplete()); // considering task1 and newTask are incomplete now
    newTask.toggleComplete();
    assertEquals(1, day.numTasksComplete()); // considering task2 and newTask are complete now
    assertEquals(2, day.numTasksIncomplete()); // only task1 is incomplete now
    day.deleteTask(newTask);
    assertEquals(0, day.numTasksComplete()); // only task2 is complete now
    assertEquals(2, day.numTasksIncomplete()); // only task1 is incomplete now
  }
}
