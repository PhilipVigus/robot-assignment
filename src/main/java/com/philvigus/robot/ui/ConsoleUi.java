package com.philvigus.robot.ui;

import java.io.PrintStream;

public class ConsoleUi implements Ui {
  private final PrintStream outputStream;

  public ConsoleUi(final PrintStream outputStream) {
    this.outputStream = outputStream;
  }

  @Override
  public void displayMessage(String message) {
    outputStream.println(message);
  }
}
