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
import java.util.Map;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The JournalController class serves as the controller in the MVC architecture, handling
 * user interactions and updating the model and view accordingly. Specifically, it manages
 * the behavior of a journal that contains a week's worth of tasks and events.
 */
public class JournalController implements Controller {
  private final Stage stage;
  private TabsController tabsContoller;
  Week week = new Week();

  @FXML
  private TextField filePath;
  @FXML
  private Label title;
  @FXML
  private Button setNameButton;
  @FXML
  private Button newTab;
  @FXML
  private MenuButton tabs;
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
  @FXML
  private TextField maxEventsText;
  @FXML
  private Button maxEventsButton;
  @FXML
  private TextField maxTasksText;
  @FXML
  private Button maxTasksButton;

  /**
   * Constructor for the JournalController that accepts a Stage object.
   *
   * @param stage the Stage object used to change the scene in JavaFX application.
   */
  public JournalController(Stage stage, TabsController tc) {
    this.stage = stage;
    this.tabsContoller = tc;
  }

  /**
   * Constructor for the JournalController that accepts a Stage and a Week object.
   *
   * @param stage the Stage object used to change the scene in JavaFX application.
   * @param week  the Week object representing the data for the week in the journal.
   */
  public JournalController(Stage stage, Week week, TabsController tc) {
    this(stage, tc);
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
    maxEventsButton.setOnAction(e -> handleMaxEventsUpdate());
    maxTasksButton.setOnAction(e -> handleMaxTasksUpdate());
    sunCreate.setOnAction(e -> switchToCreationScene(DayOfWeek.SUNDAY));
    monCreate.setOnAction(e -> switchToCreationScene(DayOfWeek.MONDAY));
    tueCreate.setOnAction(e -> switchToCreationScene(DayOfWeek.TUESDAY));
    wenCreate.setOnAction(e -> switchToCreationScene(DayOfWeek.WEDNESDAY));
    thuCreate.setOnAction(e -> switchToCreationScene(DayOfWeek.THURSDAY));
    friCreate.setOnAction(e -> switchToCreationScene(DayOfWeek.FRIDAY));
    satCreate.setOnAction(e -> switchToCreationScene(DayOfWeek.SATURDAY));
    newTab.setOnAction(e -> createNewTab());
    loadTabs();
    loadWeek();
  }

  private void createNewTab() {
    this.tabsContoller.createNewTab(this.stage);
    loadTabs();
  }

  private void loadTabs() {
    tabs.getItems().clear();
    for (JournalController jc : tabsContoller.getTabs()) {
      MenuItem tab = new MenuItem(jc.getWeek().getName());
      tabs.getItems().add(tab);
      tab.setOnAction(e -> switchTab(jc));
    }
  }

  private void switchTab(JournalController jc) {
    tabsContoller.switchTab(jc, stage);
  }

  private void handleNameChange() {
    this.week.setName(nameBox.getText());
    title.setText(week.getName());
    loadTabs();
  }

  private void switchToCreationScene(DayOfWeek dayOfWeek) {
    CreationMenuController menuController =
        new CreationMenuController(dayOfWeek, week, stage, tabsContoller);
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
        new ScheduleEventBox(event.getName(), event.getCategory(), event.getDescription(),
            event.getStartTime(),
            event.getDuration());
    eventBox.setDeleteAction(e -> handleDeleteEvent(event, vbox, eventBox));
    eventBox.setSaveAction(e -> handleSaveEvent(event, vbox, eventBox));
    vbox.getChildren().add(eventBox);
  }

  private void createTaskBoxes(ScheduleTask task, VBox vbox) {
    ScheduleTaskBox scheduleTask =
        new ScheduleTaskBox(task.getName(), task.getCategory(), task.getDescription());
    vbox.getChildren().add(scheduleTask);

    BarTaskBox barTask = new BarTaskBox(task.getName(), task.isComplete());
    tasksBar.getChildren().add(barTask);

    scheduleTask.setDeleteAction(e -> handleDeleteTask(task, vbox, scheduleTask, barTask));
    scheduleTask.setSaveAction(e -> handleSaveTask(task, scheduleTask));

    scheduleTask.setCompleteAction(e -> toggleScheduleComplete(task, barTask));
    barTask.setCompleteAction(e -> toggleBarComplete(task, scheduleTask));
  }

