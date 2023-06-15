package cs3500.pa05.model;

import java.util.ArrayList;

public class WeekModel {
  ArrayList<DayModel> days;
  ArrayList<String> possibleCategories;

  public WeekModel(ArrayList<DayModel> days, ArrayList<String> possibleCategories) {
    this.days = new ArrayList<>(days);
    this.possibleCategories = new ArrayList<>(possibleCategories);
  }

  public ArrayList<DayModel> getDays() {
    return this.days;
  }

  public ArrayList<String> getPossibleCategories() {
    return this.possibleCategories;
  }

  public boolean categoryExists(String category) {
    return this.possibleCategories.contains(category);
  }
}
