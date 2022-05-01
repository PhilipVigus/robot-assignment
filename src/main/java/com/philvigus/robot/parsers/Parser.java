package com.philvigus.robot.parsers;

import com.philvigus.robot.world.Direction;
import com.philvigus.robot.world.Room;
import com.philvigus.robot.world.RoomImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TODO: Introduce a Parser interface that this implements
 */
public class Parser {
  /**
   * Returns the direction from the string.
   *
   * @param positionAndDirection the position and direction string
   * @return the parsed direction
   */
  public Direction parseDirection(final String positionAndDirection) {
    final String[] fields = positionAndDirection.split(" ");

    return Direction.valueOf(fields[2]);
  }

  /**
   * Returns the position from the string.
   *
   * @param positionAndDirection the position and direction string
   * @return the position map
   *
   * TODO:
   * Introducing a Position class would make the most difference here, massively simplify
   * this. Using a Map here makes it much harder to following what is actually a relative simple
   * function
   */
  public Map<String, Integer> parsePosition(final String positionAndDirection, final Room room) {
    final Map<String, Integer> position = new ConcurrentHashMap<>();

    final String[] fields = positionAndDirection.split(" ");

    final int x = Integer.parseInt(fields[0]);
    final int y = room.getLength() - Integer.parseInt(fields[1]) - 1;

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
  public Room parseRoom(final String roomSize) {
    final String[] data = roomSize.split(" ");

    final int x = Integer.parseInt(data[0]);
    final int y = Integer.parseInt(data[1]);

    return new RoomImpl(x, y);
  }
}
