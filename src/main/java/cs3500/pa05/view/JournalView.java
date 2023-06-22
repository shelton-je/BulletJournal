package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import cs3500.pa05.controller.JournalController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;


/**
 * This class represents the view component of a journal application in a MVC architecture.
 * It helps in setting up the GUI by loading a specified FXML file and setting the specified
 * controller as the controller for the loaded FXML file.
 */
public class JournalView {
  FXMLLoader loader;

  /**
   * Constructs a JournalView object and initializes it with the specified controller and FXML file.
   *
   * @param jc   the controller that should be set as the controller for the FXML file
   * @param fxml the FXML file that should be loaded to create the GUI
   */
  public JournalView(Controller jc, String fxml) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource(fxml));

    this.loader.setController(jc);
  }

  /**
   * Loads a scene for the journal application from an FXML file.
   *
   * @return the loaded scene
   * @throws IllegalStateException if there is an error during loading the FXML file
   */
  public Scene load() throws IllegalStateException {

    try {
      return this.loader.load();
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }
}
