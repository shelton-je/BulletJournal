package pa05.model;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayOfWeek;
import cs3500.pa05.model.ScheduleEvent;
import cs3500.pa05.model.ScheduleTask;
import cs3500.pa05.model.Week;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class WeekTest {
  private Week week;
  private Day day1;
  private Day day2;
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

    // Initialize some Day objects for use in tests
    day1 = new Day(DayOfWeek.MONDAY, events, tasks);
    day2 = new Day(DayOfWeek.TUESDAY, events, tasks);

    ArrayList<Day> days = new ArrayList<>();
    days.add(day1);
    days.add(day2);

    week = new Week("Test Week", 5, 5, days);
  }

  @Test
  void testGetName() {
    assertEquals("Test Week", week.getName());
  }

  @Test
  void testGetMaxEvent() {
    assertEquals(5, week.getMaxEvent());
  }

  @Test
  void testGetMaxTask() {
    assertEquals(5, week.getMaxTask());
  }

  @Test
  void testGetDays() {
    ArrayList<Day> days = week.getDays();
    assertEquals(2, days.size());
    assertTrue(days.contains(day1));
    assertTrue(days.contains(day2));
  }
}
