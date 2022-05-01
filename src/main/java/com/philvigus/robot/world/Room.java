package com.philvigus.robot.world;

/** The Room interface. */
public interface Room {
  /**
   * Whether the specified field location is valid.
   *
   * @param x the x position
   * @param y the y position
   * @return whether the field is valid
   */
  boolean isValidField(int x, int y);

  int getLength();
}
