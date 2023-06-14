package cs3500.pa05.model;

public interface ScheduleItem {

  String name();

  String description();

  DaysOfWeek day();

  String category();
}
