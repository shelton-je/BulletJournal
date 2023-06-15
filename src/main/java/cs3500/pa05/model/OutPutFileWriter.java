package cs3500.pa05.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * A class that contains the method to write to a file
 */
public class OutPutFileWriter {

  /**
   * this method will write a string to an output file
   *
   * @param filePath the file name to write the contents to
   * @param contents a String that will be the contents to write in the file
   */
  public static void writeToFile(String filePath, String contents) {

    Path theFile = Path.of(filePath);
    byte[] data = contents.getBytes();

    try {
      if (Files.notExists(theFile)) {
        Files.createFile(theFile);
      }
      Files.write(theFile, data);
    } catch (IOException e) {
      System.err.println(e + " : Could not write to the file " + theFile);
      throw new RuntimeException(e);
    }
  }
}
