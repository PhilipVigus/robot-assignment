package com.philvigus.robot.world;

public class Position {
  private int x;
  private int y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public static Position createFromUserCoordinates(int x, int y, Room room) {
    return new Position(x, room.getLength() - y - 1);
  }

  public static Position convertToUserCoordinates(Position position, Room room) {
    return new Position(position.getX(), room.getLength() - position.getY() - 1);
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return String.format("%d %d", x, y);
  }
}
