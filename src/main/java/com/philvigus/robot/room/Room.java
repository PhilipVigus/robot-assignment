package com.philvigus.robot.room;

/** The Room c;ass. */
public class Room {
  private final int width;
  private final int length;

  /**
   * Instantiates a new Room.
   *
   * @param width the width of the room
   * @param length the length of the room
   */
  public Room(final int width, final int length) {
    this.width = width;
    this.length = length;
  }

  /**
   * Gets the room's width.
   *
   * @return the width
   */
  public int getWidth() {
    return width;
  }

  /**
   * Gets the room's length.
   *
   * @return the length
   */
  public int getLength() {
    return length;
  }

  /**
   * Whether the specified field location is valid.
   *
   * @param x the x position
   * @param y the y position
   * @return whether the field is valid
   */
  public boolean isValidField(final int x, final int y) {
    return x >= 0 && x <= width && y >= 0 && y <= length;
  }
}
