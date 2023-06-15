package cs3500.pa05;


import cs3500.pa05.controller.JournalController;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayOfWeek;
import cs3500.pa05.model.ScheduleEvent;
import cs3500.pa05.model.ScheduleTask;
import cs3500.pa05.view.JournalView;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Represents a Java journal
 */
public class Driver extends Application {
  /**
   * Starts the GUI for a game of Whack-A-Mole.
   *
   * @param stage the JavaFX stage to add elements to
   */
  @Override
  public void start(Stage stage) {
    JournalController JournalController = new JournalController();
    JournalView JournalView  = new JournalView(JournalController);


    try {
      // load and place the view's scene onto the stage
      Scene scene = JournalView.load();
      stage.setScene(scene);
      JournalController.run();
      // render the stage
      stage.show();
    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }
  }
  /**
   * Entry point for java Journal
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
   launch();
  }
}