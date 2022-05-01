package com.philvigus.robot.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/** The Console UI class. */
public class ConsoleUi implements Ui {
  private final Scanner scanner;
  private final PrintStream outputStream;

  /**
   * Instantiates a new Console UI.
   *
   * @param inputStream the input stream
   * @param outputStream the output stream
   *
   * TODO:
   * Introduce classes to encapsulate input and output streams here. This
   * would help fix the issue I am having testing some of the user input based
   * classes, as the new classes would be easier to mock in the tests
   */
  public ConsoleUi(final InputStream inputStream, final PrintStream outputStream) {
    this.scanner = new Scanner(inputStream);
    this.outputStream = outputStream;
  }

  @Override
  public void displayMessage(final String message) {
    outputStream.println(message);
  }

  @Override
  public String getInput(final String prompt) {
    displayMessage(prompt);

    return scanner.nextLine();
  }
}
