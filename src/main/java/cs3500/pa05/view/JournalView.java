package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import cs3500.pa05.controller.JournalController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class JournalView {
  FXMLLoader loader;

  public JournalView(Controller jc, String fxml) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource(fxml));

    this.loader.setController(jc);
  }
  /**
   * Loads a scene from a Whack-a-Mole GUI layout.
   *
   * @return the layout
   */
  public Scene load() throws IllegalStateException {

    try {
      return this.loader.load();
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }
}
