package cs3500.pa05.view;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ScheduleEventBox extends VBox {
  Label event = new Label("EVENT");
  Label name;
  Label description;
  Label start;
  Label duration;

  public ScheduleEventBox(String name, String description, String start, String duration) {
    this.name = new Label(name);
    this.description = new Label(description);
    this.start = new Label(start);
    this.duration = new Label(duration);
    this.getChildren().addAll(this.event, this.name, this.description, this.start, this.duration);
    this.setAlignment(Pos.CENTER);
    this.setStyle("-fx-border-color: black");
  }
}
