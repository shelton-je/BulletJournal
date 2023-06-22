package cs3500.pa05.controller;

import cs3500.pa05.view.JournalView;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Controller for managing tabs in a user interface.
 * Each tab corresponds to a JournalController.
 */
public class TabsController {
  private final ArrayList<JournalController> controllers = new ArrayList<>();

  /**
   * Returns the list of JournalControllers representing the tabs.
   *
   * @return the list of JournalControllers
   */
  public ArrayList<JournalController> getTabs() {
    return this.controllers;
  }


  /**
   * Adds a JournalController to the list of tabs.
   *
   * @param jc the JournalController to add
   */
  public void addController(JournalController jc) {
    this.controllers.add(jc);
  }

  /**
   * creates a new tab with a controller
   *
   * @param s the stage to give the controller
   */
  public void createNewTab(Stage s) {
    this.controllers.add(new JournalController(s, this));
  }

  /**
   * switch to a different tab
   *
   * @param jc the controller to switch too
   * @param s the stage top display on
   */
  public void switchTab(JournalController jc, Stage s) {
    JournalView jv = new JournalView(jc, "journal.fxml");
    Scene scene = jv.load();
    jc.run();
    s.setScene(scene);
  }
}
