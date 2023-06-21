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

/**
 * The CreationMenuController class is responsible for creating events and tasks for
 * a particular day and week. It handles the UI for creating new events and tasks,
 * including their categories.
 */
public class CreationMenuController implements Controller {
  private final DayOfWeek day;
  private final Week week;
  private final Stage stage;
  private final TabsController tc;

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

  /**
   * Constructor for CreationMenuController.
   *
   * @param day the DayOfWeek object representing the day for which the event or task is created.
   * @param week the Week object that the events and tasks are added to.
   * @param stage the Stage object where the scenes are displayed.
   */
  CreationMenuController(DayOfWeek day, Week week, Stage stage, TabsController tc) {
    this.day = day;
    this.week = week;
    this.stage = stage;
    this.tc = tc;
    this.eventCategoryButtons = new VBox();
    this.taskCategoryButtons = new VBox();
  }

  /**
   * Sets the action handlers for the UI elements.
   */
  public void run() {
    eventCreateButton.setOnAction(e -> handleEventCreation());
    taskCreateButton.setOnAction(e -> handleTaskCreation());
    newEventCategoryButton.setOnAction(e -> handleNewEventCategorySelection());
    newTaskCategoryButton.setOnAction(e -> handleNewTaskCategorySelection());
    createCategoryButtons(eventCategoryButtons, week);
    createCategoryButtons(taskCategoryButtons, week);
  }

  /**
   * Handles the creation of a new event. The event is added to the week.
   */
  private void handleEventCreation() {
    if (eventName.getText().equals("") || eventStart.getText().equals("") ||
        eventDuration.getText().equals("")) {
      return;
    }
    if (newEventCategoryButton.isSelected()) {
      category = newEventCategoryText.getText();
      week.addCategory(category);
    }
    ScheduleEvent event =
        new ScheduleEvent(eventName.getText(), category, eventDescription.getText(),
            eventStart.getText(), eventDuration.getText());
    week.addEvent(day, event);
    switchScene();
  }

  /**
   * Handles the creation of a new task. The task is added to the week.
   */
  private void handleTaskCreation() {
    if (taskName.getText().equals("")) {
      return;
    }
    if(newTaskCategoryButton.isSelected()) {
      category = newTaskCategoryText.getText();
      week.addCategory(category);
    }
    ScheduleTask task = new ScheduleTask(taskName.getText(), category, taskDescription.getText(), false);
    week.addTask(day, task);
    switchScene();
  }

  /**
   * Switches the scene back to the journal view.
   */
  private void switchScene() {
    JournalController controller = new JournalController(stage, week, tc);
    JournalView jv = new JournalView(controller, "journal.fxml");
    Scene scene = jv.load();
    controller.run();
    stage.setScene(scene);
  }

  /**
   * Creates the category buttons for the specified parent VBox using the categories in the week.
   *
   * @param parent the VBox where the category buttons are added.
   * @param week the Week object that the categories are retrieved from.
   */
  private void createCategoryButtons(VBox parent, Week week) {
    ArrayList<String> categories = week.getCategories();
    for(String category: categories) {

      RadioButton categoryButton = new RadioButton(category);
      categoryButton.setOnAction(e -> handleCategorySelection(category, parent));

      parent.getChildren().add(categoryButton);
    }
  }

  /**
   * Handles the selection of an event category.
   *
   * @param categorySelected the selected category.
   */
  private void handleEventCategorySelection(String categorySelected) {
    handleCategorySelection(categorySelected, eventCategoryButtons);
  }

  /**
   * Handles the selection of a task category.
   *
   * @param categorySelected the selected category.
   */
  private void handleTaskCategorySelection(String categorySelected) {
    handleCategorySelection(categorySelected, taskCategoryButtons);
  }

  /**
   * Handles the selection of a category.
   *
   * @param categorySelected the selected category.
   * @param categoryButtons the VBox containing the category buttons.
   */
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

  /**
   * Handles the selection of a new category.
   *
   * @param categoryButtons the VBox containing the category buttons.
   * @param newCategoryText the TextField containing the new category text.
   */
  private void handleNewCategorySelection(VBox categoryButtons, TextField newCategoryText) {
    category = newCategoryText.getText();
    for(Node node : categoryButtons.getChildren()) {
      if(node instanceof RadioButton) {
        RadioButton categoryButton = ((RadioButton) node);
        categoryButton.setSelected(false);
      }
    }
  }

  /**
   * Handles the selection of a new event category.
   */
  private void handleNewEventCategorySelection() {
    handleNewCategorySelection(eventCategoryButtons, newEventCategoryText);
  }

  /**
   * Handles the selection of a new task category.
   */
  private void handleNewTaskCategorySelection() {
    handleNewCategorySelection(taskCategoryButtons, newTaskCategoryText);
  }
}
