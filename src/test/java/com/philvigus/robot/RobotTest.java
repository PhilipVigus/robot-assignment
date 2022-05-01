package com.philvigus.robot;

import com.philvigus.robot.exceptions.InvalidFieldException;
import com.philvigus.robot.room.RoomImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RobotTest {
  @Test
  void turnLeftShouldTurnTheRobotLeft() {
    Robot robot = new Robot(Direction.N, 1, 1, new RoomImpl(10, 10));

    robot.turnLeft();

    assertEquals(Direction.W, robot.getDirection());
  }

  @Test
  void turnRightShouldTurnTheRobotRight() {
    Robot robot = new Robot(Direction.N, 1, 1, new RoomImpl(10, 10));

    robot.turnRight();

    assertEquals(Direction.E, robot.getDirection());
  }

  @Test
  void moveForwardWhenFacingNorthShouldMoveTheRobotNorth() {
    Robot robot = new Robot(Direction.N, 1, 1, new RoomImpl(10, 10));

    robot.moveForward();

    assertEquals(2, robot.getY());
  }

  @Test
  void moveForwardWhenFacingEastShouldMoveTheRobotEast() {
    Robot robot = new Robot(Direction.E, 1, 1, new RoomImpl(10, 10));

    robot.moveForward();

    assertEquals(2, robot.getX());
  }

  @Test
  void moveForwardWhenFacingSouthShouldMoveTheRobotSouth() {
    Robot robot = new Robot(Direction.S, 1, 1, new RoomImpl(10, 10));

    robot.moveForward();

    assertEquals(0, robot.getY());
  }

  @Test
  void moveForwardWhenFacingWestShouldMoveTheRobotWest() {
    Robot robot = new Robot(Direction.W, 1, 1, new RoomImpl(10, 10));

    robot.moveForward();

    assertEquals(0, robot.getX());
  }

  @Test
  void moveForwardWhenFacingNorthToAnInvalidFieldShouldThrowAnException() {
    Robot robot = new Robot(Direction.N, 1, 1, new RoomImpl(1, 1));

    InvalidFieldException exception = assertThrows(InvalidFieldException.class, robot::moveForward);

    assertEquals("Unable to move North", exception.getMessage());
  }

  @Test
  void moveForwardWhenFacingEastToAnInvalidFieldShouldThrowAnException() {
    Robot robot = new Robot(Direction.E, 1, 1, new RoomImpl(1, 1));

    InvalidFieldException exception = assertThrows(InvalidFieldException.class, robot::moveForward);

    assertEquals("Unable to move East", exception.getMessage());
  }

  @Test
  void moveForwardWhenFacingWestToAnInvalidFieldShouldThrowAnException() {
    Robot robot = new Robot(Direction.W, 0, 0, new RoomImpl(1, 1));

    InvalidFieldException exception = assertThrows(InvalidFieldException.class, robot::moveForward);

    assertEquals("Unable to move West", exception.getMessage());
  }

  @Test
  void moveForwardWhenFacingSouthToAnInvalidFieldShouldThrowAnException() {
    Robot robot = new Robot(Direction.S, 0, 0, new RoomImpl(1, 1));

    InvalidFieldException exception = assertThrows(InvalidFieldException.class, robot::moveForward);

    assertEquals("Unable to move South", exception.getMessage());
  }
}
