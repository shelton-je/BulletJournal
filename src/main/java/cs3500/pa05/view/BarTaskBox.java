package cs3500.pa05.view;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * Represents a user interface component for displaying a task and its completion status in a bar.
 * This class extends the JavaFX HBox class and is designed to be used within a JavaFX application.
 */
public class BarTaskBox extends HBox {

  Label name;
  CheckBox complete;

  /**
   * Constructs a ScheduleTaskBox object and initializes it with the provided task details.
   *
   * @param name        the name of the scheduled task
   */
  public BarTaskBox(String name) {
    this.name = new Label(name);
    complete = new CheckBox();
    this.getChildren().addAll(this.name, complete);
    this.setAlignment(Pos.CENTER);
    this.setStyle("-fx-border-color: black");
  }

  /**
   * Constructs a BarTaskBox with the specified task name and initial completion status.
   *
   * @param name     the name of the task
   * @param complete the initial completion status of the task
   */
  public BarTaskBox(String name, boolean complete) {
    this(name);
    this.complete.setSelected(complete);
  }

  /**
   * Sets an action event handler to the complete checkbox. This handler is invoked whenever
   * the user interacts with the checkbox.
   *
   * @param value the event handler to be set to the complete checkbox
   */
  public void setCompleteAction(javafx.event.EventHandler<javafx.event.ActionEvent> value) {
    complete.setOnAction(value);
  }

  /**
   * Toggles the selection status of the complete checkbox. If it is currently selected, it will
   * become unselected, and vice versa.
   */
  public void toggleComplete() {
    complete.setSelected(!complete.isSelected());
  }
}
