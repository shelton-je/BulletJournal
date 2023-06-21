package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import java.util.ArrayList;

public class TabsController {
  private ArrayList<JournalController> controllers = new ArrayList<>();

  public void addController(JournalController jc) {
    this.controllers.add(jc);
  }

  public ArrayList<JournalController> getTabs() {
    return this.controllers;
  }
}
