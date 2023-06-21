package cs3500.pa05.controller;

import cs3500.pa05.view.JournalView;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SplashContoller implements Controller{
  private Stage stage;
  private Scene weekScene;
  @FXML
  private Label transition;

  public SplashContoller(Stage stage, Scene weekScene) {
    this.stage = stage;
    this.weekScene = weekScene;
  }

  public void loadSplashScreen() {
   JournalView jv = new JournalView(this, "Splash.fxml");
   Scene scene = jv.load();
   stage.setScene(scene);
    //Load splash screen with fade in effect
    FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), transition);
    fadeIn.setFromValue(0);
    fadeIn.setToValue(1);
    fadeIn.setCycleCount(1);

    //Finish splash with fade out effect
    FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), transition);
    fadeOut.setFromValue(1);
    fadeOut.setToValue(0);
    fadeOut.setCycleCount(1);

    fadeIn.play();

    //After fade in, start fade out
    fadeIn.setOnFinished((e) -> {
      fadeOut.play();
    });
    fadeOut.setOnFinished(e ->  stage.setScene(weekScene));
  }
}
