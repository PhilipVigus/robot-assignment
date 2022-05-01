package com.philvigus.robot;

import com.philvigus.robot.exceptions.InvalidFieldException;
import com.philvigus.robot.world.Direction;
import com.philvigus.robot.world.RoomImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RobotTest {
  @Test
  void turnLeftShouldTurnTheRobotLeft() {
    Robot robot = new Robot(Direction.N, 1, 1, new RoomImpl(10, 10));

    robot.turnLeft();

    assertEquals("Report: 1 1 W", robot.getReport());
  }

  @Test
  void turnRightShouldTurnTheRobotRight() {
    Robot robot = new Robot(Direction.N, 1, 1, new RoomImpl(10, 10));

    robot.turnRight();

    assertEquals("Report: 1 1 E", robot.getReport());
  }

  @Test
  void moveForwardWhenFacingNorthShouldMoveTheRobotNorth() {
    Robot robot = new Robot(Direction.N, 1, 1, new RoomImpl(10, 10));

    robot.moveForward();

    assertEquals("Report: 1 2 N", robot.getReport());
  }

  @Test
  void moveForwardWhenFacingEastShouldMoveTheRobotEast() {
    Robot robot = new Robot(Direction.E, 1, 1, new RoomImpl(10, 10));

    robot.moveForward();

    assertEquals("Report: 2 1 E", robot.getReport());
  }

  @Test
  void moveForwardWhenFacingSouthShouldMoveTheRobotSouth() {
    Robot robot = new Robot(Direction.S, 1, 1, new RoomImpl(10, 10));

    robot.moveForward();

    assertEquals("Report: 1 0 S", robot.getReport());
  }

  @Test
  void moveForwardWhenFacingWestShouldMoveTheRobotWest() {
    Robot robot = new Robot(Direction.W, 1, 1, new RoomImpl(10, 10));

    robot.moveForward();

    assertEquals("Report: 0 1 W", robot.getReport());
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

  @Test
  void reportReturnsAStringSummarisingTheRobotStatus() {
    Robot robot = new Robot(Direction.S, 0, 0, new RoomImpl(1, 1));

    assertEquals("Report: 0 0 S", robot.getReport());
  }
}
