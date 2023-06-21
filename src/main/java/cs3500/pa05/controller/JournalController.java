package cs3500.pa05.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayOfWeek;
import cs3500.pa05.model.OutPutFileWriter;
import cs3500.pa05.model.ReadBujo;
import cs3500.pa05.model.ScheduleEvent;
import cs3500.pa05.model.ScheduleTask;
import cs3500.pa05.model.Week;
import cs3500.pa05.model.WeekRecord;
import cs3500.pa05.view.BarTaskBox;
import cs3500.pa05.view.JournalView;
import cs3500.pa05.view.ScheduleEventBox;
import cs3500.pa05.view.ScheduleTaskBox;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The JournalController class serves as the controller in the MVC architecture, handling
 * user interactions and updating the model and view accordingly. Specifically, it manages
 * the behavior of a journal that contains a week's worth of tasks and events.
 */
public class JournalController implements Controller{
  private final Stage stage;
  Week week = new Week();

  @FXML
  private TextField filePath;
  @FXML
  private Label title;
  @FXML
  private Button setNameButton;
  @FXML
  private TextField nameBox;
  @FXML
  private MenuItem openFile;
  @FXML
  private MenuItem saveFile;
  @FXML
  private Button sunCreate;
  @FXML
  private Button monCreate;
  @FXML
  private Button tueCreate;
  @FXML
  private Button wenCreate;
  @FXML
  private Button thuCreate;
  @FXML
  private Button friCreate;
  @FXML
  private Button satCreate;
  @FXML
  private VBox sun;
  @FXML
  private VBox mon;
  @FXML
  private VBox tue;
  @FXML
  private VBox wen;
  @FXML
  private VBox thu;
  @FXML
  private VBox fri;
  @FXML
  private VBox sat;
  @FXML
  private Label sunEventWarning;
  @FXML
  private Label monEventWarning;
  @FXML
  private Label tueEventWarning;
  @FXML
  private Label wenEventWarning;
  @FXML
  private Label thuEventWarning;
  @FXML
  private Label friEventWarning;
  @FXML
  private Label satEventWarning;
  @FXML
  private Label sunTaskWarning;
  @FXML
  private Label monTaskWarning;
  @FXML
  private Label tueTaskWarning;
  @FXML
  private Label wenTaskWarning;
  @FXML
  private Label thuTaskWarning;
  @FXML
  private Label friTaskWarning;
  @FXML
  private Label satTaskWarning;
  @FXML
  private VBox tasksBar;
  @FXML
  private ProgressBar sunProgress;
  @FXML
  private ProgressBar monProgress;
  @FXML
  private ProgressBar tueProgress;
  @FXML
  private ProgressBar wenProgress;
  @FXML
  private ProgressBar thuProgress;
  @FXML
  private ProgressBar friProgress;
  @FXML
  private ProgressBar satProgress;
  @FXML
  private Label sunRemainingTasks;
  @FXML
  private Label monRemainingTasks;
  @FXML
  private Label tueRemainingTasks;
  @FXML
  private Label wenRemainingTasks;
  @FXML
  private Label thuRemainingTasks;
  @FXML
  private Label friRemainingTasks;
  @FXML
  private Label satRemainingTasks;
  @FXML
  private Label totalEvents;
  @FXML
  private Label totalTasks;
  @FXML
  private Label taskCompletion;

  /**
   * Constructor for the JournalController that accepts a Stage object.
   *
   * @param stage the Stage object used to change the scene in JavaFX application.
   */
  public JournalController(Stage stage) {
    this.stage = stage;
  }

  /**
   * Constructor for the JournalController that accepts a Stage and a Week object.
   *
   * @param stage the Stage object used to change the scene in JavaFX application.
   * @param week the Week object representing the data for the week in the journal.
   */
  public JournalController(Stage stage, Week week) {
    this(stage);
    this.week = week;
  }

  /**
   * The run method sets up event handlers for UI components.
   */
  public void run() {
    title.setText(week.getName());
    openFile.setOnAction(e -> loadBujo());
    saveFile.setOnAction(e -> saveBujo());
    setNameButton.setOnAction(e -> handleNameChange());
    sunCreate.setOnAction(e -> switchScene(DayOfWeek.SUNDAY));
    monCreate.setOnAction(e -> switchScene(DayOfWeek.MONDAY));
    tueCreate.setOnAction(e -> switchScene(DayOfWeek.TUESDAY));
    wenCreate.setOnAction(e -> switchScene(DayOfWeek.WEDNESDAY));
    thuCreate.setOnAction(e -> switchScene(DayOfWeek.THURSDAY));
    friCreate.setOnAction(e -> switchScene(DayOfWeek.FRIDAY));
    satCreate.setOnAction(e -> switchScene(DayOfWeek.SATURDAY));
    loadWeek();
  }

