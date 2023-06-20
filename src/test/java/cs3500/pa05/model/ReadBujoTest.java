package cs3500.pa05.model;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ReadBujoTest {


  @Test
  void readBulletJournalWCategoriesBujo() throws IOException {
    Path filePath = Path.of("src/main/Resources/BulletTest.bujo");
    String expectedContent =
        "{\"week\":{\"name\":\"\",\"categories\":[],\"days\":{\"WEDNESDAY\":{\"day\""
            + ":\"WEDNESDAY\",\"events\":[],\"tasks\":[]},\"FRIDAY\":{\"day\":\"FRIDAY\","
            + "\"events\":[],\"tasks\":[]},\"SUNDAY\":{\"day\":\"SUNDAY\",\"events\":[],\"tasks\""
            + ":[]},\"TUESDAY\":{\"day\":\"TUESDAY\",\"events\":[],\"tasks\":[]},\"THURSDAY\""
            + ":{\"day\":\"THURSDAY\",\"events\":[],\"tasks\":[]},\"MONDAY\":{\"day\":\"MONDAY\",\""
            + "events\":[],\"tasks\":[]},\"SATURDAY\":{\"day\":\"SATURDAY\","
            + "\"events\":[],\"tasks\":[]}},\"maxEvent\":5,\"maxTask\":5}}";

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
