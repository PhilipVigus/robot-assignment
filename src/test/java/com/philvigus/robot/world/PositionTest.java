package com.philvigus.robot.world;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {
  @Test
  void setXShouldSetTheXAttribute() {
    final Position position = new Position(0, 0);
    position.setX(5);

    assertEquals(5, position.getX());
  }

  @Test
  void setYShouldSetTheYAttribute() {
    final Position position = new Position(0, 0);
    position.setY(5);

    assertEquals(5, position.getY());
  }
}
