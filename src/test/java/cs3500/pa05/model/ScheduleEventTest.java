package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ScheduleEventTest {
  private ScheduleEvent event;

  @BeforeEach
  void setUp() {
    event =
        new ScheduleEvent("Test event", "Test category", "Test description", "10:00", "2 hours");
  }

  @Test
  void getDescription() {
    assertEquals("Test description", event.getDescription());
  }

  @Test
  void getName() {
    assertEquals("Test event", event.getName());
  }

  @Test
  void getCategory() {
    assertEquals("Test category", event.getCategory());
  }

  @Test
  void getStartTime() {
    assertEquals("10:00", event.getStartTime());
  }

  @Test
  void getDuration() {
    assertEquals("2 hours", event.getDuration());
  }
}
