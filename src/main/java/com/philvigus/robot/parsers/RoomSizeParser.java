package com.philvigus.robot.parsers;

import com.philvigus.robot.world.Room;
import com.philvigus.robot.world.RoomImpl;

/** The Room size parser. */
public class RoomSizeParser {
  /**
   * Returns the room from the roomSize string.
   *
   * @param roomSize the room size
   * @return the room
   */
  public Room parse(String roomSize) {
    String[] data = roomSize.split(" ");

    int x = Integer.parseInt(data[0]);
    int y = Integer.parseInt(data[1]);

    return new RoomImpl(x, y);
  }
}
