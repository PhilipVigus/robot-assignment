package com.philvigus.robot.ui;

import java.util.regex.Matcher;

public class PositionAndDirectionReader extends ValidatedStringReader {

  public PositionAndDirectionReader(Ui ui) {
    super(
        ui,
        "Please enter the position and direction",
        "^\\d+ \\d+ [NSEW]$",
        "The input must be specified in the form of two positive numbers separated by a space, followed by one of N, S, E or W");
  }

  @Override
  public String readInput() {
    final String input = ui.getInput(prompt);
    final Matcher matcher = pattern.matcher(input);

    // Does it match the pattern?
    if (!matcher.matches()) {
      ui.displayMessage(error);
      return readInput();
    }

    return input;
  }
}
