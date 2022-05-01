package com.philvigus.robot.room;

public class Room {
  private final int width;
  private final int length;

  public Room(int width, int length) {
    this.width = width;
    this.length = length;
  }

  public int getWidth() {
    return width;
  }

  public int getLength() {
    return length;
  }

  public boolean isValidField(int x, int y) {
    return x >= 0 && x <= width && y >= 0 && y <= length;
  }
}
