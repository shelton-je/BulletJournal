package cs3500.pa05.model;

public class ScheduleTask implements ScheduleItem{

  private final boolean isComplete;

  public ScheduleTask(boolean isComplete) {
    this.isComplete = isComplete;
  }

  public boolean getCompelete() {
    return false;
  }

  @Override
  public String name() {
    return "";
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
