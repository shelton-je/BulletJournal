package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeekRecordTest {
  private WeekRecord weekRecord;
  private Week week;

  @BeforeEach
  void setUp() {
    week = new Week("Test Week", 5, 5, new ArrayList<>(), new HashMap<>());
    weekRecord = new WeekRecord(week);
  }

  @Test
  void getWeek() {
    assertEquals(week, weekRecord.getWeek());
  }
}
