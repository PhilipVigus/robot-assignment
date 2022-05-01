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

  @Test
  void createFromUserCoordinatesShouldReturnAPositionInInternalCoordinates() {
    final Position position = Position.createFromUserCoordinates(0, 1, new RoomImpl(5, 5));

    assertEquals(0, position.getX());
    assertEquals(3, position.getY());
  }

  @Test
  void convertToUserCoordinatesShouldConvertAPositionFromInternalToWorldCoordinates() {
    final Position position = new Position(0, 3);

    final Position convertedPosition =
        Position.convertToUserCoordinates(position, new RoomImpl(5, 5));

    assertEquals(0, convertedPosition.getX());
    assertEquals(1, convertedPosition.getY());
  }
}
