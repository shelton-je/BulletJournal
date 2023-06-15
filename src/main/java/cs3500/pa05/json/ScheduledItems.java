package cs3500.pa05.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.ScheduleEvent;
import cs3500.pa05.model.ScheduleTask;
import java.util.List;

public record ScheduledItems(
    @JsonProperty("events")List<ScheduleEvent> events,
    @JsonProperty("tasks") List<ScheduleTask> tasks
    ) {

    public List<ScheduleEvent> getEvents() {
        return events;
    }

    public List<ScheduleTask> getTasks() {
        return tasks;
    }
}
