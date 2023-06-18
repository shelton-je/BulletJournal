package cs3500.pa05.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * This class represents a visual box for a scheduled task in a JavaFX application.
 * It consists of a label for task name and description, and a checkbox to indicate
 * whether the task is complete.
 */
public class ScheduleTaskBox extends VBox {
  Label task = new Label("TASK");
  Button deleteButton;
  ImageView delete_image = new ImageView(getClass().getClassLoader().getResource
      ("delete_icon.png").toString());
  Label name;
  Label category;
  Label description;
  CheckBox complete;

  /**
   * Constructs a ScheduleTaskBox object and initializes it with the provided task details.
   *
   * @param name        the name of the scheduled task
   * @param description the description of the scheduled task
   */
  public ScheduleTaskBox(String name, String category, String description) {
    HBox title = new HBox();
    title.setAlignment(Pos.CENTER);
    deleteButton = new Button();
    delete_image.setFitHeight(20);
    delete_image.setFitWidth(20);
    deleteButton.setGraphic(delete_image);

    title.getChildren().addAll(this.task, this.deleteButton);

    this.name = new Label(name);
    this.category = new Label(category);
    this.description = new Label(description);
    complete = new CheckBox();
    this.getChildren().addAll(title, this.name, this.category, this.description, complete);
    this.setAlignment(Pos.CENTER);
    this.setStyle("-fx-border-color: black");
  }

  public ScheduleTaskBox(String name, String category, String description, boolean complete) {
    this(name, category, description);
    this.complete.setSelected(complete);
  }

  public void toggleComplete() {
    complete.setSelected(!complete.isSelected());
  }

  public void setCompleteAction(javafx.event.EventHandler<javafx.event.ActionEvent> value) {
    complete.setOnAction(value);
  }

  public void setDeleteAction(javafx.event.EventHandler<javafx.event.ActionEvent> value) {
    deleteButton.setOnAction(value);
  }
}
