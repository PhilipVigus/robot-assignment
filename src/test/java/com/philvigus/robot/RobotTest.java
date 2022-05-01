package com.philvigus.robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RobotTest {
  @Test
  void turnLeftTurnsTheRobotLeft() {
    Robot robot = new Robot(Direction.N);

    robot.turnLeft();

    assertEquals(Direction.W, robot.getDirection());
  }

  @Test
  void turnRightTurnsTheRobotRight() {
    Robot robot = new Robot(Direction.N);

    robot.turnRight();

    assertEquals(Direction.E, robot.getDirection());
  }
}
