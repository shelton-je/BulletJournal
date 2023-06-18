package cs3500.pa05.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * This class represents a user interface component for displaying a scheduled task and its details.
 * The class extends the JavaFX VBox class and is designed to be used within a JavaFX application.
 * Each ScheduleTaskBox consists of labels for the task name, category, and description. Additionally,
 * it includes a checkbox to indicate whether the task is complete and a delete button that allows
 * users to remove the task.
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
   * Constructs a ScheduleTaskBox with the specified task details. The box includes a delete
   * button with an icon loaded from the specified URL.
   *
   * @param name        the name of the task
   * @param category    the category of the task
   * @param description a brief description of the task
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

  /**
   * Constructs a ScheduleTaskBox with the specified task details and the status of the task.
   * The checkbox will be selected if the task is complete.
   *
   * @param name        the name of the task
   * @param category    the category of the task
   * @param description a brief description of the task
   * @param complete    the status of the task
   */
  public ScheduleTaskBox(String name, String category, String description, boolean complete) {
    this(name, category, description);
    this.complete.setSelected(complete);
  }

  /**
   * Toggles the status of the task.
   */
  public void toggleComplete() {
    complete.setSelected(!complete.isSelected());
  }

  /**
   * Sets an action event handler to the checkbox. This handler is invoked whenever the user
   * interacts with the checkbox.
   *
   * @param value the event handler to be set to the checkbox
   */
  public void setCompleteAction(javafx.event.EventHandler<javafx.event.ActionEvent> value) {
    complete.setOnAction(value);
  }

  /**
   * Sets an action event handler to the delete button. This handler is invoked whenever the user
   * interacts with the delete button.
   *
   * @param value the event handler to be set to the delete button
   */
  public void setDeleteAction(javafx.event.EventHandler<javafx.event.ActionEvent> value) {
    deleteButton.setOnAction(value);
  }
}
