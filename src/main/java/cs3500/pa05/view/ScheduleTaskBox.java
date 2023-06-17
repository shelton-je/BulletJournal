package cs3500.pa05.view;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ScheduleTaskBox extends VBox {
  Label task = new Label("TASK");
  Label name;
  Label description;
  CheckBox complete;

  public ScheduleTaskBox(String name, String description){
    this.name = new Label(name);
    this.description = new Label(description);
    complete = new CheckBox();
    this.getChildren().addAll(this.task, this.name, this.description, complete);
    this.setAlignment(Pos.CENTER);
    this.setStyle("-fx-border-color: black");
  }
}
