package com.philvigus.robot;

import com.philvigus.robot.exceptions.InvalidFieldException;
import com.philvigus.robot.world.Direction;
import com.philvigus.robot.world.Position;
import com.philvigus.robot.world.Room;
import com.philvigus.robot.world.RoomImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RobotTest {
  @Test
  void turnLeftShouldTurnTheRobotLeft() {
    final Robot robot = new Robot();

    robot.turnLeft();

    assertEquals("Report: 0 0 W", robot.getReport());
  }

  @Test
  void turnRightShouldTurnTheRobotRight() {
    final Robot robot = new Robot();

    robot.turnRight();

    assertEquals("Report: 0 0 E", robot.getReport());
  }

  @Test
  void moveForwardWhenFacingNorthShouldMoveTheRobotNorth() {
    final Robot robot = new Robot();
    Room room = new RoomImpl(2, 2);
    Position userCoordPosition = Position.createFromUserCoordinates(0, 1, room);

    robot.initialise(userCoordPosition, Direction.N, room);

    robot.moveForward();

    // The report gives the position in user coordinates
    assertEquals("Report: 0 0 N", robot.getReport());
  }

  @Test
  void moveForwardWhenFacingEastShouldMoveTheRobotEast() {
    final Robot robot = new Robot();
    Room room = new RoomImpl(2, 2);
    Position userCoordPosition = Position.createFromUserCoordinates(0, 0, room);

    robot.initialise(userCoordPosition, Direction.E, room);

    robot.moveForward();

    // The report gives the position in user coordinates
    assertEquals("Report: 1 0 E", robot.getReport());
  }

  @Test
  void moveForwardWhenFacingSouthShouldMoveTheRobotSouth() {
    final Robot robot = new Robot();

    Room room = new RoomImpl(2, 2);
    Position userCoordPosition = Position.createFromUserCoordinates(0, 0, room);

    robot.initialise(userCoordPosition, Direction.S, room);

    robot.moveForward();

    // The report gives the position in user coordinates
    assertEquals("Report: 0 1 S", robot.getReport());
  }

  @Test
  void moveForwardWhenFacingWestShouldMoveTheRobotWest() {
    final Robot robot = new Robot();

    Room room = new RoomImpl(2, 2);
    Position userCoordPosition = Position.createFromUserCoordinates(1, 0, room);

    robot.initialise(userCoordPosition, Direction.W, room);

    robot.moveForward();

    // The report gives the position in user coordinates
    assertEquals("Report: 0 0 W", robot.getReport());
  }

  @Test
  void moveForwardWhenFacingNorthToAnInvalidFieldShouldThrowAnException() {
    final Robot robot = new Robot();

    final InvalidFieldException exception =
        assertThrows(InvalidFieldException.class, robot::moveForward);

    assertEquals("Unable to move North", exception.getMessage());
  }

  @Test
  void moveForwardWhenFacingEastToAnInvalidFieldShouldThrowAnException() {
    final Robot robot = new Robot();
    robot.initialise(new Position(1, 1), Direction.E, new RoomImpl(1, 1));

    final InvalidFieldException exception =
        assertThrows(InvalidFieldException.class, robot::moveForward);

    assertEquals("Unable to move East", exception.getMessage());
  }

  @Test
  void moveForwardWhenFacingWestToAnInvalidFieldShouldThrowAnException() {
    final Robot robot = new Robot();
    robot.initialise(new Position(0, 0), Direction.W, new RoomImpl(1, 1));

    final InvalidFieldException exception =
        assertThrows(InvalidFieldException.class, robot::moveForward);

    assertEquals("Unable to move West", exception.getMessage());
  }

  @Test
  void moveForwardWhenFacingSouthToAnInvalidFieldShouldThrowAnException() {
    final Robot robot = new Robot();
    robot.initialise(new Position(0, 0), Direction.S, new RoomImpl(1, 1));

    final InvalidFieldException exception =
        assertThrows(InvalidFieldException.class, robot::moveForward);

    assertEquals("Unable to move South", exception.getMessage());
  }

  @Test
  void reportReturnsAStringSummarisingTheRobotStatus() {
    final Robot robot = new Robot();

    assertEquals("Report: 0 0 N", robot.getReport());
  }
}
