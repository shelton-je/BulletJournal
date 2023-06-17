package cs3500.pa05.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Utility class to read the contents of a Bullet Journal file. This class takes a file path as
 * an input and reads the entire content of the file as a single string.
 */
public class ReadBujo {
  private Path file;

  /**
   * Constructs a new instance of ReadBujo, given the path of the file to read.
   *
   * @param file the path of the file to read
   */
  public ReadBujo(Path file) {
    this.file = file;
  }

  /**
   * Reads the content of the file specified in the constructor and returns it as a single string.
   *
   * @return a string containing the entire content of the file
   * @throws IllegalStateException if the file path cannot be accessed
   */
  public String readBujo() {
    Scanner sc = null;
    try {
      sc = new Scanner(new FileInputStream(file.toFile()));
    } catch (FileNotFoundException e) {
      throw new IllegalStateException("cannot access file path");
    }
    StringBuilder sb = new StringBuilder();

    while(sc.hasNextLine()){
      sb.append(sc.nextLine());
    }
    return sb.toString();
  }
}
