package cs3500.pa05.controller;

import cs3500.pa05.model.DayOfWeek;
import cs3500.pa05.model.ScheduleEvent;
import cs3500.pa05.model.ScheduleTask;
import cs3500.pa05.model.Week;
import cs3500.pa05.view.JournalView;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
  private VBox eventCategoryButtons;
  @FXML
  private RadioButton newEventCategoryButton;
  @FXML
  private TextField newEventCategoryText;
  @FXML
  private TextField taskName;
  @FXML
  private VBox taskCategoryButtons;
  @FXML
  private RadioButton newTaskCategoryButton;
  @FXML
  private TextField newTaskCategoryText;
  @FXML
  private TextField eventDescription;
  @FXML
  private TextField taskDescription;
  @FXML
  private TextField eventStart;
  @FXML
  private TextField eventDuration;

  private String category;

  CreationMenuController(DayOfWeek day, Week week, Stage stage) {
    this.day = day;
    this.week = week;
    this.stage = stage;
    this.eventCategoryButtons = new VBox();
    this.taskCategoryButtons = new VBox();
  }

  public void run() {
    eventCreateButton.setOnAction(e -> handleEventCreation());
    taskCreateButton.setOnAction(e -> handleTaskCreation());
    newEventCategoryButton.setOnAction(e -> handleNewEventCategorySelection());
    newTaskCategoryButton.setOnAction(e -> handleNewTaskCategorySelection());
    createCategoryButtons(eventCategoryButtons, week);
    createCategoryButtons(taskCategoryButtons, week);
  }

  private void handleEventCreation() {
    if(newEventCategoryButton.isSelected()) {
      category = newEventCategoryText.getText();
      week.addCategory(category);
    }
    ScheduleEvent event = new ScheduleEvent(eventName.getText(), category, eventDescription.getText(),
        eventStart.getText(), eventDuration.getText());
    week.addEvent(day, event);
    switchScene();
  }

  private void handleTaskCreation() {
    if(newTaskCategoryButton.isSelected()) {
      category = newTaskCategoryText.getText();
      week.addCategory(category);
    }
    ScheduleTask task = new ScheduleTask(taskName.getText(), category, taskDescription.getText(), false);
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

  private void createCategoryButtons(VBox parent, Week week) {
    ArrayList<String> categories = week.getCategories();
    for(String category: categories) {

      RadioButton categoryButton = new RadioButton(category);
      categoryButton.setOnAction(e -> handleCategorySelection(category, parent));

      parent.getChildren().add(categoryButton);
    }
  }

  private void handleEventCategorySelection(String categorySelected) {
    handleCategorySelection(categorySelected, eventCategoryButtons);
  }

  private void handleTaskCategorySelection(String categorySelected) {
    handleCategorySelection(categorySelected, taskCategoryButtons);
  }


  private void handleCategorySelection(String categorySelected, VBox categoryButtons) {
    category = categorySelected;
    for(Node node : categoryButtons.getChildren()) {
      if(node instanceof RadioButton) {
        RadioButton categoryButton = ((RadioButton) node);
        if(!categoryButton.getText().equals(categorySelected)) {
          categoryButton.setSelected(false);
        }
        else {
          categoryButton.setSelected(true);
        }
      }
    }
    int numCategoryButtons = categoryButtons.getChildren().size();
    HBox newCategoryBox = (HBox) categoryButtons.getChildren().get(0);
    RadioButton newCategoryButton = (RadioButton) newCategoryBox.getChildren().get(0);
    newCategoryButton.setSelected(false);
  }

  private void handleNewCategorySelection(VBox categoryButtons, TextField newCategoryText) {
    category = newCategoryText.getText();
    for(Node node : categoryButtons.getChildren()) {
      if(node instanceof RadioButton) {
        RadioButton categoryButton = ((RadioButton) node);
        categoryButton.setSelected(false);
      }
    }
  }
  private void handleNewEventCategorySelection() {
    handleNewCategorySelection(eventCategoryButtons, newEventCategoryText);
  }

  private void handleNewTaskCategorySelection() {
    handleNewCategorySelection(taskCategoryButtons, newTaskCategoryText);
  }
}
