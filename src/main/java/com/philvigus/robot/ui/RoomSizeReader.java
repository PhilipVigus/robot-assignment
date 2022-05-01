package com.philvigus.robot.ui;

import java.util.regex.Matcher;

// TODO: Needs tests

/** The Room size reader
 *
 * TODO:
 * - Add tests
 * - Move display strings to a resource bundle
 */
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
        "Room must be specified as a number then a space then a number, with both numbers greater than zero");
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
