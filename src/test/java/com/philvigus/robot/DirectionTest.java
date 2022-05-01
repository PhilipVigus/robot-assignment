package com.philvigus.robot;

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
}