  private void handleNameChange() {
    this.week.setName(nameBox.getText());
    title.setText(week.getName());
  }

  private void switchScene(DayOfWeek dayOfWeek) {
    CreationMenuController menuController = new CreationMenuController(dayOfWeek, week, stage);
    JournalView jv = new JournalView(menuController, "creation.fxml");
    Scene scene = jv.load();
    menuController.run();
    stage.setScene(scene);
  }

  /**
   * The loadBujo method reads in a bujo file and updates the week data accordingly.
   */
  public void loadBujo() {
    ReadBujo reader = new ReadBujo(Path.of(filePath.getText()));
    ObjectMapper mapper = new ObjectMapper();
    String jsonString = reader.readBujo();
    WeekRecord weekRecord = null;
    try {
      JsonNode jsonNode = mapper.readTree(jsonString);
      weekRecord = mapper.convertValue(jsonNode, WeekRecord.class);
    } catch (JsonProcessingException e) {

    }
    this.week = weekRecord.getWeek();
    loadWeek();
  }

  /**
   * The saveBujo method writes the current week data to a bujo file.
   */
  public void saveBujo() {
    ObjectMapper mapper = new ObjectMapper();
    WeekRecord weekRecord = new WeekRecord(this.week);
    try {
      OutPutFileWriter.writeToFile(filePath.getText(), mapper.writeValueAsString(weekRecord));
    } catch (JsonProcessingException e) {

    }
  }

  /**
   * The loadWeek method displays the week's data on the view.
   */
  private void loadWeek() {
    // Clear all VBox before loading tasks and events
    sun.getChildren().clear();
    mon.getChildren().clear();
    tue.getChildren().clear();
    wen.getChildren().clear();
    thu.getChildren().clear();
    fri.getChildren().clear();
    sat.getChildren().clear();
    tasksBar.getChildren().clear();

    this.title.setText(this.week.getName());
    for (Map.Entry<DayOfWeek, Day> day : week.getDays().entrySet()) {
      VBox vbox = null;
      switch (day.getKey()) {
        case SUNDAY -> vbox = this.sun;
        case MONDAY -> vbox = this.mon;
        case TUESDAY -> vbox = this.tue;
        case WEDNESDAY -> vbox = this.wen;
        case THURSDAY -> vbox = this.thu;
        case FRIDAY -> vbox = this.fri;
        case SATURDAY -> vbox = this.sat;
      }
      for (ScheduleEvent e : day.getValue().getEvents()) {
        createEventBox(e, vbox);
      }
      for (ScheduleTask t : day.getValue().getTasks()) {
        createTaskBoxes(t, vbox);
      }
      handleWarnings(day.getValue());
      handleRemainingTasks();
      handleOverview();
    }
  }

  private void createEventBox(ScheduleEvent event, VBox vbox) {
    ScheduleEventBox eventBox =
        new ScheduleEventBox(event.getName(), event.getCategory(), event.getDescription(), event.getStartTime(),
            event.getDuration());
    eventBox.setDeleteAction(e -> handleDeleteEvent(event, vbox, eventBox));
    vbox.getChildren().add(eventBox);
  }

  private void createTaskBoxes(ScheduleTask task, VBox vbox) {
    ScheduleTaskBox scheduleTask = new ScheduleTaskBox(task.getName(), task.getCategory(), task.getDescription());
    vbox.getChildren().add(scheduleTask);

    BarTaskBox barTask = new BarTaskBox(task.getName(), task.isComplete());
    tasksBar.getChildren().add(barTask);

    scheduleTask.setDeleteAction(e -> handleDeleteTask(task, vbox, scheduleTask, barTask));

    scheduleTask.setCompleteAction(e -> toggleScheduleComplete(task, barTask));
    barTask.setCompleteAction(e -> toggleBarComplete(task, scheduleTask));
  }

  private void handleWarnings(Day day) {
    switch(day.getDay()) {
      case SUNDAY -> {
        handleEventWarning(day, this.sunEventWarning);
        handleTaskWarning(day, this.sunTaskWarning);
      }
      case MONDAY -> {
        handleEventWarning(day, this.monEventWarning);
        handleTaskWarning(day, this.monTaskWarning);
      }
      case TUESDAY -> {
        handleEventWarning(day, this.tueEventWarning);
        handleTaskWarning(day, this.tueTaskWarning);
      }
      case WEDNESDAY -> {
        handleEventWarning(day, this.wenEventWarning);
        handleTaskWarning(day, this.wenTaskWarning);
      }
      case THURSDAY -> {
        handleEventWarning(day, this.thuEventWarning);
        handleTaskWarning(day, this.thuTaskWarning);
      }
      case FRIDAY -> {
        handleEventWarning(day, this.friEventWarning);
        handleTaskWarning(day, this.friTaskWarning);
      }
      case SATURDAY -> {
        handleEventWarning(day, this.satEventWarning);
        handleTaskWarning(day, this.satTaskWarning);
      }
    }
  }

