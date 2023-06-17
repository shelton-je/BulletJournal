package pa05.model;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayOfWeek;
import cs3500.pa05.model.ScheduleEvent;
import cs3500.pa05.model.ScheduleTask;
import cs3500.pa05.model.Week;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class WeekTest {
  private Week week;
  private Day day1;
  private Day day2;

  @BeforeEach
  void setUp() {
    // Initialize some ScheduleEvent and ScheduleTask objects for use in tests
    ScheduleEvent event1 = new ScheduleEvent("Event 1", "Description 1", "1000", "0130");
    ScheduleEvent event2 = new ScheduleEvent("Event 2", "Description 2", "1130", "0130");

    ArrayList<ScheduleEvent> events = new ArrayList<>();
    events.add(event1);
    events.add(event2);

    ScheduleTask task1 = new ScheduleTask("Task 1", "Task Description 1", false);
    ScheduleTask task2 = new ScheduleTask("Task 2", "Task Description 2", false);

    ArrayList<ScheduleTask> tasks = new ArrayList<>();
    tasks.add(task1);
    tasks.add(task2);

    // Initialize some Day objects for use in tests
    day1 = new Day(DayOfWeek.MONDAY, events, tasks);
    day2 = new Day(DayOfWeek.TUESDAY, events, tasks);

    Map<DayOfWeek, Day> days = new HashMap<>();
    days.put(DayOfWeek.MONDAY, day1);
    days.put(DayOfWeek.TUESDAY, day2);

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
    Map<DayOfWeek, Day> days = week.getDays();
    assertEquals(2, days.size());
    assertTrue(days.containsValue(day1));
    assertTrue(days.containsValue(day2));
  }
}
