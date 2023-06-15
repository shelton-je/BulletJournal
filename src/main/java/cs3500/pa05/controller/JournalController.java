package cs3500.pa05.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.json.ScheduledItems;
import cs3500.pa05.model.ReadBujo;
import cs3500.pa05.model.ScheduleEvent;
import cs3500.pa05.model.ScheduleTask;
import java.nio.file.Path;
import java.util.List;


public class JournalController {
  Path bujoPath;
  List<ScheduleEvent> allEvents;
  List<ScheduleTask> allTaks;


  public JournalController(String filePath) {
    this.bujoPath = Path.of(filePath);
  }

  public void loadBujo() {
    ReadBujo reader = new ReadBujo(bujoPath);
    ObjectMapper mapper = new ObjectMapper();
    ScheduledItems items = null;
    try {
      items = mapper.readValue(reader.readBujo(), ScheduledItems.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
    this.allEvents = items.getEvents();
    this.allTaks = items.getTasks();
  }
}