  private void handleEventWarning(Day day, Label eventWarning) {
    eventWarning.setVisible(day.getEvents().size() > week.getMaxEvent());
  }

  private void handleTaskWarning(Day day, Label taskWarning) {
    taskWarning.setVisible(day.getTasks().size() > week.getMaxTask());
  }

  private void toggleBarComplete(ScheduleTask task, ScheduleTaskBox scheduleTask) {
    task.toggleComplete();
    scheduleTask.toggleComplete();
    handleProgresses();
    handleRemainingTasks();
    handleOverview();
  }

  private void toggleScheduleComplete(ScheduleTask task, BarTaskBox barTask) {
    task.toggleComplete();
    barTask.toggleComplete();
    handleProgresses();
    handleRemainingTasks();
    handleOverview();
  }

  private void handleProgresses() {
    for(Map.Entry<DayOfWeek, Day> entry : week.getDays().entrySet()) {
      Day day = entry.getValue();

      double numTasksComplete = day.numTasksComplete();
      double totalTasks = day.getTasks().size();
      double progress;
      if(numTasksComplete == 0) {
        progress = 0.0;
      }
      else {
        progress = numTasksComplete / totalTasks;
      }
      ProgressBar progressBar = chooseProgressBar(entry.getKey());
      progressBar.setProgress(progress);
    }
  }

  private ProgressBar chooseProgressBar(DayOfWeek dayOfWeek) {
    switch(dayOfWeek) {
      case SUNDAY -> { return sunProgress; }
      case MONDAY -> { return monProgress; }
      case TUESDAY -> { return tueProgress; }
      case WEDNESDAY -> { return wenProgress; }
      case THURSDAY -> { return thuProgress; }
      case FRIDAY -> { return friProgress; }
      default -> { return satProgress; }
    }
  }

  private Label chooseRemainingTasksLabel(DayOfWeek dayOfWeek) {
    switch(dayOfWeek) {
      case SUNDAY -> { return sunRemainingTasks; }
      case MONDAY -> { return monRemainingTasks; }
      case TUESDAY -> { return tueRemainingTasks; }
      case WEDNESDAY -> { return wenRemainingTasks; }
      case THURSDAY -> { return thuRemainingTasks; }
      case FRIDAY -> { return friRemainingTasks; }
      default -> { return satRemainingTasks; }
    }
  }

  private void handleDeleteEvent(ScheduleEvent event, VBox vbox, ScheduleEventBox eventBox) {
    for(Map.Entry<DayOfWeek, Day> entry : week.getDays().entrySet()) {
      Day day = entry.getValue();

      if(day.hasEvent(event)) {
        day.deleteEvent(event);
      }
    }
    vbox.getChildren().remove(eventBox);
    handleOverview();
  }

  private void handleDeleteTask(ScheduleTask task, VBox vbox, ScheduleTaskBox taskBox, BarTaskBox barTask) {
    for(Map.Entry<DayOfWeek, Day> entry : week.getDays().entrySet()) {
      Day day = entry.getValue();

      if(day.hasTask(task)) {
        day.deleteTask(task);
      }
    }
    vbox.getChildren().remove(taskBox);
    tasksBar.getChildren().remove(barTask);
    handleProgresses();
    handleRemainingTasks();
    handleOverview();
  }

  private void handleRemainingTasks() {
    for(Map.Entry<DayOfWeek, Day> entry : week.getDays().entrySet()) {
      Day day = entry.getValue();

      Label dayRemainingTasks = chooseRemainingTasksLabel(entry.getKey());
      String remainingTasks = String.valueOf(day.numTasksIncomplete());
      dayRemainingTasks.setText(remainingTasks);
    }
  }

  private void handleOverview() {
    int totalEvents = 0;
    double totalTasks = 0;
    double tasksCompleted = 0;
    for(Map.Entry<DayOfWeek, Day> entry : week.getDays().entrySet()) {
      Day day = entry.getValue();

      totalEvents += day.getEvents().size();
      totalTasks += day.getTasks().size();
      tasksCompleted += day.numTasksComplete();
    }

    double taskCompletionPercentage;
    if(totalTasks == 0) {
      taskCompletionPercentage = 100;
    }
    else {
      taskCompletionPercentage = (tasksCompleted / totalTasks) * 100;
    }

    this.totalEvents.setText(String.valueOf(totalEvents));
    this.totalTasks.setText(String.valueOf((int) totalTasks));
    this.taskCompletion.setText(String.format("%.1f", taskCompletionPercentage));
  }
}
