package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ScheduleTaskTest {
  private ScheduleTask task;
  @BeforeEach
  void setUp() {
    task = new ScheduleTask("Test task", "Test category", "Test description", false);

  }

  @Test
  void getDescription() {
    assertEquals("Test description", task.getDescription());
  }

  @Test
  void getName() {
    assertEquals("Test task", task.getName());

  }

  @Test
  void getCategory() {
    assertEquals("Test category", task.getCategory());

  }

  @Test
  void isComplete() {
    assertFalse(task.isComplete());
  }

  @Test
  void toggleComplete() {
    assertFalse(task.isComplete());
    task.toggleComplete();
    assertTrue(task.isComplete());
    task.toggleComplete();
    assertFalse(task.isComplete());
  }
}