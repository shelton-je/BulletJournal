package cs3500.pa05.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.json.WeekRecord;
import cs3500.pa05.model.ReadBujo;
import cs3500.pa05.model.Week;
import java.nio.file.Path;


public class JournalController {
  Path bujoPath;
  Week journalWeek;

  public JournalController() {
  }


  public void run() {
    this.bujoPath = getBujoFile();
    loadBujo();
  }

  private Path getBujoFile() {
    return null;
  }

  public void loadBujo() {
    ReadBujo reader = new ReadBujo(bujoPath);
    ObjectMapper mapper = new ObjectMapper();
    WeekRecord weekRecord = null;
    try {
      weekRecord = mapper.readValue(reader.readBujo(), WeekRecord.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
    this.journalWeek = weekRecord.getWeek();
  }

}
