package com.philvigus.robot.ui;

import java.util.regex.Matcher;

// TODO: Needs tests

/** The Room size reader class. */
public class RoomSizeReader extends ValidatedStringReader {
  /**
   * Instantiates a new Room size reader.
   *
   * @param ui the UI used by the reader
   */
  public RoomSizeReader(final Ui ui) {
    super(
        ui,
        "Please enter the room size",
        "^\\d+ \\d+$",
        "Room must be specified as a positive number then a space then a positive number");
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

    final String[] data = input.split(" ");

    // Is either dimension 0?
    if ("0".equals(data[0]) || "0".equals(data[1])) {
      ui.displayMessage(error);
      return readInput();
    }

    return input;
  }
}
