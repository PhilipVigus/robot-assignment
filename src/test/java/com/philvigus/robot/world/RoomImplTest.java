package com.philvigus.robot.world;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RoomImplTest {
  @Test
  void isValidFieldShouldReturnTrueIfTheFieldIsValid() {
    final RoomImpl room = new RoomImpl(3, 4);

    assertTrue(room.isValidField(new Position(1, 1)));
  }

  @Test
  void isValidFieldShouldReturnFalseIfXIsLessThanZero() {
    final RoomImpl room = new RoomImpl(3, 4);

    assertFalse(room.isValidField(new Position(-1, 1)));
  }

  @Test
  void isValidFieldShouldReturnFalseIfYIsLessThanZero() {
    final RoomImpl room = new RoomImpl(3, 4);

    assertFalse(room.isValidField(new Position(1, -1)));
  }

  @Test
  void isValidFieldShouldReturnFalseIfXIsMoreThanWidth() {
    final RoomImpl room = new RoomImpl(3, 4);

    assertFalse(room.isValidField(new Position(4, 1)));
  }

  @Test
  void isValidFieldShouldReturnFalseIfYIsMoreThanWidth() {
    final RoomImpl room = new RoomImpl(3, 4);

    assertFalse(room.isValidField(new Position(1, 5)));
  }
}
