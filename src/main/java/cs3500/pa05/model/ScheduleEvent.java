package cs3500.pa05.model;

import java.time.Duration;
import java.time.LocalTime;

public class ScheduleEvent implements ScheduleItem{

  private final LocalTime startTime;

  private final Duration duration;

  public ScheduleEvent(LocalTime startTime, Duration duration) {
    this.startTime = startTime;
    this.duration = duration;
  }

  public LocalTime getStartTime() {
    return this.startTime;
  }

  public Duration getDuration() {
    return this.duration;
  }
  @Override
  public String name() {
    return null;
  }

  @Override
  public String description() {
    return null;
  }

  @Override
  public DaysOfWeek day() {
    return null;
  }

  @Override
  public String category() {
    return null;
  }
}
