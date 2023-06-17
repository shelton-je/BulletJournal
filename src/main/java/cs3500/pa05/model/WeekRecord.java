package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WeekRecord(
    @JsonProperty("week") Week week
) {


  public Week getWeek() {
    return this.week;
  }
}

