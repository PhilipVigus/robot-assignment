package com.philvigus.robot;

import com.philvigus.robot.exceptions.InvalidFieldException;
import com.philvigus.robot.world.Direction;
import com.philvigus.robot.world.Room;

/**
 * The Robot class.
 */
public class Robot {
  private Room room;
  private Direction direction;
  private int x;
  private int y;

  /**
   * Instantiates a new Robot.
   *
   * @param direction the initial
   * @param x the initial x position
   * @param y the initial y position
   * @param room the room the robot is in
   */
public Robot(final Direction direction, final int x, final int y, final Room room) {
    this.direction = direction;
    this.x = x;
    this.y = y;
    this.room = room;
  }

  /**
   * Turn left.
   */
public void turnLeft() {
    direction = direction.turnLeft();
  }

  /**
   * Turn right.
   */
public void turnRight() {
    direction = direction.turnRight();
  }

  /**
   * Move forward.
   *
   * @throws InvalidFieldException the invalid field exception
   */
public void moveForward() throws InvalidFieldException {
    switch(direction) {
      case N -> moveNorth();
      case E -> moveEast();
      case S -> moveSouth();
      case W -> moveWest();
    }
  }

  /**
   * Gets a status report.
   *
   * @return the report
   */
  public String getReport() {
    int userY = room.getLength() - y - 1;
    return String.format("Report: %s %s %s", x, userY, direction);
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

  /**
   * Sets room.
   *
   * @param room the room
   */
public void setRoom(final Room room) {
    this.room = room;
  }

  /**
   * Sets direction.
   *
   * @param direction the direction
   */
public void setDirection(final Direction direction) {
    this.direction = direction;
  }

  /**
   * Sets x.
   *
   * @param x the x
   */
public void setX(final int x) {
    this.x = x;
  }

  /**
   * Sets y.
   *
   * @param y the y
   */
public void setY(final int y) {
    this.y = y;
  }
}
