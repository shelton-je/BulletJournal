package cs3500.pa05.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Scanner;

public class ReadBujo {
  private Path file;

  public ReadBujo(Path file) {
    this.file = file;
  }

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
