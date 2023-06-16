package pa05.model;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.ScheduleEvent;
import cs3500.pa05.model.ScheduleTask;
import cs3500.pa05.model.DayOfWeek;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DayTest {
  private Day day;
  private ScheduleEvent event1;
  private ScheduleEvent event2;
  private ScheduleTask task1;
  private ScheduleTask task2;

  @BeforeEach
  void setUp() {
    // Initialize some ScheduleEvent and ScheduleTask objects for use in tests
    event1 = new ScheduleEvent("Event 1", "Description 1", 10, 30);
    event2 = new ScheduleEvent("Event 2", "Description 2", 11, 30);

    ArrayList<ScheduleEvent> events = new ArrayList<>();
    events.add(event1);
    events.add(event2);

    task1 = new ScheduleTask("Task 1", "Task Description 1", false);
    task2 = new ScheduleTask("Task 2", "Task Description 2", false);

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
  void testGetTasks() {
    ArrayList<ScheduleTask> tasks = day.getTasks();
    assertEquals(2, tasks.size());
    assertTrue(tasks.contains(task1));
    assertTrue(tasks.contains(task2));
  }
}
