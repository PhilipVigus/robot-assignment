package com.philvigus.robot.ui;

/** The Ui interface. */
public interface Ui {
  /**
   * Displays a message.
   *
   * @param message the message to display
   */
  void displayMessage(String message);

  /**
   * Gets input.
   *
   * @param prompt the displayed prompt
   * @return the input
   */
  String getInput(String prompt);
}
