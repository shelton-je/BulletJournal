package cs3500.pa05.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import cs3500.pa05.model.Week;

public record WeekRecord(
    @JsonProperty("week") Week week
) {


  public Week getWeek() {
    return this.week;
  }
}
