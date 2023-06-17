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
import cs3500.pa05.view.JournalView;
import cs3500.pa05.view.ScheduleEventBox;
import cs3500.pa05.view.ScheduleTaskBox;
import java.nio.file.Path;
import java.util.Map;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
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
        createTaskBox(t, vbox);
      }
    }
  }

  private void createEventBox(ScheduleEvent event, VBox vbox) {
    VBox eventBox =
        new ScheduleEventBox(event.getName(), event.getDescription(), event.getStartTime(),
            event.getDuration());
    vbox.getChildren().add(eventBox);
  }

  private void createTaskBox(ScheduleTask task, VBox vbox) {
    VBox taskBox = new ScheduleTaskBox(task.getName(), task.getDescription());
    vbox.getChildren().add(taskBox);
  }
}
