package com.philvigus.robot.world;

/** The Room class. */
public class RoomImpl implements Room {
  private final int width;
  private final int length;

  /**
   * Instantiates a new Room.
   *
   * @param width the width of the room
   * @param length the length of the room
   */
  public RoomImpl(final int width, final int length) {
    this.width = width;
    this.length = length;
  }

  public boolean isValidField(final int x, final int y) {
    return x >= 0 && x <= width && y >= 0 && y <= length;
  }
}
