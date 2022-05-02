package com.philvigus.robot.world;

/** The Position class. */
public class Position {
  private int x;
  private int y;

  /**
   * Instantiates a new Position.
   *
   * @param x the x
   * @param y the y
   */
  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Create a position from coordinates with the origin top-left.
   *
   * @param x the x
   * @param y the y
   * @param room the room
   * @return the position
   */
  public static Position createFromUserCoordinates(int x, int y, Room room) {
    return new Position(x, room.getLength() - y - 1);
  }

  /**
   * Convert a position to one with coordinates with the origin top-left.
   *
   * @param position the position
   * @param room the room
   * @return the position
   */
  public static Position convertToUserCoordinates(Position position, Room room) {
    return new Position(position.getX(), room.getLength() - position.getY() - 1);
  }

  /**
   * Gets the x component.
   *
   * @return the x component
   */
  public int getX() {
    return x;
  }

  /**
   * Sets the x component.
   *
   * @param x the x component
   */
  public void setX(int x) {
    this.x = x;
  }

  /**
   * Gets the y component.
   *
   * @return the y component
   */
  public int getY() {
    return y;
  }

  /**
   * Sets the y component.
   *
   * @param y the y component
   */
  public void setY(int y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return String.format("%d %d", x, y);
  }
}
