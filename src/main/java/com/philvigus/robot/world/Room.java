package com.philvigus.robot.world;

/** The Room interface. */
public interface Room {
  /**
   * Whether the specified field location falls within the room.
   *
   * @param x the x position
   * @param y the y position
   * @return whether the field is valid
   */
  boolean isValidField(int x, int y);

  /**
   * Gets the room's length.
   *
   * @return the length
   */
  int getLength();
}
