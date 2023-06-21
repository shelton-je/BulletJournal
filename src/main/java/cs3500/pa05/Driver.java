package cs3500.pa05;

import cs3500.pa05.controller.JournalController;
import cs3500.pa05.controller.SplashContoller;
import cs3500.pa05.controller.TabsController;
import cs3500.pa05.view.JournalView;
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
    TabsController tc = new TabsController();
    JournalController journalController = new JournalController(stage, tc);
    tc.addController(journalController);
    JournalView journalView  = new JournalView(journalController, "journal.fxml");



    try {
      // load and place the view's scene onto the stage
      Scene scene = journalView.load();
      journalController.run();
      stage.setScene(scene);
      // render the stage
      SplashContoller sc = new SplashContoller(stage, scene);
      stage.show();
      sc.loadSplashScreen();
    } catch (IllegalStateException exc) {
      System.err.println(exc);

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