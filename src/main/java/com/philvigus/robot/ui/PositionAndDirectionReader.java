package com.philvigus.robot.ui;

import com.philvigus.robot.world.Position;
import com.philvigus.robot.world.Room;

import java.util.regex.Matcher;

/**
 * The Position and direction reader
 *
 * TODO:
 * - Add tests
 * - Move display strings to a resource bundle
 * - Think of a better class name
 */
public class PositionAndDirectionReader extends ValidatedStringReader {
  private final Room room;

  /**
   * Instantiates a new Position and direction reader.
   *
   * @param ui the ui
   * @param room the room
   */
  public PositionAndDirectionReader(final Ui ui, final Room room) {
    super(
        ui,
        "Please enter the position and direction",
        "^\\d+ \\d+ [NSEW]$",
        "The input must be specified in the form of two positive numbers separated by a space, followed by one of N, S, E or W");

    this.room = room;
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
    final int x = Integer.parseInt(data[0]);
    final int y = Integer.parseInt(data[1]);

    // Is the start position valid for the room size?
    if (!room.isValidField(new Position(x, y))) {
      ui.displayMessage("The position must be within the room");
      return readInput();
    }

    return input;
  }
}
