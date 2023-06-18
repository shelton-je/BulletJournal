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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class JournalController implements Controller{
  private final Stage stage;
  Week week = new Week();

  @FXML
  private TextField filePath;
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


  public JournalController(Stage stage) {
    this.stage = stage;
  }

  public JournalController(Stage stage, Week week) {
    this(stage);
    this.week = week;
  }


  public void run() {
    openFile.setOnAction(e -> loadBujo());
    saveFile.setOnAction(e -> saveBujo());
    sunCreate.setOnAction(e -> switchScene(DayOfWeek.SUNDAY));
    monCreate.setOnAction(e -> switchScene(DayOfWeek.MONDAY));
    tueCreate.setOnAction(e -> switchScene(DayOfWeek.TUESDAY));
    wenCreate.setOnAction(e -> switchScene(DayOfWeek.WEDNESDAY));
    thuCreate.setOnAction(e -> switchScene(DayOfWeek.THURSDAY));
    friCreate.setOnAction(e -> switchScene(DayOfWeek.FRIDAY));
    satCreate.setOnAction(e -> switchScene(DayOfWeek.SATURDAY));
    loadWeek();
  }

  private void switchScene(DayOfWeek dayOfWeek) {
    CreationMenuController menuController = new CreationMenuController(dayOfWeek, week, stage);
    JournalView jv = new JournalView(menuController, "creation.fxml");
    Scene scene = jv.load();
    menuController.run();
    stage.setScene(scene);
  }

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

  public void saveBujo() {
    ObjectMapper mapper = new ObjectMapper();
    WeekRecord weekRecord = new WeekRecord(this.week);
    try {
      OutPutFileWriter.writeToFile(filePath.getText(), mapper.writeValueAsString(weekRecord));
    } catch (JsonProcessingException e) {

    }
  }

  private void loadWeek() {
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
    }
  }

  private void createEventBox(ScheduleEvent event, VBox vbox) {
    VBox eventBox =
        new ScheduleEventBox(event.getName(), event.getCategory(), event.getDescription(), event.getStartTime(),
            event.getDuration());
    vbox.getChildren().add(eventBox);
  }

  private void createTaskBoxes(ScheduleTask task, VBox vbox) {
    ScheduleTaskBox scheduleTask = new ScheduleTaskBox(task.getName(), task.getCategory(), task.getDescription());
    vbox.getChildren().add(scheduleTask);

    BarTaskBox barTask = new BarTaskBox(task.getName(), task.isComplete());
    tasksBar.getChildren().add(barTask);

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
  }

  private void toggleScheduleComplete(ScheduleTask task, BarTaskBox barTask) {
    task.toggleComplete();
    barTask.toggleComplete();
  }

}
