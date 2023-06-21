package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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
    if (!filePath.equals("C:\\Users\\namvi\\OneDrive\\Documents\\CS3500\\pa05-badesign\\src\\note.sr")) {
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
  void writeToFileWhenFileAlreadyExists() throws IOException {
    filePath = "C:\\Users\\namvi\\OneDrive\\Documents\\CS3500\\pa05-badesign\\src\\note.sr";

    OutPutFileWriter.writeToFile(filePath, contents);

    Path theFile = Path.of(filePath);
    assertTrue(Files.exists(theFile));

    String readContents = Files.readString(theFile);
    assertEquals(contents, readContents);
  }

  @Test
  void writeToFileIOException() {
    assertThrows(java.lang.RuntimeException.class, () -> OutPutFileWriter.writeToFile("/", contents));
  }
}