  private void handleWarnings(Day day) {
    switch (day.getDay()) {
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

  public void handleAllWarnings() {
    for (Map.Entry<DayOfWeek, Day> entry : week.getDays().entrySet()) {
      Day day = entry.getValue();

      handleWarnings(day);
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
    for (Map.Entry<DayOfWeek, Day> entry : week.getDays().entrySet()) {
      Day day = entry.getValue();

      double numTasksComplete = day.numTasksComplete();
      double totalTasks = day.getTasks().size();
      double progress;
      if (numTasksComplete == 0) {
        progress = 0.0;
      } else {
        progress = numTasksComplete / totalTasks;
      }
      ProgressBar progressBar = chooseProgressBar(entry.getKey());
      progressBar.setProgress(progress);
    }
  }

  private ProgressBar chooseProgressBar(DayOfWeek dayOfWeek) {
    switch (dayOfWeek) {
      case SUNDAY -> {
        return sunProgress;
      }
      case MONDAY -> {
        return monProgress;
      }
      case TUESDAY -> {
        return tueProgress;
      }
      case WEDNESDAY -> {
        return wenProgress;
      }
      case THURSDAY -> {
        return thuProgress;
      }
      case FRIDAY -> {
        return friProgress;
      }
      default -> {
        return satProgress;
      }
    }
  }

  private Label chooseRemainingTasksLabel(DayOfWeek dayOfWeek) {
    switch (dayOfWeek) {
      case SUNDAY -> {
        return sunRemainingTasks;
      }
      case MONDAY -> {
        return monRemainingTasks;
      }
      case TUESDAY -> {
        return tueRemainingTasks;
      }
      case WEDNESDAY -> {
        return wenRemainingTasks;
      }
      case THURSDAY -> {
        return thuRemainingTasks;
      }
      case FRIDAY -> {
        return friRemainingTasks;
      }
      default -> {
        return satRemainingTasks;
      }
    }
  }

  private void handleDeleteEvent(ScheduleEvent event, VBox vbox, ScheduleEventBox eventBox) {
    for (Map.Entry<DayOfWeek, Day> entry : week.getDays().entrySet()) {
      Day day = entry.getValue();

      if (day.hasEvent(event)) {
        day.deleteEvent(event);
        handleWarnings(day);
      }
    }
    vbox.getChildren().remove(eventBox);
    handleOverview();
  }

  private void handleSaveEvent(ScheduleEvent event, VBox vBox, ScheduleEventBox scheduleEventBox) {
    String newName = scheduleEventBox.getNameText();
    String newCategory = scheduleEventBox.getCategoryText();
    String newDescription = scheduleEventBox.getDescriptionText();
    String newStart = scheduleEventBox.getStartTimeText();
    String newDuration = scheduleEventBox.getDurationText();
    if (!newName.isBlank()) {
      event.setName(newName);
    }
    if (!newCategory.isBlank()) {
      handleNewCategory(newCategory);
      event.setCategory(newCategory);
    }
    if (!newDescription.isBlank()) {
      event.setDescription(newDescription);
    }
    if (!newStart.isBlank()) {
      event.setStartTime(newStart);
    }
    if (!newDuration.isBlank()) {
      event.setDuration(newDuration);
    }
  }

  private void handleSaveTask(ScheduleTask task, ScheduleTaskBox scheduleTaskBox) {
    String newName = scheduleTaskBox.getNameText();
    String newCategory = scheduleTaskBox.getCategoryText();
    String newDescription = scheduleTaskBox.getDescriptionText();
    if (!newName.isBlank()) {
      task.setName(newName);
    }
    if (!newCategory.isBlank()) {
      handleNewCategory(newCategory);
      task.setCategory(newCategory);
    }
    if (!newDescription.isBlank()) {
      task.setDescription(newDescription);
    }
  }

  private void handleDeleteTask(ScheduleTask task, VBox vbox, ScheduleTaskBox taskBox,
                                BarTaskBox barTask) {
    for (Map.Entry<DayOfWeek, Day> entry : week.getDays().entrySet()) {
      Day day = entry.getValue();

      if (day.hasTask(task)) {
        day.deleteTask(task);
        handleWarnings(day);
      }
    }
    vbox.getChildren().remove(taskBox);
    tasksBar.getChildren().remove(barTask);
    handleProgresses();
    handleRemainingTasks();
    handleOverview();
  }

  private void handleRemainingTasks() {
    for (Map.Entry<DayOfWeek, Day> entry : week.getDays().entrySet()) {
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
    for (Map.Entry<DayOfWeek, Day> entry : week.getDays().entrySet()) {
      Day day = entry.getValue();

      totalEvents += day.getEvents().size();
      totalTasks += day.getTasks().size();
      tasksCompleted += day.numTasksComplete();
    }

    double taskCompletionPercentage;
    if (totalTasks == 0) {
      taskCompletionPercentage = 0;
    } else {
      taskCompletionPercentage = (tasksCompleted / totalTasks) * 100;
    }

    this.totalEvents.setText(String.valueOf(totalEvents));
    this.totalTasks.setText(String.valueOf((int) totalTasks));
    this.taskCompletion.setText(String.format("%.1f", taskCompletionPercentage));
  }

  private void handleMaxEventsUpdate() {
    String text = maxEventsText.getText();

    try {
      int newMax = Integer.parseInt(text);
      week.setMaxEvent(newMax);
      handleAllWarnings();
    } catch (NumberFormatException e) {

    }
  }

  private void handleMaxTasksUpdate() {
    String text = maxTasksText.getText();

    try {
      int newMax = Integer.parseInt(text);
      week.setMaxTask(newMax);
      handleAllWarnings();
    } catch (NumberFormatException e) {

    }
  }

  /**
   * Get the current week the user is using
   *
   * @return the week
   */
  public Week getWeek() {
    return this.week;
  }

  private void handleNewCategory(String category) {
    if (!week.getCategories().contains(category)) {
      week.addCategory(category);
    }
  }
}
