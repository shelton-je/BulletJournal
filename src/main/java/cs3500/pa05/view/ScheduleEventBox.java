package cs3500.pa05.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * This class represents a visual box for a scheduled event in a JavaFX application.
 * It consists of four labels: name, description, start time, and duration of the event.
 */
public class ScheduleEventBox extends VBox {
  Label event = new Label("EVENT");
  ImageView deleteImage = new ImageView(getClass().getClassLoader().getResource(
      "delete_icon.png").toString());
  ImageView saveImage = new ImageView(getClass().getClassLoader().getResource(
      "save_icon.png").toString());
  TextField name;
  Button deleteButton;
  Button saveButton;
  TextField category;
  TextField description;
  TextField start;
  TextField duration;

  /**
   * Constructs a ScheduleEventBox object and initializes it with the provided event details.
   *
   * @param name        the name of the scheduled event
   * @param category    the category of the scheduled event
   * @param description the description of the scheduled event
   * @param start       the start time of the scheduled event
   * @param duration    the duration of the scheduled event
   */
  public ScheduleEventBox(String name, String category, String description, String start,
                          String duration) {
    HBox title = new HBox();
    title.setAlignment(Pos.CENTER);
    deleteButton = new Button();
    deleteImage.setFitHeight(17);
    deleteImage.setFitWidth(17);
    deleteButton.setGraphic(deleteImage);

    saveButton = new Button();
    saveImage.setFitHeight(17);
    saveImage.setFitWidth(17);
    saveButton.setGraphic(saveImage);

    title.getChildren().addAll(this.saveButton, this.event, this.deleteButton);

    this.name = new TextField(name);
    this.category = new TextField(category);
    this.description = new TextField(description);
    this.start = new TextField(start);
    this.duration = new TextField(duration);
    this.getChildren()
        .addAll(title, this.name, this.category, this.description, this.start, this.duration);
    this.setAlignment(Pos.CENTER);
    this.setStyle("-fx-border-color: black");
  }

  /**
   * Sets an action event handler to the delete button. This handler is invoked whenever the user
   * interacts with the delete button.
   *
   * @param value the event handler to be set to the delete button
   */
  public void setDeleteAction(javafx.event.EventHandler<javafx.event.ActionEvent> value) {
    this.deleteButton.setOnAction(value);
  }

  /**
   * Sets an action event handler to the save button. This handler is invoked whenever the user
   * interacts with the save button.
   *
   * @param value the event handler to be set to the delete button
   */
  public void setSaveAction(javafx.event.EventHandler<javafx.event.ActionEvent> value) {
    this.saveButton.setOnAction(value);
  }

  /**
   * returns the name in the text box
   *
   * @return the name as a string
   */
  public String getNameText() {
    return this.name.getText();
  }

  /**
   * gets the category text
   *
   * @return category text
   */
  public String getCategoryText() {
    return this.category.getText();
  }

  /**
   * returns the description text
   *
   * @return returns the description text
   */
  public String getDescriptionText() {
    return this.description.getText();
  }

  /**
   * return the text of the start time
   *
   * @return returns start time text
   */
  public String getStartTimeText() {
    return this.start.getText();
  }

  /**
   * returns the duration text
   *
   * @return duration text
   */
  public String getDurationText() {
    return this.duration.getText();
  }
}
