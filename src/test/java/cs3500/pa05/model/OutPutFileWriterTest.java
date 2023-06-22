package cs3500.pa05.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class OutPutFileWriterTest {

  private String filePath;
  private String contents;

  @BeforeEach
  void setUp() {
    filePath = "tempFile.txt";
    contents = "Test content";
  }

  @AfterEach
  void tearDown() throws IOException {
    if (!filePath.equals(
        "CS3500\\pa05-badesign\\src\\note.sr")) {
      Path theFile = Path.of(filePath);
      if (Files.exists(theFile)) {
        Files.delete(theFile);
      }
    }
  }

  @Test
  void writeToFile() throws IOException {
    OutPutFileWriter.writeToFile(filePath, contents);

    Path theFile = Path.of(filePath);
    assertTrue(Files.exists(theFile));

    String readContents = Files.readString(theFile);

    assertEquals(contents, readContents);
  }

  @Test
  void writeToFileIoException() {
    assertThrows(java.lang.RuntimeException.class,
        () -> OutPutFileWriter.writeToFile("/", contents));
  }
}
