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
    final Robot robot = new Robot(Direction.N, 1, 1, new RoomImpl(10, 10));

    robot.turnLeft();

    assertEquals("Report: 1 8 W", robot.getReport());
  }

  @Test
  void turnRightShouldTurnTheRobotRight() {
    final Robot robot = new Robot(Direction.N, 1, 1, new RoomImpl(10, 10));

    robot.turnRight();

    assertEquals("Report: 1 8 E", robot.getReport());
  }

  @Test
  void moveForwardWhenFacingNorthShouldMoveTheRobotNorth() {
    final Robot robot = new Robot(Direction.N, 1, 1, new RoomImpl(10, 10));

    robot.moveForward();

    assertEquals("Report: 1 7 N", robot.getReport());
  }

  @Test
  void moveForwardWhenFacingEastShouldMoveTheRobotEast() {
    final Robot robot = new Robot(Direction.E, 1, 1, new RoomImpl(10, 10));

    robot.moveForward();

    assertEquals("Report: 2 8 E", robot.getReport());
  }

  @Test
  void moveForwardWhenFacingSouthShouldMoveTheRobotSouth() {
    final Robot robot = new Robot(Direction.S, 1, 1, new RoomImpl(10, 10));

    robot.moveForward();

    assertEquals("Report: 1 9 S", robot.getReport());
  }

  @Test
  void moveForwardWhenFacingWestShouldMoveTheRobotWest() {
    final Robot robot = new Robot(Direction.W, 1, 1, new RoomImpl(10, 10));

    robot.moveForward();

    assertEquals("Report: 0 8 W", robot.getReport());
  }

  @Test
  void moveForwardWhenFacingNorthToAnInvalidFieldShouldThrowAnException() {
    final Robot robot = new Robot(Direction.N, 1, 1, new RoomImpl(1, 1));

    final InvalidFieldException exception =
        assertThrows(InvalidFieldException.class, robot::moveForward);

    assertEquals("Unable to move North", exception.getMessage());
  }

  @Test
  void moveForwardWhenFacingEastToAnInvalidFieldShouldThrowAnException() {
    final Robot robot = new Robot(Direction.E, 1, 1, new RoomImpl(1, 1));

    final InvalidFieldException exception =
        assertThrows(InvalidFieldException.class, robot::moveForward);

    assertEquals("Unable to move East", exception.getMessage());
  }

  @Test
  void moveForwardWhenFacingWestToAnInvalidFieldShouldThrowAnException() {
    final Robot robot = new Robot(Direction.W, 0, 0, new RoomImpl(1, 1));

    final InvalidFieldException exception =
        assertThrows(InvalidFieldException.class, robot::moveForward);

    assertEquals("Unable to move West", exception.getMessage());
  }

  @Test
  void moveForwardWhenFacingSouthToAnInvalidFieldShouldThrowAnException() {
    final Robot robot = new Robot(Direction.S, 0, 0, new RoomImpl(1, 1));

    final InvalidFieldException exception =
        assertThrows(InvalidFieldException.class, robot::moveForward);

    assertEquals("Unable to move South", exception.getMessage());
  }

  @Test
  void reportReturnsAStringSummarisingTheRobotStatus() {
    final Robot robot = new Robot(Direction.S, 0, 0, new RoomImpl(1, 1));

    assertEquals("Report: 0 0 S", robot.getReport());
  }
}
