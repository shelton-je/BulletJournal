package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DayOfWeekTest {

  @Test
  void testToString() {
    assertEquals("Sunday", DayOfWeek.SUNDAY.toString());
    assertEquals("Monday", DayOfWeek.MONDAY.toString());
    assertEquals("Tuesday", DayOfWeek.TUESDAY.toString());
    assertEquals("Wednesday", DayOfWeek.WEDNESDAY.toString());
    assertEquals("Thursday", DayOfWeek.THURSDAY.toString());
    assertEquals("Friday", DayOfWeek.FRIDAY.toString());
    assertEquals("Saturday", DayOfWeek.SATURDAY.toString());
  }

  @Test
  void values() {
    DayOfWeek[] expected = {DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY,
        DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY};
    assertArrayEquals(expected, DayOfWeek.values());
  }

  @Test
  void valueOf() {
    assertEquals(DayOfWeek.MONDAY, DayOfWeek.valueOf("MONDAY"));
    assertEquals(DayOfWeek.TUESDAY, DayOfWeek.valueOf("TUESDAY"));
    assertEquals(DayOfWeek.WEDNESDAY, DayOfWeek.valueOf("WEDNESDAY"));
    assertEquals(DayOfWeek.THURSDAY, DayOfWeek.valueOf("THURSDAY"));
    assertEquals(DayOfWeek.FRIDAY, DayOfWeek.valueOf("FRIDAY"));
    assertEquals(DayOfWeek.SATURDAY, DayOfWeek.valueOf("SATURDAY"));
    assertEquals(DayOfWeek.SUNDAY, DayOfWeek.valueOf("SUNDAY"));
  }
}
