package com.philvigus.robot;

import com.philvigus.robot.exceptions.InvalidFieldException;
import com.philvigus.robot.world.Direction;
import com.philvigus.robot.world.Position;
import com.philvigus.robot.world.Room;
import com.philvigus.robot.world.RoomImpl;

/**
 * The Robot class.
 */
// TODO: Should implement an interface
public class Robot {
  private Room room;
  private Direction direction;
  private Position position;

  /**
   * Instantiates a new Robot.
   *
   * @param direction the robot's initial direction
   * @param room the room the robot is in
   * @param position the robot's initial position
   */
  public Robot(final Direction direction, final Room room, final Position position) {
    this.direction = direction;
    this.room = room;
    this.position = position;
  }

  /**
   * Instantiates a new Robot with default parameters.
   */
  // TODO: extract variables here and name them to make it clear they are defaults
public Robot() {
    this.direction = Direction.N;
    this.position = new Position(0,0);
    this.room = new RoomImpl(1, 1);
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
    return String.format("Report: %s %s", Position.convertToUserCoordinates(position, room).toString(), direction);
  }

  /**
   * Initialise the robot's state.
   *
   * @param position the position
   * @param direction the direction
   * @param room the room
   */
public void initialise(final Position position, final Direction direction, final Room room) {
    this.position = position;
    this.direction = direction;
    this.room = room;
  }

  private void moveNorth() throws InvalidFieldException {
    Position newPosition = new Position(position.getX(), position.getY() + 1);

    if (!room.isValidField(newPosition)) {
      throw new InvalidFieldException("Unable to move North");
    }

    position = newPosition;
  }

  private void moveEast() throws InvalidFieldException {
    Position newPosition = new Position(position.getX() + 1, position.getY());

    if (!room.isValidField(newPosition)) {
      throw new InvalidFieldException("Unable to move East");
    }

    position = newPosition;
  }

  private void moveSouth() throws InvalidFieldException {
    Position newPosition = new Position(position.getX(), position.getY() - 1);

    if (!room.isValidField(newPosition)) {
      throw new InvalidFieldException("Unable to move South");
    }

    position = newPosition;
  }

  private void moveWest() throws InvalidFieldException {
    Position newPosition = new Position(position.getX() - 1, position.getY());

    if (!room.isValidField(newPosition)) {
      throw new InvalidFieldException("Unable to move West");
    }

    position = newPosition;
  }
}
