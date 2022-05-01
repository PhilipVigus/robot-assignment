package com.philvigus.robot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RobotTest {
  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

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
