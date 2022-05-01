package com.philvigus.robot;

import com.philvigus.robot.world.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectionTest {
  @Test
  void turnRightFromNorthShouldReturnEast() {
    Direction direction = Direction.N;

    assertEquals(Direction.E, direction.turnRight());
  }

  @Test
  void turnRightFromEastShouldReturnSouth() {
    Direction direction = Direction.E;

    assertEquals(Direction.S, direction.turnRight());
  }

  @Test
  void turnRightFromSouthShouldReturnWest() {
    Direction direction = Direction.S;

    assertEquals(Direction.W, direction.turnRight());
  }

  @Test
  void turnRightFromWestShouldReturnNorth() {
    Direction direction = Direction.W;

    assertEquals(Direction.N, direction.turnRight());
  }

  @Test
  void turnLeftFromWestShouldReturnSouth() {
    Direction direction = Direction.W;

    assertEquals(Direction.S, direction.turnLeft());
  }

  @Test
  void turnLeftFromSouthShouldReturnEast() {
    Direction direction = Direction.S;

    assertEquals(Direction.E, direction.turnLeft());
  }

  @Test
  void turnLeftFromEastShouldReturnNorth() {
    Direction direction = Direction.E;

    assertEquals(Direction.N, direction.turnLeft());
  }

  @Test
  void turnLeftFromNorthShouldReturnWest() {
    Direction direction = Direction.N;

    assertEquals(Direction.W, direction.turnLeft());
  }
}
