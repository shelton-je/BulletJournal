package cs3500.pa05.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.DaysOfWeek;

public record TaskRecord(
    @JsonProperty("name") String name,
    @JsonProperty("description") String description,
    @JsonProperty("day") DaysOfWeek day,
    @JsonProperty("complete") boolean complete
) {
}
