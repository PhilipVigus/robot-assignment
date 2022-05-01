package com.philvigus.robot.ui;

// TODO: Write tests

/** The Moves reader class.
 *
 * TODO:
 * - Rename to CommandsReader
 * - Move display strings to a resource bundle
 * - Add tests
 */
public class MovesReader extends ValidatedStringReader {
  /**
   * Instantiates a new Moves reader.
   *
   * @param ui the ui
   */
  public MovesReader(final Ui ui) {
    super(
        ui,
        "Please enter the robot's moves",
        "^[LRF]+$",
        "Moves must be a string consisting of L, R or F");
  }
}
