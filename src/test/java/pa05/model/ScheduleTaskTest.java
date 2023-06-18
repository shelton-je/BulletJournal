package pa05.model;

import cs3500.pa05.model.ScheduleTask;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ScheduleTaskTest {
  private ScheduleTask task;

  @Before
  public void setUp() {
    task = new ScheduleTask("Test task", "Test category", "Test description", false);
  }

  @Test
  public void testGetName() {
    assertEquals("Test task", task.getName());
  }

  @Test
  public void testGetCategory() {
    assertEquals("Test category", task.getCategory());
  }

  @Test
  public void testGetDescription() {
    assertEquals("Test description", task.getDescription());
  }

  @Test
  public void testIsComplete() {
    assertFalse(task.isComplete());
  }

  @Test
  public void testToggleComplete() {
    assertFalse(task.isComplete());
    task.toggleComplete();
    assertTrue(task.isComplete());
    task.toggleComplete();
    assertFalse(task.isComplete());
  }
}