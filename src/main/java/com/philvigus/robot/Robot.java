package com.philvigus.robot;

import com.philvigus.robot.exceptions.InvalidFieldException;
import com.philvigus.robot.world.Direction;
import com.philvigus.robot.world.Room;

public class Robot {
  private final Room room;
  private Direction direction;
  private int x;
  private int y;

  public Robot(Direction direction, int x, int y, Room room) {
    this.direction = direction;
    this.x = x;
    this.y = y;
    this.room = room;
  }

  public Direction getDirection() {
    return direction;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void turnLeft() {
    direction = direction.turnLeft();
  }

  public void turnRight() {
    direction = direction.turnRight();
  }

  public void moveForward() throws InvalidFieldException {
    switch(direction) {
      case N -> moveNorth();
      case E -> moveEast();
      case S -> moveSouth();
      case W -> moveWest();
    }
  }

  public String getReport() {
    return String.format("Report: %s %s %s", x, y, direction);
  }

  private void moveNorth() throws InvalidFieldException {
    if (!room.isValidField(x, y + 1)) {
      throw new InvalidFieldException("Unable to move North");
    }

    y++;
  }

  private void moveEast() throws InvalidFieldException {
    if (!room.isValidField(x + 1, y)) {
      throw new InvalidFieldException("Unable to move East");
    }

    x++;
  }

  private void moveSouth() throws InvalidFieldException {
    if (!room.isValidField(x, y - 1)) {
      throw new InvalidFieldException("Unable to move South");
    }

    y--;
  }

  private void moveWest() throws InvalidFieldException {
    if (!room.isValidField(x - 1, y)) {
      throw new InvalidFieldException("Unable to move West");
    }

    x--;
  }
}
