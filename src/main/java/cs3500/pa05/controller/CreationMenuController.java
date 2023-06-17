package cs3500.pa05.controller;

import cs3500.pa05.model.DayOfWeek;
import cs3500.pa05.model.ScheduleEvent;
import cs3500.pa05.model.ScheduleTask;
import cs3500.pa05.model.Week;
import cs3500.pa05.view.JournalView;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreationMenuController implements Controller {
  private DayOfWeek day;
  private Week week;
  private Stage stage;

  @FXML
  private Button eventCreateButton;
  @FXML
  private Button taskCreateButton;
  @FXML
  private TextField eventName;
  @FXML
  private TextField taskName;
  @FXML
  private TextField eventDescription;
  @FXML
  private TextField taskDescription;
  @FXML
  private TextField eventStart;
  @FXML
  private TextField eventDuration;

  CreationMenuController(DayOfWeek day, Week week, Stage stage) {
    this.day = day;
    this.week = week;
    this.stage = stage;
  }

  public void run() {
    eventCreateButton.setOnAction(e -> handleEventCreation());
    taskCreateButton.setOnAction(e -> handleTaskCreation());
  }

  private void handleEventCreation() {
    ScheduleEvent event = new ScheduleEvent(eventName.getText(), eventDescription.getText(),
        eventStart.getText(), eventDuration.getText());
    week.addEvent(day, event);
    switchScene();
  }

  private void handleTaskCreation() {
    ScheduleTask task = new ScheduleTask(taskName.getText(), taskDescription.getText(), false);
    week.addTask(day, task);
    switchScene();
  }

  private void switchScene() {
    JournalController controller = new JournalController(stage, week);
    JournalView jv = new JournalView(controller, "journal.fxml");
    Scene scene = jv.load();
    controller.run();
    stage.setScene(scene);
  }
}
