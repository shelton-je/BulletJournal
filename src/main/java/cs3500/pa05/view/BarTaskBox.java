package cs3500.pa05.view;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
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

  public BarTaskBox(String name, boolean complete) {
    this(name);
    this.complete.setSelected(complete);
  }

  public void setCompleteAction(javafx.event.EventHandler<javafx.event.ActionEvent> value) {
    complete.setOnAction(value);
  }

  public void toggleComplete() {
    complete.setSelected(!complete.isSelected());
  }
}
