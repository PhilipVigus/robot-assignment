package com.philvigus.robot.parsers;

import com.philvigus.robot.world.Direction;
import com.philvigus.robot.world.Room;
import com.philvigus.robot.world.RoomImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Parser {
  /**
   * Returns the direction from the string.
   *
   * @param positionAndDirection the position and direction string
   * @return the direction
   */
  public Direction parseDirection(final String positionAndDirection) {
    final String[] data = positionAndDirection.split(" ");

    return Direction.valueOf(data[2]);
  }

  /**
   * Returns the position from the string.
   *
   * @param positionAndDirection the position and direction string
   * @return the position map
   */
  // TODO: This is horrible - should add a position class
  public Map<String, Integer> parsePosition(final String positionAndDirection) {
    final Map<String, Integer> position = new ConcurrentHashMap<>();

    final String[] data = positionAndDirection.split(" ");

    final int x = Integer.parseInt(data[0]);
    final int y = Integer.parseInt(data[1]);

    position.put("x", x);
    position.put("y", y);

    return position;
  }

  /**
   * Returns the room from the roomSize string.
   *
   * @param roomSize the room size
   * @return the room
   */
  public Room parseRoom(String roomSize) {
    String[] data = roomSize.split(" ");

    int x = Integer.parseInt(data[0]);
    int y = Integer.parseInt(data[1]);

    return new RoomImpl(x, y);
  }
}
