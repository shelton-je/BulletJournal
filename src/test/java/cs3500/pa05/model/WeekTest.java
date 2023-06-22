package cs3500.pa05.model;

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
    ScheduleEvent event1 =
        new ScheduleEvent("Event 1", "Category 1", "Description 1", "1000", "0130");
    ScheduleEvent event2 =
        new ScheduleEvent("Event 2", "Category 2", "Description 2", "1130", "0130");

    ArrayList<ScheduleEvent> events = new ArrayList<>();
    events.add(event1);
    events.add(event2);

    ScheduleTask task1 = new ScheduleTask("Task 1", "Category 1", "Task Description 1", false);
    ScheduleTask task2 = new ScheduleTask("Task 2", "Category 2", "Task Description 2", false);

    ArrayList<ScheduleTask> tasks = new ArrayList<>();
    tasks.add(task1);
    tasks.add(task2);

    // Initialize some Day objects for use in tests
    day1 = new Day(DayOfWeek.MONDAY, events, tasks);
    day2 = new Day(DayOfWeek.TUESDAY, events, tasks);

    Map<DayOfWeek, Day> days = new HashMap<>();
    days.put(DayOfWeek.MONDAY, day1);
    days.put(DayOfWeek.TUESDAY, day2);

    ArrayList<String> categories = new ArrayList<>();
    categories.add("Category 1");
    categories.add("Category 2");

    week = new Week("Test Week", 5, 5, categories, days);
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

  @Test
  void testGetCategories() {
    ArrayList<String> categories = week.getCategories();
    assertEquals(2, categories.size());
    assertTrue(categories.contains("Category 1"));
    assertTrue(categories.contains("Category 2"));
  }

  @Test
  void testAddTask() {
    ScheduleTask task3 = new ScheduleTask("Task 3", "Category 3", "Task Description 3", false);
    week.addTask(DayOfWeek.MONDAY, task3);
    assertTrue(week.getDays().get(DayOfWeek.MONDAY).getTasks().contains(task3));
  }

  @Test
  void testAddEvent() {
    ScheduleEvent event3 =
        new ScheduleEvent("Event 3", "Category 3", "Description 3", "1330", "0200");
    week.addEvent(DayOfWeek.TUESDAY, event3);
    assertTrue(week.getDays().get(DayOfWeek.TUESDAY).getEvents().contains(event3));
  }

  @Test
  void testAddCategory() {
    String newCategory = "Category 3";
    week.addCategory(newCategory);
    assertTrue(week.getCategories().contains(newCategory));
  }

  @Test
  void testDefaultConstructor() {
    Week defaultWeek = new Week();

    assertEquals("", defaultWeek.getName());
    assertEquals(5, defaultWeek.getMaxEvent());
    assertEquals(5, defaultWeek.getMaxTask());

    assertTrue(defaultWeek.getCategories().isEmpty());

    Map<DayOfWeek, Day> days = defaultWeek.getDays();
    assertEquals(7, days.size());

    for (Day day : days.values()) {
      assertTrue(day.getTasks().isEmpty());
      assertTrue(day.getEvents().isEmpty());
    }
  }

  @Test
  void testMaxEvents() {
    assertEquals(5, week.getMaxEvents());

    week.setMaxEvent(8);

    assertEquals(8, week.getMaxEvents());
  }

  @Test
  void testGetMaxEvents() {
    assertEquals(5, week.getMaxEvents());
  }

  @Test
  void testSetMaxEvents() {
    week.setMaxEvent(8);
    assertEquals(8, week.getMaxEvents());
  }

  @Test
  void testGetMaxTasks() {
    assertEquals(5, week.getMaxTasks());
  }

  @Test
  void testSetMaxTasks() {
    week.setMaxTask(7);
    assertEquals(7, week.getMaxTasks());
  }

  @Test
  void testSetName() {
    assertEquals("Test Week", week.getName());

    week.setName("Updated Week Name");

    assertEquals("Updated Week Name", week.getName());
  }
}
