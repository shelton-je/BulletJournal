package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class OutPutFileWriterTest {

  @Test
  void writeToFile() throws IOException {
    String filePath = "tempFile.txt";
    String contents = "Test content";

    OutPutFileWriter.writeToFile(filePath, contents);

    Path theFile = Path.of(filePath);
    assertTrue(Files.exists(theFile));

    String readContents = Files.readString(theFile);
    assertEquals(contents, readContents);

    Files.delete(theFile);
  }
}
