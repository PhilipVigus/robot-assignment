package com.philvigus.robot.parsers;

/** The Direction parser. */
public class DirectionParser {
  /**
   * Returns the direction from the string.
   *
   * @param positionAndDirection the position and direction string
   * @return the direction
   */
  // TODO: This is horrible - should add a position class
  public String parse(final String positionAndDirection) {
    final String[] data = positionAndDirection.split(" ");

    return data[2];
  }
}
