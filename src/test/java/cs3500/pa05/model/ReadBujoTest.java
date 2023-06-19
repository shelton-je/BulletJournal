package cs3500.pa05.model;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ReadBujoTest {

  @Test
  void readBulletJornulBujo() throws IOException {
    Path filePath = Path.of("C:\\Users\\namvi\\OneDrive\\Documents\\CS3500\\pa05-badesign\\src\\main\\Resources\\BulletJornul.bujo");
    String expectedContent = "{\"week\":{\"name\":\"\",\"days\":{\"MONDAY\":{\"day\":\"MONDAY\",\"events\":[]," +
        "\"tasks\":[]},\"SUNDAY\":{\"day\":\"SUNDAY\",\"events\":[{\"name\":\"Party\",\"description\":\"party\",\"" +
        "duration\":\"2 hours\",\"startTime\":\"5pm\"}],\"tasks\":[]},\"THURSDAY\":{\"day\":\"THURSDAY\",\"events\":[],\"" +
        "tasks\":[]},\"WEDNESDAY\":{\"day\":\"WEDNESDAY\",\"events\":[],\"tasks\":[]},\"FRIDAY\":{\"day\":\"FRIDAY\",\"" +
        "events\":[],\"tasks\":[]},\"TUESDAY\":{\"day\":\"TUESDAY\",\"events\":[],\"tasks\":[]},\"SATURDAY\":{\"day\":\"" +
        "SATURDAY\",\"events\":[],\"tasks\":[]}},\"maxEvent\":5,\"maxTask\":5}}";

    ReadBujo reader = new ReadBujo(filePath);

    String readContents = reader.readBujo();
    assertEquals(expectedContent, readContents);
  }

  @Test
  void readBulletJournalWCategoriesBujo() throws IOException {
    Path filePath = Path.of("C:\\Users\\namvi\\OneDrive\\Documents\\CS3500\\pa05-badesign\\src\\main\\Resources\\BulletJournalWCategories.bujo");
    String expectedContent = "{\"week\":{\"name\":\"\",\"categories\":[\"Homework\",\"Class\",\"Food\"],\"" +
        "days\":{\"FRIDAY\":{\"day\":\"FRIDAY\",\"events\":[],\"tasks\":[]},\"WEDNESDAY\":{\"day\":\"WEDNESDAY\",\"" +
        "events\":[],\"tasks\":[]},\"THURSDAY\":{\"day\":\"THURSDAY\",\"events\":[{\"name\":\"Make Dinner\",\"category\"" +
        ":\"Food\",\"description\":\"Mac and Cheese\",\"duration\":\"1 Hour\",\"startTime\":\"8:00\"}],\"tasks\":[]},\"" +
        "MONDAY\":{\"day\":\"MONDAY\",\"events\":[],\"tasks\":[]},\"SATURDAY\":{\"day\":\"SATURDAY\",\"events\":[],\"" +
        "tasks\":[{\"name\":\"PA05 categories\",\"category\":\"Homework\",\"description\":\"Implement category functionality\"" +
        ",\"complete\":false}]},\"SUNDAY\":{\"day\":\"SUNDAY\",\"events\":[{\"name\":\"PA05 Team Meeting\",\"category\":\"" +
        "Homework\",\"description\":\"Meet with team to discuss project\",\"duration\":\"1 Hour\",\"startTime\":\"12:00\"" +
        "}],\"tasks\":[{\"name\":\"Finish PA05 sections 2 and 3\",\"category\":\"Homework\",\"description\":\"" +
        "Sections 2 and 3\",\"complete\":false}]},\"TUESDAY\":{\"day\":\"TUESDAY\",\"events\":[{\"name\":\"Acting Class\",\"" +
        "category\":\"Class\",\"description\":\"\",\"duration\":\"1 Hour 40 Minutes\",\"startTime\":\"1:30\"}],\"tasks\"" +
        ":[]}},\"maxEvent\":5,\"maxTask\":5}}";

    ReadBujo reader = new ReadBujo(filePath);

    String readContents = reader.readBujo();
    assertEquals(expectedContent, readContents);
  }

  @Test
  void readBujoNoFile() {
    Path file = Path.of("nonexistentFile.txt");

    ReadBujo reader = new ReadBujo(file);

    assertThrows(IllegalStateException.class, reader::readBujo);
  }
}
