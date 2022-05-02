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

  public boolean isValidField(final Position position) {
    return position.getX() >= 0
        && position.getX() <= width - 1
        && position.getY() >= 0
        && position.getY() <= length - 1;
  }

  public int getLength() {
    return length;
  }

  @Override
  public int getWidth() {
    return width;
  }
}
