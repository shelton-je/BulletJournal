package cs3500.pa05.view;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * This class represents a visual box for a scheduled event in a JavaFX application.
 * It consists of four labels: name, description, start time, and duration of the event.
 */
public class ScheduleEventBox extends VBox {
  Label event = new Label("EVENT");
  Label name;
  Label category;
  Label description;
  Label start;
  Label duration;

  /**
   * Constructs a ScheduleEventBox object and initializes it with the provided event details.
   *
   * @param name        the name of the scheduled event
   * @param description the description of the scheduled event
   * @param start       the start time of the scheduled event
   * @param duration    the duration of the scheduled event
   */
  public ScheduleEventBox(String name, String category, String description, String start, String duration) {
    this.name = new Label(name);
    this.category = new Label(category);
    this.description = new Label(description);
    this.start = new Label(start);
    this.duration = new Label(duration);
    this.getChildren().addAll(this.event, this.name, this.category, this.description, this.start, this.duration);
    this.setAlignment(Pos.CENTER);
    this.setStyle("-fx-border-color: black");
  }
}
