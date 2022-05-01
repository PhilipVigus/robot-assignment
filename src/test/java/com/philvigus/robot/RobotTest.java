package com.philvigus.robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RobotTest {
  @Test
  void turnLeftShouldTurnTheRobotLeft() {
    Robot robot = new Robot(Direction.N, 1, 1);

    robot.turnLeft();

    assertEquals(Direction.W, robot.getDirection());
  }

  @Test
  void turnRightShouldTurnTheRobotRight() {
    Robot robot = new Robot(Direction.N, 1, 1);

    robot.turnRight();

    assertEquals(Direction.E, robot.getDirection());
  }

  @Test
  void moveForwardWhenFacingNorthShouldMoveTheRobotNorth() {
    Robot robot = new Robot(Direction.N, 1, 1);

    robot.moveForward();

    assertEquals(2, robot.getY());
  }

  @Test
  void moveForwardWhenFacingEastShouldMoveTheRobotEast() {
    Robot robot = new Robot(Direction.E, 1, 1);

    robot.moveForward();

    assertEquals(2, robot.getX());
  }

  @Test
  void moveForwardWhenFacingSouthShouldMoveTheRobotSouth() {
    Robot robot = new Robot(Direction.S, 1, 1);

    robot.moveForward();

    assertEquals(0, robot.getY());
  }

  @Test
  void moveForwardWhenFacingWestShouldMoveTheRobotWest() {
    Robot robot = new Robot(Direction.W, 1, 1);

    robot.moveForward();

    assertEquals(0, robot.getX());
  }
}
