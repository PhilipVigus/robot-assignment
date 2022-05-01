package com.philvigus.robot.world;

/** The Room interface. */
public interface Room {
  /**
   * Whether the specified field location falls within the room.
   *
   * @param position the position to be checked
   * @return whether the field is valid
   */
  boolean isValidField(Position position);

  /**
   * Gets the room's length.
   *
   * @return the length
   */
  int getLength();
}
