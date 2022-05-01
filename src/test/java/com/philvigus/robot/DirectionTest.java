package com.philvigus.robot;

import com.philvigus.robot.world.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectionTest {
  @Test
  void turnRightFromNorthShouldReturnEast() {
    final Direction direction = Direction.N;

    assertEquals(Direction.E, direction.turnRight());
  }

  @Test
  void turnRightFromEastShouldReturnSouth() {
    final Direction direction = Direction.E;

    assertEquals(Direction.S, direction.turnRight());
  }

  @Test
  void turnRightFromSouthShouldReturnWest() {
    final Direction direction = Direction.S;

    assertEquals(Direction.W, direction.turnRight());
  }

  @Test
  void turnRightFromWestShouldReturnNorth() {
    final Direction direction = Direction.W;

    assertEquals(Direction.N, direction.turnRight());
  }

  @Test
  void turnLeftFromWestShouldReturnSouth() {
    final Direction direction = Direction.W;

    assertEquals(Direction.S, direction.turnLeft());
  }

  @Test
  void turnLeftFromSouthShouldReturnEast() {
    final Direction direction = Direction.S;

    assertEquals(Direction.E, direction.turnLeft());
  }

  @Test
  void turnLeftFromEastShouldReturnNorth() {
    final Direction direction = Direction.E;

    assertEquals(Direction.N, direction.turnLeft());
  }

  @Test
  void turnLeftFromNorthShouldReturnWest() {
    final Direction direction = Direction.N;

    assertEquals(Direction.W, direction.turnLeft());
  }
}
