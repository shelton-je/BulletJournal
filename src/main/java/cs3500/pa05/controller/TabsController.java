package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import cs3500.pa05.view.JournalView;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TabsController {
  private ArrayList<JournalController> controllers = new ArrayList<>();

  public ArrayList<JournalController> getTabs() {
    return this.controllers;
  }

  public void addController(JournalController jc) {
    this.controllers.add(jc);
  }
  public void createNewTab(Stage s) {
    this.controllers.add(new JournalController(s, this));
  }

  public void switchTab(JournalController jc, Stage s) {
    JournalView jv = new JournalView(jc, "journal.fxml");
    Scene scene = jv.load();
    jc.run();
    s.setScene(scene);
  }
}
