package com.philvigus.robot.parsers;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** The Position parser. */
public class PositionParser {
  /**
   * Returns the position from the string.
   *
   * @param positionAndDirection the position and direction string
   * @return the position map
   */
  // TODO: This is horrible - should add a position class
  public Map<String, Integer> parse(final String positionAndDirection) {
    final Map<String, Integer> position = new ConcurrentHashMap<>();

    final String[] data = positionAndDirection.split(" ");

    final int x = Integer.parseInt(data[0]);
    final int y = Integer.parseInt(data[1]);

    position.put("x", x);
    position.put("y", y);

    return position;
  }
}
