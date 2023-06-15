package cs3500.pa05.model;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class DayModel {

  int maxEvent;
  int maxTasks;
  ArrayList<ScheduleEvent> events;
  ArrayList<ScheduleTask> tasks;
  DaysOfWeek days;

  public DayModel(int maxEvent, int maxTasks, ArrayList<ScheduleEvent> events, ArrayList<ScheduleTask> task, DaysOfWeek days){
    this.maxEvent = maxEvent;
    this.maxTasks = maxTasks;
    this.events = new ArrayList<>();
    this.tasks = new ArrayList<>();
    this.days = days;
  }

  public int getMaxEvent() {
    return this.maxEvent;
  }

  public int getMaxTasks() {
    return this.maxTasks;
  }

  public ArrayList<ScheduleEvent> getEvents() {
    return new ArrayList<>(this.events);
  }

  public ArrayList<ScheduleTask> getTask() {
    return new ArrayList<>(this.tasks);
  }

  public DaysOfWeek getDay() {
    return this.days;
  }
}
